package SigletonePattern;

public class Singleton {

    private static final Singleton sInstance = new Singleton();

    //pulic이 아닌 private로 생성자를 선언해서 new를 방지한다
    private Singleton() {
    }

    public static Singleton getInstance() {
        return sInstance;
    }
}
