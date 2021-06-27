import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameOverMultiplayer implements Runnable {
    public static int width = 513, heigth = 270;
    public static Sound sound = new Sound();
    String finish;
    @Override
    public void run() {
        JFrame frame = new JFrame("GameOver");
        frame.setSize(width, heigth);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setVisible(true);
        frame.add(panel);

        if (Players.getPlayer(0).getScore() < Players.getPlayer(1).getScore()) {
            finish = "BLUE WON!";
        }
        if (Players.getPlayer(0).getScore() > Players.getPlayer(1).getScore()) {
            finish = "GREEN WON!";
        }
        if (Players.getPlayer(0).getScore() == Players.getPlayer(1).getScore()) {
            finish = "DRAW!";
        }

        JLabel gameOver = new JLabel(finish, SwingConstants.CENTER);
        gameOver.setForeground(Color.LIGHT_GRAY);
        gameOver.setFont(new Font("TimesRoman", Font.BOLD, 50));
        gameOver.setBounds(0, 0, width, 100);
        panel.add(gameOver);

        JLabel score = new JLabel("Score(GREEN)", SwingConstants.CENTER);
        score.setForeground(Color.LIGHT_GRAY);
        score.setFont(new Font("TimesRoman", Font.BOLD, 25));
        score.setBounds(10, 100, 200, 30);
        panel.add(score);

        JLabel intScore = new JLabel(String.valueOf(Players.getPlayer(0).getScore()), SwingConstants.CENTER);
        intScore.setForeground(Color.LIGHT_GRAY);
        intScore.setFont(new Font("TimesRoman", Font.BOLD, 25));
        intScore.setBounds(50, 150, 100, 30);
        panel.add(intScore);


        JLabel highscore = new JLabel("Score(BLUE)", SwingConstants.CENTER);
        highscore.setForeground(Color.LIGHT_GRAY);
        highscore.setFont(new Font("TimesRoman", Font.BOLD, 25));
        highscore.setBounds(285, 100, 200, 30);
        panel.add(highscore);

        JLabel intScore2 = new JLabel(String.valueOf(Players.getPlayer(1).getScore()), SwingConstants.CENTER);
        intScore2.setForeground(Color.LIGHT_GRAY);
        intScore2.setFont(new Font("TimesRoman", Font.BOLD, 25));
        intScore2.setBounds(325, 150, 100, 30);
        panel.add(intScore2);


        JButton home = new JButton("HOME");
        home.setBounds(325, 200, 150, 50);
        home.setBackground(new Color(170, 170, 170));
        home.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        home.setBorder(null);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                frame.dispose();
                MainMenu.Menu();
            }
        });
        panel.add(home);

        JButton playAgain = new JButton("Play again");
        playAgain.setBounds(37, 200, 150, 50);
        playAgain.setBackground(new Color(170, 170, 170));
        playAgain.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        playAgain.setBorder(null);
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                frame.dispose();
                Multiplayer main = new Multiplayer();
                Thread t = new Thread(main);
                t.start();
            }
        });
        panel.add(playAgain);

        frame.setVisible(true);
        Players.removeAllPlayers();
    }
}
