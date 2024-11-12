package com.example.cqrs.common.application.command

interface ApplicationCommand<T> {
    fun getCommandName(): String {
        return this.javaClass.simpleName
    }
}