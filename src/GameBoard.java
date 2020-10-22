import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor Kodet <br>
 * Date: 2020-10-22 <br>
 * Time: 17:19 <br>
 * Project: IntelliJ IDEA <br>
 */
public class GameBoard extends JFrame {

    List<Tile> tileList = new ArrayList<>();
    int n;
    List<String> valueList = new ArrayList<>();

    public List<Tile> generateTiles(int n){
        int input = n;
        List<Tile> tempList = new ArrayList<>();
        for (int i = 0; i < input * input; i++) {
            int row = i / input;
            int col = i % input;
            tempList.add(new Tile(row, col, "" + i));
        }
        return tempList;
    }

    public void generateBoard(int n){
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JLabel label = new JLabel(" ");
        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        p1.add(label);
        p2.setLayout(new GridLayout(n, n));

        for (int i = 0; i < tileList.size(); i++){
            p2.add(tileList.get(i).getButton());
        }
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    GameBoard(int n){
        this.n = n;
        tileList = generateTiles(n);
        generateBoard(n);
    }

    public void checkAdjacency(){

    }

    public List<Tile> getTileList() {
        return tileList;
    }
}
