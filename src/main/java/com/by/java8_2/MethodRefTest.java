package com.by.java8_2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    //情况一：对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1 = str-> System.out.println(str);
        con1.accept("北京");
        System.out.println("******************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("天津");
    }
    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void Test2(){
        Employee employee = new Employee(1001,"Tom",23,5600);
        Supplier<String> s1 = ()->employee.getName();
        System.out.println(s1.get());
        System.out.println("******************");
        Supplier<String> s2 = employee::getName;
        System.out.println(s2.get());
    }
    //情况二：类::静态方法
    //Comparator中的int compare(T t1,Tt2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void Test3(){
        Comparator<Integer> com1 = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(12,21));
        System.out.println("**************");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12,3));
    }
    //Function中的apply(T,t)
    //Math中的Long round(Double d)
    @Test
    public void test4(){
        Function<Double,Long> func0 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        Function<Double,Long> fun1 = d->Math.round(d);
        System.out.println(fun1.apply(12.3));
        System.out.println("********************");
        Function<Double,Long> fun2 = Math::round;
        System.out.println(fun2.apply(12.6));
    }
    //情况三：类::实例方法
    //Compare中的int compare(T t1,T t2)
    //String 中的int t1.compareTo(t2)
    @Test
    public void Test5(){
        Comparator<String> com1 = (s1,s2)->s1.compareTo(s2);
        System.out.println(com1.compare("abc","acd"));
        System.out.println("*********************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd","abf"));//ASCII值相减
    }
    //BiPredicate中的boolean test(T t1,T t2)
    //String 中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> pre1 = (s1,s2)->s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));
        System.out.println("****************");
        BiPredicate<String,String> pre2 = String::equals;
        System.out.println(pre2.test("abc","abc"));
    }
    //Function 中的Rapply(T t)
    //Employee中的String getName()
    @Test
    public void test7(){
        Employee employee = new Employee(1001, "Jerry", 23, 5600);
        Function<Employee,String > fun1 = e->e.getName();
        System.out.println(fun1.apply(employee));
        System.out.println("******************");
        Function<Employee,String> fun2 = Employee::getName;
        System.out.println(fun2.apply(employee));

    }
}
