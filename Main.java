import AdapterPattern.Person;
import AdapterPattern.PersonAdapter;
import BuilderPattern.HTML;
import DecoratorPattern.FullBorder;
import DecoratorPattern.Scaffold;
import DecoratorPattern.SideBorder;
import DecoratorPattern.TextWidget;
import FactoryMethodPattern.Book;
import FactoryMethodPattern.BookFactory;
import FactoryMethodPattern.IDCardFactory;
import FactoryMethodPattern.Product;
import SigletonePattern.Singleton;

public class Main {
    public static void main(String[] args) {
        decorator();
    }

    private static void decorator() {
        TextWidget textWidget = new TextWidget("hello");
        textWidget.show();
        new SideBorder(new FullBorder(new FullBorder(new SideBorder(new TextWidget("start"))))).show();

        new Scaffold(new SideBorder(new FullBorder(new FullBorder(new SideBorder(new TextWidget("start"))))));
    }

    private static void adapter() {
        Person personWoonsik = new Person("woonsik", 26);
        System.out.println(personWoonsik.getName());
        System.out.println(personWoonsik.getAge());

        PersonAdapter adapter = new PersonAdapter(personWoonsik);

        System.out.println(adapter.showName());
        System.out.println(adapter.showAge());
    }

    private static void singletone() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        //아래 방법을 막아야 추가적인 객체 생성을 방지할 수 있다
        //Singleton singleton3 = new Singleton();
        //생성자를 public에서 private로 접근을 막는다

        String testNoSingleton1 = new String("Test");
        String testNoSingleton2 = new String("Test");

        if (singleton1 == singleton2)
            System.out.println("same");
        else
            System.out.println("not same");

        if (testNoSingleton1 == testNoSingleton2)
            System.out.println("sameTest");
        else
            System.out.println("not sameTest");
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
