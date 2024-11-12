package com.example.cqrs.common.application

import com.example.cqrs.common.application.command.AbstractCommandHandler
import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.common.application.command.ApplicationCommandHandler
import com.example.cqrs.common.application.event.AbstractEventListener
import com.example.cqrs.common.application.event.ApplicationEvent
import com.example.cqrs.common.application.event.ApplicationEventListener
import com.example.cqrs.common.application.query.AbstractQueryResolver
import com.example.cqrs.common.application.query.ApplicationQuery
import com.example.cqrs.common.application.query.ApplicationQueryResolver
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext

class ApplicationDispatcherContext(private val context: ApplicationContext): ApplicationDispatcherContextInterface {
    private val LOG = LoggerFactory.getLogger(ApplicationDispatcherContext::class.java)

    override fun <R> execute(command: ApplicationCommand<R>?): Any {
        LOG.debug("handle command: " + command!!.getCommandName())
        val commandName = command.getCommandName().plus("HandlerBean")
        val handler = this.context.getBean(commandName) as ApplicationCommandHandler<ApplicationCommand<R>, R>
        return handler.handleCommand(command) as Any
    }

    override fun <R> execute(query: ApplicationQuery<R>?): Any {
        LOG.debug("handle query: " + query!!.getQueryName())
        val queryName = query.getQueryName().plus("ResolverBean")
        val resolver = this.context.getBean(queryName) as ApplicationQueryResolver<ApplicationQuery<R>, R>
        return resolver.resolveQuery(query) as Any
    }

    override fun <R> execute(event: ApplicationEvent<R>?): Boolean {
        LOG.debug("handle event: " + event!!.getEventName())
        val eventName = event.getEventName().plus("ListenerBean")
        val listener = this.context.getBean( eventName) as ApplicationEventListener<ApplicationEvent<R>, R>
        return listener.consumeEvent(event) as Boolean
    }
}