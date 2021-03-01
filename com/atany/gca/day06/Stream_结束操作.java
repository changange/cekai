package com.atany.gca.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-02-25-21:40
 * Description：<描述>
 */
public class Stream_结束操作 {
    public static void main(String[] args) {
        //集合
        List<String> list = new ArrayList<>();
        list.add("cc");
        list.add("aa");
        list.add("asdf");
        list.add("aer");
        list.add("afdgtg");

        //testCount(list);
        //testFindFirst(list);
        testCollect(list);
    }

    //结束操作
    //count 统计有几个
    public static void testCount(List<String> list){
        long re = list.stream().map(x->x.toUpperCase()).count();
        System.out.println("rs="+re);
    }

    //findFirst 返回第一个
    //findAny   返回任意一个
    public static void testFindFirst(List<String> list){
        Optional<String> first = list.stream().map(x -> x.toUpperCase()).findFirst();
        System.out.println("rs="+first.get());
    }

    //collect：toMap、toList、toSet
    public static void testCollect(List<String> list){
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("collect+" + collect);

        list.stream().map(x -> x.toUpperCase())
                .collect(Collectors.toMap(x -> x, x -> x.length()))
                .forEach((k,v)-> System.out.println(k+":"+v));  //forEach是map集合里的，不是stream里的


        //分组
        Map<Integer, List<String>> collect1 = list.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println("map = " + collect1);

        //判断型的  分组，符合条件的一堆，不符合条件的一堆
        Map<Boolean, List<String>> collect2 = list.stream().collect(Collectors.partitioningBy(x -> x.length() > 3));
        System.out.println("collect2 = " + collect2);
    }

    //reduce()：
    public static void testReduce(List<Integer> list){
        //每相邻两个元素相加，返回结果
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);

        //这种给个默认值的，这这个初始值上操作    返回一个int
        Integer reduce1 = list.stream().reduce(100, (x, y) -> x + y);
    }
}
