package io.hndrs.artifacts.module.user.registration

import com.auth0.client.mgmt.ManagementAPI
import com.auth0.json.mgmt.users.User
import io.hndrs.artifacts.module.user.UserRepository
import org.springframework.stereotype.Service

@Service
class RegistrationService(
    private val userRepository: UserRepository,
    private val managementAPI: ManagementAPI
) {
    fun register(request: RegistrationRequest) {
        userRepository.save(
            io.hndrs.artifacts.module.user.User(
                email = request.email,
                name = request.name
            )
        ).let {
            val user = User("Username-Password-Authentication")
            user.id = it.id
            user.email = it.email
            user.name = it.name
            user.setPassword(request.password.toCharArray())
            managementAPI.users().create(user).execute()
        }
    }
}
