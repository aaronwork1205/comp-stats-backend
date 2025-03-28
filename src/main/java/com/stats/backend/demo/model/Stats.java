package com.stats.backend.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
public class Stats {
    // 使用 timestamp 作为主键，移除 columnDefinition
    @Id
    @Column(name = "timestamp", nullable = false, unique = true)
    private LocalDateTime timestamp;
    
    // 移除 @GeneratedValue，直接保存cpuUsage数据
    @Column(name = "cpuUsage", nullable = true)
    private double cpuUsage;
    
    @Column(nullable = true)
    private double memoryUsage;
    
    @Column(nullable = true)
    private double diskUsage;
    
    @Column(nullable = true)
    private double networkUsage;
    
    public double getCpuUsage() {
        return cpuUsage;
    }
    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
    public double getMemoryUsage() {
        return memoryUsage;
    }
    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }
    public double getDiskUsage() {
        return diskUsage;
    }
    public void setDiskUsage(double diskUsage) {
        this.diskUsage = diskUsage;
    }
    public double getNetworkUsage() {
        return networkUsage;
    }
    public void setNetworkUsage(double networkUsage) {
        this.networkUsage = networkUsage;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Stats{" +
               "timestamp=" + timestamp +
               ", cpuUsage=" + cpuUsage +
               '}';
    }
}
