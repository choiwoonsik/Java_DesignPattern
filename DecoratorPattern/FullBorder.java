package DecoratorPattern;

public class FullBorder extends Border
{
    public FullBorder(Widget widget) {
        super(widget);
    }

    @Override
    public int getColumns() {
        return widget.getColumns() + 2;
    }

    @Override
    public int getRows() {
        return widget.getRows() + 2;
    }

    @Override
    public String getRowText(int row) {

        // ---- 파트
        StringBuilder str = new StringBuilder();
        if (row == 0 || row == widget.getRows() + 1)
        {
            for (int i = 0; i < widget.getColumns()+2; i++) {
                if (i == 0 || i == widget.getColumns() + 1)
                    str.append("+");
                else
                    str.append("-");
            }
        }
        // ||| 파트
        else
            str.append("|").append(widget.getRowText(row-1)).append("|");

        return str.toString();
    }
}
