import javax.sound.sampled.Clip;

public class Multiplayer implements Runnable {
    public static boolean gameOver1 = false;
    public static boolean gameOver2 = false;
    @Override
    public void run() {
        Player p1 = new Player();
        Player p2 = new Player();
        MainMenu.allPlayers.addPlayer(p1);
        MainMenu.allPlayers.addPlayer(p2);
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

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!p1.isGameOver() || !p2.isGameOver()) {
            if (!p1.isGameOver()) {
                SnakeBody.UpdateArrayList(MainMenu.allPlayers.getPlayer(0));
                if (MainMenu.allPlayers.getPlayer(0).getDirection() == 1) {
                    MainMenu.allPlayers.getPlayer(0).setHead_y(MainMenu.allPlayers.getPlayer(0).getHead_y() - 1);
                    p1.setDirectionBefore(1);
                }
                if (MainMenu.allPlayers.getPlayer(0).getDirection() == 3) {
                    MainMenu.allPlayers.getPlayer(0).setHead_y(MainMenu.allPlayers.getPlayer(0).getHead_y() + 1);
                    p1.setDirectionBefore(3);
                }
                if (MainMenu.allPlayers.getPlayer(0).getDirection() == 2) {
                    MainMenu.allPlayers.getPlayer(0).setHead_x(MainMenu.allPlayers.getPlayer(0).getHead_x() - 1);
                    p1.setDirectionBefore(2);
                }
                if (MainMenu.allPlayers.getPlayer(0).getDirection() == 4) {
                    MainMenu.allPlayers.getPlayer(0).setHead_x(MainMenu.allPlayers.getPlayer(0).getHead_x() + 1);
                    p1.setDirectionBefore(4);
                }
                Collision.CheckCollision(MainMenu.allPlayers.getPlayer(0));
                Apple.SpawnApple(MainMenu.allPlayers.getPlayer(0));
            }
            if (!p2.isGameOver()) {
                SnakeBody.UpdateArrayList(MainMenu.allPlayers.getPlayer(1));
                if (MainMenu.allPlayers.getPlayer(1).getDirection() == 1) {
                    MainMenu.allPlayers.getPlayer(1).setHead_y(MainMenu.allPlayers.getPlayer(1).getHead_y() - 1);
                    p2.setDirectionBefore(1);
                }
                if (MainMenu.allPlayers.getPlayer(1).getDirection() == 3) {
                    MainMenu.allPlayers.getPlayer(1).setHead_y(MainMenu.allPlayers.getPlayer(1).getHead_y() + 1);
                    p2.setDirectionBefore(3);
                }
                if (MainMenu.allPlayers.getPlayer(1).getDirection() == 2) {
                    MainMenu.allPlayers.getPlayer(1).setHead_x(MainMenu.allPlayers.getPlayer(1).getHead_x() - 1);
                    p2.setDirectionBefore(2);
                }
                if (MainMenu.allPlayers.getPlayer(1).getDirection() == 4) {
                    MainMenu.allPlayers.getPlayer(1).setHead_x(MainMenu.allPlayers.getPlayer(1).getHead_x() + 1);
                    p2.setDirectionBefore(4);
                }
                Collision.CheckCollision(MainMenu.allPlayers.getPlayer(1));
                Apple.SpawnApple(MainMenu.allPlayers.getPlayer(1));
                while (p1.getApple_x() == p2.getApple_y() && p1.getApple_y() == p2.getApple_y()) {
                    Apple.SpawnAppleAt(MainMenu.allPlayers.getPlayer(1));
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
