package ee.bcs.valiit.controller;

public class Lesson1 {

    public static void main(String[] args) {

    }

    public static void excersie1(){
        // TODO
        // defineeri 3 muutujat a = 1, b = 1, c = 3
        // Prindi välja a==b ja a==c
        // Lisa rida a = c
        // Prindi välja a==b ja a==c, mis muutus???
        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a==b && a==c);
        a = c;
        System.out.println(a==b && a==c);
    }

    public static void excersie2(){
        // TODO
        // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
        int x1 = 10;
        int x2 = 20;
        // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
        int y1 = ++x1;
        System.out.println(x1);
        System.out.println(y1);
        // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
        int y2 = x2++;
        System.out.println(x2);
        System.out.println(y2);
        // Analüüsi tulemusi
    }

    public static void excersie3(){
        // TODO
        // Loo arvulised muutujad
        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;
        // a = 18 % 3
        // b = 19 % 3
        // c = 20 % 3
        // d = 21 % 3
        // Prindi välja kõigi muutujate väärtused
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static void excersie4(){
        // TODO
        // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
        // Trüki muutuja sisu välja
        System.out.println("\"\\\"\\\\\"\"");
    }

}