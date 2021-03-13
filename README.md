# CRUD-Project-Back-End

This is the README for my first project at QA Academy as part of the National Security Academy cohort 11. It is a CRUD (Create, Read, Update, Delete) Application that incorporates Full stack development, HTML/CSS web design and Database management through the use of MySQL.

This README will outline the project, the idea and any important development documentation to go alongside the project.

# UkHS Vaccine tracker

# Contents 

1. Resources
2. Brief
3. Project management (Jira)
4. Database Structure
5. Data Stack
6. Testing
7. Front-End
8. Future goals

# 1. Resources

- [Jira Board](https://qatestsite2.atlassian.net/secure/RapidBoard.jspa?rapidView=4&projectKey=PROJ&view=reporting&chart=sprintRetrospective&sprint=4)
- [Front-End Git Repo](https://github.com/SeanLeonard4/QAProject-FrontEnd)


# 2. Brief

The premise of the project is to incorporate all of the methodologies and technologies learnt throughout the training thus far to produce a CRUD application. This project will involve concepts from all core training modules; more specifically, this will involve:

- Project Management
- Databases
- Java SE
- Spring Boot
- Front-End Development
- Automated Testing

# The plan

In order to achieve this functionality I have decided to produce a simple Ship Manifest database to implement with CRUD functionality. This Ship manifest will allow the user to do the following:

To achieve this I have decided to create a topical CRUD application to record a COVID-19 vaccine tracker. This vaccine tracker would allow staff members to do the following:

- Create Records with automated dates of the first jab (at the time of creation) and the secong jab (12 weeks ahead) in the database.
- Read the records from the database.
- Update existing records in the database (maintaining original first and second jab dates as well as any data not wanted to be updated i.e if you're only updating age the name remains the same)
- Delete any records from the database.

# 3. Project management

For the project management component I utilised Jira software and modelled it as an Agile scrum board. The Jira board utilises agile sprint methodologies to complete the various user stories as created at the beginning of the project. Below is an example of a User-story.

![User_story](https://user-images.githubusercontent.com/78798264/111034714-d3a2c300-840e-11eb-96e3-0319d25f73f4.jpg)

This project comprised of four varying lengths of sprints. I attempted to reduce dependencies within the same sprin. Thus I ensured that the read, update and delete were in an alternate sprint to the create patient method and the DB/repo setup.

# First sprint

![Sprint1](https://user-images.githubusercontent.com/78798264/111034835-4e6bde00-840f-11eb-87cf-bbe34caad290.jpg)

# Second sprint

![Sprint2](https://user-images.githubusercontent.com/78798264/111034840-5461bf00-840f-11eb-96ea-946035c57c38.jpg)

# Third sprint

![Sprint3](https://user-images.githubusercontent.com/78798264/111034850-5c216380-840f-11eb-8a96-54a9896dce95.jpg)

# Fourth sprint

![Sprint4](https://user-images.githubusercontent.com/78798264/111034857-68a5bc00-840f-11eb-85b0-cfbdc51348c4.jpg)

The fourth and final sprint contained only selenium testing as this was dependant upon the entire frontend and backend working seamlessly together.

# 4. Database structure

Below is an entity relationship diagram (ERD) for my project. As you can see the ID field is flashed yellow to represent that it is the primary key.

![ERD](https://user-images.githubusercontent.com/78798264/111035603-20889880-8413-11eb-9295-ef9f6cd3ad64.png)

# 5. Data Stack

# Database

The database for this project is a relational MySQL database. MySQL is an effective database as it stores data in files on your local system automatically ensuring that data isn't lost after each re-run. It is also effective, widely-used and works across platform and for multiple programming languages. This ensures that the webpage remains resilient and easily adaptable if it were to be moved to a remote server for professioonal use.

# Back-End

The back-end has been completed using Java and the Spring Boot Framework. Spring boot is effective as it reduces overall deployment time and allows a default setup for unit and 
integration tests which works to improve efficiency through Spring's dependency injection approach. The back-end contains the database logic as well as the HTTP requests which 
allows the front-end to access via HTTP requests written in JavaScript to work with the data there and present it on the webpage.

# Front-End

The front-end has been written in HTML, CSS and Javascript. Whilst utilising Bootstrap to ensure a smoother and more aesthetically pleasing design. The HTML and CSS were used to 
design and format the webpage whilst the Javascript utilised various HTTP requests to get create, read, update and delete data from the back-end. Whilst also rendering the 

formatted table with the DB data.

# 6. Testing

My total test coverage was 82.4% 

![Coverage](https://user-images.githubusercontent.com/78798264/111035653-5168cd80-8413-11eb-87cb-887a343ccae7.jpg)

The testing for the backend was achieved through MockMVC integration testing and Mockito Unit testing. The unit tests work by creating a mock repo (this isn't accessible) to 
test whether each method works by itself. Thus, the unit tests are ideal to be completed first as it can ensure that the methodology at its barest works fine. The integration 
tests on the other hand allow us to see if the HTTP endpoints in our application work with various HTTP erquests. In this instance the controller is mocked to test the outcomes 
of sending data to each HTTP endpoint against the expected outcomes. This ensures that the application works as a whole and not just on a singular class methodology level.

Automated testing was achieve via Selenium. This is a collection of tools and libraries allowing the automation of web browsers. Due to the complexities of WebDrivers Selenium 
works to provide a single interface through which we interact (this interface acts as a facade to the complex WebDriver and hides any unneccesary implementation detail) to 
ensure that accurate and efficient automated testing can be achieved. Through Selenium I tested the  webpages CRUD functionality. This is important as the user would interact 
with the webpage directly and not the back-end or front-end code. Thus, any errors here would be detrimental to the usage of the webpage.

# 7. Front-End

Below is a screenshot of the final front-end webpage design

![Front-EndPage](https://user-images.githubusercontent.com/78798264/111037581-9b09e600-841c-11eb-9206-65096edea02d.png)

The front-end takes inspiration from the NHS website. I have attempted a simple and clean professional looking design. It is practical and easy to understand and thus staff at 
the UkNS would have no difficulty inputting recently vaccinated patients into their database. The webpage ensures the current date is taken as well as 12 weeks in advance. This 
remains practical to maintain second-vaccine priorities.

![Front-EndModal](https://user-images.githubusercontent.com/78798264/111036807-12d61180-8419-11eb-9062-06f63cf577ce.png)

The modal as pictured above ensures patients records can be adequately updated whilst maintaining the simple clean design look of the webpage. The update button for the modal 
are rendered next to the patient to ensure the correct patient is updated. This is the same for delete and works to enhance the webpages practicality and ease of use.

# 8. Future Improvements

- Enhance the usability of the webpage in relation to the second vaccine date - By allowing an option to filter the table by date.
- Automated emailing system - Which ensures that the patients are reminded at least one week in advance of their second vaccine as well as one day prior.
- Provide more site functionality such as areas of access through the navbar.
- Tweak the design to reduce the amount of white space.
