Feature: Contact Us in the application

Scenario: Validating Contact Us Form
	
	And The user clicks on the contact Us option in the homepage
	Then 'GET IN TOUCH' should be visible in contact us page
	And The user enters the name as 'Lara Fischer' and email id as 'lara.fischer@proton.com'
	And The user enters subject as 'Alert: Technical Difficulties on Our Website' and message as 'We regret to inform you that our website is currently experiencing technical difficulties'
	And The user uploads the file
	And The user clicks on submit button
	Then A simple pop-up will appear and click on ok
	And 'Success! Your details have been submitted successfully.' message should be visible after submitting
	And The user clicks on Home button
	Then The user will land on the homepage
	

