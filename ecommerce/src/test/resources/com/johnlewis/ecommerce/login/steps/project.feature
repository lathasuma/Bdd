@checkout @Regression
Feature: project

Scenario Outline: 
Given I navigate to John Lewis home page on "<Browsers>"
And I mouse over on Electricals tab
And I click on iPad & Tablets
Then I should get ipad-Tablets Page
And I click on iPad mini 2
Then I should get all iPad images
Then I should get all the iPad from Highest Price
And I click on highest iPad
Then I should get selected iPad detailed page
And I click on Silver color 
Then I should change the Quantity 
And I click on Add to Basket 
And I click on View basket
Then I should get basket page
And I changed the Quantity 
And I clicked on update link
And I clicked on Continue securely
Then I should get checkout Page
Then I give email address "<Username>"
And I click on Continue button
Then I should get checkout delivery details page
And I click on UK delivery link
And I give the Title
And I give the First name
And I give the Last name 
And I give the Post code
And I click on Find Address button
And I selected the address
And I click on select Address button
And I selected the standard delivery 
And I enter the mobile number
And I click on Continue to payment
Then I should get Review & Pay Page "<Expected Result>"

Examples:

| Browsers 	| SearchTextField| Username              | Password  | Expected_Result    |
| Chrome 	| John Lewis     | sumanilv09@gmail.com  | Chinna13	 | Success		      |
#| Firefox 	| John Lewis     | sumanilv09@gmail.com  | Chinna13	 | Success		      |
