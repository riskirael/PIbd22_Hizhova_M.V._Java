import java.awt.*;

public class SeaPlane {
    private int startPosX;
    private int startPosY;
    private int pictureWidth = 100;
    private int pictureHeight = 60;

    private final int aircraftWidth = 120;
    private final int aircraftHeight = 95;

    private int maxSpeed;
    private float weight;
    private Color mainColor;
    private Color dopColor;
    private boolean stripes;
    private Bobber bobber;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getWeight() {
        return weight;
    }

    private void setWeight(float weight) {
        this.weight = weight;
    }

    public Color getMainColor() {
        return mainColor;
    }

    private void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getDopColor() {
        return dopColor;
    }

    private void setDopColor(Color dopColor) {
        this.dopColor = dopColor;
    }

    public boolean isStripes() {
        return stripes;
    }

    private void setStripes(boolean stripes) {
        this.stripes = stripes;
    }

    public SeaPlane(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean stripes, int count) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.stripes = stripes;
        this.bobber = new Bobber(count);
    }

    public void setPosition(int startPosX, int startPosY, int pictureWidth, int pictureHeight) {
        this.pictureHeight = pictureHeight;
        this.pictureWidth = pictureWidth;
        if (startPosX >= 0 &&startPosX + pictureWidth < pictureWidth && startPosY >= 0 && startPosY+ pictureHeight < pictureHeight)
        {
            this.startPosX = startPosX;
            this.startPosY = startPosY;
        }
    }

    public void moveTransport(Direction direction) {
        int step = (int) (maxSpeed * 100 / weight);
        switch (direction) {
            case Up:
                if (startPosY - step > 0)
                {
                    startPosY -= step;
                }
                break;
            case Right:
                if (startPosX+aircraftWidth + step < pictureWidth)
                {
                    startPosX += step;
                }
                break;
            case Down:
                if (startPosY + aircraftHeight+ step < pictureHeight)
                {
                    startPosY += step;
                }
                break;
            case Left:
                if (startPosX - step > 0)
                {
                    startPosX -= step;
                }
                break;
        }
    }

    public void draw(Graphics g) {

        bobber.draw(g, getDopColor(), startPosX, startPosY);
        g.setColor(mainColor);
        // корпус
        g.fillRect(startPosX, startPosY + 45, 100, 20);
        g.drawLine(startPosX + 80, startPosY + 5, startPosX + 80, startPosY + 105);
        g.drawLine(startPosX + 59, startPosY + 5, startPosX + 59, startPosY + 105);
        // крылья
        g.fillRect(startPosX + 60, startPosY + 5, 20, 100);
        // нос
        g.fillOval(startPosX + 90, startPosY + 45, 20, 20);
        g.drawLine(startPosX + 110, startPosY + 35, startPosX + 110, startPosY + 75);
        // хвост
        g.fillRect(startPosX - 5, startPosY + 35, 10, 40);
        g.drawLine(startPosX + 5, startPosY + 35, startPosX + 15, startPosY + 45);
        g.drawLine(startPosX + 5, startPosY + 75, startPosX + 15, startPosY + 65);
        g.drawLine(startPosX - 5, startPosY + 35, startPosX - 5, startPosY + 75);
        g.drawLine(startPosX + 5, startPosY + 35, startPosX + 5, startPosY + 75);
        g.setColor(Color.black);
        // разметка
        if (stripes) {
            g.drawLine(startPosX + 70, startPosY + 5, startPosX + 70, startPosY + 105);
            g.drawLine(startPosX + 72, startPosY + 5, startPosX + 72, startPosY + 105);
            g.drawLine(startPosX + 74, startPosY + 5, startPosX + 74, startPosY + 105);
            g.drawLine(startPosX + 76, startPosY + 5, startPosX + 76, startPosY + 105);
        }

    }
}
