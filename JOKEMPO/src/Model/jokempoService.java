package Model;

import java.util.Scanner;

public class jokempoService {

    private String p1 = "";
    private String p2 = "";
    private final Scanner sc = new Scanner(System.in);

    public void Start() {

        while (true) {

            System.out.println("\n-- JOKEMPO --");
            System.out.println("(rock | paper | scissors | exit)");

            System.out.print("P1 - Make your move: ");
            p1 = sc.nextLine();

            if ("exit".equalsIgnoreCase(p1)) {
                System.out.println("Game ended.");
                break;
            }

            if (!moveValid(p1)) {
                System.out.println("Invalid move!");
                continue;
            }

            System.out.print("P2 - Make your move: ");
            p2 = sc.nextLine();

            //Two condicionals to find out made a mistake (p1 || p2)

            if (!moveValid(p2)) {
                System.out.println("Invalid move!");
                continue;
            }

            String result = checkWin(p1, p2);
            System.out.println("Result: " + result);
        }

        sc.close();
    }

    public String checkWin(String p1, String p2) {

        if (p1.equalsIgnoreCase(p2)) {
            return "draw";
        }

        if (
                p1.equalsIgnoreCase("rock") && p2.equalsIgnoreCase("scissors") ||
                        p1.equalsIgnoreCase("paper") && p2.equalsIgnoreCase("rock") ||
                        p1.equalsIgnoreCase("scissors") && p2.equalsIgnoreCase("paper")
        ) {
            return "p1_win";
        }

        return "p2_win";
    }

    private boolean moveValid(String move) {
        return move.equalsIgnoreCase("rock") ||
                move.equalsIgnoreCase("paper") ||
                move.equalsIgnoreCase("scissors");
    }
}
