package mr.cookie;

import org.jetbrains.annotations.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SimpleApp {

    public static void main(@Nullable String[] args) {
        SpringApplication.run(SimpleApp.class, args);
    }

}
