@login @Regression @suma 
Feature: Website Login
As a Registered user
In order to login
I want to sign in with valid credentials

Scenario Outline: Accessing secured Login page 
	Given I navigate to John Lewis home page on "<Browsers>"
	And I click on the Sign In link 
	Then I should see Sign in overlay 
	When I type my valid email address as "<Username>"
	And I type my valid password as "<Password>"
	And I click on Sign In button
	Then I should get "<Expected_Result>"
	
	Examples:
	
| Browsers 	| Username              | Password  | Expected_Result    |
| Chrome 	| sumanilv09@gmail.com  |Chinna13	|Success		     |
#| Chrome 	| riav4562001@gmail.com |suma		|Failure			 |
#| Firefox 	| sumanilv09@gmail.com  | Chinna13	|Success		     |
#| Firefox	| 3435szfzfdg			|suma		|Failure			 |
