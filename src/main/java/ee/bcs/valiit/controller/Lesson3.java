package ee.bcs.valiit.controller;

import java.util.Arrays;

public class Lesson3 {

    public static void main(String[] args) {
        System.out.println(viimaneveerand(1, 100));

        System.out.println(funct(22));

        System.out.println(alg(5));

        System.out.println(sum(389, 694));

        int[] x = {2, 5, 6, 8};
        System.out.println(sum(x));

        System.out.println(factorial(6));

        int[] a = {6, 5, 8, 14};
        System.out.println(Arrays.toString(sort(a)));

        System.out.println(reverseString("hej"));

        System.out.println(isPrime(6));

    }

    public static int viimaneveerand(int r, int q) {
        //tsükkel, mis käib r-st q-ni. r+1, r+1 kuni qni
        //tsükklik kutsun välja eelmist funktisooni
        //leian kõige suurem numbri
        int max = 0;
        for (int i = r; i <= q; i++) {
            int tmp = funct(i);
            if (tmp > max) {
                max = tmp;
            }

        }
        return max;
    }

    public static int funct(int t) {
        int u = 1;
        while (t > 1) { // kas t on suurem kui 1, jah, siis läheb edasi
            t = alg(t); //läheb otsib alg() mis väärtus tuleb
            u = u + 1;
        }

        return u;
    }

    private static int alg(int n) {
        // TODO
        // kui n on paaris arv tagasta n/2
        // kui n on paaritu arv tagasta n*3+1
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n * 3 + 1;

        }

    }

    public static int sum(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        int sum;
        sum = x + y;
        return sum;
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int arrSum = 0;
        for (int i = 0; i < x.length; i++) {
            arrSum += x[i];
        }
        return arrSum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 4*3*2*1 = 24
        int fact = 1;
        for (int i = 2; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        int jada;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    jada = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = jada;
                }
            }
        }
        return a;
    }


    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";

        String reverse = a;

        for (int i = a.length() - 1; i >= 0; i--) {
            reverse = reverse + a.charAt(i);
        }
        return reverse;
    }

    public static boolean isPrime(int x) {

        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        if (x == 1 || x == 0) {
            return true;
        } else {
            for (int i = 2; i < x; i++) {
                if (x % i == 0) ;
            }
            return false;
        }

    }
}
