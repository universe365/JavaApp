import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    static App app = new App();
    Counter cal;
    double PRICE, DOWN, INTEREST, YEARS;
    JPanel p;
    JButton btn;
    JLabel lblprice, lbldown, lblint, lblyr, lblproperty;
    JTextField txtprice, txtdown, txtint, txtyr, txtproperty;
    JTextArea result;
    
    // frame values
    static int WIDTH = 250;
    static int HEIGHT = 300;
    static int sw = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - WIDTH )/2;
    static int sh = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - HEIGHT )/2;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                app.setSize(WIDTH, HEIGHT);
                app.setLocation(sw, sh);
                app.setResizable(false);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
                app.execute();
            }
            
        });
    }




    private void execute(){

        lblprice = new JLabel("Pice" );
        lbldown = new JLabel("Down payment (%)" );
        lblproperty = new JLabel("Property: ");
        lblint = new JLabel("Interest (%)" );
        lblyr = new JLabel("Years" );
        txtdown = new JTextField(10);
        txtprice = new JTextField(10);
        txtproperty = new JTextField(10);
        txtproperty.setEditable(false);
        txtint = new JTextField(10);
        txtyr = new JTextField(10);


        btn = new JButton("Calculate");
        result = new JTextArea("");





        p = new JPanel();
        p.setLayout(new GridLayout(6, 2));
        p.add(lblprice);  p.add(txtprice); 
        p.add(lbldown); p.add(txtdown);
        p.add(lblproperty); p.add(txtproperty);
        p.add(lblint); p.add(txtint);
        p.add(lblyr); p.add(txtyr);
        p.add(btn); p.add(result);


        setContentPane(p);






        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                PRICE = Double.parseDouble(txtprice.getText());
                DOWN = Double.parseDouble(txtdown.getText());
                INTEREST = Double.parseDouble(txtint.getText());
                YEARS = Double.parseDouble(txtyr.getText());
                
                cal = new Counter(PRICE, DOWN, INTEREST, YEARS);

                System.out.println( "price: \t"+ cal.getPRICE() +"down: \t"+ cal.getDOWN() +"interest:\t"+ cal.getINTEREST() +"year:\t"+ cal.getYEARS()+"property:\t"+ cal.getPROPERTY()+" result"+ cal.count());
                result.setText(""+ cal.count());
            }
            
        });



    }




























}