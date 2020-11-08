import javax.swing.*;
import java.awt.*;

public class DrawPanelAircraft extends JPanel {
    private SeaPlane seaPlane;

    public void paintComponent(Graphics g) {
        if (seaPlane != null)
            seaPlane.draw(g);
    }

    public void setSeaPlane(SeaPlane seaPlane) {
        this.seaPlane = seaPlane;
    }

    public SeaPlane getSeaPlane() {
        return seaPlane;
    }
}