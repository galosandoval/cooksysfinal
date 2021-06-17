
# **Company Endpoints**
___

1. Companies
    * Get All Companies
    * Get Company by Company name
    * Create Company
    * Update Company Description

___
### **GET Path: '/company'**
GET All companies (returns all companies)
</br>
Returns Json:
```json
[
    {
        "companyName": "Krusty Krab",
        "companyDescription": "The squeaking of the horrible boots!",
        "teams": [
            {
                "teamName": "Kitchen Staff",
                "teamDescription": "How the Sausage is made.",
                "isDeleted": false,
                "teamMembers": [
                    {
                        "userName": "The Quickster",
                        "firstName": "Spongebob",
                        "lastName": "Squarepants",
                        "isDeleted": false,
                        "userRole": {
                            "roleTitle": "Member"
                        },
                        "newUser": false
                    }
                ]
            },
            {
                "teamName": "Service Staff",
                "teamDescription": "Customer Service",
                "isDeleted": false,
                "teamMembers": [
                    {
                        "userName": "Captain Magma",
                        "firstName": "Squidward",
                        "lastName": "Tentacles",
                        "isDeleted": false,
                        "userRole": {
                            "roleTitle": "Member"
                        },
                        "newUser": false
                    }
                ]
            }
        ],
        "users": [
            {
                "userName": "JP Lobster",
                "firstName": "Mr.",
                "lastName": "Krabbs",
                "isDeleted": false,
                "userRole": {
                    "roleTitle": "Company"
                },
                "newUser": false,
                "associatedTeam": null
            },
            {
                "userName": "GD",
                "firstName": "Pearl",
                "lastName": "Whale",
                "isDeleted": true,
                "userRole": {
                    "roleTitle": "Company"
                },
                "newUser": false,
                "associatedTeam": null
            }
        ]
    },...
]
```

### **GET Path: '/company/{companyName}'**
GET company by company name
</br>
Returns Json:
```json
{
    "companyName": "Krusty Krab",
    "companyDescription": "The squeaking of the horrible boots!",
    "teams": [
        {
            "teamName": "Kitchen Staff",
            "teamDescription": "How the Sausage is made.",
            "isDeleted": false,
            "teamMembers": [
                {
                    "userName": "The Quickster",
                    "firstName": "Spongebob",
                    "lastName": "Squarepants",
                    "isDeleted": false,
                    "userRole": {
                        "roleTitle": "Member"
                    },
                    "newUser": false
                }
            ]
        },
        {
            "teamName": "Service Staff",
            "teamDescription": "Customer Service",
            "isDeleted": false,
            "teamMembers": [
                {
                    "userName": "Captain Magma",
                    "firstName": "Squidward",
                    "lastName": "Tentacles",
                    "isDeleted": false,
                    "userRole": {
                        "roleTitle": "Member"
                    },
                    "newUser": false
                }
            ]
        }
    ],
    "users": [
        {
            "userName": "JP Lobster",
            "firstName": "Mr.",
            "lastName": "Krabbs",
            "isDeleted": false,
            "userRole": {
                "roleTitle": "Company"
            },
            "newUser": false,
            "associatedTeam": null
        },
        {
            "userName": "GD",
            "firstName": "Pearl",
            "lastName": "Whale",
            "isDeleted": true,
            "userRole": {
                "roleTitle": "Company"
            },
            "newUser": false,
            "associatedTeam": null
        }
    ]
}
```

### **POST Path: '/company'**
POST company
Request Json:
```json
{
    "seedCompany":{
        "companyName":"Umbrella Corp",
        "companyDescription":"Zombies"
    },
    "seedUser":{
        "userName":"Head Guy",
        "password":"Scientist"
    }
}
```
Returns Json:
```json
{
    "companyName": "Umbrella Corp",
    "companyDescription": "Zombies",
    "teams": [],
    "users": [
        {
            "userName": "Head Guy",
            "firstName": null,
            "lastName": null,
            "isDeleted": false,
            "userRole": {
                "roleTitle": "Company"
            },
            "newUser": false,
            "associatedTeam": null
        }
    ]
}
```
### **PUT Path: '/company/{companyName}'**
PUT company (edit company name and/or description)
Request Json:
```json
{
    "credentials":{
        "userName":"JP Lobster",
        "password":"Money"
    },
    "newCompany":{
        "companyName":"Red Lobster",
        "companyDescription":"Seafood"
    }
}
```
Returns Json:
```json
{
    "companyName": "Red Lobster",
    "companyDescription": "Seafood",
    "teams": [
        {
            "teamName": "Kitchen Staff",
            "teamDescription": "How the Sausage is made.",
            "isDeleted": false,
            "teamMembers": [
                {
                    "userName": "The Quickster",
                    "firstName": "Spongebob",
                    "lastName": "Squarepants",
                    "isDeleted": false,
                    "userRole": {
                        "roleTitle": "Member"
                    },
                    "newUser": false
                }
            ]
        },
        {
            "teamName": "Service Staff",
            "teamDescription": "Customer Service",
            "isDeleted": false,
            "teamMembers": [
                {
                    "userName": "Captain Magma",
                    "firstName": "Squidward",
                    "lastName": "Tentacles",
                    "isDeleted": false,
                    "userRole": {
                        "roleTitle": "Member"
                    },
                    "newUser": false
                }
            ]
        }
    ],
    "users": [
        {
            "userName": "JP Lobster",
            "firstName": "Mr.",
            "lastName": "Krabbs",
            "isDeleted": false,
            "userRole": {
                "roleTitle": "Company"
            },
            "newUser": false,
            "associatedTeam": null
        },
        {
            "userName": "GD",
            "firstName": "Pearl",
            "lastName": "Whale",
            "isDeleted": true,
            "userRole": {
                "roleTitle": "Company"
            },
            "newUser": false,
            "associatedTeam": null
        }
    ]
}
```