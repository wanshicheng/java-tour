package com.skillip.dp.visitor;

public class Demo {
    public static void main(String[] args) {
        TravelCities travelCities = new TravelCities();
        travelCities.accept(new SingleVisitor());
    }
}
