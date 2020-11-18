package CommandPattern;

import javax.crypto.Mac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class DrawingApp extends JFrame {
    MacroCommand history = new MacroCommand();
    MacroCommand lineHistory = new MacroCommand();

    // JFrame을 상속 받으면 win을 만들게 된다
    public DrawingApp(String title)
    {
        super(title);

        // 기능 버튼들을 담는 박스
        Box buttonBox = new Box(BoxLayout.X_AXIS);

        // 기능
        JButton undoButton = new JButton("undo");
        JButton clearButton = new JButton("clear");
        JButton saveButton = new JButton("save");

        buttonBox.add(undoButton);
        buttonBox.add(clearButton);
        buttonBox.add(saveButton);

        DrawCanvas canvas = new DrawCanvas(300, 200, history);

        // main Box
        Box mainBox = new Box(BoxLayout.Y_AXIS);

        // 메인 박스에 모든 것들을 추가
        mainBox.add(buttonBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack(); // 화면의 사이즈가 알아서 조절된다
        setVisible(true);

        // 마우스 클릭 이벤트 처리용
        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                DrawCommand command = new DrawCommand(canvas, e.getPoint());
                lineHistory.add(command);
                command.execute();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed");
                lineHistory = new MacroCommand();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");
                history.add(lineHistory);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // Undo
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });

        // Clear
        clearButton.addActionListener( e -> {
            history.clear();
            canvas.repaint();
        });
    }
}
