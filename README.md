# qa-framework-challenge
**1. Introduction:**
- This little document aims to explain how the project is setup, as well as how to run it.
- Due to tight schedule so I know that there are quite a lot of points needs to be improved.
- I try to be as flexible as much as possible in the framework by allowing people to choose
their style: either come along with classic approach, or go with BDD approach.

**2. Pre-requisities:**
- Java JDK 17 installed and configured properly
- IDE. IntelliJ is recommended
- Maven installed and configured properly, but it is optional since I already provide
Maven wrapper. Instead of using mvn command, we can issue command: ./mvnw

**3. How to run the tests:**

**3.1. UI:**

**3.1.1. CucumberRunner**
- To run BDD tests, right click on the CucumberRunner > Run
https://drive.google.com/file/d/1sRCP_fOiTWLrzD_USnpkyTHJdaR8yVPO/view?usp=sharing
- In VM options, update command to -ea -Dspring.profiles.active=dev
https://drive.google.com/file/d/1II7-1waiQT103w0iHT7MmuaUSuos1eER/view?usp=sharing
- Finally, click on Apply then OK
- Now we can right-click on CucumberRunner > Run CucumberRunner

**3.1.2. TestNG XML file**

- To run classic test, right click on the testng.xml file > Modify Run configuration
https://drive.google.com/file/d/1RUJeEiVvRT2NcsnmbEs7s6P2fRkPxh7t/view?usp=sharing
- In VM options, update command to -ea -Dspring.profiles.active=dev
https://drive.google.com/file/d/1EWKutqIrftdI3KiNRR67gQm7tCPK4wCt/view?usp=sharing
- Finally, click on Apply then OK
- Now we can right-click on testng.xml file > Run testng.xml file:
https://drive.google.com/file/d/1el5Vsik0uTuQ0WA5bjXCdK-ifC1eS_IU/view?usp=sharing


**3.2. Command line:**

**3.2.1. TestNG XML file**

- First clone this repo from GitHub
- Next, cd to qa-framework-challenge repo
- Run following command line: mvn clean install -Dspring.profiles.active=dev
https://drive.google.com/file/d/1IGpjaLpGsgzZrua0MZfqpxiWh8msdswY/view?usp=sharing
https://drive.google.com/file/d/1TvEgV9GiVc1eKReKO-8MN2rc1we6JEiX/view?usp=sharing
https://drive.google.com/file/d/11n0VItZ5mJcErhEzL-qKEJtEaL0UAmZY/view?usp=sharing

**3.2.2. CucumberRunner**
- Will update sooner.

**5. Improvements:**
- Rework on pom.xml. Some dependencies are not used but I don't have enough of times for clean up.
- Support for Selenium Grid
- Rework on CucumberHooks. Now afterScenario step always check if WebDriver instance is existed
- Update the NinjaVanClient. It is still verbose now.
- Dockernize the framework to run it on CI/CD tool.
- Define groups for non-BDD test cases.
- Have better report. ReportPortal is one great report tool that keep run history, and elapsed time for each run
