import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanelAircraft extends Panel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Aircraft aircraft;

    public DrawPanelAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void paint(Graphics g) {
        super.paint( g );
        if (aircraft != null)
            aircraft.draw( g );
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
