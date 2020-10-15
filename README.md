Compass Digital Lab - QA Specialist Interview Assessment

"Demonstrate a Java/Selenium (Chrome driver) program to Automates Google account login(successful, unsuccessful - invalid entries)/logout"


# Creation of Maven Project

##### 1. Create a Maven Project

>* src/test/java - All the test cases created here
>* src/main/java - All the utilities, base objects, data and etc.
>* pom.xml - the maven configure file

##### 2. Add All Dependencies and Plugins to pom.xml
##### 3. Create Base java class in src/main/java/utilities
##### 4. Create public void initializeDriver() method
##### 5. Create data.properties src/main/java/resource

# Creation page objects

##### 1. Create LoginPage class in src/main/java/pageObjects and defien the web elements 
##### 2. Create LogoutPage class in src/main/java/pageObjects and defien the web elements 

# Creation testCases

##### 1. Create LoginValidation class in src/test/java/testCases and write the corresponding tests 
##### 2. Create LogoutValidation class in src/test/java/testCases and write the corresponding tests 

# Integrate with testNG

##### 1. Add @Test annotation to each test 
##### 2. Add BeforeMethod and AfterMethod
##### 3. Add dataProvider for username and password and define the test data

# Run the tests

##### 1. Running the test as TestNG test for each class
##### 2. Running from testng.xml
##### 3. mvn command line
###### 
* Search log4j maven dependency
* Append the dependency to pom.xml
* Check if Project//Build Automatically is selected.
* Add resource folder of "log4j.xml" to "pom.xml" file

	<resources>
			<resource>
				<directory>src/main/recources</directory>
				<filtering>true</filtering>
		</resource>
	<resources>
	
* Add the source file to java build path - otherwise the system does not know where to find the log4j2.xml configuration file.2
* right click project ==> Build Path ==> Configure Build Path... ==> Java Build Path//Source Folde

##### 7. Fix the framework issues by tweaking TestNG configuration file.
* The 1st and 2nd windows are not closed before the 3rd window opens. They all closed after the tests are completed.
* This is because the TestNG configured the 3 classes inside 1 test. 
* Define each class under 1 set of the test to avoid the windows closing issue. 
* put "driver = null;" after driver.close(); -- release the memory.
* Change the driver initialize to static that has more advantages. 

##### 8. Screenshot on Failure - TestNG Listeners
* Add Apache commons-io maven dependency to pom.xml
* Add getScreenshot() method in base class
* Create a listener class and implements ITestListener
* Invoke getScreenshot() in Failed Listener.
* Configure testng.xml - adding the listener.

			<listeners>
				<listener class-name="Academy.Listeners"/>
			</listeners> 

##### 9. Excellent HTML Reports on Test Execution - Extent - Report API & Dashboard
* Get the dependency of "extentreports" and add it to pom.xml
* Get the ExtentReporterNG.java class to be added to the project
* Add ExtentReporterNG as a listener.

##### 10. Integrate the project to Jenkins CI tool
* Jenkins installation
* http://localhost:8080/ - Jenkins console
* Jenkins ==> Manage Jenkins ==> Global Tool Configuration

>* JDK setup
>* GIT setup
>* Maven setup

* New Item ==> Enter"E2EProject" ==> General ==> Advanced ==> Use custom workspace
* Build ==> Add build step ==> Invoke top-level Maven targets ==> put the mvn command to the Goals
* Optional - Build Triggers ==> Build periodically

##### 11. Parameterize Jenkins Build with different browsers execution

##### 12. Coding Standards - Private locators & Public methods to achieving Encapsulation 
* OOPS Principle Framework

##### 13. Remove hard coded Paths from everywhere in the Project

##### 14. Achieve Chrome Headless Execution Mechanism

##### 15. How Inheritance is achieved in Framework

##### 16. Where are Interfaces used in the framework

##### 17. Can there be multiple @Test methods in one single class? What changes needed in Testng.xml file to club multiple @Test methods into one single Test Tag.

##### 18. Can driver be static without initializing it form every Test?



##### 19. Enhancement
* Add the timestamp to the screenshot file.
* Add the webdrivers to resources folder and change the path to dynamic path

* 
