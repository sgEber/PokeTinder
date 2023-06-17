package com.solano.eber.poketinder2023.data.model

import java.io.Serializable

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String
): Serializable {
    fun geyImage() = "https://graph.facebook.com/$id/picture?type=large&width=720&height=720"
}
