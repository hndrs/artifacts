package io.hndrs.artifacts.shared

import com.fasterxml.jackson.annotation.JsonProperty

data class Organisation(
    @field:JsonProperty(ID_PROPERTY_NAME)
    @param:JsonProperty(ID_PROPERTY_NAME)
    val id: String
) {

    companion object {
        const val ID_PROPERTY_NAME = "id"
    }
}
