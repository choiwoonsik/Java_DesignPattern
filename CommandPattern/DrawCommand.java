package CommandPattern;

import java.awt.*;

public class DrawCommand implements Command{
    // Canvas 에서 클릭이 발생하면 해당 point 좌표를 얻을수 있다
    private Point point;
    private Drawable drawable;

    public DrawCommand(Drawable drawable, Point point) {
        this.drawable = drawable;
        this.point = point;
    }

    @Override
    public void execute() {
        drawable.draw(point.x, point.y);
    }
}
