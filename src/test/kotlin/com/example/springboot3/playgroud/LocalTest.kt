package com.example.springboot3.playgroud

import com.example.springboot3.user.MongoDbUserRepository
import com.example.springboot3.user.MongoDbUserRepository2
import com.example.springboot3.user.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
class LocalTest {

//    @Autowired
//    lateinit var mongoDbUserRepository2: MongoDbUserRepository2

    @Test
    fun test() {
//        val users = mongoDbUserRepository2.findByEmail("hi8735@gmail.com")
//        println(users)
    }

}