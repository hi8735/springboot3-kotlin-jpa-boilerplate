package com.example.springboot3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
class Springboot3Application

fun main(args: Array<String>) {
    runApplication<Springboot3Application>(*args)
}
