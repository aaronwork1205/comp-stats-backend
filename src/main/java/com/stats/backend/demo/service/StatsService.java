package com.stats.backend.demo.service;

import com.stats.backend.demo.model.Stats;
import com.stats.backend.demo.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    public Stats collectStats() {
        // 获取 CPU 使用率（需要 cast 为 com.sun.management.OperatingSystemMXBean 获取更多指标）
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        double cpuLoad = -1;
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            cpuLoad = ((com.sun.management.OperatingSystemMXBean) osBean).getSystemCpuLoad();
        }
        
        // 获取内存使用率
        Runtime runtime = Runtime.getRuntime();
        double memoryUsage = (double) (runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory();

        // 获取磁盘使用率（以根目录为例）
        File root = new File("/");
        double diskUsage = (double) (root.getTotalSpace() - root.getFreeSpace()) / root.getTotalSpace();

        // 网络使用率示例（需要更专业的工具，示例中设为 0）
        double networkUsage = 0.0;
        
        Stats stats = new Stats();
        stats.setCpuUsage(cpuLoad);
        stats.setMemoryUsage(memoryUsage);
        stats.setDiskUsage(diskUsage);
        stats.setNetworkUsage(networkUsage);
        stats.setTimestamp(LocalDateTime.now());
        
        return statsRepository.save(stats);
    }
}
