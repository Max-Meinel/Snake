import java.util.ArrayList;

public class Player {
    public  ArrayList<Tail> tails;

    private int score;

    private boolean gameOver = false;

    private int head_x;
    private int head_y;

    private int apple_x;
    private int apple_y;
    //1 == up, 3 == down, 2 == left, 4 == right
    private int direction;
    private int directionBefore;

    private boolean newTail;

    public static int width = 800, heigth = 600;
    public static int xoff = 130, yoff = 20;

    public Player() {
        this.head_x = 4;
        this.head_y = 7;
        this.apple_x = 8;
        this.apple_y = 7;
        this.direction = 4;
        this.tails = new ArrayList<>();
        this.score = 0;
    }

    public void resetGame() {
        this.head_x = 4;
        this.head_y = 7;
        this.apple_x = 8;
        this.apple_y = 7;
        this.direction = 4;
        this.directionBefore = 2;
        this.tails = new ArrayList<>();
        this.addTail(new Tail(3, 7));
        this.addTail(new Tail(2, 7));
        this.score = 0;
    }

    public int getDirectionBefore() {
        return directionBefore;
    }

    public void setDirectionBefore(int directionBefore) {
        this.directionBefore = directionBefore;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Tail getTail(int i) {
        return tails.get(i);
    }

    public void addTail(Tail tail) {
        this.tails.add(tail);
    }

    public int getLength() {
        return tails.size();
    }

    public int getHead_x() {
        return head_x;
    }

    public void setHead_x(int head_x) {
        this.head_x = head_x;
    }

    public int getHead_y() {
        return head_y;
    }

    public void setHead_y(int head_y) {
        this.head_y = head_y;
    }

    public int getApple_x() {
        return apple_x;
    }

    public void setApple_x(int apple_x) {
        this.apple_x = apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public void setApple_y(int apple_y) {
        this.apple_y = apple_y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Player.width = width;
    }

    public static int getHeigth() {
        return heigth;
    }

    public static void setHeigth(int heigth) {
        Player.heigth = heigth;
    }

    public static int getXoff() {
        return xoff;
    }

    public static void setXoff(int xoff) {
        Player.xoff = xoff;
    }

    public static int getYoff() {
        return yoff;
    }

    public static void setYoff(int yoff) {
        Player.yoff = yoff;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
