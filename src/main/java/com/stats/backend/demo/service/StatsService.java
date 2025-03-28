package com.stats.backend.demo.service;

import com.stats.backend.demo.model.Stats;
import com.stats.backend.demo.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    public Stats collectStats() {
        // 获取 CPU 使用率
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        double cpuLoad = -1;
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            cpuLoad = ((com.sun.management.OperatingSystemMXBean) osBean).getSystemCpuLoad();
            if (Double.isNaN(cpuLoad) || cpuLoad < 0) {  // 增加判断确保 cpuLoad 合法
                cpuLoad = 0.0;
            }
        } else {
            cpuLoad = 0.0;
        }
        System.out.println("CPU Load: " + cpuLoad);

        
        // 获取内存使用率
        Runtime runtime = Runtime.getRuntime();
        double memoryUsage = (double) (runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory();
        if(memoryUsage < 0) {
            memoryUsage = 0.0;
        }
        
        // 获取磁盘使用率（以根目录为例）
        File root = new File("/");
        double diskUsage = (double) (root.getTotalSpace() - root.getFreeSpace()) / root.getTotalSpace();
        if(diskUsage < 0) {
            diskUsage = 0.0;
        }
        
        // 网络使用率示例（设置为 0）
        double networkUsage = 0.0;
        
        Stats stats = new Stats();
        stats.setCpuUsage(cpuLoad);
        stats.setMemoryUsage(memoryUsage);
        stats.setDiskUsage(diskUsage);
        stats.setNetworkUsage(networkUsage);
        // 为 timestamp 添加微量随机偏移，确保主键唯一
        LocalDateTime baseTime = LocalDateTime.now();
        stats.setTimestamp(baseTime.plusNanos(ThreadLocalRandom.current().nextLong(1, 1000)));
        
        Stats savedStats = statsRepository.save(stats);
        System.out.println("Saved stats: " + savedStats);
        return savedStats;
    }
}
