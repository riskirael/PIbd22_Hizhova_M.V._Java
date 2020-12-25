import java.awt.*;

public class Aircraft extends Plane
{
    private int aircraftWidth = 120;
    private int aircraftHeight = 95;

    public Aircraft(int maxSpeed, float weight, Color mainColor)
    {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
    }

    protected Aircraft(int maxSpeed, float weight, Color mainColor, int boatWidth, int boatHeight)
    {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
        this.aircraftWidth = aircraftWidth;
        this.aircraftHeight =aircraftHeight;
    }

    @Override
    public void MoveTransport(Direction direction) {
        float step = MaxSpeed * 100 / Weight;
        switch (direction) {
            case Right:
                if (startPosX + step < pictureWidth - aircraftWidth) {
                    startPosX = ( (int) (startPosX + step));
                }
                break;
            case Left:
                if (startPosX - step > 0) {
                    startPosX = ( (int) (startPosX - step));

                }
                break;
            case Up:
                if (startPosY - step > 0) {
                    startPosY =( (int) (startPosY - step) );
                }
                break;
            case Down:
                if (startPosY + step < pictureHeight -aircraftHeight) {
                    startPosY = ( (int) (startPosY + step) );
                }
                break;
        }
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(MainColor);
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

    }
}