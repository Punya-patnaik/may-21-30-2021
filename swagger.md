## Generate API docs using Swagger

* Add the following dependencies to pom.xml

``` xml
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
```

* Create a class __AppConfiguration__ with the following code

``` java

@Configuration
@EnableSwagger2
public class AppConfiguration {

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("<BASE PACKAGE>"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("<TITLE>").description("API documentation v1.0").build());
	}
}

``` 

* Change the __<BASE PACKAGE>__ and __<TITLE>__ values accordingly

* Run the app and go to http://localhost:8080/swagger-ui.html

* Use the annotations __@ApiOperation, @ApiResponses, @ApiResponse, @ApiParam__ on your controller methods and observe the changes in the generated documentation 