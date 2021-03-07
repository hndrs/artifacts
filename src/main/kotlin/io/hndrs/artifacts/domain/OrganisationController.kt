package io.hndrs.artifacts.domain

import io.hndrs.api.response.JsonApiResponse
import io.hndrs.artifacts.shared.Organisation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrganisationController {


    @GetMapping("/organisations")
    @JsonApiResponse
    fun organisations(): List<Organisation> {
        return listOf(Organisation("1"))
    }

}
