package com.yandey.mysimplecleanarchitecture.data

import com.yandey.mysimplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}