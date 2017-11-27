import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;


class MyFrame extends JFrame {

    public static ArrayList<Animal> animals = new ArrayList<Animal>();
    Animal lion;
    Animal penguin;
    Animal zebra;
    Animal tiger;
    Animal hippo;

    private JButton btnFeedLion  = new JButton("Feed lion");
    private JButton btnGetStatusLion = new JButton("Get status of lion");
    private JButton btnFeedPenguin  = new JButton("Feed Penguin");
    private JButton btnGetStatusPenguin = new JButton("Get status of penguin");
    private JButton btnFeedZebra  = new JButton("Feed Zebra");
    private JButton btnGetStatusZebra = new JButton("Get status of Zebra");
    private JButton btnFeedHippo  = new JButton("Feed Hippo");
    private JButton btnGetStatusHippo = new JButton("Get status of Hippo");
    private JButton btnFeedTiger  = new JButton("Feed Tiger");
    private JButton btnGetStatusTiger = new JButton("Get status of Tiger");
    private JButton btnAddAnimal = new JButton("Add Animal");


    private JTextField txtA = new JTextField();
    private JTextField txtB = new JTextField();
    private JTextField txtC = new JTextField();
    private JTextField txtD = new JTextField();
    private JTextField txtE = new JTextField();

    private JTextField foodlion = new JTextField();
    private JTextField foodtiger = new JTextField();
    private JTextField foodhippo = new JTextField();
    private JTextField foodpenguin = new JTextField();
    private JTextField foodzebra = new JTextField();

    private JTextField statuslion = new JTextField();
    private JTextField statustiger = new JTextField();
    private JTextField statushippo = new JTextField();
    private JTextField statuspenguin = new JTextField();
    private JTextField statuszebra = new JTextField();


    private JLabel lbllion = new JLabel("Lion :");
    private JLabel lbltiger = new JLabel("Tiger :");
    private JLabel lblpenguin = new JLabel("Penguin :");
    private JLabel lblzebra = new JLabel("Zebra :");
    private JLabel lblhippo = new JLabel("Hippopotamus :");
    ImageIcon image = new ImageIcon("/home/mudit/IdeaProjects/GUI/lion.png");
    private JLabel imageLabelA = new JLabel(image);

    public void initialiseAnimals() throws InterruptedException {
        if(DB.getCurrentAnimals()!=null) {
            lion = new Animal("1", "Hungry", 0, "lion");
            penguin = new Animal("2", "Hungry", 0, "penguin");
            zebra = new Animal("3", "Hungry", 0, "zebra");
            hippo = new Animal("4", "Hungry", 0, "hippo");
            tiger = new Animal("5", "Hungry", 0, "tiger");

            animals.add(lion);
            animals.add(tiger);
            animals.add(penguin);
            animals.add(hippo);
            animals.add(zebra);

            DB.setCurrentAnimals(animals);
        }
        else
            animals = DB.getCurrentAnimals();

    }
    public MyFrame() throws InterruptedException {

        setTitle("Zoo");
        setSize(500,1000);
        setLocation(new Point(0,0));
        setLayout(null);
        setResizable(false);

        initComponent();
        initEvent();
    }

