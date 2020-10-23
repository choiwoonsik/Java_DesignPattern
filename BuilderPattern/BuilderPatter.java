package BuilderPattern;

public class BuilderPatter {
    public static void main(String[] args) {
        text();
    }
    private static void text()
    {
        Text text = new Text.Builder()
                .setTitle("Hello")
                .setContent("Name")
                .setItems()
                .build();

        System.out.println(text);
    }
}
