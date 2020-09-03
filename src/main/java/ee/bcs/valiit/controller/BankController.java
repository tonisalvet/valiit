package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//RequestParam - loeb url-ist seda mis ise sinna kirjutad
//RequestBody - loeb JSONit
//PathVariable - on ka pmst uris, aga roheline
@RestController
public class BankController {
    Map<String, Integer> pangakonto = new HashMap<>();

    @Autowired
        private NamedParameterJdbcTemplate jdbcTemplate;


    @GetMapping("sqltest")
    public void testSql() {
        //String sql = "SELECT account_nr FROM account where id = :id";
        Map<String, Object> paramMap = new HashMap();
        //paramMap.put("id", 6);
        //String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        //return vastus;

        String sql = "UPDATE account SET balance = :balance where id = :id";
        paramMap.put("balance", 789);
        paramMap.put("id", 8);
        jdbcTemplate.update(sql, paramMap);

    }

    //createAccount
    @PostMapping("/Account/{looKonto}")
    public void addPangakonto(@PathVariable("looKonto") String kontonr, @RequestParam("algnejaak") int jaak) {
        pangakonto.put(kontonr, jaak);

        /*
    @PostMapping("/Account")
    public Integer addPangakonto(@RequestBody() UusTest uusTest) {
        pangakonto.put(uusTest.getKontonr(), uusTest.getJ22k());
        return pangakonto.get(uusTest.getKontonr());
        Siin pidi ka uue klassi tegema ja seal oli vaja settida ja gettida (alt + ins)
        private String kontonr;
        private int j22k;
    */
    }

    //getAccount
    @GetMapping("/Account/{getKonto}")
    public Integer getPangakonto(@PathVariable("getKonto") String accountNr) {
        return pangakonto.get(accountNr);
    }

    //depositMoney localhost:8080/Account/EE123?dkgha=10
    @PutMapping("/Account/{lisaRaha}")
    public void depositMoney(@PathVariable("lisaRaha") String accountNr,
                             @RequestParam("lisatavRaha")/*see mis brauserisse kirjutan*/ int lisatavRaha) {
        int kokkuRaha; //teeme uue variable
        kokkuRaha = lisatavRaha + pangakonto.get(accountNr); //uuele variabile lisame raha, aga vaja teada kuhu lisame
        pangakonto.replace(accountNr, kokkuRaha); //ja peame asendama uue summa vanaga
        // plaju juurde tuleb
        // palju oli
        // konto nr - accountNr

    }
    //withrawMoney
    @PutMapping("/Account/{votaRaha}")
    public void withdrawMoney(@PathVariable("votaRaha") String accountNr,
                              @RequestParam("voetavRaha")/*see mis brauserisse kirjutan*/ int voetavRaha) {
        int kokkuRaha; //teeme uue variable
        kokkuRaha = pangakonto.get(accountNr) - voetavRaha; //uuele variabilt votame raha, aga vaja teada kuhu lisame
        pangakonto.replace(accountNr, kokkuRaha); //ja peame asendama uue summa vanaga
    }
/*
    @PostMapping("/Account/{kannaRaha}")
    public void transferMoney(@PathVariable("kannaRaha") String accountNr1,
                              @RequestParam("summa") int summa,
                                @PathVariable("kannaRaha") String accountNr2){
        int transfer;
        pangakonto.get(accountNr1) = summa + pangakonto.get(accountNr2);

    }

 */
    //mis kontolt mis kontole
    //palju raha

    @PostMapping("test/{id1}/{id2}/{id3}")
    public List<BankController> test(@PathVariable("id1") String pathId1,
                                     @RequestParam(value = "id2", required = false) Long queryId2,
                                     @PathVariable("id3") BigInteger pathId3,
                                     @PathVariable("id2") Long pathId2,
                                     @RequestBody BankController requestBody,
                                     @RequestParam(value = "id1", required = false) Integer queryId1,
                                     @RequestParam(value = "id3") BigInteger queryId3) {

        return null;
    }
}
/*
@Autowired
@PutMapping("transfer")
public void transfer(@RequestBody TransferMoneyRequest request){ // tee getterid ja setterid ka
    accountService.transferMoney(request.getAccount)

 */