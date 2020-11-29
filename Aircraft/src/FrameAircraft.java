import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FrameAircraft{
    private JFrame frame;
    DrawPanelAircraft aircraftPanel;
    Aircraft aircraft;
    final Random random = new Random();
    JButton btnLeft;
    JButton btnRigth;
    JButton btnUp;
    JButton btnDown;
    JButton btnCreate;
    Direction direction;
    JLabel lblCountBobbers;
    private int countBobbers;
    private int typeBobbers;
    JLabel lblTypeBobbers;
    JButton btnSeaPlane;

    public static void main(String[] args) {
        EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    FrameAircraft window = new FrameAircraft();
                    window.frame.setVisible( true );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );
    }

    public FrameAircraft() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds( 100, 100, 900, 600 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        aircraftPanel = new DrawPanelAircraft(aircraft);
        aircraftPanel.setBounds( 0, 0, 650, 600 );
        frame.getContentPane().add(aircraftPanel );

        btnUp = new JButton( "" );
        btnUp.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft.MoveTransport( Direction.Up );
                aircraftPanel.repaint();
            }
        } );
        btnUp.setIcon( new ImageIcon( "верх.jpg" ) );
        btnUp.setBounds( 690, 350, 35, 35 );
        frame.getContentPane().add( btnUp );

        btnDown = new JButton( "" );
        btnDown.setIcon( new ImageIcon(
                "низ.jpg" ) );
        btnDown.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft.MoveTransport( Direction.Down );
                aircraftPanel.repaint();
            }
        } );
        btnDown.setBounds( 690, 390, 35, 35 );
        frame.getContentPane().add( btnDown );

        btnRigth = new JButton( "" );
        btnRigth.setIcon( new ImageIcon(
                "право.jpg" ) );
        btnRigth.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft.MoveTransport( Direction.Right );
                aircraftPanel.repaint();
            }
        } );
        btnRigth.setBounds( 730, 390, 35, 35 );
        frame.getContentPane().add( btnRigth );

        btnLeft = new JButton( "" );
        btnLeft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft.MoveTransport( Direction.Left );
                aircraftPanel.repaint();
            }
        } );
        btnLeft.setIcon( new ImageIcon(
                "лево.jpg" ) );
        btnLeft.setBounds( 650, 390, 35, 35 );
        frame.getContentPane().add( btnLeft );

        btnCreate = new JButton( "Создать самолет" );
        btnCreate.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aircraft = new Aircraft( random.nextInt( 300 ), random.nextInt( 1000 ), Color.GREEN );
                aircraftPanel.setAircraft( aircraft );
                aircraft.SetPosition( random.nextInt( 200 ), random.nextInt( 200 ),
                        aircraftPanel.getWidth(), aircraftPanel.getHeight() );
                lblTypeBobbers.setText( "Тип поплавков:- " );
                lblCountBobbers.setText( "Кол-во поплавков:- " );

                aircraftPanel.repaint();
            }
        } );
        btnCreate.setBounds( 666, 79, 156, 35 );
        frame.getContentPane().add( btnCreate );

        lblCountBobbers = new JLabel( "Кол-во поплавков: " );
        lblCountBobbers.setBackground( new Color( 173, 216, 230 ) );
        lblCountBobbers.setBounds( 660, 16, 176, 29 );
        frame.getContentPane().add( lblCountBobbers);

        lblTypeBobbers = new JLabel( "Тип поплавков:" );
        lblTypeBobbers.setBounds( 660, 45, 191, 20 );
        frame.getContentPane().add( lblTypeBobbers );

        btnSeaPlane = new JButton( "Создать гидросамолет " );
        btnSeaPlane.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                typeBobbers = random.nextInt( 3 ) +1;
                countBobbers = random.nextInt( 3 ) +1;
                countBobbers=countBobbers*2;
                aircraft = new SeaPlane( 100, 1000, Color.BLUE, Color.RED, true, true, true, typeBobbers, countBobbers );
                aircraftPanel.setAircraft( aircraft );
                aircraft.SetPosition( random.nextInt( 200 ), random.nextInt( 200 ),
                        aircraftPanel.getWidth(), aircraftPanel.getHeight() );
                lblCountBobbers.setText( "Кол-во поплавков: " + countBobbers );
                lblTypeBobbersIn( typeBobbers );
                aircraftPanel.repaint();
            }
        } );
        btnSeaPlane.setBounds( 660, 145, 156, 35 );
        frame.getContentPane().add( btnSeaPlane );
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


}