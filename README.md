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
##### 3. Running from mvn command line

	mvn clean test

# More Features

##### 1. Screenshot on Failure - TestNG Listeners
##### 2. Excellent HTML Reports on Test Execution - Extent - Report 

##### 10. Enhancement
* Integrate with BrowserStack for multiple Chrome versions validation
* Intefrate with Jenkins for the flexibility running with schedule
* Using different Data Driven method, such as Excel or CSV data Driven and database test data driven

