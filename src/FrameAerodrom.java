import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

public class FrameAerodrom {
    private JFrame frame;
    private JTextField textFieldGetPlace;
    private AerodromPanel aerodromPanel;
    private Aerodrom<Aircraft, IAdditional> aerodrom;
    private JButton btnTakeAircraft;
    private JButton btnParkingAircraft;
    private JList<String> listOfAerodrom;
    private final DefaultListModel<String> listAerodromModel = new DefaultListModel<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameAerodrom window = new FrameAerodrom();
                    window.frame.setVisible( true );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );
    }

    public FrameAerodrom() {
        initialize();
    }

    private void initialize() {
        int width = 533;
        int height = 390;
        frame = new JFrame();
        frame.setBounds( 100, 100, 778, 546 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        aerodrom = new Aerodrom<Aircraft, IAdditional>( width, height );

        aerodromPanel = new AerodromPanel( aerodrom );
        aerodromPanel.setBounds( 0, 0, width, height );
        aerodromPanel.setBackground( new Color( 254, 254, 254) );
        frame.getContentPane().add( aerodromPanel );

        btnParkingAircraft = new JButton( "Посадить самолет" );
        btnParkingAircraft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Color mainColor = JColorChooser.showDialog( frame, "Выберите цвет лодки", Color.BLUE );
                if (mainColor != null) {
                    Aircraft aircraft = new Aircraft( 100, 1000, mainColor );
                    if (aerodrom.add( aircraft )) {
                        aerodromPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog( frame, "Гавань переполнена", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
                aerodromPanel.repaint();
            }
        } );
        btnParkingAircraft.setBounds( 548, 246, 193, 51 );
        frame.getContentPane().add( btnParkingAircraft );

        JButton btnTakeSeaPlane = new JButton( "Посадить гидросамолет" );
        btnTakeSeaPlane.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Color mainColor = JColorChooser.showDialog( frame, "Выберите цвет самолета", Color.BLUE );
                Color dopColor = JColorChooser.showDialog( frame, "Выберите цвет самолета", Color.BLUE );
                if (mainColor != null) {
                    Random random = new Random();
                    int typeBobbers = random.nextInt( 3 ) + 1;
                    int countBobbers = random.nextInt( 3 ) + 1;
                    countBobbers=countBobbers*2;
                    SeaPlane seaPlane = new SeaPlane( 100, 1000, mainColor, dopColor, true, true, true, typeBobbers, countBobbers);
                    if (aerodrom.add( seaPlane )) {
                       aerodromPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog( frame, "Аэродром переполнен", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
            }
        } );
        btnTakeSeaPlane.setBounds( 548, 213, 193, 29 );
        frame.getContentPane().add( btnTakeSeaPlane );

        textFieldGetPlace = new JTextField();
        textFieldGetPlace.setBounds( 657, 299, 84, 26 );
        frame.getContentPane().add( textFieldGetPlace );
        textFieldGetPlace.setColumns( 10 );

        btnTakeAircraft = new JButton( "Забрать" );
        btnTakeAircraft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textFieldGetPlace.getText() != "") {
                    Aircraft aircraft = aerodrom.remove( Integer.parseInt( textFieldGetPlace.getText() ) );
                    if (aircraft != null) {
                        EventQueue.invokeLater( () -> {
                            FrameAircraft formAircraft;
                            try {
                                formAircraft= new FrameAircraft( frame );
                                formAircraft.frame.setVisible( true );
                                frame.setVisible( false );
                            } catch (Exception exp) {
                                exp.printStackTrace();
                                return;
                            }
                            formAircraft.setAircraft(aircraft );
                        } );
                    } else
                        JOptionPane.showMessageDialog( frame, "Место пусто", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                    aerodromPanel.repaint();
                }
            }
        } );
        btnTakeAircraft.setBounds( 605, 341, 115, 29 );
        frame.getContentPane().add( btnTakeAircraft );


        JLabel lblPlaceAircraft = new JLabel( "Место" );
        lblPlaceAircraft.setBounds( 574, 302, 69, 20 );
        frame.getContentPane().add( lblPlaceAircraft );

        JLabel lblPickUpAircraft = new JLabel( "Забрать самолет" );
        lblPickUpAircraft.setBounds( 592, 263, 115, 20 );
        frame.getContentPane().add( lblPickUpAircraft );
    }
}