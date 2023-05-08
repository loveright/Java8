package com.by.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {
    private static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
        consumer.accept(t);
    }




    public static void main(String[] args) {
//        Consumer<String> consumer = s -> System.out.println(s);
//        useConsumer(consumer,"Alex");
//        useConsumer(s-> System.out.println(s),"aaa");
//        useConsumer(System.out::println,"bbb");
        List<Apple> list = Arrays.asList(new Apple("abc",789),new Apple("Green",123),new Apple("Red",456));
        System.out.println(list);
        list.sort((a1,a2)->a1.getColor().compareTo(a2.getColor()));
//        System.out.println(list);
//        list.stream().forEach(apple -> System.out.println(apple));
        list.stream().forEach(System.out::println);
        int value = Integer.valueOf("123");
        System.out.println(value);
        Function<String,Integer> f = Integer::parseInt;
        Integer result = f.apply("123");
        System.out.println(result);
    }
}
