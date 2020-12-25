import java.util.HashMap;

public class AerodromCollection {
    public HashMap<String, Aerodrom<Aircraft, IAdditional>> aerodromStages;

    public String[] keys() {
        return aerodromStages.keySet().toArray( new String[aerodromStages.keySet().size()] );
    }

    private int pictureWidth;

    private int pictureHeight;

    public AerodromCollection(int pictureWidth, int pictureHeight) {
        aerodromStages = new HashMap<String, Aerodrom<Aircraft, IAdditional>>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    public void AddAerodrom(String name) {
        if (aerodromStages.containsKey( name )) {
            return;
        }
        aerodromStages.put( name, new Aerodrom<Aircraft, IAdditional>( pictureWidth, pictureHeight ) );
    }

    public void DelAerodrom(String name) {
        if (aerodromStages.containsKey( name )) {
            aerodromStages.remove( name );
        }
    }

    public void DelAerodrom(int index) {
        if (aerodromStages.containsKey( index )) {
            aerodromStages.remove( index );
        }
    }

    public Aerodrom<Aircraft, IAdditional> get(String ind) {
        if (aerodromStages.containsKey( ind )) {
            return aerodromStages.get( ind );
        }
        return null;
    }

    public Plane getIndex(String ind, int index) {
        if (!aerodromStages.containsKey( ind )) {
            return null;
        }
        return aerodromStages.get( ind ).get( index );
    }
}