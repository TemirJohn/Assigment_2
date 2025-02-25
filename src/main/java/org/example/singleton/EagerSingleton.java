package org.example.singleton;
import org.springframework.stereotype.Component;

@Component
public class EagerSingleton {

    public EagerSingleton() {
        System.out.println("EagerSingleton initialized!");
    }
}
