
# **User Endpoints**
___

1. Users
    * Get All Users
    * Get User by User Name
    * User Login
    * Create User
    * Update User
    * Assign User a Role
    * Assign User a Project
    * Assign User a Company
    * Assign User a Team
    * Delete User

___

## **User Endpoints**
### **GET Path: '/user'**
GET All users (returns all non deleted users)
</br>
Returns Json:
```json
[
    {
        "userName": "JP Lobster",
        "firstName": "Mr.",
        "lastName": "Krabbs",
        "associatedTeam": null,
        "isDeleted": false,
        "userCompany": {
            "companyName": "Krusty Krab",
            "companyDescription": "The squeaking of the horrible boots!"
        },
        "userRole": {
            "roleTitle": "Company"
        },
        "projects": [
            {
                "name": "Count ma money!",
                "description": "Stop the squeaking of horrible boots!"
            }
        ],
        "newUser": false
    },...
]
```

### **GET Path: '/user/{username}'**
GET user with userName = {username}
</br>
Returns Json:
```json
{
    "userName": "Loki",
    "firstName": "Jim",
    "lastName": "Halpert",
    "associatedTeam": {
        "teamName": "Sales",
        "teamDescription": "Sell products to Clients."
    },
    "isDeleted": false,
    "userCompany": {
        "companyName": "Dunder Mifflin",
        "companyDescription": "Paper and paper accessories."
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [
        {
            "name": "Prank Dwight.",
            "description": "Bears, Beets, BattleStar Galactica."
        }
    ],
    "newUser": false
}
```

### **POST Path: '/user/login'**
POST login user
</br>
Request Json:
```json
{
    "userName":"JP Lobster",
    "password":"Money"
}
```
Returns Json:
```json
{
    "userName": "JP Lobster",
    "firstName": "Mr.",
    "lastName": "Krabbs",
    "associatedTeam": null,
    "isDeleted": false,
    "userCompany": {
        "companyName": "Krusty Krab",
        "companyDescription": "The squeaking of the horrible boots!"
    },
    "userRole": {
        "roleTitle": "Company"
    },
    "projects": [
        {
            "name": "Count ma money!",
            "description": "Stop the squeaking of horrible boots!"
        },
        {
            "name": "The perfect burger.",
            "description": "Imagination!"
        },
        {
            "name": "Endure.",
            "description": "Envy SpongeBob."
        }
    ],
    "newUser": false
}
```

### **POST Path: '/user'**
POST create new user
</br>
Request Json:
```json
{
    "createUser":{
        "userName":"Breeduss",
        "firstName":"Nathan",
        "lastName":"Breedlove",
        "password":"Nada"
    },
     "companyName":"Krusty Krab"
}
```
Returns Json:
```json
{
    "userName": "Breeduss",
    "firstName": "Nathan",
    "lastName": "Breedlove",
    "associatedTeam": null,
    "isDeleted": false,
    "userCompany": {
        "companyName": "Krusty Krab",
        "companyDescription": "The squeaking of the horrible boots!"
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [],
    "newUser": true
}
```

### **PATCH Path: '/user/{username}'**
PATCH edit user
</br>
Request Json:
```json
{
     "credentials":{
         "userName":"Captain Magma",
         "password":"Clarinet"
     },
     "newData":{
        "userName" : "Squiddy",

        "firstName" : "Kraken",

        "lastName" : "Unleashed",

        "password" : "SoldierBoy"
     }
}
```
Returns Json:
```json
{
    "userName": "Squiddy",
    "firstName": "Kraken",
    "lastName": "Unleashed",
    "associatedTeam": {
        "teamName": "Service Staff",
        "teamDescription": "Customer Service"
    },
    "isDeleted": false,
    "userCompany": {
        "companyName": "Krusty Krab",
        "companyDescription": "The squeaking of the horrible boots!"
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [],
    "newUser": false
}
```

### **PATCH Path: '/user/{username}/role'**
PATCH assign user a role
</br>
Request Json:
```json
{
     "credentials":{
         "userName":"Michael Scarn",
         "password":"Friendship"
     },
     "roleName":"Member"
}
```
Returns Json:
```json
{
    "userName": "Kgurl",
    "firstName": "kelly",
    "lastName": "Whoof",
    "associatedTeam": null,
    "isDeleted": false,
    "userCompany": {
        "companyName": "Dunder Mifflin",
        "companyDescription": "Paper and paper accessories."
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [],
    "newUser": false
}
```

### **PATCH Path: '/user/{username}/project'**
PATCH assign user a project
</br>
Request Json:
```json
{
     "credentials":{
         "userName":"Michael Scarn",
         "password":"Friendship"
     },
     "projectName":"Count Paper"
}
```
Returns Json:
```json
{
    "userName": "Darth Shrewt",
    "firstName": "Dwight",
    "lastName": "Schrute",
    "associatedTeam": {
        "teamName": "Sales",
        "teamDescription": "Sell products to Clients."
    },
    "isDeleted": false,
    "userCompany": {
        "companyName": "Dunder Mifflin",
        "companyDescription": "Paper and paper accessories."
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [
        {
            "name": "Count Paper",
            "description": "At least the sales team can get away from Michael."
        }
    ],
    "newUser": false
}
```

### **PATCH Path: '/user/{username}/company'**
PATCH assign user a company
</br>
Request Json:
```json
{
     "credentials":{
         "userName":"JP Lobster",
         "password":"Money"
     },
     "companyName":"Krusty Krab"
}
```
Returns Json:
```json
{
    "userName": "The Quickster",
    "firstName": "Spongebob",
    "lastName": "Squarepants",
    "associatedTeam": {
        "teamName": "Kitchen Staff",
        "teamDescription": "How the Sausage is made."
    },
    "isDeleted": false,
    "userCompany": {
        "companyName": "Krusty Krab",
        "companyDescription": "The squeaking of the horrible boots!"
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [
        {
            "name": "Living life like GOAT.",
            "description": "Bring it around town!"
        }
    ],
    "newUser": false
}
```

### **PATCH Path: '/user/{username}/team'**
PATCH assign user a team
</br>
Request Json:
```json
{
     "credentials":{
         "userName":"Michael Scarn",
         "password":"Friendship"
     },
     "teamName":"Accounting"
}
```
Returns Json:
```json
{
    "userName": "Loki",
    "firstName": "Jim",
    "lastName": "Halpert",
    "associatedTeam": {
        "teamName": "Accounting",
        "teamDescription": "Crunch the numbers."
    },
    "isDeleted": false,
    "userCompany": {
        "companyName": "Dunder Mifflin",
        "companyDescription": "Paper and paper accessories."
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [
        {
            "name": "Prank Dwight.",
            "description": "Bears, Beets, BattleStar Galactica."
        }
    ],
    "newUser": false
}
```

### **DELETE Path: '/user/{username}'**
DELETE a user
</br>
Request Json:
```json
{	
    "userName":"Darth Shrewt",
	"password":"Beets"
}
```
Returns Json:
```json
{
    "userName": "Darth Shrewt",
    "firstName": "Dwight",
    "lastName": "Schrute",
    "associatedTeam": {
        "teamName": "Sales",
        "teamDescription": "Sell products to Clients."
    },
    "isDeleted": true,
    "userCompany": {
        "companyName": "Dunder Mifflin",
        "companyDescription": "Paper and paper accessories."
    },
    "userRole": {
        "roleTitle": "Member"
    },
    "projects": [
        {
            "name": "Count Paper",
            "description": "At least the sales team can get away from Michael."
        }
    ],
    "newUser": false
}
```