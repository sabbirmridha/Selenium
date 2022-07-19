# selenium - Junit using java

How to run this project for selenium Junit using java:

---

Prerequisites:

1.You must have install jdk 1.8 or above

2.You must have set JAVA_HOME and GRADLE_HOME 

3.Clone the project

4.Open terminal inside the project folder

5.Give following command:

  gradle clean test


---

# selenium - Junit Test Report Screenshot

![jUnitTestReport](https://user-images.githubusercontent.com/50478815/178106402-a0b8bf21-8d08-4641-9df7-778568418b7e.PNG)
![terminal view](https://user-images.githubusercontent.com/50478815/178106405-055d8103-1f07-49a6-b52e-e636f870eefa.PNG)


# selenium - TestNG -POM 

Technology:

---

Tool: selenium

IDE: IntelIJ

Build tool: Gradle

Language: Java

Framework: TestNG

---


# Prerequisites :

---

1.Install jdk 8 or any LTS version

2.Configure JAVA_HOME and GRADLE_HOME

3.Download Allure latest version and configure system environment path

4.Stable internet connection

---

# How to run this project

---

1.Clone the repo in your local directory

2.Open terminal to the project folder

3.Run below command to build the project

gradle clean test



4.Run  belowcommands to generate allure report-

allure generate allure-results --clean -o allure-report


5.Run below command  to generate html report and automatically open it in a web browser-

allure serve allure-results

---

# Screenshots for Reports

















