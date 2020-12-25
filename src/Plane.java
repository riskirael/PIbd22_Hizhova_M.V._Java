import java.awt.*;

public abstract class Plane implements ITransport {

    public static int startPosX;
    public static int startPosY;
    protected int pictureWidth;
    protected int pictureHeight;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;

    public void SetPosition(int x, int y, int width, int height) {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

    public abstract void draw(Graphics g);

    public abstract void MoveTransport(Direction direction);
}