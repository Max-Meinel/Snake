public class SnakeBody {

    public void UpdateArrayList(Player player) {
        Tail help = new Tail(player.getHead_x(), player.getHead_y());
        Tail help_2 = new Tail(0, 0);

        for (int i = 0; i < player.tails.size(); i++) {
            help_2.setX(player.getTail(i).getX());
            help_2.setY(player.getTail(i).getY());

            player.getTail(i).setX(help.getX());
            player.getTail(i).setY(help.getY());

            help.setX(help_2.getX());
            help.setY(help_2.getY());
        }
    }
    public void RefreshNewTail(Player player) {
        player.addTail(new Tail(player.getTail(player.getLength() - 1).getX(), player.getTail(player.getLength() - 1).getY()));
    }
}