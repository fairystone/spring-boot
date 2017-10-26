package com.tech.minmin.springBoot.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Minmin on 26/10/2017.
 */
@Component
public class Properties {
    @Value("${minmin.name}")
    private String name;

    @Value("${minmin.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
