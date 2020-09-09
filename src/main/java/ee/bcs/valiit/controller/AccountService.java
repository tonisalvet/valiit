package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            //http://localhost:8080/transferMoney?accountNumber=EE357&amount=500&accountNumber2=EE123
        } else {
            System.out.println("Insufficient funds");
        }
    }
}


// otse controllerist teeme postgre sse päringu
// teeme bank service ja controlleris injectite
// tõstame kõik servicesse ja
//pmst paneme igale poole account service ette


