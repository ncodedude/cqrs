package com.example.cqrs.common.application.event

abstract class AbstractEventListener<T>: ApplicationEventListener<ApplicationEvent<T>, T> {
    abstract override fun consumeEvent(event: ApplicationEvent<T>?): Boolean?
}
