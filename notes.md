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


#### Spring boot configuration

* Create a class with any name
* Mark it as __@Configuration__
* Create methods inside this class that return beans
* Mark the methods using __@Bean__ annotation

### Transactional

* Generates proxy classes that extend the target class

``` java

class AccountService {
	@Transactional
	withdraw()
	
	@Transactional
	deposit()
}

class Proxy extends AccountService {
	private AccountService original;
	
	withdraw() {
		txnManager.beginTranscation();
		try {
			original.withdraw();
			txnManager.commit();
		}
		catch(ex) {
			txnManager.rollback();
		}
	}
	
	deposit() {
		txnManager.beginTransaction();
		try {
			original.withdraw();
			txnManager.commit();
		}
		catch(ex) {
			txnManager.rollback();
		}
		
	}
}

```

#### Packaging and deploying

* -Dkey1=value -Dkey2=value
* mvn package
* Spring boot applications are packaged as jar files
* Service is a self-sufficient, independently running, self deployable unit
* jar contains embedded tomcat
* __java -jar -Dserver.port=8082 -Dwelcome="welcome" day03-0.0.1-SNAPSHOT.jar__

* If you want to deploy in a standalone pre-configured server, package the spring boot application as a war file and deploy it
* This requires tweaking of pom.xml and @Configuration beans in the code
  























