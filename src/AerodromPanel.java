import java.awt.*;

public class AerodromPanel extends Panel {

    private Aerodrom<Aircraft, IAdditional> aerodrom;

    public AerodromPanel(Aerodrom<Aircraft, IAdditional> park) {
        this.aerodrom = park;
    }

    public void paint(Graphics g) {
        super.paint( g );
        if (aerodrom != null) {
            aerodrom.draw( g );
        }
    }
    public void setAerodrom(Aerodrom<Aircraft, IAdditional>aerodrom) {
        this.aerodrom = aerodrom;
    }
}