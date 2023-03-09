package com.example.springboot3.user.support

import com.example.springboot3.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : UserRepository, JpaRepository<User, Long> {
}

interface UserJpaRepositoryCustom {

}

class UserJpaRepositoryImpl : UserJpaRepositoryCustom {

}