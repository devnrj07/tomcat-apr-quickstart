# tomcat-apr-quickstart
This springboot project provides an easy to enable apr+openssl in your embedded tomcat webserver

#This is just simple configuration project with no functional implementation, will tell you how to enable native apr in springboot embedded tomact server.

1 .First, get the tomcat-native libraries from here : https://tomcat.apache.org/tomcat-8.0-doc/apr.html
2 .Set the java.library.path to point to the native libraries.

3. Add this lines to your pom.xml


<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <jvmArguments>
            -Djava.library.path=/path/to/tomcat-native/
        </jvmArguments>
    </configuration> 
</plugin>

or uncomment them from this project's pom.xml file.

4. Add a java class APRConfiguration, which will tell the LifeCycleListner to use apr protocol.
