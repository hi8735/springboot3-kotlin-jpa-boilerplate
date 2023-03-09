package com.example.springboot3.user

import com.example.springboot3.user.params.UserParam
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jpa/users")
class UserJPAController(
    private val userJpaService: UserService,
) {
    @GetMapping
    fun getUsers(
        @Parameter(description = "검색조건")
        @ModelAttribute condition: UserSearchCondition,
        @PageableDefault(size = 50, sort = ["id"], direction = Sort.Direction.DESC) page: Pageable,
    ): Page<User> {
        return userJpaService.findUsers(condition, page)
    }

    @GetMapping("/email")
    fun getUserByEmail(@RequestParam email: String): User? {
        return userJpaService.findUserByEmail(email)
    }

    @PostMapping
    fun createUser(@RequestBody user: UserParam): User {
        return userJpaService.createUser(user)
    }
}

data class UserSearchCondition(
    val name: String? = null,
    val email: String? = null,
)