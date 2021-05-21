### Little bit of history in Spring

* EJB (Enterprise Java Beans)

``` java

class Account {
	accountNumber, balance;
	deposit(amount) {}
	withdraw(amount) {}
	transferFund(to, amount) {}
}

```

* A pool of Account objects; Object Pooling
* Transaction service for transferFund
* Security service for withdraw and transferFund

* Provide a EJB container
* You drop your code inside the container
* Tell(configure) the container and specify what services your code needs
* Container provides those services

#### Silly rules of (old) EJB

``` java
	
	interface Account extends Remote {
		deposit(amount);
		withdraw(amount);
		transferFund(to, amount);
	}
	
	interface AccountHome extends Home {
	}
	
	class AccountBean implements EntityBean {
		//implement all the methods in Account interface
		//DO NOT write constructors
		//DO NOT have static methods
		//DO NOT extend some other class
		//DO NOT have final methods
	}
	
//	ejb-jar.xml
//  Bundle all these into a jar file and then drop them inside the container

```

* Spring framework provided a lightweight container
* POJO framework
* __ApplicationContext__ that acts as a container
* It manages the lifecycle of all the beans in the application
* __Dependency Injection__ is the basic principle of Spring framework
* Simple mechanism by which you avoid writing unnecessary creation and lookup code


#### Need to bootstrap Spring


* Cloud providers like AWS
* Spring boot is an abstraction of Spring framework
* Agile way of developing production-ready applications on the JVM
* Spring 5.x; Spring Boot is 2.x(uses Spring 5)












