package com.example.springcassandrafordemo;

import com.datastax.astra.sdk.AstraClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {
        CassandraDataAutoConfiguration.class,
        CassandraAutoConfiguration.class
})
public class SpringCassandraFordemoApplication {
    @Autowired
    private AstraClient astraClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCassandraFordemoApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return astraClient.apiDevopsOrganizations().organizationId();
    }
}
