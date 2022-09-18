package com.yandey.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int? = null,

    val avatar_url: String,

    val bio: String? = null,

    val blog: String? = null,

    val company: String? = null,

    val followers: Int? = null,

    val following: Int? = null,

    val html_url: String? = null,

    val location: String? = null,

    val login: String? = null,

    val name: String? = null,

    val public_repos: Int? = null,

    val isFavorite: Boolean? = false,
) : Parcelable