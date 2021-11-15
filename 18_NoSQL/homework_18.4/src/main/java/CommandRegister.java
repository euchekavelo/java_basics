/**
 * Интерфейс реестра команд для управления товарами в магазинах.
 */
public interface CommandRegister {

    //Добавить магазин
    void addStore(String name);

    //Добавить товар
    void addProduct(String name, double price);

    //Выставить товар в магазине
    void displayTheProductInTheStore(String nameProduct, String nameStore);

    //Получить статистику по товарам в каждом магазине
    void getProductStatistics();

}
