Feature:Validate the login page
Background:
Given User opens the application

Scenario: Validate if user is able to login with valid credentials
Given user clicks on login button
And enters valid username and password
And clicks on login button
Then login page loads successfully


