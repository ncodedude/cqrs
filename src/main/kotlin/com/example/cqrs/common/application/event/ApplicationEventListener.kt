package com.example.cqrs.common.application.event


interface ApplicationEventListener <C : ApplicationEvent<R>, R>{
    fun consumeEvent(event: ApplicationEvent<R>?): Boolean?
}
