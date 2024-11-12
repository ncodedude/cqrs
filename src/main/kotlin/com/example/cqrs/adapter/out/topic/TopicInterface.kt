package com.example.cqrs.adapter.out.topic

interface TopicInterface {

    fun sendMessageToTopic(message: String, topic: String): Boolean
}