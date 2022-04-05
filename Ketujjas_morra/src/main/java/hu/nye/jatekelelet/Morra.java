package hu.nye.jatekelelet;

import java.util.Scanner;

public class Morra {

    public Morra() {

    }

    public boolean randomNumberGenerator() {
        double randNumber = Math.random();
        if (randNumber < 0.75) {
            return true;
        }
        return false;
    }

    public int secondPlayerNumber() {
        if(randomNumberGenerator()) {
            return 1;
        }
        return 2;
    }

    public void welcome() {
        System.out.print("Udv a morra jatekban. \n" +
                "A jatek menete: mutasson 1 vagy 2 ujjat, ezutan az ellenfel is mutat,\n" +
                "ha az ujjak osszege paros akkor maga nyer, ha paraatlan akkor az ellenfele.\n\n");
    }

    public void gameStart() {
        boolean flag = true;
        int allas = 0;

        while (flag) {
            int secondPlayer = secondPlayerNumber();
            Scanner sc = new Scanner(System.in);
            System.out.println("Kerem a szamodat: ");
            int yourNumber = sc.nextInt();
            while (yourNumber > 2 || yourNumber < 1) {
                System.out.println("Csak 1-es vagy 2-es szamot irhatsz be!!");
                yourNumber = sc.nextInt();
            }

            int sum = secondPlayer + yourNumber;

            if (sum % 2 == 0) {
                allas += sum;
                System.out.println("A jatek tippje " + secondPlayer + " volt, igy maga nyert " + sum + " pontot.\n" +
                        "Jelen allas: " + allas);
            } else {
                allas -= sum;
                System.out.println("A jatek tippje " + secondPlayer + " volt, igy a jatek nyert " + sum + " pontot.\n" +
                        "Jelen allas: " + allas);
            }

            Scanner sl = new Scanner(System.in);

            System.out.println("Akarja-e folytatni? (i/n) ");
            String answer = sl.nextLine();

            while (!answer.equals("n") && !answer.equals("i")) {
                System.out.println("Csak i-vel vagy n-nel tudsz valaszolni!!");
                answer = sl.nextLine();
            }

            if (answer.equals("n")) {
                flag = false;
            }
        }

        if (allas == 0) {
            System.out.println("Dontetlen.");
        } else if (allas < 0) {
            System.out.println("Vesztettel.");
        } else if (allas > 0) {
            System.out.println("Gyoztel.");
        }
    }
}