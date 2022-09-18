package com.yandey.core.data.source.local.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yandey.core.utils.Constants.COL_AVATAR_URL
import com.yandey.core.utils.Constants.COL_BIO
import com.yandey.core.utils.Constants.COL_BLOG
import com.yandey.core.utils.Constants.COL_COMPANY
import com.yandey.core.utils.Constants.COL_FOLLOWERS
import com.yandey.core.utils.Constants.COL_FOLLOWING
import com.yandey.core.utils.Constants.COL_HTML_URL
import com.yandey.core.utils.Constants.COL_ID
import com.yandey.core.utils.Constants.COL_IS_FAVORITE
import com.yandey.core.utils.Constants.COL_LOCATION
import com.yandey.core.utils.Constants.COL_LOGIN
import com.yandey.core.utils.Constants.COL_NAME
import com.yandey.core.utils.Constants.COL_PUBLIC_REPOS
import com.yandey.core.utils.Constants.USER

@Entity(tableName = USER)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = COL_ID)
    val id: Int? = null,

    @ColumnInfo(name = COL_AVATAR_URL)
    val avatar_url: String? = null,

    @ColumnInfo(name = COL_BIO)
    val bio: String? = null,

    @ColumnInfo(name = COL_BLOG)
    val blog: String? = null,

    @ColumnInfo(name = COL_COMPANY)
    val company: String? = null,

    @ColumnInfo(name = COL_FOLLOWERS)
    val followers: Int? = null,

    @ColumnInfo(name = COL_FOLLOWING)
    val following: Int? = null,

    @ColumnInfo(name = COL_HTML_URL)
    val html_url: String? = null,

    @ColumnInfo(name = COL_LOCATION)
    val location: String? = null,

    @ColumnInfo(name = COL_LOGIN)
    val login: String? = null,

    @ColumnInfo(name = COL_NAME)
    val name: String? = null,

    @ColumnInfo(name = COL_PUBLIC_REPOS)
    val public_repos: Int? = null,

    @ColumnInfo(name = COL_IS_FAVORITE)
    val isFavorite: Boolean? = false,
)