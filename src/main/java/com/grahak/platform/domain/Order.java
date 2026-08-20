package com.grahak.platform.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double customerLat;

    @Column(nullable = false)
    private double customerLng;

    @Column(name = "assigned_vendor_id")
    private Long assignedVendorId;

    @Column(nullable = false)
    private String status; // PENDING, ASSIGNED, FAILED

    public Order() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getCustomerLat() { return customerLat; }
    public void setCustomerLat(double customerLat) { this.customerLat = customerLat; }

    public double getCustomerLng() { return customerLng; }
    public void setCustomerLng(double customerLng) { this.customerLng = customerLng; }

    public Long getAssignedVendorId() { return assignedVendorId; }
    public void setAssignedVendorId(Long assignedVendorId) { this.assignedVendorId = assignedVendorId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}