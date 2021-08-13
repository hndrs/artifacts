package io.hndrs.artifacts.module.artifacts

import io.hndrs.api.response.JsonApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArtifactsController {

    @GetMapping("/artifacts")
    @JsonApiResponse
    fun artifacts() {
    }
}
