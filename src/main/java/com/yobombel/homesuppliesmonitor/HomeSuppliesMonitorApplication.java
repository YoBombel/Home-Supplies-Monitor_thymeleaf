package com.yobombel.homesuppliesmonitor;

import com.yobombel.homesuppliesmonitor.Service.ItemService;
import com.yobombel.homesuppliesmonitor.util.FileParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HomeSuppliesMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeSuppliesMonitorApplication.class, args);
    }

}
