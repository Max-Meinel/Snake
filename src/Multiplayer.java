import javax.sound.sampled.Clip;

public class Multiplayer implements Runnable {
    public static boolean gameOver1 = false;
    public static boolean gameOver2 = false;
    @Override
    public void run() {
        Player p1 = new Player();
        Player p2 = new Player();
        Players.addPlayer(p1);
        Players.addPlayer(p2);
        p1.setDirection(1);
        p1.setHead_x(5);
        p1.setHead_y(8);
        p1.addTail(new Tail(5, 9));
        p1.addTail(new Tail(5, 10));
        p1.setApple_x(5);
        p1.setApple_y(4);

        p2.setDirection(1);
        p2.setHead_x(11);
        p2.setHead_y(8);
        p2.addTail(new Tail(11, 9));
        p2.addTail(new Tail(11, 10));
        p2.setApple_x(11);
        p2.setApple_y(4);

        GUI.create("multiplayer");
        Sound sound = new Sound();
        Clip background = sound.playSoundLoop("src/Sounds/background.wav");

        while (!p1.isGameOver() || !p2.isGameOver()) {
            if (!p1.isGameOver()) {
                SnakeBody.UpdateArrayList(p1);
                if (Players.getPlayer(0).getDirection() == 1) {
                    p1.setHead_y(p1.getHead_y() - 1);
                    p1.setDirectionBefore(1);
                }
                if (p1.getDirection() == 3) {
                    p1.setHead_y(p1.getHead_y() + 1);
                    p1.setDirectionBefore(3);
                }
                if (p1.getDirection() == 2) {
                    p1.setHead_x(p1.getHead_x() - 1);
                    p1.setDirectionBefore(2);
                }
                if (p1.getDirection() == 4) {
                    p1.setHead_x(p1.getHead_x() + 1);
                    p1.setDirectionBefore(4);
                }
                Collision.CheckCollision(p1);
                Apple.SpawnApple(p1);
            }
            if (!p2.isGameOver()) {
                SnakeBody.UpdateArrayList(p2);
                if (p2.getDirection() == 1) {
                    p2.setHead_y(p2.getHead_y() - 1);
                    p2.setDirectionBefore(1);
                }
                if (p2.getDirection() == 3) {
                    p2.setHead_y(p2.getHead_y() + 1);
                    p2.setDirectionBefore(3);
                }
                if (p2.getDirection() == 2) {
                    p2.setHead_x(p2.getHead_x() - 1);
                    p2.setDirectionBefore(2);
                }
                if (p2.getDirection() == 4) {
                    p2.setHead_x(p2.getHead_x() + 1);
                    p2.setDirectionBefore(4);
                }
                Collision.CheckCollision(p2);
                Apple.SpawnApple(p2);
                while (p1.getApple_x() == p2.getApple_y() && p1.getApple_y() == p2.getApple_y()) {
                    Apple.SpawnAppleAt(p2);
                }
            }
            CollisionMultiplayer.PlayerCollision(p1, p2);
            GUI.d.repaint();
            GUI.refreshScoreM();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        background.stop();
        GUI.jf.dispose();
        GameOverMultiplayer main = new GameOverMultiplayer();
        Thread t = new Thread(main);
        t.start();
    }
}
