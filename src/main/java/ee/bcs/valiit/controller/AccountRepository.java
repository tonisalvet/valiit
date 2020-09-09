package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNumber, Integer balance) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:aNr, :blnc)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        paramMap.put("blnc", balance);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer getAccountBalance(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void withdrawMoney(String accountNumber, Integer withdraw) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        if (result >= withdraw) {
            sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
            paramMap = new HashMap();
            paramMap.put("blnc", result - withdraw);
            paramMap.put("aNr", accountNumber);
            jdbcTemplate.update(sql, paramMap);
        }
    }

    public void updateMoney(String accountNumber, Integer amount){
        String sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("blnc", amount);
        paramMap.put("aNr", accountNumber);
        jdbcTemplate.update(sql, paramMap);
    }

    public void transferMoney(String accountNumber, Integer transfer, String accountNumber2) {
        if (result >= transfer) {
            String sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
            HashMap paramMap = new HashMap();
            paramMap.put("blnc", +result - transfer);
            paramMap.put("aNr", accountNumber);
            jdbcTemplate.update(sql, paramMap);

            sql = "SELECT balance FROM account WHERE account_nr = :aNr";
            paramMap = new HashMap();
            paramMap.put("aNr", accountNumber2);
            Integer result2 = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
            sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
            paramMap = new HashMap();
            paramMap.put("blnc", result2 + transfer);
            paramMap.put("aNr", accountNumber2);
            jdbcTemplate.update(sql, paramMap);
        }
    }
}