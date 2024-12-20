package com.secor.fdamonolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FdamonolithApplication
{
    public static void main(String[] args)
    {
        // IoC principle in action within this main method
        SpringApplication.run(FdamonolithApplication.class, args);

    }
}
