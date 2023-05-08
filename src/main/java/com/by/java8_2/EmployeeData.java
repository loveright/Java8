package com.by.java8_2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"马化腾",34,6000.38));
        list.add(new Employee(1001,"马云",34,6000.38));
        list.add(new Employee(1001,"刘强东",34,6000.38));
        list.add(new Employee(1001,"雷军",34,6000.38));
        list.add(new Employee(1001,"李彦宏",34,6000.38));
        list.add(new Employee(1001,"比尔盖茨",34,6000.38));
        list.add(new Employee(1001,"任正非",34,6000.38));
        list.add(new Employee(1001,"扎克伯格",34,6000.38));
        return list;
    }
}
