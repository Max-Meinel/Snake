import java.util.Random;

public class Apple {
    public void SpawnApple(Player player) {
        if (player.getHead_x() == player.getApple_x() && player.getHead_y() == player.getApple_y()) {
            Sound sound = new Sound();
            sound.playSound("src/Sounds/eatingApple.wav");
            player.setScore(player.getScore() + 10);
            SnakeBody body = new SnakeBody();
            body.RefreshNewTail(player);
            Apple apple = new Apple();
            apple.SpawnAppleAt(player);
        }
    }
    public void SpawnAppleAt(Player player) {
        Random rand = new Random();
        boolean repeat = true;
        int x = rand.nextInt(16);
        int y = rand.nextInt(16);

        while (repeat) {
            repeat = false;
            for (int i = 0; i < player.tails.size(); i++) {
                if (x == player.tails.get(i).getX() && y == player.tails.get(i).getY()) {
                    repeat = true;
                    x = rand.nextInt(16);
                    y = rand.nextInt(16);
                }
            }
            if (x == player.getHead_x() && y == player.getHead_y()) {
                repeat = true;
                x = rand.nextInt(16);
                y = rand.nextInt(16);
            }
        }
        player.setApple_x(x);
        player.setApple_y(y);
    }
}
