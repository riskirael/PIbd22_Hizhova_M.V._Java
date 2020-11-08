import javax.swing.*;
import java.awt.*;

public class FrameAircraft extends JFrame {

    private JPanel contentPane;
    private final JFrame frame;
    private DrawPanelAircraft drawPanelAircraft;
    private JComboBox<String> list;

    public FrameAircraft() {
        frame = new JFrame("Самолет");
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        Icon up = new ImageIcon("верх.jpg");
        Icon down = new ImageIcon("низ.jpg");
        Icon left = new ImageIcon("лево.jpg");
        Icon right = new ImageIcon("право.jpg");

        JButton btnCreate = new JButton("Создать");
        JButton btnUp = new JButton(up);
        btnUp.setName("Up");
        JButton btnDown = new JButton(down);
        btnDown.setName("Down");
        JButton btnLeft = new JButton(left);
        btnLeft.setName("Left");
        JButton btnRight = new JButton(right);
        btnRight.setName("Right");

        frame.getContentPane().add(btnCreate);
        frame.getContentPane().add(btnUp);
        frame.getContentPane().add(btnDown);
        frame.getContentPane().add(btnLeft);
        frame.getContentPane().add(btnRight);

        btnCreate.setBounds(10, 10, 90, 30);
        btnUp.setBounds(805, 375, 30, 30);
        btnDown.setBounds(805, 410, 30, 30);
        btnLeft.setBounds(770, 410, 30, 30);
        btnRight.setBounds(840, 410, 30, 30);

        btnCreate.addActionListener(e -> setAircraft());
        btnUp.addActionListener(e -> setDirection(btnUp));
        btnDown.addActionListener(e -> setDirection(btnDown));
        btnLeft.addActionListener(e -> setDirection(btnLeft));
        btnRight.addActionListener(e -> setDirection(btnRight));

        list = new JComboBox<>(new String[] { "2 поплавка", "4 поплавка", "6 поплавков" });
        frame.getContentPane().add(list);
        list.setBounds(10, 45, 90, 30);
    }

    public void addDrawPanel(DrawPanelAircraft panel) {
        drawPanelAircraft = panel;
        frame.getContentPane().add(drawPanelAircraft);
        drawPanelAircraft.setBounds(0, 0, 900, 500);
        frame.repaint();
    }

    private void setDirection(JButton button) {
        String name = button.getName();
        switch (name) {
            case "Up":
                drawPanelAircraft.getSeaPlane().moveTransport(Direction.Up);
                break;
            case "Down":
                drawPanelAircraft.getSeaPlane().moveTransport(Direction.Down);
                break;
            case "Left":
                drawPanelAircraft.getSeaPlane().moveTransport(Direction.Left);
                break;
            case "Right":
                drawPanelAircraft.getSeaPlane().moveTransport(Direction.Right);
                break;
        }
        frame.repaint();
    }

    private void setAircraft() {
        SeaPlane seaPlane = new SeaPlane(150, 1500, Color.BLUE, Color.green, true, list.getSelectedIndex() * 2 + 2);
        drawPanelAircraft.setSeaPlane(seaPlane);
        drawPanelAircraft.getSeaPlane().setPosition((int) (Math.random() * 100 + 10), (int) (Math.random() * 100 + 10),
                850, 450);
        frame.repaint();
    }

}

