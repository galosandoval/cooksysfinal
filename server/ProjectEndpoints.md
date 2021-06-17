
# **Project Endpoints**
___

1. Projects
    * Get All Projects
    * Get Project by Name
    * Create Project
    * Update Project
    * Delete Project
___

### **GET Path: '/project'**
GET All projects (returns all non deleted projects)
</br>
Returns Json:
```json
[
    {
        "name": "Prank Dwight.",
        "description": "Bears, Beets, BattleStar Galactica.",
        "company": "Dunder Mifflin",
        "user": {
            "userName": "Loki",
            "firstName": "Jim",
            "lastName": "Halpert",
            "password": "Pranks",
            "userRole": {
                "roleTitle": "Member"
            }
        },
        "team": null,
        "isDeleted": false
    },...
]
```

### **GET Path: '/project/{projectName}'**
GET project by project name
</br>
Returns Json:
```json
{
    "name": "Prank Dwight.",
    "description": "Bears, Beets, BattleStar Galactica.",
    "company": "Dunder Mifflin",
    "user": {
        "userName": "Loki",
        "firstName": "Jim",
        "lastName": "Halpert",
        "password": "Pranks",
        "userRole": {
            "roleTitle": "Member"
        }
    },
    "team": null,
    "isDeleted": false
}
```

### **POST Path: '/project'**
POST project
</br>
Request Json:
```json
{
    "credentials":{
        "userName": "JP Lobster",
        "password": "Money"
    },
    
    "project":{
        "name": "Hunt Jellyfish",
        "description": "Catch the blue whale!"
    }
}
```
Returns Json:
```json
{
    "name": "Hunt Jellyfish",
    "description": "Catch the blue whale!",
    "company": "Krusty Krab",
    "user": {
        "userName": "JP Lobster",
        "firstName": "Mr.",
        "lastName": "Krabbs",
        "password": "Money",
        "userRole": {
            "roleTitle": "Company"
        }
    },
    "team": null,
    "isDeleted": false
}
```

### **PATCH Path: '/project/{projectName}'**
PATCH project (update project info)
</br>
Request Json:
```json
{
    "credentials":{
        "userName": "JP Lobster",
        "password": "Money"
    },
    
    "project":{
        "name": "Balance the register",
        "description": "Sell some boots!"
    }
}
```
Returns Json:
```json
{
    "name": "Balance the register",
    "description": "Sell some boots!",
    "company": "Krusty Krab",
    "user": {
        "userName": "JP Lobster",
        "firstName": "Mr.",
        "lastName": "Krabbs",
        "password": "Money",
        "userRole": {
            "roleTitle": "Company"
        }
    },
    "team": null,
    "isDeleted": false
}
```

### **DELETE Path: '/project/{projectName}'**
DELETE project 
</br>
Request Json:
```json
{
    "userName":"Loki",
    "password":"Pranks"
}
```
Returns Json:
```json
{
    "name": "Prank Dwight.",
    "description": "Bears, Beets, BattleStar Galactica.",
    "company": "Dunder Mifflin",
    "user": {
        "userName": "Loki",
        "firstName": "Jim",
        "lastName": "Halpert",
        "password": "Pranks",
        "userRole": {
            "roleTitle": "Member"
        }
    },
    "team": null,
    "isDeleted": true
}
```