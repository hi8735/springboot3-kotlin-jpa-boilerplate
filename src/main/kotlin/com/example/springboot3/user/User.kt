package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import org.springframework.data.mongodb.core.mapping.Document
interface User {
    var id: Long?
    var name: String
    var email: String
    var password: String
}


