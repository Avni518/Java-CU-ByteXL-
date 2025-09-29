import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.*;

public class PartB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student st1 = new Student(101, "Avni", 9.5);
        String fileName = "byteData.txt";
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(st1);
            System.out.println("Data stored successfully...");
        }
        catch(Exception e){

        }   
        
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            Student st2 = (Student)ois.readObject();
            System.out.println("Data restored successfully...");
            System.out.println("ID: "+ st2.id);
            System.out.println("Name: "+ st2.name);
            System.out.println("Grade: "+ st2.grade);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
    }

}

class Student implements Serializable{
    int id;
    String name;
    Double grade;

    Student(int id, String name, Double grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    void display(){
        System.out.println("id: "+ this.id);
        System.out.println("name: "+ this.name);
        System.out.println("grade: "+ this.grade);
    }

}
