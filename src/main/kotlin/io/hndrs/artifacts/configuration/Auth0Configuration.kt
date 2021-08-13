package io.hndrs.artifacts.configuration

import com.auth0.client.auth.AuthAPI
import com.auth0.client.mgmt.ManagementAPI
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(Auth0ConfigurationProperties::class)
class Auth0Configuration(private val properties: Auth0ConfigurationProperties) {

    @Bean
    fun managementApi(): ManagementAPI {
        val authAPI = AuthAPI(
            properties.domain,
            properties.clientId,
            properties.clientSecret
        )

        val accessToken = authAPI.requestToken("${properties.domain}/api/v2/").execute().accessToken

        return ManagementAPI(properties.domain, accessToken)
    }
}

@ConfigurationProperties(prefix = "artifacts.auth0")
open class Auth0ConfigurationProperties {

    lateinit var domain: String

    lateinit var clientId: String

    lateinit var clientSecret: String


}
