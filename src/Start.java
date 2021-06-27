public class Start {
    public static void main(String[] args) {
        System.out.println("game started");
        MainMenu mainMenu = new MainMenu();
        Thread t = new Thread(mainMenu);
        t.start();
    }
}
