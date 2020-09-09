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

    public void updateMoney(String accountNumber, Integer amount){
        String sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("blnc", amount);
        paramMap.put("aNr", accountNumber);
        jdbcTemplate.update(sql, paramMap);
    }
}