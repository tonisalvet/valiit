package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNumber, Integer balance, Integer client_id) {
        String sql = "INSERT INTO account (account_nr, balance, client_id) VALUES (:aNr, :blnc, :id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        paramMap.put("blnc", balance);
        paramMap.put("id", client_id);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer getAccountBalance(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void updateMoney(String accountNumber, Integer amount) {
        String sql = "UPDATE account SET balance = :blnc WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("blnc", amount);
        paramMap.put("aNr", accountNumber);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateTransactions(Integer fromAcc_id, Integer amount, Integer toAcc_id) {
        String sql = "INSERT into transactions (fromAcc_id, toAcc_id, amount) values (:fromAcc_id, " +
                ":toAcc_id, :amount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("amount", amount);
        paramMap.put("fromAcc_id", fromAcc_id);
        paramMap.put("toAcc_id", toAcc_id);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer getAccountIdByAccountNr(String accountNumber) {
        String sql = "SELECT id FROM account WHERE accountNumber = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}