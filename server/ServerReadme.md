
# **Server Endpoint Setup**

### This file contains information on how to interact with the endpoints created by the backend team. 
___

## Endpoints

1. Company
    * Get All Companies
    * Get Company by Company name
    * Create Company
    * Update Company Description
2. Users
    * Get User by User Name
    * Create User
    * Update User
    * Assign User a Project
    * Assign User a Company
    * Delete User
3. Teams
    * Get All Teams
    * Get Team by Team Name
    * Create Team
    * Update Team
    * Delete Team
4. Projects
    * Get All Projects
    * Get Project by Id
    * Get Project by Name
    * Get Project By Team
    * Create Project
    * Update Project Name
    * Update Project Description
    * Update Project Users
    * Update Project Team
    * Delete Project

___

#   **End Point Implenmentation**

### **Company Endpoints**

End Point | Html and json
------------ | -------------
Get All Companies | GET </br>``` /company ```
Get Company by Company name | GET </br>``` /company/{comapny name} ```</br> example</br> ```  /company/Krusty Krab ```
Create Company | POST </br>``` /company/{comapny name} ```</br> Json code required </br>```{"companyName": "Company name", ``` </br> ```"companyDescription": "Company Description"}  ```
Update Company Description | PUT </br>``` /company/{comapny name} ```</br> Json code required </br> ```"companyDescription": "Company Description."}  ```

### **User Endpoints**

End Point | Html and json
------------ | -------------
Get User by User Name | GET </br>``` /user/{user name} ```</br> example</br> ```  /user/Loki ```
Create User | POST </br>``` /user ```</br> Json code required </br>```{"userName": "user name", ``` </br> ```"firstName": "first name",``` </br> ``` "lastName": "last name",``` </br> ```"password": "password",``` </br> ```"roleTitle": "user role"}  ```
Update User | Patch </br>``` /user/{user name} ```</br> Json code required </br> ``` {"credentials":{  ``` </br>```"userName": "input user name", ``` </br> ```"password": "input password",}  ``` </br>```"userName": "user name", ``` </br> ```"firstName": "first name",``` </br> ```"lastName": "last name",``` </br> ```"password": "password",}  ```
Assign User a Project | Patch </br>``` /user/{user name}/project ```</br> Json code required </br> ``` {"credentials":{  ``` </br>```"userName": "user name", ``` </br> ```"password": "password",}  ``` </br>```"projectName":"Count Paper"}  ```
Assign User a Company | Patch </br>``` /user/{user name}/company ```</br> Json code required </br> ``` {"credentials":{  ``` </br>```"userName": "user name", ``` </br> ```"password": "password",}  ``` </br>```"companyName":"Krusty Krab"}  ```
Delete User | Delete </br>``` /user/{user name} ```</br> Json code required </br> ``` {"userName": "user name", ``` </br> ```"password": "password",}  ```

### **Teams Endpoints**

End Point | Html and json
------------ | -------------
Get All Teams | GET </br> ``` /team ``` 
Get Team by Team Name | GET </br> ``` /team/{teamName} ```</br> example</br> ```  /team/Sales ```
Create Team | POST </br> ``` /team/create ```</br> Json code required </br> ```{"teamName": "Team Name", ``` </br> ```"teamDescription": "Team Description"}  ```
Update Team | PATCH </br> ``` /team/update/{teamName} ```</br> Json code required </br> ```{"teamName": "Team Name", ``` </br> ```"teamDescription": "Team Description"}  ```
Delete Team | DELETE </br> ``` /team/delete/{teamName} ```</br> example</br> ```  /team/delete/Sales ```


### **Projects Endpoints**

End Point | Html and json
------------ | -------------
Get All Projects |  GET </br> ``` /project ```
Get Project by Id | GET </br> ``` /project/{id} ```
Get Project by Name | GET </br> ``` /project/{projectName} ```
Get Project By Team | GET </br> ``` /project/{projectTeam} ```
Create Project | POST </br>``` /project ```</br> Json code required </br>```{"name": "project name", ``` </br> ```"description": "project description"}```
Update Project Name | PUT </br>``` /project ```</br> Json code required </br>```{"name": "updated project name",}  ```
Update Project Description | PUT </br>``` /project ```</br> Json code required </br>```{"description": "update project description"}  ```
Update Project Users | PUT </br>``` /project ```</br> Json code required </br>```{"projectUsers": "updated project users"}  ```
Update Project Team | PUT </br>``` /project ```</br> Json code required </br>```{"projectTeam": "updated project team"}  ```
Delete Project | DELETE </br> ``` /team/{id} ```</br> example</br> ```  /team/12 ```