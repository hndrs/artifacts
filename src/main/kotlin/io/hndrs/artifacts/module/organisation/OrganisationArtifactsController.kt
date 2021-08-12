package io.hndrs.artifacts.module.organisation

import io.hndrs.api.response.JsonApiResponse
import io.swagger.annotations.ApiImplicitParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class OrganisationArtifactsController {

    @ApiImplicitParam(
        name = "Authorization",
        value = "Id Token",
        required = true,
        allowEmptyValue = false,
        paramType = "header",
        dataTypeClass = String::class,
        example = "Bearer id_token"
    )
    @GetMapping("/organisations/{orgainsation_id}/artifacts")
    @JsonApiResponse
    fun organisationArtifacts(@PathVariable("orgainsation_id") organisationId: String) {
    }

}
