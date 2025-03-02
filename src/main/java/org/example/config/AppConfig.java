package org.example.config;

import org.example.singleton.EagerSingleton;
import org.example.singleton.LazySingleton;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    @Lazy
    public LazySingleton lazySingleton() {
        return new LazySingleton();
    }

    @Bean
    public EagerSingleton eagerSingleton() {
        return new EagerSingleton();
    }
}
