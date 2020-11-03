package DecoratorPattern;

public class TextWidget extends Widget {
    private final String text;

    public TextWidget(String text) {
        this.text = text;
    }

    @Override
    public int getColumns() {
        //문자열의 길이
        return text.length();
    }

    @Override
    public int getRows() {
        //한줄
        return 1;
    }

    @Override
    public String getRowText(int row) {
        return row == 0 ? text : null;
    }
}
