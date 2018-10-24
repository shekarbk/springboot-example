Simple CRUD operation for PetStore

REST API's:
GET:
http://localhost:8080/pet 
</br>
POST:
http://localhost:8080/pet
{
        "id": 1,
        "name": "Lucy",
        "age": 3,
        "color": "brown"
    }
    </br>
GET:        
http://localhost:8080/pet/2
</br>
DELETE:
http://localhost:8080/pet/3
</br>
PUT:
http://localhost:8080/pet
{
        "id": 1,
        "name": "Lilly",
        "age": 3,
        "color": "white"
    }
