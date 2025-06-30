Test Cases for Requirements
Requirement R1: User can log in
TC1: Successful Login with Valid Credentials

Description: Verify that a user can log in with valid username and password.
Steps:
Navigate to the login page.
Enter valid username and password.
Click the "Login" button.


Expected Result: User is redirected to the dashboard, and a welcome message is displayed.

TC2: Login with Invalid Credentials

Description: Verify that a user cannot log in with invalid credentials.
Steps:
Navigate to the login page.
Enter an invalid username or password.
Click the "Login" button.


Expected Result: Error message "Invalid username or password" is displayed.

TC3: Login with Empty Fields

Description: Verify that a user cannot log in with empty username or password fields.
Steps:
Navigate to the login page.
Leave username and/or password fields empty.
Click the "Login" button.


Expected Result: Error message "Username and password are required" is displayed.

Requirement R2: User can reset password
TC4: Successful Password Reset with Valid Email

Description: Verify that a user can reset their password using a valid registered email.
Steps:
Navigate to the "Forgot Password" page.
Enter a valid registered email.
Click the "Reset Password" button.


Expected Result: A password reset link is sent to the user's email, and a confirmation message is displayed.

TC5: Password Reset with Unregistered Email

Description: Verify that a password reset fails for an unregistered email.
Steps:
Navigate to the "Forgot Password" page.
Enter an unregistered email.
Click the "Reset Password" button.


Expected Result: Error message "Email not found" is displayed.

Requirement R3: User can update profile
TC6: Successful Profile Update

Description: Verify that a user can update their profile information.
Steps:
Log in with valid credentials.
Navigate to the profile page.
Update fields (e.g., name, phone number).
Click the "Save" button.


Expected Result: Profile is updated, and a success message "Profile updated successfully" is displayed.

TC7: Profile Update with Invalid Data

Description: Verify that a user cannot update their profile with invalid data.
Steps:
Log in with valid credentials.
Navigate to the profile page.
Enter invalid data (e.g., invalid email format).
Click the "Save" button.


Expected Result: Error message "Invalid data provided" is displayed.
