package com.example.springboot3.user.support

import com.example.springboot3.user.User
import com.example.springboot3.user.entity.JpaUser
import org.springframework.data.jpa.repository.JpaRepository

interface IUserJpaRepository : JpaRepository<JpaUser, Long> {
    fun findByEmail(email: String): User?
}
