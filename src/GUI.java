import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class GUI {
    static Draw d;
    static JLabel jl;

    public static int posX = 0;
    public static int posY = 0;

    public static int width = 513, heigth = 553;
    public static int xoff = 0, yoff = 40;
    public  static JFrame jf;
    public static String modus;
    public static JLabel mBar;
    public static JLabel score;
    public static JLabel scoreM;
    public static JLabel appleImage;
    public static JLabel appleImageM;
    public static JLabel headImage;
    public static JLabel headImageM;

    public static void create(String mode) {
        modus = mode;

        jf = new JFrame(mode);
        jf.setSize(width, heigth);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.addKeyListener(new KeyInput());
        jf.setUndecorated(true);

        if (mode.equalsIgnoreCase("singleplayer")) {
            JLabel scoreLabel = new JLabel("Score: ");
            scoreLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
            scoreLabel.setForeground(Color.LIGHT_GRAY);
            scoreLabel.setBounds(10, 5, 80, 30);
            jf.add(scoreLabel);

            score = new JLabel("0");
            score.setFont(new Font("TimesRoman", Font.BOLD, 20));
            score.setForeground(Color.LIGHT_GRAY);
            score.setBounds(80, 5, 80, 30);
            jf.add(score);

            JLabel highScore = new JLabel("Highscore: ");
            highScore.setFont(new Font("TimesRoman", Font.BOLD, 20));
            highScore.setForeground(Color.LIGHT_GRAY);
            highScore.setBounds(350, 5, 120, 30);
            jf.add(highScore);

            try {
                SaveData saveData = new SaveData();
                JLabel highscore = new JLabel(String.valueOf(saveData.getHighscore()));
                highscore.setFont(new Font("TimesRoman", Font.BOLD, 20));
                highscore.setForeground(Color.LIGHT_GRAY);
                highscore.setBounds(460, 5, 80, 30);
                jf.add(highscore);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            JLabel scoreLabel = new JLabel("Score(Green):");
            scoreLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
            scoreLabel.setForeground(Color.LIGHT_GRAY);
            scoreLabel.setBounds(10, 5, 140, 30);
            jf.add(scoreLabel);

            score = new JLabel("0");
            score.setFont(new Font("TimesRoman", Font.BOLD, 20));
            score.setForeground(Color.LIGHT_GRAY);
            score.setBounds(155, 5, 80, 30);
            jf.add(score);

            JLabel scoreMLabel = new JLabel("Score(Blue):");
            scoreMLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
            scoreMLabel.setForeground(Color.LIGHT_GRAY);
            scoreMLabel.setBounds(330, 5, 140, 30);
            jf.add(scoreMLabel);

            scoreM = new JLabel("0");
            scoreM.setFont(new Font("TimesRoman", Font.BOLD, 20));
            scoreM.setForeground(Color.LIGHT_GRAY);
            scoreM.setBounds(458, 5, 80, 30);
            jf.add(scoreM);
        }

        Icon apple = new ImageIcon("src/Images/apple.png");
        appleImage = new JLabel(apple);
        appleImage.setBounds(31, 31, 100, 100);

        jf.add(appleImage);

        Icon appleM = new ImageIcon("src/Images/appleM.png");
        appleImageM = new JLabel(appleM);
        appleImageM.setBounds(31, 31, 100, 100);

        jf.add(appleImageM);

        Icon head = new ImageIcon("src/Images/headUp.png");
        headImage = new JLabel(head);
        headImage.setBounds(31, 31, 100, 100);

        jf.add(headImage);

        Icon headM = new ImageIcon("src/Images/headUpM.png");
        headImageM = new JLabel(headM);
        headImageM.setBounds(31, 31, 100, 100);
        jf.add(headImageM);

        d = new Draw();
        d.setBounds(0, 0, width, heigth);
        d.setVisible(true);
        jf.add(d);
        jf.setVisible(true);

        mBar = new JLabel();
        mBar.setBounds(0, 0, 772, 40);
        mBar.setBackground(new Color(30, 30, 30));
        mBar.setOpaque(true);
        mBar.setVisible(true);
        jf.add(mBar);

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                posX = e.getX();
                posY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                jf.setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
            }
        };

        mBar.addMouseListener(ma);
        mBar.addMouseMotionListener(ma);
    }
    public static void refreshScore() {
        score.setText(String.valueOf(Players.getPlayer(0).getScore()));
    }

    public static void refreshScoreM() {
        score.setText(String.valueOf(Players.getPlayer(0).getScore()));
        scoreM.setText(String.valueOf(Players.getPlayer(1).getScore()));
    }
}
