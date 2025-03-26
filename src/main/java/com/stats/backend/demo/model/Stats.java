package com.stats.backend.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
public class Stats {
	// 移除 id, 使用 timestamp 作为主键
	@Id
	private LocalDateTime timestamp;
	
	private double cpuUsage;
	private double memoryUsage;
	private double diskUsage;
	private double networkUsage;

	// ...existing getters and setters...
	
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
}