    private void initComponent() throws InterruptedException {
        initialiseAnimals();

        btnGetStatusLion.setBounds(300,70, 200,25);
        btnFeedLion.setBounds(300,40, 200,25);
        btnGetStatusTiger.setBounds(300,270, 200,25);
        btnFeedTiger.setBounds(300,240, 200,25);
        btnGetStatusHippo.setBounds(300,470, 200,25);
        btnFeedHippo.setBounds(300,440, 200,25);
        btnGetStatusPenguin.setBounds(300,670, 200,25);
        btnFeedPenguin.setBounds(300,640, 200,25);
        btnGetStatusZebra.setBounds(300,870, 200,25);
        btnFeedZebra.setBounds(300,840, 200,25);
        btnAddAnimal.setBounds(300,950,200,25);

        txtA.setText("ID - " + lion.getanimalID());
        txtB.setText("ID - " + penguin.getanimalID());
        txtC.setText("ID - " + zebra.getanimalID());
        txtD.setText("ID - " + hippo.getanimalID());
        txtE.setText("ID - " + tiger.getanimalID());

        foodpenguin.setText("Food of penguin - " + penguin.foodquantity);
        foodlion.setText("Food of lion - " + lion.foodquantity);
        foodtiger.setText("Food of tiger - " + tiger.foodquantity);
        foodhippo.setText("Food of hippo - " + hippo.foodquantity);
        foodzebra.setText("Food of zebra - " + zebra.foodquantity);



        txtA.setBounds(150,10,100,20);
        imageLabelA.setBounds(150,20,75,75);
        imageLabelA.setVisible(true);
        txtB.setBounds(150,210,100,20);
        txtC.setBounds(150,410,100,20);
        txtD.setBounds(150,610,100,20);
        txtE.setBounds(150,810,100,20);

        foodlion.setBounds(150,40,130,20);
        foodtiger.setBounds(150,240,130,20);
        foodhippo.setBounds(150,440,130,20);
        foodpenguin.setBounds(150,640,130,20);
        foodzebra.setBounds(150,840,130,20);

        statuslion.setBounds(150,70,100,20);
        statustiger.setBounds(150,270,100,20);
        statushippo.setBounds(150,470,100,20);
        statuspenguin.setBounds(150,670,100,20);
        statuszebra.setBounds(150,870,100,20);

        lbllion.setBounds(20,10,100,20);
        lbltiger.setBounds(20,210,100,20);
        lblhippo.setBounds(20,410,100,20);
        lblpenguin.setBounds(20,610,100,20);
        lblzebra.setBounds(20,810,100,20);

        add(btnFeedLion);
        add(btnGetStatusLion);
        add(btnFeedTiger);
        add(btnGetStatusTiger);
        add(btnFeedPenguin);
        add(btnGetStatusPenguin);
        add(btnFeedZebra);
        add(btnGetStatusZebra);
        add(btnFeedHippo);
        add(btnGetStatusHippo);
        add(btnAddAnimal);

        add(lbllion);
        add(lblzebra);
        add(lbltiger);
        add(lblhippo);
        add(lblpenguin);

        add(txtA);
        add(txtB);
        add(txtC);
        add(txtD);
        add(txtE);
        add(foodhippo);
        add(foodtiger);
        add(foodlion);
        add(foodzebra);
        add(foodpenguin);
        add(statushippo);
        add(statuslion);
        add(statustiger);
        add(statuspenguin);
        add(statuszebra);

        //add(imageLabelA);
        add(new JLabel(new ImageIcon("/home/mudit/IdeaProjects/GUI/lion.jpg")));
       // BufferedImage image = ImageIO.read(new File(pathToImage));
//        imageLabelA.setIcon(image);


    }

    private void initEvent(){

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });

        btnFeedLion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedLion(e);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        lion.foodquantity = 0;
                        foodlion.setText("Food of lion - 0");
                        new OptionPaneLion();
                    }
                }, 30*1000);
            }
        });
        btnGetStatusLion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetStatusLion(e);
            }
        });

        btnGetStatusTiger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetStatusTiger(e);
            }
        });
        btnFeedTiger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FeedTiger(e);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        tiger.foodquantity = 0;
                        foodtiger.setText("Food of tiger - 0");
                        new OptionPaneTiger();
                    }
                }, 20*1000);
            }
        });
        btnGetStatusPenguin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetStatusPenguin(e);
            }
        });
        btnFeedPenguin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedPenguin(e);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        penguin.foodquantity = 0;
                        foodpenguin.setText("Food of penguin - 0");
                        new OptionPanePenguin();
                    }
                }, 10*1000);
            }
        });
        btnGetStatusZebra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetStatusZebra(e);
            }
        });
        btnAddAnimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAnimal(e);
            }
        });
        btnFeedZebra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedZebra(e);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        zebra.foodquantity = 0;
                        foodzebra.setText("Food of zebra - 0");
                        new OptionPaneZebra();
                    }
                }, 15*1000);
            }
        });
        btnGetStatusHippo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetStatusHippo(e);
            }
        });
        btnFeedHippo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedHippo(e);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        hippo.foodquantity = 0;
                        foodhippo.setText("Food of hippo - 0");
                        new OptionPaneHippo();
                    }
                }, 25*1000);
            }
        });


    }

    public void feedLion(ActionEvent evt) {
        lion.feed();
        foodlion.setText("" + lion.foodquantity);

    }

    private void GetStatusLion(ActionEvent evt){

         try {
             String x =  lion.getStatus();
             statuslion.setText(x);
         }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void FeedTiger(ActionEvent evt){
        tiger.feed();
        foodtiger.setText("" +tiger.foodquantity);

    }

    private void GetStatusTiger(ActionEvent evt){

        try {
            String x = tiger.getStatus();
            statustiger.setText(x);
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void feedPenguin(ActionEvent evt) {
        penguin.feed();
        foodpenguin.setText("" + penguin.foodquantity);

    }
    private void GetStatusPenguin(ActionEvent evt){

        try {
            String x = penguin.getStatus();
            statuspenguin.setText(x);
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void feedHippo(ActionEvent evt) {
        hippo.feed();
        foodhippo.setText("" + hippo.foodquantity);

    }

    private void GetStatusHippo(ActionEvent evt){

        try {
            String x = hippo.getStatus();
            statushippo.setText(x);
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void feedZebra(ActionEvent evt) {
        zebra.feed();
        foodzebra.setText("" + zebra.foodquantity);

    }
    private void GetStatusZebra(ActionEvent evt){

        try {
            String x = zebra.getStatus();
            statuszebra.setText(x);
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void addAnimal(ActionEvent evt){

        AddAnimalFrame x = new AddAnimalFrame();
        x.setVisible(true);
    }
}
