# UI и API autotests for [openfoodfacts](https://world.openfoodfacts.org/)

<img alt="openfoodfacts" src="readme/screenshots/openfoodfacts.png">

## <a id="list"></a> Content 

* <a href="#tools">Тools and technologies</a>

* <a href="#cases">Tests</a>:   
  - <a href="#cases-ui"> UI
  - <a href="#cases-api"> API

* <a href="#integrations">Integrations</a>

* <a href="#console">Launch via terminal</a>
  - <a href="#console-ui"> UI
  - <a href="#console-api"> API

* <a href="#jenkins">Jenkins jobs</a>

* <a href="#allure">Allure reports</a>

* <a href="#telegram">Telegram reports</a>

* <a href="#testops">Integration with Allure TestOps</a>


## <a id="tools"></a> Tools and technologies
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="75" alt="IDEA" src="readme/icons/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="75" alt="JAVA" src="readme/icons/Java.svg"></a>
<a href="https://github.com/"><img width="75" alt="Github" src="readme/icons/GitHub.svg"></a>
<a href="https://junit.org/junit5/"><img width="75" alt="JUnit5" src="readme/icons/JUnit5.svg"></a>
<a href="https://gradle.org/"><img width="75" alt="Gradle" src="readme/icons/Gradle.svg"></a>
<a href="https://selenide.org/"><img width="75" alt="Selenide" src="readme/icons/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="75" alt="Selenoid" src="readme/icons/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="75" alt="Allure" src="readme/icons/Allure.svg"></a>
<a href="https://qameta.io"><img width="55" alt="TestOps" src="readme/icons/TestOpspng.png"></a>
<a href="https://www.jenkins.io/"><img width="75" alt="Jenkins" src="readme/icons/Jenkins.svg"></a>
<a href="https://telegram.org/"><img width="75" alt="Telegram" src="readme/icons/Telegram.svg"></a>
</p>


## <a id="cases"></a> Tests
<a id="cases-ui"></a>UI cases:

:heavy_check_mark: Successful sign in

:heavy_check_mark: Unsuccessful sign in

:heavy_check_mark: Observe QR code to download the app  

:heavy_check_mark: Observe button for contributors Skill Pool form  

:heavy_check_mark: Observe search form link on the 'Discover' page 

:heavy_check_mark: Displaying of 'Nutella' results after successful search 

:heavy_check_mark: Observe displaying of the banner 'Poor match 31%'  
  
<a id="cases-api"></a>API cases:
  
:heavy_check_mark: Get information about sugars for the particular product 

:heavy_check_mark: Information about allergens is not shown in case of invalid product id

:heavy_check_mark: Get product name for a particular product id

:heavy_check_mark: Information about product is not shown in case of invalid product id 

:heavy_check_mark: A new product is successfully added 

:heavy_check_mark: A new product is not added  

:heavy_check_mark: Photo is successfully cropped  

<a href="#list">Content</a>

## 	<a id="integrations"></a> Integrations
:heavy_check_mark: Launch tests in Jenkins  

:heavy_check_mark: Allure Report + SelenideLogger.addListener + step()   

:heavy_check_mark: Notifications in Telegram 

:heavy_check_mark: Allure TestOps    

:heavy_check_mark: Selenoid   

:heavy_check_mark: Owner   

<a href="#list">Content</a>

## <a id="console"></a> Launch via terminal
  
### <a id="console-ui"></a>Launch UI tests locally

```
gradle clean uiAuto_test
```

### <a id="console-api"></a>Launch API tests locally

```
gradle clean apiAuto_test
```
  
### Launch tests via Jenkins

```
clean
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dremote=${REMOTE}
-Denv=${ENV}
uiAuto_test
```

```
clean apiAuto_test "-Dname=${NAME}"
```


<a href="#list">Content</a>

## <a id="jenkins"></a> Job for UI tests in [Jenkins](https://jenkins.autotests.cloud/job/021-marinka_k-projectUITests/)

<img alt="Jenkins_screenshot_ui" src="readme/screenshots/Jenkins_ui.png">

## <a id="jenkins"></a> Job for API tests in [Jenkins](https://jenkins.autotests.cloud/job/020-marinka_k-apiFinalProject/)

<img alt="Jenkins_screenshot_api" src="readme/screenshots/Jenkins_api.png">

<a href="#list">Content</a>

:information_source: Allure Reports

<img alt="AllureReport_screenshot" src="readme/screenshots/AllureReportUI.png">

## <a id="allure"></a> [Allure](https://jenkins.autotests.cloud/job/021-marinka_k-projectUITests/20/allure/) UI reports

<img alt="AllureReportTest_screenshot" src="readme/screenshots/AllureReportUI.png">

## <a id="allure"></a> [Allure](https://jenkins.autotests.cloud/job/020-marinka_k-apiFinalProject/25/allure/) API reports


<a href="#list">Content</a>

## <a id="telegram"></a>Telegram reports

:information_source: Тelegram notifications

<img alt="Telegram_screenshot" src="readme/screenshots/Telegram.jpeg">

<a href="#list">Content</a>

## <a id="testops"> Integration with [Allure TestOps](https://allure.autotests.cloud/project/3840/test-cases/27753?treeId=0)
  
<img alt="AllureTestOpsLaunches_screenshot" src="readme/screenshots/AllureTestOps.png">
