package com.example.cqrs.common.application.query

interface ApplicationQuery<T> {
    fun getQueryName(): String {
        return this.javaClass.simpleName
    }
}