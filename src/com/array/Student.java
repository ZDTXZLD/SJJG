package com.array;

public class Student {
    private  String name;
    private  int score;

    public Student() {
        super();
    }

    public Student(String name,int score) {
        this.name = name;
        this.score=score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  static  void main(String[] args){
       Array<Student> arr=new Array<>();
       arr.addLast(new Student("longge",100));
       arr.addLast(new Student("tianbao",90));
       arr.addLast(new Student("daihu",85));
       System.out.println(arr.getSize());
    }
}
