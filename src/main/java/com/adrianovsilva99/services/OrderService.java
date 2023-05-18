package com.adrianovsilva99.services;

import com.adrianovsilva99.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double total(Order order) {
        return order.getBasic()
                - order.getBasic() * order.getDiscount() / 100;
    }
}