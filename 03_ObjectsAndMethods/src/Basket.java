public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    //Общая масса всех товаров в корзине
    private double totalWeight = 0;

    //Общая стоимость всех товаров во всех корзинах
    private static int totalPriceAllItems = 0;
    //Общее количество всех товаров во всех корзинах
    private static int totalCountAllItems = 0;

    public static void increaseTotalPriceAllItems(int price)
    {
        Basket.totalPriceAllItems = Basket.totalPriceAllItems + price;
    }

    public static int getTotalPriceAllItems()
    {
        return totalPriceAllItems;
    }

    public static void increaseTotalCountAllItems(int count)
    {
        Basket.totalCountAllItems = Basket.totalCountAllItems + count;
    }

    public static int getTotalCountAllItems()
    {
        return totalCountAllItems;
    }

    //Получить среднюю цену товара во всех корзинах
    public static String getAveragePriceProduct()
    {
        double averagePrice = (double) totalPriceAllItems / (double) totalCountAllItems;
        String roundedAveragePrice = String.format("%.2f", averagePrice);
        return roundedAveragePrice;
    }

    //Получить среднюю стоимость корзины
    public static String getAverageBasketPrice()
    {
        double AverageBasketPrice = (double) totalPriceAllItems / (double) count;
        String roundedAverageBasketPrice = String.format("%.2f", AverageBasketPrice);
        return roundedAverageBasketPrice;
    }


    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
        increaseCount(1);
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        increaseCount(1);
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price)
    {
        add(name, price, 1);
    }

    public void add(String name, int price, int count)
    {
        add(name, price, count,0.0);
    }

    public void add(String name, int price, double weight)
    {
        add(name, price, 1, weight);
    }

    public void add(String name, int price, int count, double weight)
    {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " р. за шт. - " + weight + " кг. за шт.";
        totalPrice = totalPrice + count * price;

        //Подсчитываем общую массу товаров в корзине
        totalWeight = totalWeight + count * weight;

        increaseTotalCountAllItems(count);
        increaseTotalPriceAllItems(count * price);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    //Метод, возвращающий значение веса всех товаров в корзине.
    public double getTotalWeight(){
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
