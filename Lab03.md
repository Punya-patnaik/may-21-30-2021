### Lab03


##### Application 01
* Create a Spring boot application, say, __lab03-ui__ running on **8081**
* Accessing **http://localhost:8081** will give you a text box where you enter a number as input 
* On hitting the submit button your application will talk to **http://localhost:8082/{number}**  
* Display the result in the **same page**


##### Application 02

* The **8082** application is another Spring boot application, say __lab03-even__ that accepts a number and determines if it's even or not


##### RestTemplate

* Talk to other services using **RestTemplate** class provided by Spring
* Create an instance of **RestTemplate** and use **getForXXX** or **postForXXX** methods

#### Exception Handling
* Bring down the Even number service and handle the exception using @ExceptionHandler

