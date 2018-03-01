# SpringWebUsingWebXMLAndSpringContext
SpringWebUsingWebXMLAndSpringContext


Spring IoC Container
====================
Spring Ioc is the mechanism to achieve loose coupling between object dependencies.

Spring container is the program which injects dependencies to an object and make ready for use.

Spring container class are part of org.springframework.beans and org.springframework.context packages
Spring IoC container provides us different ways to decouple the object dependencies.

i) BeanFactory
ii) Application context

BeanFactory is root interface of the IoC container and ApplicationContext is the child interface of BeanFactory interface.

differences between bean factory and applicationContext
---------------------------------------------------------
1.BeanFactory does Lazy initialization, which means it creates beans only when it is requested, whereas applicationcontext
creates all beans during initialization

2. applicationContext supports L10n and internalization, whereas beanfactory does not.

3.Annotation based dependency injection is supported by application context whereas beanfactory does not.


Some of the useful implementation of applicationContext
------------------------------------------------------
a) ClassPathXmlApplicationContext: if we spring bean configuration file in an application, 
then we use ClassPathXmlApplicationContext class to load the file and get container object.

b) FileSystemXmlApplicationContext: it is similar to the ClassPathXmlApplicationContext, however
the file can be loaded anywhere in the filesystem.

c) AnnotationConfigApplicationContext: if we are using standalone java application and using annotation for configuration,
then we can use AnnotationConfigApplicationContext to initialize the container objects and get the bean objects.

Spring Bean
-----------
any object that we initialize through spring container is called Spring bean.
Any POJO can be a Bean.

Spring bean scopes
--------------------
There are five scopes defined for Spring Beans.


1.singleton:
	only once instance is created for each container.
	
2. prototype:
	a new instance is created every time bean is requested.

3. request:
	it is similar to prototype scope bean  but it is used for web application, a new instance of the bean is created
	for each http request.

4. session: 
	a new bean is created for each http session by the container

5. global-session – This is used to create global session beans for Portlet application	


<TODO>
example of request bean and session bean

Spring bean configuration
--------------------------
1. Annotation Based Configuration – By using @Service or @Component annotations. 
   Scope details can be provided with @Scope annotation.
   
2. XML based configuration - by using simple spring configuration xml file to configure the beans
   if you are using spring MVC  then use can use web.xml to mention the spring configuration file

   
	
