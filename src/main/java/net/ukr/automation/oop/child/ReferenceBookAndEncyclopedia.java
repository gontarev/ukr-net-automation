package net.ukr.automation.oop.child;

public class ReferenceBookAndEncyclopedia extends Book {
    private String bookName;
    private String bookType;

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return  bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void printBookName() {
        System.out.println("Book name is: " + bookName + ".");
    }
}
