package com.example.springboot3.user.support

import com.example.springboot3.user.User
import com.example.springboot3.user.entity.JpaUser
import org.springframework.stereotype.Repository

@Repository
class UserJpaRepository(
    private val repository: IUserJpaRepository
) : UserRepository {
    override fun findByEmail(email: String): User? {
        return repository.findByEmail(email)
    }

    override fun findAll(): List<User> {
        return repository.findAll()
    }

    override fun save(user: User): User {
        return repository.save(user as JpaUser)
    }
}
