package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
// Kasutame ainult @GetMapping ja @RequestParam, see tähendab, et me leob url-ist, mis ise sinna kirjutad
public class BankController2 {
    Map<String, Integer> pangakonto = new HashMap<>();

    //CreateAccount
    @GetMapping("looKonto")
    public void addPangakonto(@RequestParam("konto") String accountNr,
                              @RequestParam("jaak") int jaak) {
        pangakonto.put(accountNr, jaak);
        //http://localhost:8080/looKonto?konto=EE123&jaak=5000
        //http://localhost:8080/looKonto?konto=EE456&jaak=5000
    }

    //getAccount
    @GetMapping("getKonto")
    public Integer getpangakonto(@RequestParam("konto") String accountNr) {
        return pangakonto.get(accountNr);
        //http://localhost:8080/getKonto?konto=EE123
        //http://localhost:8080/getKonto?konto=EE456
    }

    //depositMoney
    @GetMapping("lisaRaha")
    public void depositMoney(@RequestParam("konto") String accountNr, int lisaRaha) {
        int kokkuRaha;
        kokkuRaha = lisaRaha + pangakonto.get(accountNr);
        pangakonto.replace(accountNr, kokkuRaha);
        //http://localhost:8080/lisaRaha?konto=EE123&lisaRaha=780
    }

    //withdrawMoney
    @GetMapping("votaRaha")
    public void withdrawMoney(@RequestParam("konto") String accountNr, int votaRaha) {
        int kokkuRaha;
        if (pangakonto.get(accountNr) > votaRaha) {
            kokkuRaha = pangakonto.get(accountNr) - votaRaha;
            pangakonto.replace(accountNr, kokkuRaha);
        }
        //http://localhost:8080/votaRaha?konto=EE123&votaRaha=700
    }

    //transfer
    @GetMapping("kanna")
    public void transfer(@RequestParam("konto") String accountNr,
                         @RequestParam ("kantavRaha") int kantavRaha,
                         @RequestParam("konto2") String accountNr2) {
        if (pangakonto.get(accountNr) > kantavRaha) {
            pangakonto.put(accountNr, pangakonto.get(accountNr) - kantavRaha);
            pangakonto.put(accountNr2, pangakonto.get(accountNr2) + kantavRaha);
        }
        //http://localhost:8080/kanna?konto=EE123&kantavRaha=500&konto2=EE456
    }
}
