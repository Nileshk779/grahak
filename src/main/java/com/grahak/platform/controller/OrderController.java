package com.grahak.platform.controller;

import com.grahak.platform.domain.Order;
import com.grahak.platform.domain.Vendor;
import com.grahak.platform.dto.OrderRequest;
import com.grahak.platform.repository.OrderRepository;
import com.grahak.platform.repository.VendorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final VendorRepository vendorRepository;

    public OrderController(OrderRepository orderRepository, VendorRepository vendorRepository) {
        this.orderRepository = orderRepository;
        this.vendorRepository = vendorRepository;
    }

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request) {
        Order order = new Order();
        order.setCustomerLat(request.getLat());
        order.setCustomerLng(request.getLng());

        List<Vendor> nearby = vendorRepository.findWithinRadius(request.getLat(), request.getLng(), 3000);

        if (nearby.isEmpty()) {
            order.setStatus("FAILED");
        } else {
            Vendor chosen = nearby.get(0); // nearest available — simple v1 logic
            order.setAssignedVendorId(chosen.getId());
            order.setStatus("ASSIGNED");
        }

        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}