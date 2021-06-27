import javax.sound.sampled.Clip;
import javax.swing.*;

public class Singleplayer implements Runnable {
    @Override
    public void run() {
        Player p1 = new Player();

        MainMenu.allPlayers.addPlayer(p1);

        p1.addTail(new Tail(3, 7));
        p1.addTail(new Tail(2, 7));

        GUI.create("singleplayer");
        GUI.headImage.setIcon(new ImageIcon("src/Images/headRight.png"));
        Sound sound = new Sound();
        Clip background = sound.playSoundLoop("src/Sounds/background.wav");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!p1.isGameOver()) {
            SnakeBody.UpdateArrayList(p1);
            if (p1.getDirection() == 1) {
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
            GUI.d.repaint();
            GUI.refreshScore();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        background.stop();
        GUI.jf.dispose();
        GameOverSingleplayer main = new GameOverSingleplayer();
        Thread t = new Thread(main);
        t.start();
    }
}
