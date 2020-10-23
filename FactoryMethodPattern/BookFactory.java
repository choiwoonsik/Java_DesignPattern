package FactoryMethodPattern;

public class BookFactory implements Factory{

    @Override
    public Product createProduct(String name) {
        return new Book(name);
    }
}
