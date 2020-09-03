package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("test2")
@RestController
public class Test2Controller {
    Map<String, Integer> muutujad = new HashMap<>();

    // loe need muutujad sisse kasutades requestParameetrit (mitte enam hardcoded)
    // tee nii, et tagastatav väärtus oleks alati miinus märgiga
    @GetMapping("y1")
    public void test1() {
        // defineeri 3 muutujat
        // annad neile väärtused 4, 8 ,12
        // trükid välja nende korrutise miinus märgiga (sout)
        int x = 4;
        int y = 8;
        int z = 12;
        System.out.println(-(x * y * z));
    }

    @GetMapping("y2")
    public void loesisse(@RequestParam("x") int x,
                         @RequestParam("y") int y,
                         @RequestParam("z") int z) {
        System.out.println((Math.abs(x * y * z)) * (-1));
    }

    //prindi välja selline tabel
    // 1 3 5 7 9
    // 2 4 6 8 10
    // 3 5 7 9 11
    @GetMapping("y3")
    public void tabel(@RequestParam("x") int x,
                      @RequestParam("y") int y) {
        for (int j = 1; j <= y; j++) {
            System.out.println(" ");
            for (int i = 0; i < x; i++) {
                System.out.print((((i * 2)) + j) + " ");
                // for (int j = 1; j <= y; j++) {
                // System.out.print(i * j + " ");
                //  }
            }
        }

        System.out.println("");
    }

    //http://localhost:8080/test2/y4?n=6
    @GetMapping("y4")
    public void y4(@RequestParam("n") int n) {
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.println(n + (n - 2) + (n - 3));
            }
        }
    }
    // 2 endpointi get ja put
    // put @requestparam annan mingi väärtuse ka kui get siis peab selle kätte saama
    //peab salvestama muutuja classi muutuja külge
    // fib(n) = fib(n -2) + fib(n-3)
    // 0
    // 1
    // 1
    // 1
    // 2
    // 2
    // 3
    // 4
    // 5
    // 7
    // 9
    // 12 (jäta 1 eelmine vahele)
}

