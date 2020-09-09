package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {


    @Autowired
    private AccountRepository repository;
    //insert into ..


    //  Map<String, Integer> pangakonto = new HashMap<>();

    //loo konto insert
    public void createAccount(String accountNumber, Integer balance) {
        repository.createAccount(accountNumber, balance);
        //http://localhost:8080/createAccount?accountNumber=EE357&balance=8500
    }

    public Integer getAccountBalance(String accountNumber) {
        return repository.getAccountBalance(accountNumber);
        //http://localhost:8080/getAccountBalance?accountNumber=EE357
    }

    public void depositMoney(String accountNumber, Integer deposit) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
        paramMap = new HashMap();
        //int deposit2 = deposit + result -- võib ka uue int teha, aga pole vaja, siis peab järgmisel real .. + .. ära muutma.
        paramMap.put("blnc", deposit + result);
        paramMap.put("aNr", accountNumber);
        jdbcTemplate.update(sql, paramMap);
        //http:localhost:8080/depositMoney?accountNumber=EE357&deposit=5000
    }

    public void withdrawMoney(String accountNumber, Integer withdraw) {
        Integer result = repository.getAccountBalance(accountNumber);
        if (result >= withdraw) {
            repository.updateMoney(accountNumber, result - withdraw);
        }
    }

    public void transferMoney(String accountNumber, Integer transfer, String accountNumber2) {
        Integer result = repository.getAccountBalance(accountNumber);
        if (result >= transfer) {
            repository.withdrawMoney(accountNumber, transfer);
            //http://localhost:8080/transferMoney?accountNumber=EE357&transfer=500&accountNumber2=EE123
        }
    }
}


// otse controllerist teeme postgre sse päringu
// teeme bank service ja controlleris injectite
// tõstame kõik servicesse ja
//pmst paneme igale poole account service ette


