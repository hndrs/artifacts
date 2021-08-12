package io.hndrs.artifacts.module.team

import io.hndrs.api.response.JsonApiResponse
import io.hndrs.jwt.Identity
import io.swagger.annotations.ApiImplicitParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamsController {

    @ApiImplicitParam(
        name = "Authorization",
        value = "Id Token",
        required = true,
        allowEmptyValue = false,
        paramType = "header",
        dataTypeClass = String::class,
        example = "Bearer id_token"
    )
    @GetMapping("/teams")
    @JsonApiResponse
    fun teams(@Identity user: Map<String, Any>) {
    }

}