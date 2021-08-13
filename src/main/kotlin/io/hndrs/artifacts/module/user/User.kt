package io.hndrs.artifacts.module.user

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.repository.MongoRepository
import java.time.Instant

@Document("users")
data class User(
    @Id
    val id: String? = null,

    @Indexed(unique = true)
    @Field("email")
    val email: String,

    @Field("name")
    val name: String?,

    @Field("createdAt")
    val createdAt: Instant = Instant.now(),

    @Field("lastModifiedAt")
    val lastModifiedAt: Instant = Instant.now(),
)

interface UserRepository : MongoRepository<User, String>
