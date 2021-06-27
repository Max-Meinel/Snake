public class CollisionMultiplayer {
    public void PlayerCollision(Player p1, Player p2) {
        boolean resetP1 = false;
        boolean resetP2 = false;
        if (!p1.isGameOver() && !p2.isGameOver()) {
            if (p1.getHead_x() == p2.getHead_x() && p1.getHead_y() == p2.getHead_y()) {
                Sound sound = new Sound();
                sound.playSound("src/Sounds/crash.wav");
                resetP1 = true;
                resetP2 = true;
            }
        }
        if (!p2.isGameOver()) {
            for (int i = 0; i < p2.tails.size(); i++) {
                if (p1.getHead_x() == p2.getTail(i).getX() && p1.getHead_y() == p2.getTail(i).getY()) {
                    resetP1 = true;
                }
            }
            if (p1.getHead_x() == p2.getApple_x() && p1.getHead_y() == p2.getApple_y()) {
                resetP1 = true;
            }
        }
        if (!p1.isGameOver()) {
            for (int i = 0; i < p1.tails.size(); i++) {
                if (p2.getHead_x() == p1.getTail(i).getX() && p2.getHead_y() == p1.getTail(i).getY()) {
                    resetP2 = true;
                }
            }
            if (p2.getHead_x() == p1.getApple_x() && p2.getHead_y() == p1.getApple_y()) {
                resetP2 = true;
            }
        }
        if (resetP1) {
            Sound sound = new Sound();
            sound.playSound("src/Sounds/crash.wav");
            p1.setGameOver(true);
        }
        if (resetP2) {
            Sound sound = new Sound();
            sound.playSound("src/Sounds/crash.wav");
            p2.setGameOver(true);
        }
    }
}
