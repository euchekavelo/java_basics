import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.Collections;
import java.util.List;

public class MongoStorage {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "test";
    private static final String COLLECTION_NAME = "students";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public void init(){
        mongoClient = new MongoClient(HOST, PORT);
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    public void clientClose(){
        mongoClient.close();
    }

    public void collectionDrop(){
        collection.drop();
    }

    //Добавить новый документ коллекции.
    public void addANewCollectionDocument(String name, String year, List<String> courseList){
        Document newDocument = new Document();
        newDocument.append("name", name);
        newDocument.append("age", Integer.parseInt(year));
        newDocument.append("courses", courseList);

        collection.insertOne(newDocument);
    }

    //Получить общее количество студентов.
    public long getTheTotalNumberOfStudentsInTheDatabase(){
        return collection.countDocuments();
    }

    //Получить количество студентов больше 40 лет.
    public long getTheNumberOfStudentsOverFortyYearsOld(){
        BsonDocument query = BsonDocument.parse("{age: {$gt: 40}}");
        return collection.countDocuments(query);
    }

    //Получить имя самого молодого студента.
    public String getTheNameOfTheYoungestStudent(){
        BsonDocument query = BsonDocument.parse("{age: 1}");
        Document document = collection.find().sort(query).first();
        return document != null ? document.getString("name") : null;
    }

    //Получить список курсов самого старого студента.
    public List<String> getTheListOfCoursesOfTheOldestStudent(){
        StringBuilder stringBuilder = new StringBuilder("");
        BsonDocument query = BsonDocument.parse("{age: -1}");
        Document document = collection.find().sort(query).first();
        return document != null ? document.getList("courses", String.class) : Collections.emptyList();
    }
}
