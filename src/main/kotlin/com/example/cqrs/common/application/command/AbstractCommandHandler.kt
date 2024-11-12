package com.example.cqrs.common.application.command

abstract class AbstractCommandHandler<T>: ApplicationCommandHandler<ApplicationCommand<T>, T> {
    abstract override fun handleCommand(command: ApplicationCommand<T>?): Long
}