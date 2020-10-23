import BuilderPattern.HTML;
import FactoryMethodPattern.Book;
import FactoryMethodPattern.BookFactory;
import FactoryMethodPattern.IDCardFactory;
import FactoryMethodPattern.Product;

public class Main {
    public static void main(String[] args) {
        factory();
    }

    private static  void MakeHtml()
    {
        HTML html = new HTML.HTMLbuilder()
                .setTitle("제목")
                .setBody(("내용"))
                .setLi("항목1", "항목2", "항목3", "항목4")
                .makeHTML();

        System.out.println(html);
    }

    private static void factory()
    {
        IDCardFactory factory = new IDCardFactory();
        Product idCard1 = factory.createProduct("최운식");
        Product idCard2 = factory.createProduct("채벼리");
        idCard1.use();
        idCard2.use();

        BookFactory bookFactory = new BookFactory();
        Product javaBook = bookFactory.createProduct("자바 프로그래밍 마스터");
        Product algoBook = bookFactory.createProduct("알고리즘 킹왕짱");

        javaBook.use();
        algoBook.use();

        Book springBook = Book.Factory.create("스프링 마스터하기");
        springBook.use();
    }
}
