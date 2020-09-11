package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNumber, Integer balance, Integer client_id, String status) {
        String sql = "INSERT INTO account (account_nr, balance, client_id, status) VALUES (:aNr, :blnc, :id, :stat)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        paramMap.put("blnc", balance);
        paramMap.put("id", client_id);
        paramMap.put("stat", status);
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

    public String getStatus(String accountNumber) {
        String sql = "SELECT status FROM account WHERE account_nr = :aNr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("aNr", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

//    public List<Transaction> getTransactionHistory(Integer accountId) {
//        String sql = "SELECT id, account_id, amount FROM transactionHistory WHERE account_id = :accountId";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("accountId", accountId);
//        return jdbcTemplate.query(sql, paramMap, new TransactionRowMapper());
//    }
}