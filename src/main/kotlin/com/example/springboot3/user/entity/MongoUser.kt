package com.example.springboot3.user.entity

import com.example.springboot3.user.User
import com.example.springboot3.user.params.UserParam
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class MongoUser private constructor(
    override var id: Long? = null,
    override var name: String,
    override var email: String,
    override var password: String,
) : User {
    companion object {
        fun create(userParam: UserParam): MongoUser {
            return MongoUser(
                name = userParam.name,
                email = userParam.email,
                password = userParam.password
            )
        }
    }
}
