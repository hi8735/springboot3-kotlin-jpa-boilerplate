package com.example.springboot3.user.support

import com.example.springboot3.user.entity.MongoUser
import com.example.springboot3.user.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMongoRepository : UserRepository, MongoRepository<MongoUser, String> {
    override fun findByEmail(email: String): MongoUser?
    override fun save(user: User): MongoUser
}
