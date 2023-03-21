package com.example.springboot3.user.entity

import com.example.springboot3.user.User
import com.example.springboot3.user.params.UserParam
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.mongodb.core.mapping.Document

@Entity
@Table(name = "user")
class JpaUser private constructor(
    override var name: String,
    override var email: String,
    override var password: String
) : User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null

    companion object {
        fun create(userParam: UserParam): JpaUser {
            return JpaUser(
                name = userParam.name,
                email = userParam.email,
                password = userParam.password
            )
        }
    }
}
