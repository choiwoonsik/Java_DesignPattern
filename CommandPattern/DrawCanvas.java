package CommandPattern;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    private int radius = 4;
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // repaint() 메소드가 불릴경우 물리는 메서드
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(Color.GREEN);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
