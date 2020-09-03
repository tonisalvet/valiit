package ee.bcs.valiit.controller;

import java.util.Scanner;

public class Lesson1MathUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palun sisesta funktsioon");
        String rida = scanner.nextLine();

        if (rida.equals("min")) {
            System.out.println("Sisesta kaks numbrit");
            int k = scanner.nextInt();
            int l = scanner.nextInt();
            System.out.println(min(k, l));
        } else if (rida.equals("abs")) {
            System.out.println("Sisesta nr");
            int m = scanner.nextInt();
            System.out.println(abs(m));

        } else if (rida.equals("max")) {
            System.out.println("Sisesta kaks nr");
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(max(m, n));
        } else if (rida.equals("isEven")) {
            System.out.println("Sisesta nr");
            int m = scanner.nextInt();
            System.out.println(isEven(m));
        }
    }


    public static int min(int a, int b) {
        // TODO tagasta a ja b väikseim väärtus
        if (a < b) {
            return a;
        }
        return b;
    }

    public static int max(int a, int b) {
        // TODO tagasta a ja b suurim väärtus
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv
        if (a > 0) {
            return a;
        }
        return a * (-1);
    }

    public static boolean isEven(int a) {
        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    public static int min(int a, int b, int c) {
        // TODO tagasta a, b ja c väikseim väärtus
        if (a <= b && b <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        }
        return c;

    }

    public static int max(int a, int b, int c) {
        // TODO tagasta a, b ja c suurim väärtus
        if (a >= b && b >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        }
        return c;
    }

}

