package org.example.singleton;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazySingleton {
    public LazySingleton() {
        System.out.println("LazySingleton initialized!");
    }
}
