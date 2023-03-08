package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import org.springframework.data.mongodb.core.mapping.Document

abstract class User(
    var name: String,
    var email: String,
    var password: String
) {
    var id: String? = null

    constructor(userParam: UserParam) : this(userParam.name, userParam.email, userParam.password)
}

interface IUser {
    var id: String?
    var name: String
    var email: String
    var password: String
    fun create(userParam: UserParam): IUser
}

//
//@Entity
//@Table(name = "users")
//class MySqlUser(
//    name: String,
//    email: String,
//    password: String
//) : User(name = name, email = email, password = password)

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


@Document(collection = "users")
class MongoDbUserI(
    override var name: String,
    override var email: String,
    override var password: String
) : IUser {
    override var id: String? = null

    override fun create(userParam: UserParam): IUser {
        return MongoDbUserI(
            name = userParam.name,
            email = userParam.email,
            password = userParam.password
        )
    }
}
