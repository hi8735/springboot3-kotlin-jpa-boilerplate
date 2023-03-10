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

@Service
class UserJpaService(
    private val userJPARepository: UserRepository
) : UserService {
    override fun findUsers(condition: UserSearchCondition, page: Pageable): Page<User> {
        TODO("Not yet implemented")
    }

    override fun findUserByEmail(email: String): User? {
        TODO("Not yet implemented")
    }

    override fun createUser(user: UserParam): User {
        TODO("Not yet implemented")
    }
}