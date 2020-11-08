import java.awt.*;
import java.util.Objects;

public class Bobber {
    private CountBobber count;

    public void setCount(int count) {
        this.count = CountBobber.getCount(count);
    }

    public Bobber(int count) {
        setCount(count);
    }

    public void draw(Graphics g, Color color, int x, int y) {

        switch (Objects.requireNonNull(count)) {
            case six: {
                g.setColor(color);
                g.fillRect(x + 45, y + 35, 50, 9);
                g.fillRect(x + 45, y + 66, 50, 9);
                g.setColor(Color.black);
                g.drawLine(x + 45, y + 35, x + 60, y + 38);
                g.drawLine(x + 45, y + 45, x + 60, y + 38);
                g.drawLine(x + 95, y + 35, x + 80, y + 38);
                g.drawLine(x + 95, y + 45, x + 80, y + 38);
                g.drawLine(x + 45, y + 66, x + 60, y + 71);
                g.drawLine(x + 45, y + 76, x + 60, y + 71);
                g.drawLine(x + 95, y + 66, x + 80, y + 71);
                g.drawLine(x + 95, y + 76, x + 80, y + 71);
            }
            case four: {
                g.setColor(color);
                g.fillRect(x + 45, y + 5, 50, 9);
                g.fillRect(x + 45, y + 80, 50, 9);
                g.setColor(Color.black);
                g.drawLine(x + 45, y + 5, x + 60, y + 9);
                g.drawLine(x + 45, y + 14, x + 60, y + 9);
                g.drawLine(x + 95, y + 5, x + 80, y + 9);
                g.drawLine(x + 95, y + 14, x + 80, y + 9);
                g.drawLine(x + 45, y + 80, x + 60, y + 85);
                g.drawLine(x + 45, y + 89, x + 60, y + 85);
                g.drawLine(x + 95, y + 80, x + 80, y +85 );
                g.drawLine(x + 95, y + 89, x + 80, y + 85);
            }
            case two: {
                g.setColor(color);
                g.fillRect(x + 45, y + 20, 50, 9);
                g.fillRect(x + 45, y + 95, 50, 9);
                g.setColor(Color.black);
                g.drawLine(x + 45, y + 20, x + 60, y +25);
                g.drawLine(x + 45, y + 29, x + 60, y + 25);
                g.drawLine(x + 95, y + 20, x + 80, y + 25);
                g.drawLine(x + 95, y + 29, x + 80, y + 25);
                g.drawLine(x + 45, y + 95, x + 60, y + 99);
                g.drawLine(x + 45, y + 104, x + 60, y + 99);
                g.drawLine(x + 95, y + 95, x + 80, y +99);
                g.drawLine(x + 95, y + 104, x + 80, y + 99);
                g.setColor(color);

            }
        }
    }
}
