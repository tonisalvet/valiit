//package ee.bcs.valiit.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountService {
//
//
//    @Autowired
//    private AccountRepository repository;
//    //insert into ..
//
//
//    //  Map<String, Integer> pangakonto = new HashMap<>();
//
//    //loo konto insert
//    public void createAccount(String accountNumber, Integer balance) {
//        repository.createAccount(accountNumber, balance);
//        //http://localhost:8080/createAccount?accountNumber=EE357&balance=8500
//    }
//
//    public Integer getAccountBalance(String accountNumber) {
//        return repository.getAccountBalance(accountNumber);
//        //http://localhost:8080/getAccountBalance?accountNumber=EE357
//    }
//
//    public void depositMoney(String accountNumber, Integer deposit) {
//        repository.depositMoney(accountNumber, deposit);
//        //http:localhost:8080/depositMoney?accountNumber=EE357&deposit=5000
//    }
//
//    public void withdrawMoney(String accountNumber, Integer withdraw) {
//        Integer result = repository.withdrawMoney(accountNumber, withdraw);
//        if (result >= withdraw) {
//            repository.withdrawMoney(accountNumber, withdraw);
//            //http://localhost:8080/withdrawMoney?accountNumber=EE357&withdraw=3000
//        }
//    }
//
//    public void transferMoney(String accountNumber, Integer transfer, String accountNumber2) {
//        Integer result = repository.getAccountBalance(accountNumber);
//        if (result >= transfer) {
//            repository.withdrawMoney(accountNumber, transfer);
//            //http://localhost:8080/transferMoney?accountNumber=EE357&transfer=500&accountNumber2=EE123
//        }
//    }
//}


// otse controllerist teeme postgre sse päringu
// teeme bank service ja controlleris injectite
// tõstame kõik servicesse ja
//pmst paneme igale poole account service ette


//