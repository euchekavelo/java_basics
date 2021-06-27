package ru.skillbox;

public class Book {

    private final String name;
    private final String author;
    private final int amountPages;
    private final long isbnNumber;


    public Book(String name, String author, int amountPages, long isbnNumber)
    {
        this.name = name;
        this.author = author;
        this.amountPages = amountPages;
        this.isbnNumber = isbnNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getAmountPages()
    {
        return amountPages;
    }

    public long getIsbnNumber()
    {
        return isbnNumber;
    }
}
