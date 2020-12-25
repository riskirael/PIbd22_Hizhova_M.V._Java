import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FrameAircraft {
    public static JFrame frame;
    public JFrame parentFrame;
    DrawPanelAircraft aircraftPanel;
    Aircraft aircraft;
    final Random random = new Random();
    JButton btnLeft;
    JButton btnRigth;
    JButton btnUp;
    JButton btnDown;
    JButton btnBack;
    JLabel lblCountBobbers;
    JLabel lblTypeBobbers;

    public void run() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameAircraft window = new FrameAircraft( parentFrame );
                    window.frame.setVisible( true );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );
    }

    public FrameAircraft(JFrame frame) {
        initialize();
        this.parentFrame = frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground( new Color( 240, 248, 255 ) );
        frame.setBounds( 100, 100, 831, 549 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        aircraft = getAircraft();

        aircraftPanel = new DrawPanelAircraft( aircraft );
        aircraftPanel.setBackground( new Color( 135, 206, 250 ) );
        aircraftPanel.setBounds( 0, 0, 603, 493 );
        frame.getContentPane().add( aircraftPanel );

        btnUp = new JButton( "" );
        btnUp.setBackground( UIManager.getColor( "MenuItem.selectionBackground" ) );
        btnUp.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft = getAircraft();
                aircraft.MoveTransport( Direction.Up );
                aircraftPanel.repaint();
            }
        } );
        btnUp.setIcon( new ImageIcon( ".\\assets\\up.jpg" ) );
        btnUp.setBounds( 690, 352, 35, 35 );
        frame.getContentPane().add( btnUp );

        btnDown = new JButton( "" );
        btnDown.setBackground( UIManager
                .getColor( "PasswordField.selectionBackground" ) );
        btnDown.setIcon( new ImageIcon(
                ".\\assets\\down.jpg" ) );
        btnDown.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft = getAircraft();
                aircraft.MoveTransport( Direction.Down );
                aircraftPanel.repaint();
            }
        } );
        btnDown.setBounds( 690, 416, 35, 35 );
        frame.getContentPane().add( btnDown );

        btnRigth = new JButton( "" );
        btnRigth.setBackground( UIManager.getColor( "MenuItem.selectionBackground" ) );
        btnRigth.setIcon( new ImageIcon(
                ".\\assets\\rigth.jpg" ) );
        btnRigth.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft= getAircraft();
                aircraft.MoveTransport( Direction.Right );
                aircraftPanel.repaint();
            }
        } );
        btnRigth.setBounds( 722, 383, 35, 35 );
        frame.getContentPane().add( btnRigth );

        btnLeft = new JButton( "" );
        btnLeft.setBackground( UIManager.getColor( "MenuItem.selectionBackground" ) );
        btnLeft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft = getAircraft();
                aircraft.MoveTransport( Direction.Left );
                aircraftPanel.repaint();
            }
        } );
        btnLeft.setIcon( new ImageIcon(
                ".\\assets\\left.jpg" ) );
        btnLeft.setBounds( 656, 383, 35, 35 );
        frame.getContentPane().add( btnLeft );

        btnBack = new JButton( "На аэродром" );
        btnBack.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                parentFrame.setVisible( true );
                frame.setVisible( false );
            }
        } );
        btnBack.setBackground( new Color( 173, 216, 230 ) );
        btnBack.setBounds( 638, 79, 156, 35 );
        frame.getContentPane().add( btnBack );

        lblCountBobbers = new JLabel( "Кол-во поплавков: " );
        lblCountBobbers.setBackground( new Color( 173, 216, 230 ) );
        lblCountBobbers.setBounds( 618, 16, 176, 29 );
        frame.getContentPane().add( lblCountBobbers );

        lblTypeBobbers = new JLabel( "Тип поплавков:" );
        lblTypeBobbers.setBounds( 618, 45, 191, 20 );
        frame.getContentPane().add( lblTypeBobbers );
    }

    public void lblTypeBobbersIn(int typeBobbers) {
        if (typeBobbers == 1) {
            lblTypeBobbers.setText( "Тип поплавков: " + "овальный" );
        }
        if (typeBobbers == 2) {
            lblTypeBobbers.setText( "Тип поплавков: " + "прямоугольный" );
        }
        if (typeBobbers== 3) {
            lblTypeBobbers.setText( "Тип поплавков: " + "квадратный" );
        }
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft =aircraft;
        aircraft.SetPosition( random.nextInt( 200 ), random.nextInt( 200 ),
                aircraftPanel.getWidth(), aircraftPanel.getHeight() );
        aircraftPanel.setAircraft( aircraft);
        if (aircraft.getClass() == SeaPlane.class) {
            lblTypeBobbersIn( ((SeaPlane) aircraft).getAddClass() );
            lblCountBobbers.setText( "Количество поплавков: " + ((SeaPlane) aircraft).getCountBobbers() );
        }
        aircraftPanel.repaint();
    }
}
