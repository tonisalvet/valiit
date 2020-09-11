package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AccountService {


    @Autowired
    private AccountRepository repository;
    //insert into ..


    //  Map<String, Integer> pangakonto = new HashMap<>();

    //loo konto insert
    public void createAccount(String accountNumber, Integer balance, Integer client_id, String status) {
        repository.createAccount(accountNumber, balance, client_id, status);
        //http://localhost:8080/createAccount?accountNumber=EE357&balance=8500&status=active
        //http://localhost:8080/createAccount?accountNumber=EE123&balance=8500
        //http://localhost:8080/createAccount?accountNumber=EE123&balance=5500&client_id=11&status=active  <- client_id peab olema unikaalne - s.t et kaks korda ühega ei toimi
    }

    public Integer getAccountBalance(String accountNumber) {
        return repository.getAccountBalance(accountNumber);
        //http://localhost:8080/getAccountBalance?accountNumber=EE357
    }

    public void depositMoney(String accountNumber, Integer amount) {
        Integer result = repository.getAccountBalance(accountNumber);
        {
            repository.updateMoney(accountNumber, result + amount);
        }
        //http://localhost:8080/depositMoney?accountNumber=EE357&amount=5000
    }

    public void withdrawMoney(String accountNumber, Integer amount) {
        Integer result = repository.getAccountBalance(accountNumber);
        if (result >= amount) {
            repository.updateMoney(accountNumber, result - amount);
        } else {
            System.out.println("Insufficient funds");
        }
        //http://localhost:8080/withdrawMoney?accountNumber=EE357&amount=5000
    }

    public void transferMoney(String accountNumber, Integer amount, String accountNumber2) {
        Integer accountNr1Balance = repository.getAccountBalance(accountNumber);
        Integer accountNr2Balance = repository.getAccountBalance(accountNumber2);
        if (accountNr1Balance >= amount) {
            repository.updateMoney(accountNumber, accountNr1Balance - amount);
            repository.updateMoney(accountNumber2, accountNr2Balance + amount);
            Integer fromAccId = repository.getAccountIdByAccountNr(accountNumber);
            Integer toAccId = repository.getAccountIdByAccountNr(accountNumber2);
            repository.updateTransactions(fromAccId, amount, toAccId);
            //http://localhost:8080/transferMoney?accountNumber=EE357&amount=500&accountNumber2=EE123
        } else {
            System.out.println("Insufficient funds");
        }
    }
    public String getStatus(String accountNumber) {
        return repository.getStatus(accountNumber);
    }

}


