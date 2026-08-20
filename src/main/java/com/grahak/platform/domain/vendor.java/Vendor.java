package com.grahak.platform.domain;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point location;

    @Column(name = "stock_capacity")
    private Integer stockCapacity;

    public Vendor() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Point getLocation() { return location; }
    public void setLocation(Point location) { this.location = location; }

    public Integer getStockCapacity() { return stockCapacity; }
    public void setStockCapacity(Integer stockCapacity) { this.stockCapacity = stockCapacity; }
}