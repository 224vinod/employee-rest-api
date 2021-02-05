

# REST api which gives you employee data.


# Tech Stack used
Java 8,
Spring Boot 2.4.2,
Spring Data JPA,
H2 Database

## GET /employee

This api gives all employee data in JSON format

#### Sample

###### Request URI 
/employee/
###### Response 
`[
    {
        "id": 2,
        "firstName": "Balaji",
        "lastName": "Mohan",
        "designation": "Engineer"
    },
    {
        "id": 3,
        "firstName": "Chandra",
        "lastName": "Sekhar",
        "designation": "Lead"
    }
]`

## GET /employee/{id}

This api gives paticular employee data with id as {id} in JSON format

#### Sample

###### Request URI 
/employee/2
###### Response 
`{
        "id": 2,
        "firstName": "Balaji",
        "lastName": "Mohan",
        "designation": "Engineer"
  }`
  
  
## POST /employee

This api adds an employee data to the system

#### Sample

###### Request URI 
/employee
###### Request Body
`{
    "firstName": "Suman",
    "lastName": "Shankar",
    "designation": "Manager"
}`
###### Response 
`{
    "id": 7,
    "firstName": "Suman",
    "lastName": "Shankar",
    "designation": "Manager"
}`



## PUT /employee/{id}

This api updates an employee data in the system if employee with {id} available.

#### Sample

###### Request URI 
/employee/5
###### Request Body
`{
    "firstName": "Teja",
    "lastName": "K",
    "designation": "Developer"
}`
###### Response 
`{
    "id": 5,
    "firstName": "Teja",
    "lastName": "K",
    "designation": "Developer"
}`


## DELETE /employee/{id}

This api deletes an employee data in the system if employee with {id} available.

#### Sample

###### Request URI 
DELETE /employee/3
###### Request Body
` `
###### Response 
`{
    "id": 3,
    "firstName": "Chandra",
    "lastName": "Sekhar",
    "designation": "Lead"
}`

