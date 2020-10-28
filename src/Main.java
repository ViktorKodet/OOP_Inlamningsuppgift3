public class Main {



    public static void main(String[] args) {

        for (int i = 0; i < 4 * 4; i++) {
            int r = i / 4;
            int c = i % 4;
            System.out.println("row : " + r + ", col : " + c);
        }

        GameBoard g = new GameBoard(4, true);

    }
}
