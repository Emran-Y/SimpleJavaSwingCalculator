import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Beki extends JFrame {

    String CalculatorPressed(Object obj, String num1, String num2) {

        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);

        boolean add = "ADDITION" == obj;
        boolean sub = "SUBTRACTION" == obj;
        boolean mul = "MULTIPLICATION" == obj;
        if (add) {
            // +
            double result = numb1 + numb2;
            String str = String.valueOf(result);
            return str;

        } else if (sub) {
            // -
            double result = numb1 - numb2;
            String str = String.valueOf(result);
            return str;
        } else if (mul) {
            // X
            double result = numb1 * numb2;
            String str = String.valueOf(result);
            return str;
        } else {
            // div/
            double result = numb1 / numb2;
            String str = String.valueOf(result);
            return str;
        }

    }

    String QuitPressed() {
        return "";
    }

    // intermediate container
    JPanel panelO;
    JPanel panelY;

    // Creating the Constructor and try to populate the components

    Beki() {
        // WORKING ON MAIN container which is the frame
        super("CALCULATOR");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // initializing the panels

        panelY = new JPanel();
        panelO = new JPanel();

        // setting the panel's background to each panels

        panelY.setBackground(Color.darkGray);
        panelO.setBackground(Color.lightGray);

        // creating the components of the panels

        // for panelY
        JButton Cbutton = new JButton();
        JButton Qbutton = new JButton();

        // for panelO
        JLabel label1 = new JLabel("LET'S CALCULATE!");
        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        JComboBox combo = new JComboBox();
        JLabel label2 = new JLabel("RESULT ~~>");
        JTextField ANSF = new JTextField(6);
        combo.getSelectedItem();

        // DECORING PERIOD FOR THE PANELS COMPONENTS

        // panelY and then panelO

        Cbutton.setBackground(Color.orange);
        Cbutton.setText("Calculate");
        Cbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object item_now = combo.getSelectedItem();
                ANSF.setText(CalculatorPressed(item_now, text1.getText(), text2.getText()));
            }
        });
        Qbutton.setBackground(Color.red);
        Qbutton.setText("Quit");
        Qbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText(QuitPressed());
                text2.setText(QuitPressed());
                ANSF.setText(QuitPressed());
            }
        });

        text1.setBackground(Color.white);
        text2.setBackground(Color.white);
        label1.setBackground(Color.WHITE);
        ANSF.setBackground(Color.white);
        // for the combo
        String[] combo_items = { "ADDITION", "SUBTRACTION", "DIVISION", "MULTIPLICATION" };
        for (String item : combo_items) {
            combo.addItem(item);
        }
        combo.setBackground(Color.LIGHT_GRAY);

        // ADDING THOSE TO THE INDI PANELS

        panelO.add(label1);
        panelO.add(text1);
        panelO.add(text2);
        panelO.add(combo);
        panelO.add(label2);
        panelO.add(ANSF);

        panelY.add(Cbutton);
        panelY.add(Qbutton);

        // ADDING TO THE FRAME

        add(panelO, BorderLayout.NORTH);
        add(panelY, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Beki beki = new Beki();

    }

}