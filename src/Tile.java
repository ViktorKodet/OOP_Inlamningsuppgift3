import javax.swing.*;
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

    Tile(int row, int col, String value, ActionListener l) {
        setRow(row);
        setCol(col);
        setValue(value);
        setButton(new JButton(decideDisplayText()));
        button.addActionListener(l);
    }


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

    private String decideDisplayText() {
        if (getValue().equalsIgnoreCase("0")) {
            return "";
        } else {
            return getValue();
        }
    }

    public void changeValue(String value) {
        this.value = value;
        getButton().setText(decideDisplayText());
    }
}
