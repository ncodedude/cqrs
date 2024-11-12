package com.example.cqrs.adapter.out.topic

import org.springframework.stereotype.Service

@Service
class TopicImpl: TopicInterface {
    override fun sendMessageToTopic(message: String, topic: String): Boolean {
        //Fiquei devendo essa implementação
        //Faz de conta que mandei
        return true
    }
}