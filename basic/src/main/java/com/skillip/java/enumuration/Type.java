package com.skillip.java.enumuration;

import lombok.Getter;
import lombok.Setter;

public enum Type {
    TYPE1(1);

    Type(int id) {
        this.id = id;
    }

    private int id;

    @Setter
    @Getter
    private String name;
}
