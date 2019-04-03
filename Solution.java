import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
   int token;
   String fname;
   double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

class StudentComparator implements Comparator<Student> {
    
    public int compare(Student a, Student b) {
        if (a.getCgpa() == b.getCgpa()) {
            if (a.getFname().equals(b.getFname())) {
                return a.getToken() - b.getToken();
            } else {
                return a.getFname().compareTo(b.getFname());
            }
        } else {
            if (a.getCgpa() < b.getCgpa()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
        PriorityQueue<Student> queue = new PriorityQueue<Student>(totalEvents, new StudentComparator());
      while(totalEvents>0){
         String event = in.next();
            
          if ("ENTER".equals(event)) {
              String fname = in.next();
              double cgpa = Double.parseDouble(in.next());
              int id = Integer.parseInt(in.next());
              queue.offer(new Student(id, fname, cgpa));
          } else {
              queue.poll();
          }
           
         totalEvents--;
      }
        if (queue.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll().getFname());
            }
        }
    }
}
