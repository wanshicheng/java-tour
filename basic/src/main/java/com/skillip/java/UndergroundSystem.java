package com.skillip.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, Map<String, Integer>> infos = null;
    Map<String, List<Integer>> times = null;

    public UndergroundSystem() {
        infos = new HashMap<>();
        times = new HashMap<>();

    }

    public void checkIn(int id, String stationName, int t) {
        if(infos.get(id) != null) return;
        Map<String, Integer> map = new HashMap<>();
        map.put(stationName, t);
        infos.put(id, map);
    }

    public void checkOut(int id, String stationName, int t) {
        Map<String, Integer> map = infos.remove(id);
        String key = null;
        Integer value = null;
        for(String k : map.keySet()) key = k;
        for(Integer v : map.values()) value = v;
        List<Integer> list = times.getOrDefault(key + "-" + stationName, new ArrayList<Integer>());
        list.add(t - value);
        times.put(key + "-" + stationName, list);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> list = times.get(startStation + "-" + endStation);
        if(list != null && list.size() != 0) {
            int time = 0;
            for(Integer t : list) time = time + t;
            return time / list.size();
        }
        return 0;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0
    }
}
