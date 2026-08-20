package com.grahak.platform.controller;

import com.grahak.platform.domain.Order;
import com.grahak.platform.domain.Vendor;
import com.grahak.platform.dto.OrderRequest;
import com.grahak.platform.dto.OrderResponse;
import com.grahak.platform.repository.OrderRepository;
import com.grahak.platform.repository.VendorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final VendorRepository vendorRepository;

    public OrderController(OrderRepository orderRepository, VendorRepository vendorRepository) {
        this.orderRepository = orderRepository;
        this.vendorRepository = vendorRepository;
    }

    private OrderResponse toResponse(Order o) {
        return new OrderResponse(o.getId(), o.getCustomerLat(), o.getCustomerLng(), o.getAssignedVendorId(), o.getStatus());
    }

    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest request) {
        Order order = new Order();
        order.setCustomerLat(request.getLat());
        order.setCustomerLng(request.getLng());

        List<Vendor> nearby = vendorRepository.findWithinRadius(request.getLat(), request.getLng(), 3000);

        if (nearby.isEmpty()) {
            order.setStatus("FAILED");
        } else {
            Vendor chosen = nearby.get(0);
            order.setAssignedVendorId(chosen.getId());
            order.setStatus("ASSIGNED");
        }

        return toResponse(orderRepository.save(order));
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
