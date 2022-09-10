package com.yandey.mysimplecleanarchitecture.data

import com.yandey.mysimplecleanarchitecture.domain.IMessageRepository
import com.yandey.mysimplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource): IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity = messageDataSource.getMessageFromSource(name)
}