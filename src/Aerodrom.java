import java.awt.*;
import java.util.ArrayList;

public class Aerodrom<T extends ITransport, D extends IAdditional> {

    public ArrayList<T> places;
    private int pictureWidth;
    private int pictureHeight;
    private int placeSizeWidth = 210;
    private int placeSizeHeight = 150;

    private int maxCount;

    public Aerodrom(int picWidth, int picHeight) {
        int width = picWidth / placeSizeWidth;
        int height = picHeight / placeSizeHeight;
        maxCount = width * height;
        places = new ArrayList<T>();
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public boolean add(T aircraft) {
        if (places.size() >= maxCount) {
            return false;
        }
        places.add( aircraft );
        return true;
    }

    public T remove(int index) {
        if (index < -1 || index > places.size()) {
            return null;
        }
        T aircraft= (T) places.get( index );
        places.remove( index );
        return aircraft;
    }

    public T get(int index) {
        if (index >= places.size() || index < 0) {
            return null;
        }
        return (T) places.get( index );
    }

    public int count(){
        int counter = 0;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null) {
                counter++;
            }
        }
        return counter;
    }
    public boolean moreOrEqual(int number) {
        return number >= count();
    }

    public boolean lessOrEqual(int number) {
        return number <= count();
    }


    public void draw(Graphics g) {
        DrawMarking( g );
        int margin = 10;
        int x = 0;
        int y = 0;
        int placesWidth = pictureWidth / placeSizeWidth;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null) {
                T place = (T) places.get(i);
                place.SetPosition( x + 4 * margin + (placeSizeWidth + margin) * (i % placesWidth),
                        y + margin + placeSizeHeight * (i / placesWidth), pictureWidth, pictureHeight );
                place.draw( g );
            }
        }
    }

    public void DrawMarking(Graphics g) {
        int x = 0;
        int interval = 35;
        g.setColor( Color.BLACK );
        for (int i = 0; i < pictureWidth / placeSizeWidth; i++) {
            for (int j = 0; j < pictureHeight / placeSizeHeight + 1; ++j) {
                g.drawLine( x + (placeSizeWidth + interval) * i, j * placeSizeHeight, x + placeSizeWidth + (placeSizeWidth + interval) * i, j * placeSizeHeight );
            }
            g.drawLine( i * (placeSizeWidth + interval), 0, i * (placeSizeWidth + interval), (pictureHeight / placeSizeHeight) * placeSizeHeight );
        }
    }


}