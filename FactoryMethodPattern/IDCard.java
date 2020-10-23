package FactoryMethodPattern;

public class IDCard implements Product {

    private String owner;

    public IDCard(String owner) {
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner+"님의 카드를 사용합니다");
    }
}
