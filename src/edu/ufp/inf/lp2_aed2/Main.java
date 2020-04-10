package edu.ufp.inf.lp2_aed2;

public class Main {
    public static void main(String[] args) {

        Teacher t = new Teacher(1, "Beatriz", "beatriz@teste.com");
        Teacher t2 = new Teacher(3, "André", "andre@teste.com");

        Student s = new Student(2, "Joao", "joao@teste.com", 33814, "Diurno");
        Student s2 = new Student(4, "Emanuel", "emanuel@teste.com", 28051, "Noturno");
        Student s3 = new Student(5, "Chico da Tina", "ctina@teste.com", 69, "Noturno");
        Student s4 = new Student(6,"Filipe", "filipe@teste.com", 2586, "Diurno");

        CourseUnit cu1 = new CourseUnit(1, "LP2", 7);
        CourseUnit cu2 = new CourseUnit(2, "AED2", 7);
        CourseUnit cu3 = new CourseUnit(3, "LP1", 7);


        Class c = new Class(1,"ASD", "Diurno", t,cu1);
        Class c2 = new Class(2, "AQW", "Noturno", t, cu1);
        Class c3 = new Class(3, "FGH", "Diurno", t2, cu1);

        System.out.println("------------------------------------------------------");
        System.out.println("---------------------Course Unit----------------------");
        System.out.println("------------------------------------------------------");

        t.addCourseUnit(cu1);
        t.addCourseUnit(cu2);
        t.addCourseUnit(cu3);

        System.out.println("Primeiro print\n");
        t.printAllCourseUnit();

        System.out.println("\nRemovido: " + t.removeCourseUnit(2));

        System.out.println("\nSegundo print");
        t.printAllCourseUnit();

        System.out.println("\nFind: " + t.searchCourseUnit(1));

        t.editCourseUnit(1);

        System.out.println("\nDepois de alterar: " + t.searchCourseUnit(1));

        System.out.println("\nTerceiro print");
        t.printAllCourseUnit();


        System.out.println("\n\n\n");
        System.out.println("------------------------------------------------------");
        System.out.println("-------------------------Class------------------------");
        System.out.println("------------------------------------------------------");

        cu1.addClass(c);
        cu1.addClass(c2);
        cu1.addClass(c3);

        System.out.println("Primeiro print\n");
        cu1.printAllClass();

        System.out.println("\nRemovido: " + cu1.removeClass("AQW"));

        System.out.println("\nSegundo print");
        cu1.printAllClass();

        System.out.println("\nFind: " + cu1.searchClass("ASD"));

        cu1.editClass("ASD");

        System.out.println("\nDepois de alterar: " + cu1.searchClass("ASD"));

        System.out.println("\nTerceiro print");
        cu1.printAllClass();

        System.out.println("\n\n\n");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------STUDENT-----------------------");
        System.out.println("------------------------------------------------------");

        cu1.addStudent(s);
        cu1.addStudent(s2);
        cu1.addStudent(s3);
        cu1.addStudent(s4);


        System.out.println("Primeiro print\n");
        cu1.printAllStudent();

        System.out.println("\nRemovido: " +  cu1.removeStudent(28051));

        System.out.println("\nSegundo print");
        cu1.printAllStudent();

        System.out.println("\nFind: " + cu1.searchStudent(33814));

        cu1.editStudent(33814);

        System.out.println("\nDepois de alterar: " + cu1.searchStudent(33814));

        System.out.println("\nTerceiro print");
        cu1.printAllStudent();
    }
}
