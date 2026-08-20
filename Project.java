import java.util.ArrayList;
import java.util.Scanner;
class Student
{
    private int age;
    private int ID;
    private String name;
    private String Branch;
    public Student(int age,int ID,String name,String Branch)
    {
        this.name=name;
        this.age=age;
        this.ID=ID;
        this.Branch=Branch;

        
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch() {
        return Branch;
    }
    public void setBranch(String branch) {
        Branch = branch;
    }
    @Override
    public String toString()
    {
        return "Student [age=" + age + ", ID=" + ID + ", name=" + name + ", Branch=" + Branch + "]";
    }

}
class StudentManagement
{
    private ArrayList<Student>students=new ArrayList<Student>();
    
    public void addstudent(Student st)
    {
        students.add(st);
        System.out.println("Student added successfully.");
        return;
    }
    public void display()
    {
      if(students.isEmpty())
        {
            System.out.println("No Student available");
            return;
        } 
        else
            {
                for(Student s:students)
                {
                    System.out.println(s);
                    
            
                }
            } 
    }
    public void SearchStudentBy(int id)
    {
        for(Student s:students)
        {
            if(id==s.getID())
            {
               System.out.println("Student found");
               System.out.println(s);
               return;
            }

        }
        System.out.println("Student not found");
        return;
    }
    public void UpdateStudent(int Id,Scanner sc)
    {
        sc.nextLine();
        for(Student s:students)
        {
            if(s.getID()==Id)
            {
                System.out.print("Enter new name:");
                String name=sc.nextLine();
                System.out.print("Enter new Age:");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new branch:");
                String branch=sc.nextLine();
                s.setName(name);
                s.setBranch(branch);
                s.setAge(age);
                System.out.println("Student updated Successfully");
                return;
            }

        }
        System.out.println("Student Not Found");
        return;      
    }
    public void Delete(int id)
    {
        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).getID()==id)
            {
                students.remove(i);
                System.out.println("Student removed Successfully");
                return;
            }
        }
        System.out.println("Student not found");
        return;
    }
}
public class Project
{
    public static void main(String a[])
    {
     Scanner sc= new Scanner(System.in);
     StudentManagement sm=new StudentManagement();
     while(true)
     {
        System.out.println("=======Student Management System======");
        System.out.println("1.Add Student");
        System.out.println("2.Display Student");
        System.out.println("3.Search Student");
        System.out.println("4.Update Student details");
        System.out.println("5.Delete student");
        System.out.println("6.Exit");
        System.out.print("Enter choice:");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
           
                System.out.print("Enter Student age:");
                int age=sc.nextInt();
                System.out.print("Enter Student ID:");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Student name:");
                String name=sc.nextLine();
                System.out.print("Enter Student branch:");
                String branch=sc.nextLine();

                Student st= new Student(age,id,name,branch);
                sm.addstudent(st);
                break;
            case 2:
                sm.display();
                break;
            case 3:
                System.out.print("Enter ID to serach:");
                int Id=sc.nextInt();
                sm.SearchStudentBy(Id);
                break;
            case 4:
                System.out.print("Enter ID of the student for Updating:");
                int idd=sc.nextInt();
                sm.UpdateStudent(idd,sc);
                break;
            case 5:
                System.out.print("Enter ID to delete:");
                int iddd=sc.nextInt();
                sm.Delete(iddd);
                break;
            case 6:
                System.out.print("Thank you!!");
                sc.close();
                return;
            default:
                System.out.print("Invalid Option");
        }   
     }

    }  
}