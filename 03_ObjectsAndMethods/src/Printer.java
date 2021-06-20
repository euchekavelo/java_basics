public class Printer {

    private String queue = "";
    private int totalPagesCount = 0;
    private int totalDocumentsCount = 0;
    private static int globalPagesCount = 0;
    private static int globalDocumentsCount = 0;

    public void append(String textDocument)
    {
        append(textDocument, "");
    }

    public void append(String textDocument, String nameDocument)
    {
        append(textDocument, nameDocument, 1);
    }

    public void append(String textDocument, String nameDocument, int amountPages)
    {
        queue = queue + "\nТекст документа: " + textDocument + "; имя документа: "
                + nameDocument + "; количество страниц: " + amountPages;
        totalPagesCount = totalPagesCount + amountPages;
        totalDocumentsCount += 1;
        Printer.globalDocumentsCount = Printer.globalDocumentsCount + 1;
        Printer.globalPagesCount = Printer.globalPagesCount + amountPages;
    }

    public void clear()
    {
        queue = "";
    }

    public void print()
    {
        System.out.println(queue);
        clear();
    }

    public int getPagesCount()
    {
        return totalPagesCount;
    }

    public int getDocumentsCount()
    {
        return totalDocumentsCount;
    }

    //Метод, возвращающий общее количество распечатанных документов и страниц за всё время существования объекта класса
    public static String getGlobalDocumentsCountAndGlobalPagesCount()
    {
        return "Общее количество распечатанных документов за все время - " + globalDocumentsCount
                + " шт., общее количество распечатанных страниц за все время - " + globalPagesCount + " стр.";
    }
}
