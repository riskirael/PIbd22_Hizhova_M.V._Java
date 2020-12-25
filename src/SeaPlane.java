import java.awt.*;

public class SeaPlane extends Aircraft {
    public IAdditional iAdditional;

    public Color DopColor;
    public boolean stripes;
    public boolean bobber;

    private int addClass;
    private int countBobbers;

    public SeaPlane(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean stripes, boolean bobber,
                    boolean b, int AddClass, int countBobbers) {
        super(maxSpeed, weight, mainColor, 110, 60 );
        this.DopColor = dopColor;
        this.stripes = stripes;
        this.bobber = bobber;
        if (AddClass == 1)
            this.iAdditional = new CircleBobbers(countBobbers);
        if (AddClass == 2)
            this.iAdditional = new RectangleBobbers(countBobbers);
        if (AddClass == 3)
            this.iAdditional = new SquareBobbers(countBobbers);
    }

    public void draw(Graphics g) {
        if (bobber) {
            iAdditional.drawBobbers( g, DopColor, startPosX, startPosY );
        }
        super.draw(g);
        g.setColor(Color.black);
        if (stripes) {
            g.drawLine(startPosX + 70, startPosY + 5, startPosX + 70, startPosY + 105);
            g.drawLine(startPosX + 72, startPosY + 5, startPosX + 72, startPosY + 105);
            g.drawLine(startPosX + 74, startPosY + 5, startPosX + 74, startPosY + 105);
            g.drawLine(startPosX + 76, startPosY + 5, startPosX + 76, startPosY + 105);
        }
    }
    public int getAddClass() {
        return addClass;
    }

    public int getCountBobbers() {
        return countBobbers;
    }
}
