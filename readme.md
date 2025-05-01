# Email Sending Application

This project is a Spring Boot-based application that allows sending emails with or without attachments through a user interface.
It uses Java Mail Sender for email functionality and provides a simple web interface for users to input the necessary information.

## Features

- Sending simple emails or emails with attachments.
- User interface to input required information (recipient, subject, message) and attach a file.
- Error handling and user feedback.

## Technologies Used

### Backend
- **Language**: Java
- **Framework**: Spring Boot
- **Library**: Java Mail Sender
- **Dependency Manager**: Maven

### Frontend
- **Languages**: HTML, CSS (with Tailwind CSS), JavaScript

### SMTP Server
- **Configuration**: Gmail (or any other compatible SMTP server)

## Video Demonstration


## Installation and Execution

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mamyDinyah34/SMTP_SpringBoot.git
   cd SMTP_SpringBoot
    ```
   
2. **Configure the `application.properties` file**:  
Add the necessary SMTP settings in the `src/main/resources/application.properties` file:  
   ```properties
   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=<YOUR_EMAIL>
   spring.mail.password=<YOUR_PASSWORD>
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true
   spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
    ```
3. **Build and run the application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access the application**:  
Open your browser and go to `http://localhost:8080`.

## Usage
1. **Enter the information**: Fill out the form with the recipient's email address, subject, and message.
2. **Add an attachment**: If necessary, select a file to attach.
3. **Send the email**: Click the "Send" button to send the email.
4. **Check the status**: A confirmation or error message will be displayed depending on the result of the sending.

