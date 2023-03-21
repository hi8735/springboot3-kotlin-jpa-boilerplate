package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import com.example.springboot3.user.support.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

interface UserService {
    fun findUsers(condition: UserSearchCondition, page: Pageable): Page<User>
    fun findUserByEmail(email: String): User?
    fun createUser(user: UserParam): User
}

