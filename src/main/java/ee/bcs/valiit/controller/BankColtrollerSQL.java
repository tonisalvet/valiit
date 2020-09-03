package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankColtrollerSQL {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    //insert into ..


    //  Map<String, Integer> pangakonto = new HashMap<>();

    //loo konto insert
    @GetMapping("createAccount")
    public void createAccount(@RequestParam String accountNumber, Integer balance) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (':aNr', ':blnc')";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        paramMap.put("blnc", balance);
        jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    @GetMapping("getAccountBalance")
    public Integer getAccountBalance(@RequestParam String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return result;
    }

    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam String accountNumber, Integer deposit) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
        paramMap = new HashMap();
        //int deposit2 = deposit + result -- võib ka uue int teha, aga pole vaja, siis peab järgmisel real .. + .. ära muutma.
        paramMap.put("blnc", deposit + result);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam String accountNumber, Integer withdraw) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        if (result >= withdraw) {
            sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
            paramMap = new HashMap();
            paramMap.put("blnc", result - withdraw);
            jdbcTemplate.update(sql, paramMap);
        }
    }

        @GetMapping("transferMoney")
        public void transferMoney(@RequestParam String accountNumber,
                @RequestParam Integer transfer,
                @RequestParam String accountNumber2){
            String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
            Map<String, Object> paramMap = new HashMap();
            paramMap.put("aNr", accountNumber);
            Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
            if (result >= transfer) {
                sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
                paramMap = new HashMap();
                paramMap.put("blnc", + result - transfer);

                sql = "SELECT balance FROM account WHERE account_nr = :aNr";
                paramMap = new HashMap();
                paramMap.put("aNr", accountNumber2);
                Integer result2 = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
                sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
                paramMap = new HashMap();
                paramMap.put("blnc", result2 + transfer);
                jdbcTemplate.update(sql, paramMap);
            }
        }
    }


// otse controllerist teeme postgre sse päringu
// teeme bank service ja controlleris injectite
// tõstame kõik servicesse ja
//pmst paneme igale poole accunrt service ette