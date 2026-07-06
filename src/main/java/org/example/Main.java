package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static LinkedList<Employee> findDuplicates(List<Employee> listInput){
        Set<Employee> set = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for(Employee e: listInput){
           if(e!=null){
               if(!set.add(e)){
                   duplicates.add(e);
               } else{
                   set.add(e);
               }
           }
        }

        return (LinkedList<Employee>) duplicates;
    }

    public static Map findUniques(List<Employee> listInput){
        Map<Integer,Employee> set = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        for(Employee e: listInput){
            if(e!=null){
                if(set.containsKey(e.getId())){
                    duplicates.add(e);
                }else{
                    set.put(e.getId(), e);
                }
            }
        }

        return  set;
    }
    public static List<Employee> removeDuplicates(List<Employee> listInput){
        List<Employee> nonDuplicates = new LinkedList<>();
        Map<Employee,Integer> map = new HashMap<>();
        for(Employee e: listInput){
            if(e != null){
                map.put(e, map.getOrDefault(e, 0) + 1);

            }


        }
        for(Map.Entry<Employee,Integer> entry: map.entrySet()){
            Employee e = entry.getKey();

            if( entry.getValue() == 1){
                nonDuplicates.add(e);
            }
        }

        return nonDuplicates;
    }


    public static void main(String[] args) {

        System.out.println("Hello World!");

        List<Employee> list = new LinkedList<>();
        list.add(new Employee(101, "John", "Doe"));
        list.add(new Employee(102, "Jane", "Doe"));
        list.add(new Employee(103, "Jessy", "Doe"));
        list.add(new Employee(104, "Jacob", "Doe"));
        list.add(new Employee(104, "Jane", "Doe"));
        findDuplicates((LinkedList<Employee>) list);
        System.out.println(findDuplicates((LinkedList<Employee>) list).toString());
        findUniques((LinkedList<Employee>) list);
        System.out.println(findUniques((LinkedList<Employee>) list).toString());
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        Main.removeDuplicates(employees);
        System.out.println(employees.toString());
    }

}