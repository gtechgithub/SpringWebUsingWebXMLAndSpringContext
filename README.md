# SpringWebUsingWebXMLAndSpringContext
SpringWebUsingWebXMLAndSpringContext
How to create Web application 
-------------------------------

Please note this is used earlier, now it has become very simple using STS, hence below instructions are application
if we are manually setting up deployment descriptor and Spring config file.

1) create a maven project with Web artifact.
2. Ensure below directory is created in the project explorer, if not manually create it

    SpringWeb   pom.xml
				
				>src
				   
					   > Java
							 > com
								  >javapoint
											Employee.java
											HomeController.java
					   > Resources
					   > webapp
							   > WEB-INF
									   > Spring
											   >SpringWeb
														 spring-context.xml
										 root-context.xml	   
									   
									   > views
											  home.jsp
									   
									   web.xml
						 index.jsp
							 
			 
3.	In the pom.xml we need following dependencies for web, servlet, jsp to work.

		 
	    <dependency>
    	<groupId>org.springframework</groupId>
    	<artifactId>spring-core</artifactId>
		<version>${spring.version}</version>
    </dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>	
		<version>${spring.version}</version>
	</dependency>
	
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-web</artifactId>
		<version>${spring.version}</version>
	</dependency>
    
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
     </dependency>


	<!--  needed for JSP rendering html tags -->
    <dependency>
	  <groupId>javax.servlet</groupId>
	  <artifactId>javax.servlet-api</artifactId>
	  <version>3.1.0</version>
	  <scope>provided</scope>
	</dependency>
	
	<!--  needed for JSP JSTL rendering -->
	<dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>jstl</artifactId>
	    <version>1.2</version>
	</dependency>
	

4. Next we need to define Deployment descriptor which is the Web.xml
   
   a) primarily context param is essential, hence define it.

		  <!-- The definition of the Root Spring Container shared by all Servlets and Filters 
		  first web.xml deployment descripter will be loaded then root-context.xml followed by spring-context.xml
		  
		  root-context.xml   ====> non web beans spring configuration file
		  spring-context.xml ====> web bean spring configuration file
		  -->
			<context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/Spring/root-context.xml</param-value>
			</context-param>	   
			
	b) create a listener which will create container class and listen to all servlet request

				<!-- Creates the Spring Container shared by all Servlets and Filters -->
				<listener>
					<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
				</listener>
				
	c) now we need to define the servlet and dispatcher servlet which processess the application request
	   and for the dispatcher servlet we need to mention the config location which is the servlet-config.xml

		The <load-on-startup> is a tag element which appear inside <servlet> tag in a web.xml. This tag specifies that the servlet should be loaded automatically on the startup of the web application.	   

		the <load-on-startup> value is a positive integer or 0 which specifies the servelts loaded order as per your business logic or what suites your application.

		
	   	<!--  now define servlet while processess application request -->
		<servlet>
		   <servlet-name>SpringWeb</servlet-name>
		   <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<init-param>	
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/Spring/SpringWeb/spring-context.xml</param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>

	d) finally we need to do the servlet mapping, let say we have two servlet tags servlet mapping is essential to resolve it.


	url to hit: 
	http://localhost:8080/SpringWeb/Spring/Home
	
			<servlet-mapping>
				<servlet-name>SpringWeb</servlet-name>
				<url-pattern>/Spring/*</url-pattern>
			</servlet-mapping>
			
	e) finally configure error page for 404 page not found 

		url to hit: 
	http://localhost:8080/SpringWeb/S
	or 
	http://localhost:8080/SpringWeb/Spring/web
	
	<error-page>
		<error-code>404</error-code>
		<location>/WEB-INF/views/errorpage404.jsp</location>
	</error-page>
	
5) now we need to define spring context as mentioned in the contextConfigLocation

	a) defines servlet request mapping
	
	 	<!--  DispatcherServlet context: defines the servlet request mapping architecture -->
 
		<!-- enables the MVC spring @controller @RequestMapping @Required etc -->
		<mvc:annotation-driven></mvc:annotation-driven>

	b) mentioned resources path
	<!--  resources mapping once can get the static resources in then ${webapproot}/resources directory -->
 	<!--  <mvc:resources mapping="/resources/**" location="/resources/"></mvc:resources>
 	 -->
 	
	c) define view resolver
	
	<!-- resolves views which is used by the controller to display the page -->
 	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 		<property name="prefix" value="/WEB-INF/views/"></property>
 		<property name="suffix" value=".jsp"></property>
 	</bean>
 	
	d) finally component scan to locate the packages to identify Component, Controller etc.
	

6) now we need to create controller to handle request and JSP

7) at last create a dummmy root-context file in the location mentioned in deployment  descriptor


		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
			  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

			  <!-- Root Context: defines shared resources visible to all other web components -->

		</beans>
	
