package com.skillip.dp.visitor;

public class TravelCities implements City {
    City[] cities;

    public TravelCities() {
        cities = new City[] {new Beijing(), new Shanghai()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (int i = 0; i < cities.length; i++) {
            cities[i].accept(visitor);
        }
    }
}
