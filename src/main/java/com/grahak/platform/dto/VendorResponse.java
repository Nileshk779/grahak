package com.grahak.platform.dto;

public class VendorResponse {
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private Integer stockCapacity;

    public VendorResponse(Long id, String name, String address, double latitude, double longitude, Integer stockCapacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stockCapacity = stockCapacity;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public Integer getStockCapacity() { return stockCapacity; }
}