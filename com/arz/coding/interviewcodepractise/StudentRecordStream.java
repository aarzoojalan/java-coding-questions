package com.arz.coding.interviewcodepractise;

import java.util.*;
import java.util.stream.Collectors;
class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String departmentName;
    private int joinedYear;
    private String city;
    private int rank;
    public Student(int id, String firstName, String lastName, int age, String gender, String departmentName,
                   int joinedYear, String city, int rank) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.departmentName = departmentName;
        this.joinedYear = joinedYear;
        this.city = city;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(int joinedYear) {
        this.joinedYear = joinedYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
                + ", gender=" + gender + ", departmantName=" + departmentName + ", joinedYear=" + joinedYear + ", city="
                + city + ", rank=" + rank + "]";
    }
}

public class StudentRecordStream {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Aditya", "Mall", 30, "Male", "Mechanical Engineering", 2014, "Mumbai", 122),
                new Student(2, "Pulkith", "Singh", 26, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankita", "Patil", 25, "Female", "Computer Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Darshan", "Mukd", 23, "Male", "Instrumentation Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Satyam", "Pandey", 26, "Male", "Biotech Engineering", 2017, "Mumbai", 98)
        );
        // group the students by department name
        Map<String,List<Student>> dpt = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
        System.out.println("Group Students by department name "+dpt);
        //count of students in each department
        Map<String,Long> studentCount = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,Collectors.counting()));
        System.out.println("Count of students in each department"+studentCount);
        // find all department names
        List<String> departmentNames = list.stream().map(e -> e.getDepartmentName()).distinct().toList();
        System.out.println(" All department names" +departmentNames);
        // find the list of students whose age is less than 25
        List<Student> students = list.stream().filter(e -> e.getAge() < 25).toList();
        System.out.println("age less than 25" +students);
        //find the max age of students
        int maxAge = list.stream().max(Comparator.comparing(Student :: getAge)).get().getAge();
        System.out.println("Max age of students" +maxAge);
        // find the avg age of male and female
        Map<String,Double> avgAge = list.stream().collect(Collectors.groupingBy(Student :: getGender,Collectors.averagingInt(Student :: getAge)));
        System.out.println("average age of male and female "+avgAge);
        // find the young student in all department
        Student student = list.stream().min(Comparator.comparing(Student::getAge)).get();
        System.out.println("young student in all the department"+student);
        // find the senior female in all departments
        Student seniorFemale = list.stream().filter(e -> e.getGender() == "Female").max(Comparator.comparing(Student :: getAge)).get();
        System.out.println("senior female in all the department "+seniorFemale);
        //list of students whose rank is between 50 and 100
        List<Student> studentRank = list.stream().filter(e -> e.getRank() > 50 && e.getRank() < 100).toList();
        System.out.println("list of students whose rank is betwen 50 and 100 "+studentRank);
        // department having max no of students
        String departmentName = String.valueOf(list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get());
        System.out.println("department having mas students" +departmentName);
        //students who stay in mumbai and sort them by their names
        List<Student> mumbaiStudent= list.stream().filter(e-> e.getCity() == "Mumbai").sorted(Comparator.comparing(Student::getFirstName)).toList();
        System.out.println("sort by names "+mumbaiStudent);
        // total count of students
        long totalCount = list.stream().count();
        System.out.println("total count of students" +totalCount);
        // avg rank in all department
        Map<String,Double> avgRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,Collectors.averagingInt(Student::getRank)));
        System.out.println("average rank in each department" +avgRank);
        //highest rank in each department
        Map<String, Optional<Student>> highest = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println("highest rank in each department" +highest);
        //list of student sorted by rank
        List<Student> studentRank1 = list.stream().sorted(Comparator.comparing(Student::getRank)).toList();
        System.out.println("students sorted by rank "+studentRank1);
        //second-highest rank student
        Student secondHighest= list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        System.out.println("second highest rank student " +secondHighest);
        //find the rank of students in all department in ascending order
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,Collectors.collectingAndThen(
                Collectors.toList(), l -> l.stream().sorted(Comparator.comparing(Student::getRank)).toList())));
        System.out.println(" rank of students in all department" +collect);
        //total sum of age of male and female gender in a list of students
        Map<String,Integer> totalAge= list.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.summingInt(Student::getAge)));
        System.out.println("total age of students "+totalAge);
    }
}