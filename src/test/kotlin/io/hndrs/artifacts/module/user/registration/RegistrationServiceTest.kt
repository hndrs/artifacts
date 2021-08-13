package io.hndrs.artifacts.module.user.registration

import com.auth0.client.mgmt.ManagementAPI
import com.auth0.client.mgmt.UsersEntity
import io.hndrs.artifacts.module.user.User
import io.hndrs.artifacts.module.user.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.util.*

internal class RegistrationServiceTest {


    @Test
    fun register() {
        val userRepository = mockk<UserRepository>() {
            every { save(any()) } returns User(
                id = UUID.randomUUID().toString(),
                email = "email@mail.com",
                name = "name"
            )
        }
        val usersEntity = mockk<UsersEntity>(relaxed = true) {
            every { create(any()) } returns mockk(relaxed = true) {
                every { execute() } returns mockk()
            }
        }
        val managementAPI = mockk<ManagementAPI>() {
            every { users() } returns usersEntity
        }
        RegistrationService(userRepository, managementAPI)
            .register(
                RegistrationRequest(
                    email = "email@mail.com",
                    password = "password",
                    name = "name"
                )
            )

        verify(exactly = 1) { userRepository.save(any()) }
    }
}
