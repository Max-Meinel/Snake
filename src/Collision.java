import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Collision {
    public static void CheckCollision(Player player) {
        boolean reset = false;
        if (player.tails.size() > 0) {
            if (player.getHead_x() > 15 || player.getHead_x() < 0) {
                reset = true;
            }
            if (player.getHead_y() > 15 || player.getHead_y() < 0) {
                reset = true;
            }
            for (int i = 0; i < player.tails.size(); i++) {
                if (player.getHead_x() == player.getTail(i).getX() && player.getHead_y() == player.getTail(i).getY()) {
                    reset = true;
                }
            }
        }
        if (reset) {
            Sound sound = new Sound();
            sound.playSound("src/Sounds/crash.wav");
            player.setGameOver(true);
            player.tails.remove(0);
            try {
                if (player.getScore() > SaveData.getHighscore()) {
                    SaveData.setHighscore(player.getScore());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
