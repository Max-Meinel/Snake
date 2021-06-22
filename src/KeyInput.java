import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (MainMenu.allPlayers.getPlayer(0).getDirectionBefore() != 3) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                Sound sound = new Sound();
                sound.playSound("src/Sounds/up.wav");
                MainMenu.allPlayers.getPlayer(0).setDirection(1);
                GUI.headImage.setIcon(new ImageIcon("src/Images/headUp.png"));
            }
        }
        if (MainMenu.allPlayers.getPlayer(0).getDirectionBefore() != 4) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                Sound sound = new Sound();
                sound.playSound("src/Sounds/left.wav");
                MainMenu.allPlayers.getPlayer(0).setDirection(2);
                GUI.headImage.setIcon(new ImageIcon("src/Images/headLeft.png"));
            }
        }

        if (MainMenu.allPlayers.getPlayer(0).getDirectionBefore() != 1) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                Sound sound = new Sound();
                sound.playSound("src/Sounds/down.wav");
                MainMenu.allPlayers.getPlayer(0).setDirection(3);
                GUI.headImage.setIcon(new ImageIcon("src/Images/headDown.png"));
            }
        }

        if (MainMenu.allPlayers.getPlayer(0).getDirectionBefore() != 2) {
            if (e.getKeyCode() == KeyEvent.VK_D) {
                Sound sound = new Sound();
                sound.playSound("src/Sounds/right.wav");
                MainMenu.allPlayers.getPlayer(0).setDirection(4);
                GUI.headImage.setIcon(new ImageIcon("src/Images/headRight.png"));
            }
        }
        if (MainMenu.allPlayers.players.size() == 2) {
            if (MainMenu.allPlayers.getPlayer(1).getDirectionBefore() != 3) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Sound sound = new Sound();
                    sound.playSound("src/Sounds/up.wav");
                    MainMenu.allPlayers.getPlayer(1).setDirection(1);
                    GUI.headImageM.setIcon(new ImageIcon("src/Images/headUpM.png"));
                }
            }
            if (MainMenu.allPlayers.getPlayer(1).getDirectionBefore() != 4) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Sound sound = new Sound();
                    sound.playSound("src/Sounds/left.wav");
                    MainMenu.allPlayers.getPlayer(1).setDirection(2);
                    GUI.headImageM.setIcon(new ImageIcon("src/Images/headLeftM.png"));
                }
            }
            if (MainMenu.allPlayers.getPlayer(1).getDirectionBefore() != 1) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    Sound sound = new Sound();
                    sound.playSound("src/Sounds/down.wav");
                    MainMenu.allPlayers.getPlayer(1).setDirection(3);
                    GUI.headImageM.setIcon(new ImageIcon("src/Images/headDownM.png"));
                }
            }
            if (MainMenu.allPlayers.getPlayer(1).getDirectionBefore() != 2) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Sound sound = new Sound();
                    sound.playSound("src/Sounds/right.wav");
                    MainMenu.allPlayers.getPlayer(1).setDirection(4);
                    GUI.headImageM.setIcon(new ImageIcon("src/Images/headRightM.png"));
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
