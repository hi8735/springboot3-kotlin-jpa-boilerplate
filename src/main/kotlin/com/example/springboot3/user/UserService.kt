package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import org.springframework.stereotype.Service

interface UserService {
    fun findUserByEmail(email: String): User?
    fun createUser(user: UserParam): User
}

@Service
class MongoDBUserService(
    private val userRepository: UserRepository,
    private val iUserRepository: IUserRepository
): UserService {
    override fun findUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun findUserByEmail2(email: String): IUser? {
        return iUserRepository.findByEmail(email)
    }

    override fun createUser(user: UserParam): User {
        return userRepository.save(MongoDbUser.create(user))
    }

//    fun createUser2(user: UserParam): IUser {
//        return iUserRepository.save(MongoDbUserI.create(user))
//    }
//
//    fun updateUserById(id: String, updatedUser: User): User? {
//        val existingUser = findUserById(id) ?: return null
//        existingUser.name = updatedUser.name
//        existingUser.email = updatedUser.email
//        existingUser.password = updatedUser.password
//        return userRepository.save(existingUser)
//    }
//
//    fun deleteUserById(id: String) {
//        userRepository.deleteById(id)
//    }
}

@Service
class JpaUserService(
    private val jpaUserRepository: UserRepository
): UserService {
    override fun findUserByEmail(email: String): User? {
        TODO("Not yet implemented")
    }

    override fun createUser(user: UserParam): User {
        TODO("Not yet implemented")
    }

}