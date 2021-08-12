package io.hndrs.artifacts.module.user.registration

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistrationController(private val registrationService: RegistrationService) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegistrationRequest) {
        registrationService.register(request)
    }
}

data class RegistrationRequest(

    @param:JsonProperty("email")
    val email: String,

    @param:JsonProperty("password")
    val password: String,

    @param:JsonProperty("name")
    val name: String? = null
)

