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
    private JButton btnTakeFirstAircraft;
    private JButton btnParkingAircraft;
    private AerodromCollection aerodromCollection;
    private JList<String> listOfAerodrom;
    private final DefaultListModel<String> listAerodromModel = new DefaultListModel<>();
    private Queue<Aircraft> deleteAircrafts = new ArrayDeque<>();

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

        JLabel stationsLabel = new JLabel( "Аэродром:" );
        stationsLabel.setBounds( width, 20, 100, 20 );
        frame.add( stationsLabel );

        JTextField addNewStationTextField = new JTextField( 2 );
        addNewStationTextField.setFont( addNewStationTextField.getFont().deriveFont( 20f ) );
        addNewStationTextField.setBounds( width, 40, 200, 20 );
        frame.add( addNewStationTextField );

        JButton addStationButton = new JButton( "Добавить аэродром" );
        addStationButton.addActionListener( e -> {
            if (addNewStationTextField.getText().equals( "" )) {
                JOptionPane.showMessageDialog( frame, "Введите название аэродрома", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
                return;
            }
            aerodromCollection.AddAerodrom( addNewStationTextField.getText() );
            ReloadLevels();
        } );
        addStationButton.setBounds( width, 60, 200, 20 );
        frame.add( addStationButton );

        aerodromCollection = new AerodromCollection( width, height );

        for (String key : aerodromCollection.keys()) {
            listAerodromModel .addElement( key );
        }
        listOfAerodrom = new JList<>( listAerodromModel  );
        listOfAerodrom.setLayoutOrientation( JList.VERTICAL );
        listOfAerodrom.setBounds( width + 20, 90, 130, 80 );
        listOfAerodrom.addListSelectionListener( e -> {
            if (listOfAerodrom.getSelectedIndex() > -1) {
                aerodromPanel.setAerodrom( aerodromCollection.get( listAerodromModel .get( listOfAerodrom.getSelectedIndex() ) ) );
                aerodromPanel.repaint();
            }
        } );
        frame.add( listOfAerodrom );

        JButton deleteStationButton = new JButton( "Удалить аэродром" );
        deleteStationButton.addActionListener( e -> {
            if (listOfAerodrom.getSelectedIndex() > -1) {
                if (JOptionPane.showConfirmDialog( frame, "Удалить аэродром " + listAerodromModel.get( listOfAerodrom.getSelectedIndex() ) + "?", "Удаление", JOptionPane.OK_CANCEL_OPTION )
                        == JOptionPane.OK_OPTION) {
                    aerodromCollection.DelAerodrom( listAerodromModel.get( listOfAerodrom.getSelectedIndex() ) );
                    ReloadLevels();
                    aerodromPanel.repaint();
                }
            }
        } );
        deleteStationButton.setBounds( width, 180, 200, 20 );
        frame.add( deleteStationButton );

        btnParkingAircraft = new JButton( "Посадить самолет" );
        btnParkingAircraft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (listOfAerodrom.getSelectedIndex() > -1) {
                    Color mainColor = JColorChooser.showDialog( frame, "Выберите цвет самолета", Color.BLUE );
                    if (mainColor != null) {
                        Aircraft aircraft = new Aircraft( 100, 1000, mainColor );
                        if (aerodromCollection.get( listAerodromModel.get( listOfAerodrom.getSelectedIndex() ) ).add( aircraft )) {
                            aerodromPanel.repaint();
                        } else {
                            JOptionPane.showMessageDialog( frame, "Аэродром переполнен", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }
                    aerodromPanel.repaint();
                } else
                    JOptionPane.showMessageDialog( frame, "Нет аэродрома", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
            }
        } );
        btnParkingAircraft.setBounds( 548, 246, 193, 51 );
        frame.getContentPane().add( btnParkingAircraft );

        JButton btnTakeSeaPlane = new JButton( "Посадить гидросамолет" );
        btnTakeSeaPlane.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (listOfAerodrom.getSelectedIndex() > -1) {
                    Color mainColor = JColorChooser.showDialog( frame, "Выберите цвет самолета", Color.BLUE );
                    Color dopColor = JColorChooser.showDialog( frame, "Выберите цвет самолета", Color.BLUE );
                    if (mainColor != null) {
                        Random random = new Random();
                        int typeBobbers = random.nextInt( 3 ) +1;
                        int countBobbers = random.nextInt( 3 ) +1;
                        countBobbers=countBobbers*2;
                        SeaPlane seaPlane = new SeaPlane( 100, 1000, mainColor, dopColor, true, true, true, typeBobbers, countBobbers );
                        if ((aerodromCollection.get( listAerodromModel.get( listOfAerodrom.getSelectedIndex() ) ).add( seaPlane ))) {
                            aerodromPanel.repaint();
                        } else {
                            JOptionPane.showMessageDialog( frame, "Аэродром переполнен", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                        }
                        aerodromPanel.repaint();
                    }
                } else
                    JOptionPane.showMessageDialog( frame, "Нет аэродрома", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
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
                if (listOfAerodrom.getSelectedIndex() > -1) {
                    if (!textFieldGetPlace.getText().equals( "" )) {
                        int numPlace;
                        try {
                            numPlace = Integer.parseInt( textFieldGetPlace.getText() );
                        } catch (Exception ex) {
                            return;
                        }
                        if ((aerodromCollection.get( listAerodromModel .get( listOfAerodrom.getSelectedIndex() ) ).get( numPlace )) != null) {
                            Aircraft aircraft = aerodromCollection.get( listAerodromModel.get( listOfAerodrom.getSelectedIndex() ) ).remove( numPlace );
                            if (aircraft != null) {
                                deleteAircrafts.add( aircraft );
                            }
                        } else
                            JOptionPane.showMessageDialog( frame, "Нет самолета", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                        aerodromPanel.repaint();
                    }
                }
            }
        } );
        btnTakeAircraft.setBounds( 605, 341, 115, 29 );
        frame.getContentPane().add( btnTakeAircraft );

        btnTakeFirstAircraft = new JButton( "Первый улетевший" );
        btnTakeFirstAircraft.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (deleteAircrafts.size() <= 0) {
                    JOptionPane.showMessageDialog( frame, "Нет улетевших самолетов", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                } else {
                    Aircraft aircraft = deleteAircrafts.poll();
                    EventQueue.invokeLater( () -> {
                                FrameAircraft formAircraft;
                                try {
                                    formAircraft = new FrameAircraft( frame );
                                    formAircraft.frame.setVisible( true );
                                    frame.setVisible( false );
                                } catch (Exception exp) {
                                    exp.printStackTrace();
                                    return;
                                }
                                formAircraft.setAircraft( aircraft );
                            }
                    );
                    deleteAircrafts.remove( aircraft );
                }
                aerodromPanel.repaint();
            }
        } );
        btnTakeFirstAircraft.setBounds( 550, 381, 200, 29 );
        frame.getContentPane().add( btnTakeFirstAircraft );

        JLabel lblPlaceAircraft = new JLabel( "Место" );
        lblPlaceAircraft.setBounds( 574, 302, 69, 20 );
        frame.getContentPane().add( lblPlaceAircraft );

        JLabel lblPickUpAircraft = new JLabel( "Забрать самолет" );
        lblPickUpAircraft.setBounds( 592, 263, 115, 20 );
        frame.getContentPane().add( lblPickUpAircraft );
    }

    private void ReloadLevels() {
        int index = listOfAerodrom.getSelectedIndex();
        listOfAerodrom.setSelectedIndex( -1 );
        listAerodromModel.clear();
        for (int i = 0; i < aerodromCollection.keys().length; i++) {
            listAerodromModel.addElement( aerodromCollection.keys()[i] );
        }

        if (listAerodromModel.size() > 0 && (index == -1 || index >= listAerodromModel.size())) {
            listOfAerodrom.setSelectedIndex( 0 );
        } else if (listAerodromModel.size() > 0 && index > -1 && index < listAerodromModel.size()) {
            listOfAerodrom.setSelectedIndex( index );
        }
    }
}