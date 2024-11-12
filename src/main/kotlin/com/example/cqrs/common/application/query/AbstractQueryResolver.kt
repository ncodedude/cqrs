package com.example.cqrs.common.application.query

abstract class AbstractQueryResolver<T>: ApplicationQueryResolver<ApplicationQuery<T>, T> {
    abstract override fun resolveQuery(query: ApplicationQuery<T>?): Any
}