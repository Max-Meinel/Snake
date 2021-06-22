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
