## In this lab you’ll practice using JPA with Spring Boot

* Create a new Spring Boot project **Lab02** and add web, jpa and mysql templates
* Create a database **accountsdb** in MySQL. 
* Copy the following SQL queries in MySQL query window to create tables **accounts** and **statements**.
```sql
create table `accountsdb`.`accounts` ( `account_number` int (4) NOT NULL AUTO_INCREMENT , `owner` varchar (40) NULL , `balance` int (7) NULL , PRIMARY KEY ( `account_number` ) );

create table `accountsdb`.`statements` ( `id` int (4) NOT NULL AUTO_INCREMENT, `account_number` int (4) NULL, `amount` int (7) NULL , `type` varchar (40) NULL, PRIMARY KEY ( `id` ) );

INSERT INTO accounts(owner,balance) VALUES('John',2000);
```



* Given below is the skeleton of AccountService class you need to implement
```java

public class AccountService {
 public boolean deposit(int accountNumber,int amount, String type) {
	// update balance in accounts table
	// insert into statements table .
 }

 public boolean withdraw(int accountNumber,int amount, String type) {
	// update balance in accounts table
	// insert into statements table
 }
}
```

* Inject **AccountService** in your **BankController** class
* **BankController** is given below

```java
@RestController
@RequestMapping("/bank")
public class BankController {
 @PostMapping("/deposit")
 public String deposit(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
 }
 @PostMapping("/withdraw")
 public String withdraw(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
 }
}
```

* Create the Entities, Repositories and modify the controller and service classes appropriately
* __type__ field has values like  “Withdraw” or “Deposit” or “Interest” or "Fees" depending on the operation

