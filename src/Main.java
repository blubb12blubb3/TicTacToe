import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("Choose Gamemode:");
        System.out.println("Enter 1 for Player vs Computer");
        System.out.println("Enter 2 for Player vs Player");
        System.out.println("Enter 3 to exit");
        System.out.print("--> ");
        int gamemode = sc.nextInt();
        boolean again = true;
        while (again) {
            again = false;
            switch (gamemode) {
                case 1:
                    OnePlayerGame.main(null);
                    break;
                case 2:
                    TwoPlayerGame.main(null);
                    break;
                case 3:
                    System.out.println("Leaving Game...");
                    break;
            }
        }
    }
}