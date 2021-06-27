import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainMenu implements Runnable {
    static int posX = 0;
    static int posY = 0;

    static boolean isSingleplayer = true;
    static boolean isOverlayVisible = false;
    static boolean areRulesVisible = false;
    static boolean isGerman = false;
    static String savedHighscore = "0";
    static Sound sound = new Sound();

    @Override
    public void run() {
        JFrame frame = new JFrame("Main Menu");
        frame.setSize(950, 490);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        frame.add(panel);

        JPanel gamerules = new JPanel();
        gamerules.setBorder(BorderFactory.createLineBorder(new Color(30, 30, 30)));
        gamerules.setLayout(null);
        gamerules.setBackground(Color.DARK_GRAY);
        gamerules.setBounds(218, 110, 515, 270);
        gamerules.setVisible(false);
        panel.add(gamerules);

        JTextArea game_rules = new JTextArea("You are the snake on the field. You can find the snake with the arrow keys or WASD (up, right, left, down). You are never allowed to step over the edge of the field. If you touch it, it's game over.\n" +
                "\n" +
                "The goal is to collect the apples on the playing field. If you touch them, your snake will grow and your score will go up. The longer the game goes, the longer your snake's tail becomes. If you touch it, the game is over as well.");
        game_rules.setBounds(5, 30, 505, 235);
        game_rules.setLineWrap(true);
        game_rules.setWrapStyleWord(true);
        game_rules.setBackground(Color.DARK_GRAY);
        game_rules.setFont(new Font("TimesRoman", Font.PLAIN, 17));
        game_rules.setForeground(Color.LIGHT_GRAY);

        JButton swapLanguage = new JButton("German");
        swapLanguage.setBorder(null);
        swapLanguage.setBounds(430, 235, 80, 30);
        swapLanguage.setFont(new Font("TimesRoman", Font.BOLD, 17));
        swapLanguage.setBackground(new Color(170, 170, 170));
        swapLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                if(!isGerman) {
                    swapLanguage.setText("English");
                    game_rules.setText("Du bist die Schlange auf dem Spielfeld. Du kannst die Schlange mit den Pfeiltasten oder WASD (oben, rechts, links, unten). Du darfst den Rand des Spielfelds nie überschreiten. Berührst du ihn, ist das Spiel vorbei. \n" +
                            "\n" +
                            "Das Ziel ist es, die Äpfel auf dem Spielfeld zu sammeln. Wenn du sie berührst, wächst deine Schlange und dein Score steigt. Je länger das Spiel geht, desto länger wird der Schwanz deiner Schlange. Berührst du diesen, ist das Spiel ebenfalls vorbei. ");
                    isGerman = true;
                }
                else {
                    swapLanguage.setText("German");
                    game_rules.setText("You are the snake on the field. You can move the snake with the arrow keys or WASD (up, right, left, down). You are never allowed to step over the edge of the field. If you touch it, it's game over.\n" +
                            "\n" +
                            "The goal is to collect the apples on the playing field. If you touch them, your snake will grow and your score will go up. The longer the game goes, the longer your snake's tail becomes. If you touch it, the game is over as well.");
                    isGerman = false;
                }
            }
        });
        gamerules.add(swapLanguage);
        gamerules.add(game_rules);

        JButton close2 = new JButton("X");
        close2.setBorder(null);
        close2.setBounds(490, 5, 20, 20);
        close2.setBackground(new Color(30, 30, 30));
        close2.setForeground(new Color(170, 170, 170));
        close2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        close2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                gamerules.setVisible(false);
                areRulesVisible = false;
            }
        });
        gamerules.add(close2);

        JPanel overlay = new JPanel();
        overlay.setLayout(null);
        overlay.setBackground(new Color(30, 30, 30));
        overlay.setBounds(751, 39, 200, 100);
        overlay.setVisible(false);
        panel.add(overlay);

        JButton quit = new JButton("quit");
        quit.setBackground(new Color(170, 170, 170));
        quit.setFont(new Font("TimesRoman", Font.BOLD, 20));
        quit.setBounds(5, 55, 190, 40);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                System.exit(0);
            }
        });
        overlay.add(quit);

        JButton rules = new JButton("game rules");
        rules.setBackground(new Color(170, 170, 170));
        rules.setFont(new Font("TimesRoman", Font.BOLD, 20));
        rules.setBounds(5, 5, 190, 40);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                if(!areRulesVisible) {
                    gamerules.setVisible(true);
                    areRulesVisible = true;
                }
                else {
                    gamerules.setVisible(false);
                    areRulesVisible = false;
                }
            }
        });
        overlay.add(rules);

        Icon singleplayer = new ImageIcon("src/Images/singleplayer.png");
        Icon multiplayer = new ImageIcon("src/Images/multiplayer.png");

        JLabel modusAnzeigetext = new JLabel("singleplayer", SwingConstants.CENTER);
        modusAnzeigetext.setBounds(650, 230, 270, 50);
        modusAnzeigetext.setBackground(null);
        modusAnzeigetext.setForeground(new Color(170, 170, 170));
        modusAnzeigetext.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        panel.add(modusAnzeigetext);

        JLabel modusErklaertxt = new JLabel("<html><body>- play alone<br>- reach a new highscore</body></html>", SwingConstants.CENTER);
        modusErklaertxt.setBounds(650, 295, 270, 65);
        modusErklaertxt.setBackground(null);
        modusErklaertxt.setForeground(new Color(170, 170, 170));
        modusErklaertxt.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        panel.add(modusErklaertxt);

        JButton selectMultiplayer = new JButton("multiplayer");
        selectMultiplayer.setBounds(330, 395, 275, 50);
        selectMultiplayer.setBackground(new Color(170, 170, 170));
        selectMultiplayer.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        selectMultiplayer.setBorder(null);
        selectMultiplayer.setOpaque(true);


        JButton selectSingleplayer = new JButton("singleplayer");
        selectSingleplayer.setBounds(35, 395, 275, 50);
        selectSingleplayer.setBackground(new Color(76, 181, 245));
        selectSingleplayer.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        selectSingleplayer.setBorder(null);
        selectSingleplayer.setOpaque(true);
        selectSingleplayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                isSingleplayer = true;
                selectSingleplayer.setBackground(new Color(76, 181, 245));
                selectMultiplayer.setBackground(new Color(170, 170, 170));
                modusAnzeigetext.setText("singleplayer");
                modusErklaertxt.setText("<html><body>- play alone<br>- reach a new highscore</body></html>");
            }
        });
        panel.add(selectSingleplayer);

        selectMultiplayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                isSingleplayer = false;
                selectMultiplayer.setBackground(new Color(76, 181, 245));
                selectSingleplayer.setBackground(new Color(170, 170, 170));
                modusAnzeigetext.setText("multiplayer");
                modusErklaertxt.setText("- play with friends");
            }
        });
        panel.add(selectMultiplayer);

        JLabel singleplayerImage = new JLabel(singleplayer);
        singleplayerImage.setBackground((new Color(0, 90, 90)));
        singleplayerImage.setBounds(35, 115, 275, 275);
        singleplayerImage.setOpaque(true);
        panel.add(singleplayerImage);

        JLabel multiplayerImage = new JLabel(multiplayer);
        multiplayerImage.setBackground((new Color(0, 90, 90)));
        multiplayerImage.setBounds(330, 115, 275, 275);
        multiplayerImage.setOpaque(true);
        panel.add(multiplayerImage);

        JLabel singleplayerLabel = new JLabel();
        singleplayerLabel.setBackground((new Color(90, 90, 90)));
        singleplayerLabel.setBounds(30, 110, 285, 340);
        singleplayerLabel.setOpaque(true);
        panel.add(singleplayerLabel);

        JLabel multiplayerLabel = new JLabel();
        multiplayerLabel.setBackground((new Color(90, 90, 90)));
        multiplayerLabel.setBounds(325, 110, 285, 340);
        multiplayerLabel.setOpaque(true);
        panel.add(multiplayerLabel);

        JLabel selectGamemode = new JLabel("select gamemode");
        selectGamemode.setFont(new Font("TimesRoman", Font.BOLD, 20));
        selectGamemode.setForeground((new Color(170, 170, 170)));
        selectGamemode.setBounds(30, 70, 200, 30);
        panel.add(selectGamemode);

        JLabel snake = new JLabel("Main Menu");
        snake.setFont(new Font("TimesRoman", Font.BOLD, 15));
        snake.setForeground((new Color(170, 170, 170)));
        snake.setBounds(10, 10, 170, 20);
        panel.add(snake);

        JLabel labelHighscoreText = new JLabel("HIGHSCORE", SwingConstants.CENTER);
        labelHighscoreText.setFont(new Font("TimesRoman", Font.BOLD, 20));
        labelHighscoreText.setForeground((new Color(170, 170, 170)));
        labelHighscoreText.setBounds(715, 70, 150, 30);
        panel.add(labelHighscoreText);

        try {
            SaveData saveData = new SaveData();
            savedHighscore = String.valueOf(saveData.getHighscore());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel highscore = new JLabel(savedHighscore, SwingConstants.CENTER);
        highscore.setFont(new Font("TimesRoman", Font.BOLD, 100));
        highscore.setForeground((new Color(170, 170, 170)));
        highscore.setBounds(635, 110, 290, 80);
        panel.add(highscore);

        Icon icon = new ImageIcon("src/Images/settings.png");

        JButton settings = new JButton(icon);
        settings.setBounds(915, 7, 26, 26);
        settings.setBackground(new Color(30, 30, 30));
        settings.setForeground(new Color(170, 170, 170));
        settings.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        settings.setBorder(null);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                if (isOverlayVisible) {
                    overlay.setVisible(false);
                    isOverlayVisible = false;
                }
                else {
                    overlay.setVisible(true);
                    isOverlayVisible = true;
                }
            }
        });
        panel.add(settings);

        JLabel labelGamemode = new JLabel();
        labelGamemode.setBounds(20, 60, 600, 400);
        labelGamemode.setBackground(new Color(45, 45, 45));
        labelGamemode.setOpaque(true);
        panel.add(labelGamemode);

        JLabel labelHighscore = new JLabel();
        labelHighscore.setBounds(640, 60, 290, 150);
        labelHighscore.setBackground(new Color(45, 45, 45));
        labelHighscore.setOpaque(true);
        panel.add(labelHighscore);

        JButton play = new JButton("play");
        play.setBounds(650, 400, 270, 50);
        play.setBackground(new Color(170, 170, 170));
        play.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        play.setBorder(null);
        play.setOpaque(true);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/Sounds/select.wav");
                frame.dispose();
                if (isSingleplayer) {
                    System.out.println("singleplayer started");
                    frame.dispose();
                    Singleplayer main = new Singleplayer();
                    Thread t = new Thread(main);
                    t.start();
                }
                else {
                    isSingleplayer = true;
                    System.out.println("multiplayer started");
                    frame.dispose();
                    Multiplayer main = new Multiplayer();
                    Thread t = new Thread(main);
                    t.start();
                }

            }
        });
        panel.add(play);

        JLabel labelPlay = new JLabel();
        labelPlay.setBounds(640, 230, 290, 230);
        labelPlay.setBackground(new Color(45, 45, 45));
        labelPlay.setOpaque(true);
        panel.add(labelPlay);



        JLabel mBar = new JLabel();
        mBar.setBounds(0, 0, 950, 40);
        mBar.setBackground(new Color(30, 30, 30));
        mBar.setOpaque(true);
        panel.add(mBar);

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
                frame.setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
            }
        };

        mBar.addMouseListener(ma);
        mBar.addMouseMotionListener(ma);

        frame.setVisible(true);
    }
}
