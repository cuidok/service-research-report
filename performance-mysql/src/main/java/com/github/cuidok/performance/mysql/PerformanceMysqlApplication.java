package com.github.cuidok.performance.mysql;

import com.github.cuidok.performance.mysql.init.DatabaseInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PerformanceMysqlApplication implements CommandLineRunner {

    private final DatabaseInitializer databaseInitializer;

    public static void main(String[] args) {
        SpringApplication.run(PerformanceMysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInitializer.initDatabase();
    }
}
