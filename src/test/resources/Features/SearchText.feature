#Author : Madhu Bala
#Desciption : User enters into AlphaSense webpage and search for AlphaSense and verifies text highlighted in doc viewer by clicking last found results

Feature: Search String in AlphaSense webpage
 
Scenario: Search string in webpage
  Given user enter into the application site
  When user search for "AlphaSense" in Additional Keyword tab
  And click on link for last found results
  Then user verfies statement highlighted in doc viewer

  