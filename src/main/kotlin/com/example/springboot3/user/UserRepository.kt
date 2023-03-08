package com.example.springboot3.user

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface UserRepository {
    //    fun findById(id: String): User?
    fun findByEmail(email: String): User?
    fun findAll(): List<User>
    fun save(user: User): User
}

interface IUserRepository {
    //    fun findById(id: String): User?
    fun findByEmail(email: String): IUser?
    fun findAll(): List<IUser>
    fun save(user: IUser): IUser
}

@Repository
interface MongoUserRepository : UserRepository, MongoRepository<MongoDbUser, String> {
    //    override fun findById(id: String): MongoDbUser?
    override fun findByEmail(email: String): MongoDbUser?
    override fun save(user: User): MongoDbUser
}

@Repository
interface MongoUserIRepository : IUserRepository, MongoRepository<MongoDbUserI, String> {
    override fun findByEmail(email: String): MongoDbUserI?
    override fun save(user: IUser): MongoDbUserI
}


//
//@Repository
//interface MongoReactiveUserRepository : ReactiveMongoRepository<MongoDbUser, String> {
//    fun findByEmail(email: String): Mono<MongoDbUser?>
//}