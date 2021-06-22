import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, GUI.width, GUI.heigth);
        //Draw Inside of the rectangle
        g.setColor(Color.GRAY);
        g.fillRect(GUI.xoff, GUI.yoff, 512, 512);

        //Draw Grid
        //every rectangle is 32 * 32 pixels and the Grid is 16 * 16 rectangles
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 512, 40);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + GUI.xoff, j * 32 + GUI.yoff, 32, 32);
            }
        }

        //Draw Boarder
        g.setColor(Color.BLACK);
        g.drawRect(GUI.xoff, GUI.yoff, 512, 512);

        if (GUI.modus.equalsIgnoreCase("singleplayer")) {
            GUI.headImageM.setVisible(false);
            GUI.appleImageM.setVisible(false);
            if (!MainMenu.allPlayers.getPlayer(0).isGameOver()) {
                //Draw Tail

                for (int i = 0; i < MainMenu.allPlayers.getPlayer(0).tails.size(); i++) {
                    g.setColor(Color.GREEN);
                    g.fillRect(MainMenu.allPlayers.getPlayer(0).getTail(i).getX() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getTail(i).getY() * 32 + 1 + GUI.yoff, 31, 31);
                    g.setColor(Color.BLACK);
                    g.drawRect(MainMenu.allPlayers.getPlayer(0).getTail(i).getX() * 32 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getTail(i).getY() * 32 + GUI.yoff, 32, 32);
                }

                //Draw Head
                g.setColor(Color.BLACK);
                g.drawRect(MainMenu.allPlayers.getPlayer(0).getHead_x() * 32 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getHead_y() * 32 + GUI.yoff, 32, 32);

                GUI.headImage.setBounds(MainMenu.allPlayers.getPlayer(0).getHead_x() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getHead_y() * 32 + 1 + GUI.yoff, 31, 31);

                //Draw Apple
                GUI.appleImage.setBounds(MainMenu.allPlayers.getPlayer(0).getApple_x() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getApple_y() * 32 + 1 + GUI.yoff, 31, 31);
            }
        }
        else {
            //Draw Tail
            if (!MainMenu.allPlayers.getPlayer(0).isGameOver()) {
                for (int i = 0; i < MainMenu.allPlayers.getPlayer(0).tails.size(); i++) {
                    g.setColor(Color.GREEN);
                    g.fillRect(MainMenu.allPlayers.getPlayer(0).getTail(i).getX() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getTail(i).getY() * 32 + 1 + GUI.yoff, 31, 31);
                    g.setColor(Color.BLACK);
                    g.drawRect(MainMenu.allPlayers.getPlayer(0).getTail(i).getX() * 32 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getTail(i).getY() * 32 + GUI.yoff, 32, 32);
                }
            }

            if (!MainMenu.allPlayers.getPlayer(1).isGameOver()) {
                for (int i = 0; i < MainMenu.allPlayers.getPlayer(1).tails.size(); i++) {
                    g.setColor(Color.BLUE);
                    g.fillRect(MainMenu.allPlayers.getPlayer(1).getTail(i).getX() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(1).getTail(i).getY() * 32 + 1 + GUI.yoff, 31, 31);
                    g.setColor(Color.BLACK);
                    g.drawRect(MainMenu.allPlayers.getPlayer(1).getTail(i).getX() * 32 + GUI.xoff, MainMenu.allPlayers.getPlayer(1).getTail(i).getY() * 32 + GUI.yoff, 32, 32);
                }
            }


            //Draw Head
            if (!MainMenu.allPlayers.getPlayer(0).isGameOver()) {
                GUI.headImage.setBounds(MainMenu.allPlayers.getPlayer(0).getHead_x() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getHead_y() * 32 + 1 + GUI.yoff, 31, 31);
                g.setColor(Color.BLACK);
                g.drawRect(MainMenu.allPlayers.getPlayer(0).getHead_x() * 32 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getHead_y() * 32 + GUI.yoff, 32, 32);
            }
            else {
                GUI.headImage.setVisible(false);
            }

            if (!MainMenu.allPlayers.getPlayer(1).isGameOver()) {
                GUI.headImageM.setBounds(MainMenu.allPlayers.getPlayer(1).getHead_x() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(1).getHead_y() * 32 + 1 + GUI.yoff, 31, 31);
                g.setColor(Color.BLACK);
                g.drawRect(MainMenu.allPlayers.getPlayer(1).getHead_x() * 32 + GUI.xoff, MainMenu.allPlayers.getPlayer(1).getHead_y() * 32 + GUI.yoff, 32, 32);
            }
            else {
                GUI.headImageM.setVisible(false);
            }



            //Draw Apple
            if (!MainMenu.allPlayers.getPlayer(0).isGameOver()) {
                GUI.appleImage.setBounds(MainMenu.allPlayers.getPlayer(0).getApple_x() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(0).getApple_y() * 32 + 1 + GUI.yoff, 31, 31);
            }
            else {
                GUI.appleImage.setVisible(false);
            }
            if (!MainMenu.allPlayers.getPlayer(1).isGameOver()) {
                GUI.appleImageM.setBounds(MainMenu.allPlayers.getPlayer(1).getApple_x() * 32 + 1 + GUI.xoff, MainMenu.allPlayers.getPlayer(1).getApple_y() * 32 + 1 + GUI.yoff, 31, 31);
            }
            else {
                try {
                    GUI.appleImageM.setVisible(false);
                } catch (Exception e) {

                }
            }
        }
    }
}
