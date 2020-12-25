import java.awt.*;

public class SquareBobbers implements IAdditional {
    private AdditionalEnumBobbers addEnumBobbers;
    public int countBobbers;

    public SquareBobbers(int CountBobbers) {
        setCountBobbers( CountBobbers);
    }

    @Override
    public void setCountBobbers(int countBobbers) {
        addEnumBobbers= AdditionalEnumBobbers.countEnumBobbers( countBobbers );
    }
    @Override
    public void drawBobbers(Graphics g, Color dopColor, int x, int y) {
        switch (addEnumBobbers) {
            case sixBobbers: {
                g.setColor(dopColor);
                g.fillRect(x + 50, y + 35, 10, 10);
                g.fillRect(x + 50, y + 66, 10, 10);
            }
            case fourBobbers: {
                g.setColor(dopColor);
                g.fillRect(x + 50, y + 5, 10, 10);
                g.fillRect(x + 50, y + 80, 10, 10);
            }
            case twoBobbers: {
                g.setColor(dopColor);
                g.fillRect(x + 50, y + 20, 10, 10);
                g.fillRect(x + 50, y + 95, 10, 10);
            }
        }
    }
}