//package ee.bcs.valiit.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class BankColtrollerSQL {
//
//
//    @Autowired
//    private AccountService service;
//    //insert into ..
//
//
//    //  Map<String, Integer> pangakonto = new HashMap<>();
//
//    //loo konto insert
//    @GetMapping("createAccount")
//    public void createAccount(@RequestParam String accountNumber, Integer balance) {
//        service.createAccount(accountNumber, balance);
//    }
//
//    @GetMapping("getAccountBalance")
//    public Integer getAccountBalance(@RequestParam String accountNumber) {
//        return service.getAccountBalance(accountNumber);
//    }
//
//    @GetMapping("depositMoney")
//    public void depositMoney(@RequestParam String accountNumber, Integer deposit) {
//        service.depositMoney(accountNumber, deposit);
//    }
//
//    @GetMapping("withdrawMoney")
//    public void withdrawMoney(@RequestParam String accountNumber, Integer withdraw) {
//        service.withdrawMoney(accountNumber, withdraw);
//    }
//
//    @GetMapping("transferMoney")
//    public void transferMoney(@RequestParam String accountNumber,
//                              @RequestParam Integer transfer,
//                              @RequestParam String accountNumber2) {
//        service.transferMoney(accountNumber, transfer, accountNumber2);
//    }
//}
//
//
//// otse controllerist teeme postgre sse päringu
//// teeme bank service ja controlleris injectite
//// tõstame kõik servicesse ja
////pmst paneme igale poole account service ette