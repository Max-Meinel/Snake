public class Start {
    public static void main(String[] args) {
        System.out.println("game started");
        MainMenu mainMenu = new MainMenu();
        new Thread(mainMenu).start();
    }
}

