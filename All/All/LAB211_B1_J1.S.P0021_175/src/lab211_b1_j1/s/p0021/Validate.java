/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_b1_j1.s.p0021;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nam
 */
public class Validate {
    
    public Scanner sc = new Scanner(System.in);

    public int option(String message, int first, int last) {
        int input = 0;
        //Run again until number is integer number
        //and integer number is in range between 1 and 6 so stop
        do {
            try {
                System.out.println(message);
                input = Integer.parseInt(sc.nextLine());
                if (input >= first && input <= last) {
                    break;
                }
                if (input < first || input > last) {
                    System.out.println("Must from " + first + " to"
                            + last + ". Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public int integerNumber(String message) {
        int input = 0;
        //Run again until number is integer number so stop
        do {
            try {
                System.out.println(message);
                input = Integer.parseInt(sc.nextLine());
                if (input <= 0) {
                    System.out.println("Positive Integer!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public float floatNumber(String message) {
        float input = 0;
        //Run again until number is float number
        //and float number greater than 0 so stop
        do {
            try {
                System.out.println(message);
                input = Float.parseFloat(sc.nextLine());
                if (input > 0) {
                    break;
                } else {
                    System.out.println("Total area must be greater than 0."
                            + "Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public String stringWords() {
        String input = "";
        //Run again until check valid words is true so stop
        do {
            input = sc.nextLine();
            if (isWords(input)) {
                break;
            } else {
                System.out.println("Must words. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public String stringCode(String message) {
        String input = "";
        //Run again until check valid code is true so stop
        do {
            System.out.println(message);
            input = sc.nextLine();
            if (isId(input)) {
                break;
            } else {
                System.out.println("Must code. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public String stringSource(String message) {
        String input = "";
        //Run again until check valid id is true so stop
        do {
            System.out.println(message);
            input = sc.nextLine();
            if (isCourseName(input)) {
                break;
            } else {
                System.out.println("Must source name. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public String yesOrNo(String message) {
        String input = "";
        //Run again until check  is y or n so break loop
        do {
            System.out.println(message);
            input = sc.nextLine();
            if (isYesOrNo(input)) {
                return input;
            } else {
                System.out.println("Must Y or N. Pls, enter again!");
            }
        } while (true);
    }

    public String updateOrDelete(String message) {
        String input = "";
        //Run again until check  is u or d so break loop
        do {
            System.out.println(message);
            input = sc.nextLine();
            if (isupdateOrDelete(input)) {
                return input;
            } else {
                System.out.println("Must U or D. Pls, enter again!");
            }
        } while (true);
    }

    //Enter a course by select
    public String inputCourse() {
        System.out.println("There are three courses:\n1-Java\n2-.Net\n3.C/C++");
        int option = option("Your choice: ", 1, 3);
        switch (option) {
            case 1:
                return "Java";
            case 2:
                return ".Net";
            default:
                return "C/C++";
        }
    }
    public boolean isWords(String name) {
        //Regex mean: name include many character and space
        String regex = "[a-z\\s]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches() && !name.trim().equals("")) {
            return true;
        }
        return false;
    }

    public boolean isId(String id) {
        //Regex mean: name include many character and integer number
        String regex = "[a-z0-9]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches() && !id.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isCourseName(String courseName) {
        //Regex mean: coursce name include java or c/c++ or .net
        String regex = "^java|c/c\\+\\+|.net$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(courseName);
        if (matcher.matches() && !courseName.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isDuplicate(ArrayList<Student> listStudents,
            Student checkedStudent) {
        //Run from first student to satisfy condition or to last student
        for (Student student : listStudents) {
            //Check id, course name and semester equals of two student
            if (student.getId().compareToIgnoreCase(checkedStudent.getId()) == 0
                    && student.getCourseName().compareToIgnoreCase(checkedStudent.getCourseName()) == 0
                    && student.getSemester() == checkedStudent.getSemester()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSameIdAndDifName(ArrayList<Student> listStudents,
            String id, String name) {
        //Run from first student to satisfy condition or to last student
        for (Student student : listStudents) {
            //Check same id and diffirent name
            if (student.getId().compareToIgnoreCase(id) == 0
                    && student.getName().compareToIgnoreCase(name) != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isYesOrNo(String input) {
        //Regex mean: input include y or n
        String regex = "[y|n]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public boolean isupdateOrDelete(String input) {
        //Regex mean: input include u or d
        String regex = "[u|d]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public boolean sameStudentWithCourse(Student student1, Student student2) {
        //Check id, course equals of two diffirence students
        if (!student1.equals(student2)
                && student1.getId().compareToIgnoreCase(student2.getId()) == 0
                && student1.getCourseName().compareToIgnoreCase(student2.getCourseName()) == 0) {
            return true;
        }
        return false;
    }

    public boolean isSameIDWithList(ArrayList<Student> listStudents, String id) {
        //Run from first student to satisfy condition or to last student
        for (Student student : listStudents) {
            //Check same id and diffirent name
            if (student.getId().compareToIgnoreCase(id) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isSameID(String id, String id0) {
        if (id.compareToIgnoreCase(id0) == 0) {
            return true;
        }
        return false;
    }

    public boolean isDuplicateAll(ArrayList<Student> listStudents,
            Student checkedStudent, Student studentByIndex) {
        String newID = checkedStudent.getId();
        String newName = checkedStudent.getName();
        String newCourseName = checkedStudent.getCourseName();
        int newSemester = checkedStudent.getSemester();
        //Run from first student to satisfy condition or to last student
        for (Student student : listStudents) {
            //Check id, course name and semester equals of two student
            if (student.getId().compareToIgnoreCase(newID) == 0
                    && student.getCourseName().compareToIgnoreCase(newCourseName) == 0
                    && student.getSemester() == newSemester
                    && !studentByIndex.equals(student)) {
                return true;
            }
        }
        return false;
    }
    
}
