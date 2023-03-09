package com.example.springboot3.user.support

import com.example.springboot3.user.User

interface UserRepository {
    fun findByEmail(email: String): User?
    fun findAll(): List<User>
    fun save(user: User): User
}