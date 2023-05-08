package com.by.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaUsage {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, IntPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Integer> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static void simpletestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }

    private static void simpletestBiConsumer(List<Apple> source, String c, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    private static Apple testFunction(String color,Integer weight,BiFunction<String,Integer,Apple> function){
        return function.apply(color,weight);
    }

    private static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        /*Runnable r1 = ()-> System.out.println("Hello");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        process(r1);
        process(r2);
        process(()-> System.out.println("Hello"));*/

        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("green", 150), new Apple("red", 130));
        /*List<Apple> greenList = filter(list, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });
        List<Apple> greenList1 = filter(list,apple -> apple.getColor().equals("green"));
        System.out.println(greenList);
        System.out.println(greenList1);
        List<Apple> weightList = filterByWeight(list,w->w > 100);
        System.out.println(weightList);
        List<Apple> biList = filterByBiPredicate(list,(a,b)->a.equals("green") && b > 120);
        System.out.println(biList);
        simpletestConsumer(list,apple -> System.out.println(apple));
        simpletestBiConsumer(list,"xxx",(a,c)-> System.out.println(c+a.getColor()+":weight"));*/
        String s = testFunction(new Apple("yellow", 100), apple -> apple.toString());
        System.out.println(s);
        System.out.println("------------------");
        IntFunction<Double> f = i -> i*100.0d;
        double result = f.apply(10);
        System.out.println(result);
        System.out.println("-------------");
        Apple a = testFunction("Blue",130,(s1,w1)->new Apple(s1,w1));
        System.out.println(a);
        System.out.println("---------------");
        Supplier<String> s1 = String::new;
        System.out.println(s1.get().getClass());
        System.out.println("---------------");
        Apple apple = createApple(()->new Apple("green",100));
        System.out.println(apple);

    }

    private static void process(Runnable r) {
        r.run();
    }

}
