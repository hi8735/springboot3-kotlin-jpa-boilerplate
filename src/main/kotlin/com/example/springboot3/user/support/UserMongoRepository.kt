package com.example.springboot3.user.support

import com.example.springboot3.user.MongoDbUser
import com.example.springboot3.user.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMongoRepository : UserRepository, MongoRepository<MongoDbUser, String> {
    override fun findByEmail(email: String): MongoDbUser?
    override fun save(user: User): MongoDbUser
}