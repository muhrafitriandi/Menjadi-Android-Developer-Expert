package com.yandey.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListUserResponse(
    @field:SerializedName("items")
    val items: List<UserResponse>,
    @field:SerializedName("total_count")
    val total_count: Int
)

data class UserResponse(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("avatar_url")
    val avatar_url: String? = null,

    @field:SerializedName("bio")
    val bio: String? = null,

    @field:SerializedName("blog")
    val blog: String? = null,

    @field:SerializedName("company")
    val company: String? = null,

    @field:SerializedName("followers")
    val followers: Int? = null,

    @field:SerializedName("following")
    val following: Int? = null,

    @field:SerializedName("html_url")
    val html_url: String? = null,

    @field:SerializedName("location")
    val location: String? = null,

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("public_repos")
    val public_repos: Int? = null
)