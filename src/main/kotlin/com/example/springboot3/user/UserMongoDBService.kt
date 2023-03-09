package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import com.example.springboot3.user.support.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserMongoDBService(
    private val userMongoRepository: UserRepository
) : UserService {
    override fun findUsers(condition: UserSearchCondition, page: Pageable): Page<User> {
        TODO("Not yet implemented")
    }

    override fun findUserByEmail(email: String): User? {
        return userMongoRepository.findByEmail(email)
    }

    override fun createUser(user: UserParam): User {
        return userMongoRepository.save(MongoDbUser.create(user))
    }
}