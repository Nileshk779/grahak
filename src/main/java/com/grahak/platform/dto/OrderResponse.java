package com.grahak.platform.dto;

public class OrderResponse {
    private Long id;
    private double customerLat;
    private double customerLng;
    private Long assignedVendorId;
    private String status;

    public OrderResponse(Long id, double customerLat, double customerLng, Long assignedVendorId, String status) {
        this.id = id;
        this.customerLat = customerLat;
        this.customerLng = customerLng;
        this.assignedVendorId = assignedVendorId;
        this.status = status;
    }

    public Long getId() { return id; }
    public double getCustomerLat() { return customerLat; }
    public double getCustomerLng() { return customerLng; }
    public Long getAssignedVendorId() { return assignedVendorId; }
    public String getStatus() { return status; }
}
