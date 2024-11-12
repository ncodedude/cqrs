package com.example.cqrs.common.configuration

import com.example.cqrs.common.application.ApplicationDispatcherContext
import com.example.cqrs.common.application.ApplicationDispatcherContextInterface
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ApplicationDispatcherConfiguration(private val applicationContext: ApplicationContext) {

    @Bean
    fun config(): ApplicationDispatcherContextInterface {
        return ApplicationDispatcherContext(this.applicationContext)
    }
}