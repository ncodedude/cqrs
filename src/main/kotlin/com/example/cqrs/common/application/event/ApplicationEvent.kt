package com.example.cqrs.common.application.event

interface ApplicationEvent<T> {
    fun getEventName(): String {
        return this.javaClass.simpleName
    }
}