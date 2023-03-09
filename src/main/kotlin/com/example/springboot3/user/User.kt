package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import org.springframework.data.mongodb.core.mapping.Document

abstract class User(
    var name: String,
    var email: String,
    var password: String
) {
    var id: String? = null
}

@Document(collection = "users")
class MongoDbUser(
    name: String,
    email: String,
    password: String
) : User(name = name, email = email, password = password){
    companion object {
        fun create(userParam: UserParam): MongoDbUser {
            return MongoDbUser(
                name = userParam.name,
                email = userParam.email,
                password = userParam.password
            )
        }
    }
}