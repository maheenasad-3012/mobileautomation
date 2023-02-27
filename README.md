# mobileautomation

Pre-requisites:

1. Java JDK 8 should be installed & JAVA_HOME environment variable should be set
2. Android SDK should be installed and ANDROID_HOME environment variable should be set
3. Maven should be installed
4. Appium should be installed and Appium Server should be started

Steps to setup:

1. Clone repo: https://github.com/maheenasad-3012/mobileautomation.git

2. Open project on IntelliJ

3. Download maven dependencies through pom.xml

Steps to execute script:

1. Right click testng.xml and Run it

2. Wait for full execution

3. After execution is completed, open /reports/report.html on Chrome browser to view results

4. To view results in json format, open /reports/report.json

5. To view the screenshot of the failed cases, open /screenshots

Code Structure:

1. All test cases are in src/main/java/testcases

2. Page objects are in src/main/java/pageObjects

3. All setup and configuration related code is in src/main/java/general

4. All application configuration are in src/main/java/config

Framework Explanation:

1. general/BaseTest: Hooks are implemented here with implementation of necessary steps to take during execution. 
2. general/CommonAssertions: Commonly used assertions are implemented here.
3. general/CommonFunctions: All the common functions related to mobile operations such as click, sendKeys etc are mentioned here.
4. general/EnvGlobals: All the data used in the cases is mentioned here
5. general/MainCall: Static instances of page objects is created here which is used to refer the pageObjects from the test cases. 
6. general/MobileDriverFactory: Driver related information is coded here
7. general/MobileDriverWaits: Waits related information is listed here
8. general/Reports: Code related to report generation is here.
9. general/Screenshots: Code related to capturing screenshots and to store them is written here.
