public class Main {

    public static void main(String[] args) {
        FrameAircraft frameAircraft = new FrameAircraft();
        DrawPanelAircraft drawPanelAircraft = new DrawPanelAircraft();
        frameAircraft.addDrawPanel(drawPanelAircraft);
    }

}
