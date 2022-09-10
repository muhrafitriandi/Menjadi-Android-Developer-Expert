package com.yandey.mysimplecleanarchitecture.data

import com.yandey.mysimplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource): IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity = messageDataSource.getMessageFromSource(name)
}