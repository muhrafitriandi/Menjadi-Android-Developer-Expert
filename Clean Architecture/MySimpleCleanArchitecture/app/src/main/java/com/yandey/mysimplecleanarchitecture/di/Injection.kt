package com.yandey.mysimplecleanarchitecture.di

import com.yandey.mysimplecleanarchitecture.data.IMessageDataSource
import com.yandey.mysimplecleanarchitecture.data.MessageDataSource
import com.yandey.mysimplecleanarchitecture.data.MessageRepository
import com.yandey.mysimplecleanarchitecture.domain.IMessageRepository
import com.yandey.mysimplecleanarchitecture.domain.MessageInteractor
import com.yandey.mysimplecleanarchitecture.domain.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}