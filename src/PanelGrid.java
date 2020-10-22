import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Viktor Kodet <br>
 * Date: 2020-10-22 <br>
 * Time: 13:19 <br>
 * Project: IntelliJ IDEA <br>
 */
public class PanelGrid extends JFrame{
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel label = new JLabel("text");

    PanelGrid(){
        setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(2,2));
        add(p1, BorderLayout.NORTH);
        p1.add(label);
        add(p2, BorderLayout.CENTER);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        b1.addActionListener(l);
        b2.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        PanelGrid pg = new PanelGrid();
    }

    ActionListener l = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
                label.setText("" + e.getID());


        }
    };

}
