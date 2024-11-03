package com.github.cuidok.performance.postgresql;

import com.github.cuidok.performance.postgresql.init.DatabaseInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PerformancePostgresqlApplication implements CommandLineRunner {

    private final DatabaseInitializer databaseInitializer;

    public static void main(String[] args) {
        SpringApplication.run(PerformancePostgresqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInitializer.initDatabase();
    }
}
