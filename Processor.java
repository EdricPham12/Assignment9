package assignment9;

import java.util.ArrayList;
import java.util.Scanner;

// 1) Tao class Student
class Student {
    String studentId;
    String fullName;
    String dateOfBirth;
    String major;
    float gpa;

    public void enterStudentInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sinh vien: ");
        studentId = sc.nextLine();

        System.out.print("Nhap ho va ten sinh vien: ");
        fullName = sc.nextLine();

        System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
        dateOfBirth = sc.nextLine();

        System.out.print("Nhap nganh hoc: ");
        major = sc.nextLine();

        System.out.print("Nhap diem GPA: ");
        gpa = sc.nextFloat();
    }

    public void displayStudentInfo() {
        System.out.println("Ma sinh vien: " + studentId);
        System.out.println("Ho va ten: " + fullName);
        System.out.println("Ngay sinh: " + dateOfBirth);
        System.out.println("Nganh hoc: " + major);
        System.out.println("Diem GPA: " + gpa);
    }
}

// 2) Tao class StudentList
class StudentList {
    ArrayList<Student> studentList = new ArrayList<>();

    // a. Nhap thong tin cua n sinh vien (n nhap tu ban phim)
    public void enterStudentInfo(int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.enterStudentInfo();  // Goi ham nhap thong tin sinh vien
            studentList.add(student);  // Them sinh vien vao danh sach
        }
    }

    // b. Hien thi thong tin tat ca sinh vien
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sach sinh vien trong!");
        } else {
            for (Student student : studentList) {
                student.displayStudentInfo();
            }
        }
    }

    // c. Tim kiem sinh vien theo ID
    public Student findStudentById(String idToFind) {
        for (Student student : studentList) {
            if (student.studentId.equals(idToFind)) {
                return student;
            }
        }
        return null;
    }

    // d. Xoa sinh vien theo ID
    public boolean deleteStudentById(String idToDelete) {
        for (Student student : studentList) {
            if (student.studentId.equals(idToDelete)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    // e. Chinh sua sinh vien theo ID
    public boolean editStudentById(String idToEdit) {
        for (Student student : studentList) {
            if (student.studentId.equals(idToEdit)) {
                student.enterStudentInfo();  // Goi lai ham nhap thong tin de chinh sua
                return true;
            }
        }
        return false;
    }
}

// 3) Tao class Processor
public class Processor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            // Menu lua chon
            System.out.println("Menu:");
            System.out.println("1. Nhap thong tin sinh vien");
            System.out.println("2. Hien thi tat ca sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ID");
            System.out.println("4. Xoa sinh vien theo ID");
            System.out.println("5. Chinh sua sinh vien theo ID");
            System.out.println("6. Thoat");
            System.out.print("** Chon chuc nang: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // a. Nhap thong tin cua n sinh vien
                    System.out.print("Nhap so luong sinh vien: ");
                    int n = sc.nextInt();
                    studentList.enterStudentInfo(n);
                    System.out.println("==========================================");
                    break;
                case 2:
                    // b. Hien thi thong tin tat ca sinh vien
                    studentList.displayAllStudents();
                    System.out.println("==========================================");
                    break;
                case 3:
                    // c. Tim kiem sinh vien theo ID
                    System.out.print("Nhap ma sinh vien can tim: ");
                    String idToFind = sc.nextLine();
                    Student foundStudent = studentList.findStudentById(idToFind);
                    if (foundStudent != null) {
                        foundStudent.displayStudentInfo();
                        System.out.println("==========================================");
                    } else {
                        System.out.println("Khong tim thay sinh vien.");
                        System.out.println("==========================================");
                    }
                    break;
                case 4:
                    // d. Xoa sinh vien theo ID
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    String idToDelete = sc.nextLine();
                    boolean deleteSuccess = studentList.deleteStudentById(idToDelete);
                    if (deleteSuccess) {
                        System.out.println("Xoa sinh vien thanh cong.");
                        System.out.println("==========================================");
                    } else {
                        System.out.println("Khong tim thay sinh vien de xoa.");
                        System.out.println("==========================================");
                    }
                    break;
                case 5:
                    // e. Chinh sua sinh vien theo ID
                    System.out.print("Nhap ma sinh vien can chinh sua: ");
                    String idToEdit = sc.nextLine();
                    boolean editSuccess = studentList.editStudentById(idToEdit);
                    if (editSuccess) {
                        System.out.println("Chinh sua sinh vien thanh cong.");
                        System.out.println("==========================================");
                    } else {
                        System.out.println("Khong tim thay sinh vien de chinh sua.");
                        System.out.println("==========================================");
                    }
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
