package com.by;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapContains {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("fullname", "1111");
        map.put("mobile", "151");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("fullname", "222");
        map2.put("mobile", "152");
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("fullname", "222");
        map3.put("mobile", "152");
        map3.put("username", "hahaha");

        List<Map<String, Object>> list2 = new ArrayList<>();
        list2.add(map3);

//        System.out.println(list.contains(map3));

        List<Map<String, Object>> collect = list.stream().filter(l -> {
//            l.put("username", "uuu");
            return true;
        }).collect(Collectors.toList());
        System.out.println(collect);

        boolean b = list.stream().anyMatch(l -> {
            if (l.get("fullname").equals(map3.get("fullname")) && l.get("mobile").equals(map3.get("mobile"))) {
                l.put("username", map3.get("username"));
                return true;
            } else {
                return false;
            }
        });
        System.out.println(b);
        System.out.println(list);


    }
}
