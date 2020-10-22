import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Viktor Kodet <br>
 * Date: 2020-10-22 <br>
 * Time: 17:07 <br>
 * Project: IntelliJ IDEA <br>
 */
public class Tile {
    private int row;
    private int col;
    private JButton button;
    private String value;

    Tile(int row, int col, String value){
        setRow(row);
        setCol(col);
        setValue(value);
        setButton(new JButton(value));
        button.addActionListener(l);
    }

    ActionListener l = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button);
            button.setText("" + row + ", " + col);
        }
    };

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
