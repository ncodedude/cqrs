package com.example.cqrs.adapter.out.persistence

import com.example.cqrs.domain.payment.core.Payment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface PaymentRepository: CrudRepository<Payment, Long> {
}