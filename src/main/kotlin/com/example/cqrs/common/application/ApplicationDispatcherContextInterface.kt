package com.example.cqrs.common.application

import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.common.application.event.ApplicationEvent
import com.example.cqrs.common.application.query.ApplicationQuery

interface ApplicationDispatcherContextInterface {
    fun <R> execute(command: ApplicationCommand<R>?): Any
    fun <R> execute(query: ApplicationQuery<R>?): Any
    fun <R> execute(event: ApplicationEvent<R>?): Boolean
}