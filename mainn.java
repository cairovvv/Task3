package com.mycompany.main1;

import java.util.Scanner;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        Repository librarian = new Repository();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("[1] Add Student");
            System.out.println("[2] Show Master List");
            System.out.println("[3] Exit");
            System.out.print("Select: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                // Collect all 10 attributes via Scanner
                System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
                System.out.print("First Name: "); String fName = sc.nextLine();
                System.out.print("Last Name: "); String lName = sc.nextLine();
                System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());
                System.out.print("Gender: "); String gen = sc.nextLine();
                System.out.print("Year Level: "); int yr = Integer.parseInt(sc.nextLine());
                System.out.print("Course: "); String crs = sc.nextLine();
                System.out.print("Blood Type: "); String bld = sc.nextLine();
                System.out.print("Address: "); String addr = sc.nextLine();
                System.out.print("Contact: "); String con = sc.nextLine();

                Student s = new Student(id, fName, lName, age, gen, yr, crs, bld, addr, con);
                librarian.addStudent(s);
                System.out.println("Student saved successfully!");

            } else if (choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("SHOW")) {
                List<Student> students = librarian.getAllStudents();
                
                // Full Header for all 10 attributes
                System.out.println("\n" + "=".repeat(160));
                System.out.printf("%-5s | %-12s | %-12s | %-3s | %-7s | %-4s | %-8s | %-5s | %-25s | %-10s%n", 
                                  "ID", "FIRST", "LAST", "AGE", "GENDER", "YEAR", "COURSE", "BLOOD", "ADDRESS", "CONTACT");
                System.out.println("-".repeat(160));

                for (Student s : students) {
                    // Displaying exactly 10 fields per student
                    System.out.printf("%-5d | %-12s | %-12s | %-3d | %-7s | %-4d | %-8s | %-5s | %-25s | %-10s%n",
                        s.getID(), s.getFirstName(), s.getLastName(), s.getAge(), 
                        s.getGender(), s.getYearLvl(), s.getCourse(), 
                        s.getBloodtype(), s.getAddress(), s.getContact());
                }
                System.out.println("=".repeat(160));
                
            } else if (choice.equals("3")) {
                break;
            }
        }
        sc.close();
    }
}