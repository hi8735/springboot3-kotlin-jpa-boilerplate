package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userMongoDBService: UserService,
    private val userJpaService: UserService,
) {

//    @GetMapping
//    fun getUsers(): List<User> {
//        return userService.findAllUsers()
//    }

//    @GetMapping("/{id}")
//    fun getUserById(@PathVariable id: String): User? {
//        return userService.findUserById(id)
//    }

    @GetMapping("/email")
    fun getUserByEmail(@RequestParam email: String): User? {
        return userMongoDBService.findUserByEmail(email)
    }

    @PostMapping
    fun createUser(@RequestBody user: UserParam): User {
        return userMongoDBService.createUser(user)
    }

//    @PutMapping("/{id}")
//    fun updateUserById(@PathVariable id: String, @RequestBody user: User): User? {
//        return userService.updateUserById(id, user)
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteUserById(@PathVariable id: String) {
//        userService.deleteUserById(id)
//    }
}
