package com.skillip.java;

import java.util.*;

public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> tableOrder = new HashMap<>();
        Map<String, Integer> foodMap = new HashMap<>();
        int sort = 1;

        for (List<String> order : orders) {
            String tableNumber = order.get(1);
            String foodItem = order.get(2);
            Map<String, Integer> map = tableOrder.getOrDefault(tableNumber, new HashMap<>());
            int count = map.getOrDefault(foodItem, 0) + 1;
            map.put(foodItem, count);
            tableOrder.put(tableNumber, map);

            if(!foodMap.containsKey(foodItem)) {
                foodMap.put(foodItem, sort);
                sort++;
            }
        }

        List<List<String>> out = new LinkedList<>();
        List<String> first = new ArrayList<>(foodMap.size() + 1);
        first.set(0, "Table");
        for (Map.Entry<String, Integer> entry : foodMap.entrySet()) {
            first.set(entry.getValue(), entry.getKey());
        }
        out.set(0, first);

        for (Map.Entry<String, Map<String, Integer>> entry : tableOrder.entrySet()) {
            List<String> subOut = new ArrayList<>();
            subOut.set(0, entry.getKey());

            Map<String, Integer> map = entry.getValue();
            for (Map.Entry<String, Integer> ent : map.entrySet()) {
                String foodItem = ent.getKey();
                Integer count = ent.getValue();
                Integer num = foodMap.get(foodItem);
                subOut.set(num, String.valueOf(count));
            }
            out.add(subOut);
        }
        return out;
    }

    public static void main(String[] args) {

    }
}
