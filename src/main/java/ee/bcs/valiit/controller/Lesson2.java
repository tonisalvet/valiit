package ee.bcs.valiit.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lesson2 {

    public static void main(String[] args) {
        exercise1();
        exercise2(5);
        exercise3(3, 3);
        fibonacci(25);
        exercise5();
    }

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
       /* int[] a;
        a = new int[10];
        // TODO loe sisse konsoolist 10 täisarvu
       Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta 10 arvu");
        for (int i = 9; i >= 0; i--) {
            int n = scanner.nextInt();
            a[i] = n;
            System.out.println(i);
        }
        */
        // TODO trüki arvud välja vastupidises järiekorras

    }

    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        System.out.println("Paaris arvud");
        for (int i = 0; i < x * 2; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
        }
        /* for (int i = 1; i <=x; i++) {
        system.out.print(i + " ");
        }
         */
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
    }

    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        for (int i = 1; i <= x; i++) {
            System.out.println("");
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + " ");

            }


            // TODO näiteks x = 3 y = 3
            // TODO väljund
            // 1 2 3
            // 2 4 6
            // 3 6 9
        }
    }

    public static int fibonacci(int n) {
        // TODO
        System.out.println(" ");
        int t1 = 0, t2 = 1;
        for (int i = 0; i <= n; i++) {
            System.out.println(t1 + " ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }

        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
        return n;
    }

    public static void exercise5() {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
    }

    public static void exercise6() {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */
    }

    public static BigDecimal exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
        //BigDecimal b1 = b.divide(c);
        BigDecimal e = b.divide(c, RoundingMode.HALF_UP);
        BigDecimal f = e.subtract(d);
        BigDecimal g = f.multiply(a);

        return g;
    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}
