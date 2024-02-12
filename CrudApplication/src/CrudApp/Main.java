package CrudApp;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


class StudentClass {
    private int studId;
    private String studName;
    private String studEmailID;
    private char studGrade; 
    private long studNumber;

    static HashMap<Integer,StudentClass> studentData=new HashMap<>();
    static int countStudent=1;
    public int getStudId() {
        return studId;
    }
    public void setStudId(int studId) {
        this.studId = studId;
    }
    public String getStudName() {
        return studName;
    }
    public void setStudName(String studName) {
        this.studName = studName;
    }
    public String getStudEmailID() {
        return studEmailID;
    }
    public void setStudEmailID(String studEmailID) {
        this.studEmailID = studEmailID;
    }
    public char getStudGrade() {
        return studGrade;
    }
    public void setStudGrade(char studGrade) {
        this.studGrade = studGrade;
    }
    public long getStudNumber() {
        return studNumber;
    }
    public void setStudNumber(long studNumber) {
        this.studNumber = studNumber;
    }
    
   
}
public class Main {
    public static void printMenu(){
        
        System.out.println("1. To create a new student");
        System.out.println("2. To remove a  student");
        System.out.println("3. To update a student");
        System.out.println("4. To display all a  student dat");
        System.out.println("5. To search a  student");
        System.out.println("6. To exit application");
    }
    private static void toCreateANewStudent(){
        System.out.println("Welcome - Creating a new student");
        Scanner s=new Scanner(System.in);
        StudentClass obj=new StudentClass();
//        obj.setStudId(StudentClass.countStudent);
//        System.out.println("Student Id is "+obj.getStudId());

        System.out.print("Enter student name: ");
        obj.setStudName(s.next());
        System.out.print("Enter student email: ");
        obj.setStudEmailID(s.next());
        System.out.print("Enter student grade: ");
        obj.setStudGrade(s.next().charAt(0));
        System.out.print("Enter student number: ");
        obj.setStudNumber(s.nextLong());
//        StudentClass.studentData.put(obj.getStudId(), obj);
//        StudentClass.countStudent++;
//        System.out.println("Thank you- Student creation successfully\n");
        DbOperations.toAddStudentData(obj);
        
//        toDisplayAStudent();
    }
    private static void toRemoveAStudent(){
        System.out.println("Welcome - Creating a new student");
        Scanner s=new Scanner(System.in);

        System.out.println("Enter the Id of the student to be removed");
        int id=s.nextInt();
        DbOperations.toRemoveAStudentdata(id);

    }
    private static void toUpdateAStudent(){
        System.out.println("Welcome - Update a student");
        Scanner s=new Scanner(System.in);

        System.out.println("Enter the Id of the student to be updated");
        int id=s.nextInt();
        if(DbOperations.studExits(id)){
             System.out.println("1. Update name");
             System.out.println("2. Update email");
             System.out.println("3. Update grade");
             System.out.println("4. Update number");
             System.out.println("Enter the choice: ");
             int choice=s.nextInt();
             switch (choice) {
                case 1:
                System.out.println("Enter the updated name: ");
                    String name=s.next();
                    DbOperations.toUpdateStudName(name,id);
                    break;
                case 2:
                System.out.println("Enter the updated email: ");
                    String email=s.next();
                    DbOperations.toUpdateStudEmail(email,id);
                    break;
                case 3:
                System.out.println("Enter the updated Grade: ");
                    char grade=s.next().charAt(0);
                    DbOperations.toUpdateStudGrade(grade,id);
                    break;
                case 4:
                System.out.println("Enter the updated Number: ");
                    long number=s.nextLong();
                    DbOperations.toUpdateStudNumb(number,id);
                    break;
             
                default:
                System.err.println("Invalid Choice!!");
                    return;
             }
              System.out.println("Student data updated successfully");
              toDisplayAStudent();
        }else{
            System.err.println("Student does not exists this id!!!");
        }
    }

    private static void toDisplayAStudent(){
    	HashMap<Integer, StudentClass> studentData1 = DbOperations.toDisplayStudent();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println("Student ID \t\t Student Name \t\t Student Mail \t\t Student Grade \t\t Student Number");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		for (Map.Entry<Integer, StudentClass> studentData : studentData1.entrySet()) {
			System.out.print(studentData.getKey() + "\t\t");
			System.out.print(studentData.getValue().getStudName() + "\t\t");
			System.out.print(studentData.getValue().getStudEmailID() + "\t\t");
			System.out.print(studentData.getValue().getStudGrade() + "\t\t");
			System.out.println(studentData.getValue().getStudNumber());
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println("Printed Student Data Successfully");

    }
    private static void toSearchAStudent(){
        System.out.println("Welcome - Search a student");
        Scanner s=new Scanner(System.in);

        System.out.println("Enter the Id of the student to be removed");
        int id=s.nextInt();
        if(DbOperations.studExits(id)){
        	StudentClass studentData=DbOperations.toGetStudData(id);
             System.out.println("Student Name: "+studentData.getStudName());
             System.out.println("Student email: "+studentData.getStudEmailID());
             System.out.println("Student grade: "+studentData.getStudGrade());
             System.out.println("Student Number: "+studentData.getStudNumber());
              System.out.println("Student data is displayed  successfully");
        }else{
            System.err.println("Student does not exists this id!!!\n");
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("\t\t\tStudent Database Application\n");
        boolean flag=true;
        while (flag) {
            printMenu();
            System.out.println("Enter your choice");
            int choice=s.nextInt();
            switch (choice) {
                case 1:
                    toCreateANewStudent();
                    break;
                case 2:
                    toRemoveAStudent();
                    break;
                case 3:
                    toUpdateAStudent();
                    break;
                case 4:
                    toDisplayAStudent();
                    break;
                case 5:
                	
                	
                    toSearchAStudent();
                    break;
                case 6:
                    flag=false;
                    break;
            
                default:
                System.err.println("Invalid choice");
                    break;
            }
        }
        System.out.println("Have a good day");
    }
}
