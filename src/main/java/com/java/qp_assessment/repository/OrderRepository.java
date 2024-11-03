package com.java.qp_assessment.repository;

import com.java.qp_assessment.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
