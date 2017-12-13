<u>The README is used by **2** projects(d171202 and d171211), read based on where this README is located.</u>

How is [d171202-consuming-web-service-spring-boot-soap-wsdl](https://github.com/peckwood/d171202-consuming-web-service-spring-boot-soap-wsdl) project different from [d171211_consuming_web_service_spring_boot](https://github.com/peckwood/d171211_consuming_web_service_spring_boot)?

- d171202 works with producer project [d171202-producting-web-service-spring-boot-soap-wsdl](https://github.com/peckwood/d171202-producting-web-service-spring-boot-soap-wsdl), which follows an [official Spring guide](https://spring.io/guides/gs/producing-web-service/) 
- d171211 works with producer project [d171212_producing_web_service](https://github.com/peckwood/d171212_producing_web_service_webapp_without_spring_boot_multiple_operations_multiple_artifacts), which follows a [concretepage guide](https://www.concretepage.com/spring-4/spring-4-soap-web-service-producer-consumer-example-with-tomcat#download)

That's it, the technologies are the same, both follow the same [official spring consumer guide](https://spring.io/guides/gs/consuming-web-service/).

### Features

- Soap WSDL web service consumer created with Spring Boot
- Annotation based Spring configuration
- Automatic artifact/stub generation with maven plugin org.codehaus.mojo:jaxws-maven-plugin 

### Development steps:

1. make sure the producer project is started and get its wsdl URL, something like `http://localhost:8080/ws/countries.wsdl`(1202) or `http://localhost:8080/d171212_producing_web_service/ws/contract-status-update.wsdl`(1211)
2. delete the generated artifacts so you can generate you own artifacts. artifacts are stub java sources generated from a wsdl url (consumer) or xsd (producer)
   1. they are located in package `com.raidencentral.app.wsdlartifact`, 
   2. empty it or create your own package
   3. errors will pop up, ignore them
3. uncomment the <goals> tag inside jaxws-maven-plugin maven plugin
4. run `mvn clean pakcage`
5. it wil fail for the errors in step 2, however the artifacts will be generated inside `target` folder
6. copy the artifacts into `main`
7. create your client just like `com.raidencentral.app.CountryClient`(1202) or `com.raidencentral.app.ContractStatusUpdateClient` (1211)
8. Modify `com.raidencentral.app.WebServiceConfiguration` to add your client
   1. the mashaller/unmarshaller must set context path to the package the artifacts are stored in step 2
   2. make sure a client has the matching marshaller/unmarshaller
   3. client's defaultUri is the wsdl url in step 1 without ".wsdl"
9. Modify `com.raidencentral.app.Application` to however you test the project
10. make sure producer project is started and run Application

> [an example of generating from wsdl using jaxws-maven-plugin](https://gist.github.com/uttesh/a59dd0b31f44af23d201)
>
> 





