import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddAnimalFrame extends JFrame {

    private JButton btnTutup  = new JButton("Add");

    private JTextField txtA = new JTextField();
    private JTextField txtB = new JTextField();

    private JLabel lblA = new JLabel("Enter type of animal:");
    private JLabel lblB = new JLabel("Enter Id of animal :");

    public AddAnimalFrame(){
        setTitle("Add animals");
        setSize(400,200);
        setLocation(new Point(300,200));
        setLayout(null);
        setResizable(false);

        initComponent();
        initEvent();

    }

    private void initComponent(){
        btnTutup.setBounds(300,130, 80,25);

        txtA.setBounds(175,10,100,20);
        txtB.setBounds(175,35,100,20);

        lblA.setBounds(20,10,175,20);
        lblB.setBounds(20,35,175,20);


        add(btnTutup);

        add(lblA);
        add(lblB);

        add(txtA);
        add(txtB);

    }

    private void initEvent() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        btnTutup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ff = txtA.getText();
                String aaa = txtB.getText();
                AddAnimal(e,ff,aaa);
                dispose();
            }
        });

    }


    public static void AddAnimal(ActionEvent evt,String typenew,String idnew)
    {

        Animal newAnimal = new Animal(idnew,"Hungry",0,typenew);
        MyFrame.animals.add(newAnimal);
        DB.setCurrentAnimals(MyFrame.animals);
    }

}


    /*

*/
