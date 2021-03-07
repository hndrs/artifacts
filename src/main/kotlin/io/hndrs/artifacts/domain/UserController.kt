package io.hndrs.artifacts.domain

import io.hndrs.api.response.JsonApiResponse
import io.hndrs.artifacts.shared.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {


    @GetMapping("/user")
    @JsonApiResponse
    fun user(): User {
        return User("id")
    }

}
