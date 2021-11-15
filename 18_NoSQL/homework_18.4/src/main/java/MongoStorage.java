import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Aggregates.*;

public class MongoStorage implements CommandRegister {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "test";
    private static final String COLLECTION_PRODUCTS = "products";
    private static final String COLLECTION_STORES = "stores";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collectionProducts;
    private MongoCollection<Document> collectionStores;

    public void init(){
        mongoClient = new MongoClient(HOST, PORT);
        database = mongoClient.getDatabase(DATABASE_NAME);

        collectionProducts = database.getCollection(COLLECTION_PRODUCTS);
        collectionStores = database.getCollection(COLLECTION_STORES);

        collectionProducts.drop();
        collectionStores.drop();
    }

    @Override
    public void addStore(String name) {
        Document document = new Document()
                                .append("name", name)
                                .append("products", new ArrayList<>());

        collectionStores.insertOne(document);
    }

    @Override
    public void addProduct(String name, double price) {
        Document document = new Document()
                                .append("name", name)
                                .append("price", price);

        collectionProducts.insertOne(document);
    }

    @Override
    public void displayTheProductInTheStore(String nameProduct, String nameStore) {
        Document queryProduct = Document.parse("{name: {$eq: '" + nameProduct + "'}}");
        Document documentProduct = collectionProducts.find(queryProduct)
                                                        .first();

        Document queryStore = Document.parse("{name: {$eq: '" + nameStore + "'}}");
        Document documentStore = collectionStores.find(queryStore)
                                                        .first();

        //Если хотя бы одного продукта или магазина с такими наименованиями не найдено в соответствующих коллекциях,
        //тогда ничего не делаем и выходим из функции.
        if (documentProduct == null || documentStore == null){
            System.out.println("Продукта или магазина с указанными параметрами не найдено. "
                                +"Рекомендуем выполнить добавления в базу недостающей информации.");
            return;
        }

        //Выполняем добавление товара в ассортимент товаров магазина.
        collectionStores.updateOne(queryStore, Updates.push("products", nameProduct));
    }

    /**
     * Метод получения общего количества наименований товаров в каждом магазине.
     */
    private void GetTheTotalNumberOfItemsInEachStore(){
        AggregateIterable<Document> listDocuments = collectionStores.aggregate(List.of(
                lookup("products", "products", "name", "products_list"),
                unwind("$products_list"),
                group("$name", Accumulators.sum("count", 1))
        ));

        System.out.println("-------Вывод общего количества наименований товаров в каждом магазине:-------");
        listDocuments.forEach((Consumer<Document>) document -> {
            System.out.println("В магазине \"" + document.get("_id") + "\" общее количество наименований товаров - "
                    + document.get("count") + " шт.");
        });
    }

    /**
     * Метод получения средней цены в каждом магазине.
     */
    private void GetTheAveragePriceOfItemsInEachStore(){
        AggregateIterable<Document> listDocuments = collectionStores.aggregate(List.of(
                lookup("products", "products", "name", "products_list"),
                unwind("$products_list"),
                group("$name", Accumulators.avg("averagePrice", "$products_list.price"))
        ));

        System.out.println("-------Вывод средней цены товаров в каждом магазине:-------");
        listDocuments.forEach((Consumer<Document>) document -> {
            System.out.println("В магазине \"" + document.get("_id") + "\" средняя цена имеющихся товаров равна: "
                    + document.get("averagePrice") + " руб.");
        });
    }

    /**
     * Метод получения самого дорого и самого дешевого товара в каждом магазине.
     */
    private void GetTheMostExpensiveAndCheapestItemInEveryStore(){
        AggregateIterable<Document> listDocuments = collectionStores.aggregate(List.of(
                lookup("products", "products", "name", "products_list"),
                unwind("$products_list"),
                sort(Sorts.descending("products_list.price")),
                group("$name", Accumulators.max("maxPrice", "$products_list.price"),
                        Accumulators.first("nameExpensiveProduct", "$products_list.name"),
                        Accumulators.min("minPrice", "$products_list.price"),
                        Accumulators.last("nameCheapProduct", "$products_list.name"))
        ));

        System.out.println("-------Вывод самого дорогого и самого дешевого товара в каждом магазине:-------");
        listDocuments.forEach((Consumer<Document>) document -> {
            System.out.println("В магазине \"" + document.get("_id") + "\" самый дорогой товар - \""
                    + document.get("nameExpensiveProduct") + "\" со стоимостью " + document.get("maxPrice") +" руб., "
                               + "самый дешевый - \"" + document.get("nameCheapProduct") + "\""
                               + " со стоимостью " + document.get("minPrice") + " руб.");
        });
    }

    /**
     * Метод получения количества товаров дешевле 100 рублей в каждом магазине.
     */
    private void getTheNumberOfGoodsCheaperThanOneHundredRubles(){
        AggregateIterable<Document> listDocuments = collectionStores.aggregate(List.of(
                lookup("products", "products", "name", "products_list"),
                unwind("$products_list"),
                match(Filters.lt("products_list.price", 100.0)),
                group("$name", Accumulators.sum("count", 1))
        ));

        System.out.println("-------Вывод общего количества товаров дешевле 100 рублей в каждом магазине:-------");
        listDocuments.forEach((Consumer<Document>) document -> {
            System.out.println("В магазине \"" + document.get("_id") + "\" количество товаров дешевле 100 рублей - "
                    + document.get("count") + " шт.");
        });
    }

    @Override
    public void getProductStatistics() {
        GetTheTotalNumberOfItemsInEachStore();
        GetTheAveragePriceOfItemsInEachStore();
        GetTheMostExpensiveAndCheapestItemInEveryStore();
        getTheNumberOfGoodsCheaperThanOneHundredRubles();
    }
}
