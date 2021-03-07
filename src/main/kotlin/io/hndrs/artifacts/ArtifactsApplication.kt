package io.hndrs.artifacts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ArtifactsApplication


fun main(args: Array<String>) {
    runApplication<ArtifactsApplication>(*args)
}
