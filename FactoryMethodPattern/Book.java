package FactoryMethodPattern;

public class Book implements Product{

    String bookName;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void use() {
        System.out.println(bookName+"을 읽습니다");
    }

    public static class Factory {
        public static Book create(String bookName)
        {
            return new Book(bookName);
        }
    }
}
