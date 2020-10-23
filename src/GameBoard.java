import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Viktor Kodet <br>
 * Date: 2020-10-22 <br>
 * Time: 17:19 <br>
 * Project: IntelliJ IDEA <br>
 */
public class GameBoard extends JFrame {

    List<Tile> tileList = new ArrayList<>();
    List<String> valueList = new ArrayList<>();
    int n;
    JLabel label = new JLabel(" ");
    boolean test;
    JButton shuffleButton = new JButton("New game");

    public List<Tile> generateTiles() {
        List<Tile> tempList = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            int row = i / n;
            int col = i % n;
            tempList.add(new Tile(row, col, valueList.get(i), l));
        }
        return tempList;
    }

    public boolean checkWinCondition(){
        for (int i = 0; i < tileList.size() - 1; i++){
            if (!tileList.get(i).getValue().equalsIgnoreCase("" + (i + 1))){
                return false;
            }
        } return true;
    }

    class WinWindow extends JFrame{
        JPanel winPanel1 = new JPanel();
        JPanel winPanel2 = new JPanel();
        JLabel winText = new JLabel("YOU WIN!");
        Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 50);
        JButton winButton = new JButton("New game");



        WinWindow(){
            winText.setFont(f2);
            setLayout(new BorderLayout());
            add(winPanel1, BorderLayout.CENTER);
            add(winPanel2, BorderLayout.SOUTH);
            winPanel1.add(winText);
            winPanel2.add(winButton);
            winButton.addActionListener(l2);
            setLocationRelativeTo(null);

            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
        }

        ActionListener l2 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                shuffleValues();
                dispose();
            }
        };
    }

    public List<String> generateValues(Boolean test) {
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            tempList.add("" + i);
        }
        String s = tempList.get(0);
        tempList.add(s);
        tempList.remove(0);
        if (test) {
            return tempList;
        }
        Collections.shuffle(tempList);
        return tempList;
    }

    public void shuffleValues() {
        List<String> shuffledValues = generateValues(false);
        for (int i = 0; i < tileList.size(); i++) {
            tileList.get(i).changeValue(shuffledValues.get(i));
        }
    }

    public void generateBoard() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        p3.add(shuffleButton);
        shuffleButton.addActionListener(l);
        p1.add(label);
        p2.setLayout(new GridLayout(n, n));

        for (int i = 0; i < tileList.size(); i++) {
            p2.add(tileList.get(i).getButton());
        }
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    ActionListener l = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == shuffleButton) {
                shuffleValues();
                label.setText("Tiles shuffled.");
            } else {
                for (Tile t : getTileList()) {
                    if (t.getButton() == e.getSource()) {
                        checkAdjacency(t);
                    }
                }
            }
        }
    };

    GameBoard(int n, boolean test) {
        this.test = test;
        this.n = n;
        valueList = generateValues(test);
        tileList = generateTiles();
        generateBoard();
    }

    public boolean isAdjacent(Tile pressed, Tile blank) {
        if (blank.getRow() == pressed.getRow() + 1 && blank.getCol() == pressed.getCol()
                || blank.getRow() == pressed.getRow() - 1 && blank.getCol() == pressed.getCol()
                || blank.getRow() == pressed.getRow() && blank.getCol() == pressed.getCol() + 1
                || blank.getRow() == pressed.getRow() && blank.getCol() == pressed.getCol() - 1) {
            return true;
        } else {
            return false;
        }
    }

    //TODO cleanup
    public void checkAdjacency(Tile pressed) {
        Tile blank = getBlankTile();
        if (isAdjacent(pressed, blank)) {
            String blankVal = blank.getValue();
            String pressedVal = pressed.getValue();
            blank.changeValue(pressedVal);
            pressed.changeValue(blankVal);
            label.setText("Tiles swapped.");
            if (checkWinCondition()){
                System.out.println("win");
                WinWindow win = new WinWindow();
            }
        } else {
            label.setText("Selected tile not adjacent to blank tile.");
        }
    }

    public Tile getBlankTile() {
        for (Tile t : getTileList()) {
            if (t.getValue().equalsIgnoreCase("0")) {
                return t;
            }
        }
        return null;
    }

    public List<Tile> getTileList() {
        return tileList;
    }
}
