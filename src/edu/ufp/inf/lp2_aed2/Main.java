package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Main {
    public static void main(String[] args) {

        // Lista de Teacher do CourseUnit - chave é o email do Teacher(email Person)
         SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();

        // Lista de Students do CourseUnit - chave é o numberStudent do Student
         SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

        Teacher t = new Teacher(1, "Beatriz", "beatriz@teste.com");
        Teacher t2 = new Teacher(3, "André", "andre@teste.com");
        Teacher t3 = new Teacher(2, "Rui Moreira", "rui@teste.com");

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

        Date d = new Date(11, 00, 2);
        Date d2 = new Date(13, 00, 2);
        Date d3 = new Date(18, 00,3);
        Date d4 = new Date(20, 00, 3);
        Date d5 = new Date(18, 00,4);
        Date d6 = new Date(20, 00, 4);


        Room r = new Room(1,1,101,true,100);
        Room r2 = new Room(2,1,102, false, 200);
        Room r3 = new Room(3,1,103, false, 200);
        Room r4 = new Room(4,1,110,true,5);

        ScheduleClass sc = new ScheduleClass(d, d2, r, c);
        ScheduleClass sc2 = new ScheduleClass(d3, d4,r2,c2);
        ScheduleClass sc3 = new ScheduleClass(d5, d6,r3,c3);

        ScheduleAccompaniment sa = new ScheduleAccompaniment(d5, d6, r4, t3);
        ScheduleAccompaniment sa2 = new ScheduleAccompaniment(d3, d4, r4, t);

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

        c.addStudent(s);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);


        System.out.println("Primeiro print\n");
        c.printAllStudent();

        System.out.println("\nRemovido: " +  c.removeStudent(28051));

        System.out.println("\nSegundo print");
        c.printAllStudent();

        System.out.println("\nFind: " + c.searchStudent(33814));

        c.editStudent(33814);

        System.out.println("\nDepois de alterar: " + c.searchStudent(33814));

        System.out.println("\nTerceiro print");
        c.printAllStudent();

        System.out.println("\n\n\n");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------TEACHER-----------------------");
        System.out.println("------------------------------------------------------");

        Main.addTeacher(teachersST, t);
        Main.addTeacher(teachersST, t2);
        Main.addTeacher(teachersST, t3);

        System.out.println("Primeiro print\n");
        Main.printAllTeacher(teachersST);

        System.out.println("\nRemovido: " +  Main.removeTeacher(teachersST, "andre@teste.com"));

        System.out.println("\nSegundo print");
        Main.printAllTeacher(teachersST);

        System.out.println("\nFind: " + Main.searchTeacher(teachersST, "rui@teste.com"));

        Main.editTeacher(teachersST,"rui@teste.com");

        System.out.println("\nDepois de alterar: " + Main.searchTeacher(teachersST, "rui@teste.com"));

        System.out.println("\nTerceiro print");
        Main.printAllTeacher(teachersST);

        System.out.println("\n\n\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------SCHEDULE CLASS----------------------");
        System.out.println("------------------------------------------------------------");

        c.addScheduleClass(sc);
        c.addScheduleClass(sc2);
        c.addScheduleClass(sc3);

        System.out.println("Primeiro print\n");
        c.printAllScheduleClass();

        System.out.println("\nRemovido: " +  c.removeScheduleClass(d3, c2));

        System.out.println("\nSegundo print");
        c.printAllScheduleClass();

        System.out.println("\nFind: " + c.searchScheduleClass(d5, c3));

        c.editScheduleClass(d5,c3);
        
        System.out.println("\nDepois de alterar: " + c.searchScheduleClass(d5, c3));

        System.out.println("\nTerceiro print");
        c.printAllScheduleClass();

        System.out.println("\n\n\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("-----------------SCHEDULE ACCPOMPANIMENT--------------------");
        System.out.println("------------------------------------------------------------");

        t.addScheduleAccompaniment(sa);
        t.addScheduleAccompaniment(sa2);

        System.out.println("Primeiro print\n");
        t.printAllScheduleAccompaniment();

        System.out.println("\nRemovido: " +  t.removeScheduleAccompaniment(t, d3));

        System.out.println("\nSegundo print");
        t.printAllScheduleAccompaniment();

        System.out.println("\nFind: " + t.searchScheduleAccompaniment(t3, d5));

        t.editScheduleAccompaniment(t3,d5);

        System.out.println("\nDepois de alterar: " + t.searchScheduleAccompaniment(t3, d5));

        System.out.println("\nTerceiro print");
        t.printAllScheduleAccompaniment();
    }

    /**
     * Adicionar um Teacher na ST
     * @param t Teacher para adicionar a ST
     */
    public static void addTeacher(SeparateChainingHashST<String, Teacher> teachersST, Teacher t)
    {
        if(teachersST.contains(t.getEmail()))
        {
            System.out.println("CourseUnit - addTeacher(): Teacher already exists!!!");
            return;
        }
        teachersST.put(t.getEmail(), t);
    }

    /**
     * Remover uma Teacher da ST
     * @param email
     * @return o Teacher eliminado
     */
    public static Teacher removeTeacher(SeparateChainingHashST<String, Teacher> teachersST, String email)
    {
        Teacher t = teachersST.get(email);

        if(t != null)
        {
            teachersST.delete(email);
            return t;
        }
        System.out.println("CourseUnit - removeTeacher(): Teacher not exists!!!");
        return null;
    }

    /**
     * Editar o Teacher
     * @param email
     * @return Teacher
     */
    public static Teacher editTeacher(SeparateChainingHashST<String, Teacher> teachersST, String email)
    {
        if(teachersST.contains(email))
        {
            Teacher t = teachersST.get(email);

            t.setName("Beatriz Gomes");

            return t;
        }

        System.out.println("CourseUnit - editTeacher(): email not exist inside teachersST");
        return null;
    }

    /**
     * Procurar um determinado Teacher na ST
     * @param email
     * @return Teacher encontrado
     */
    public static Teacher searchTeacher(SeparateChainingHashST<String, Teacher> teachersST, String email)
    {
        if(teachersST.contains(email))
        {
            Teacher t = teachersST.get(email);
            return t;
        }

        System.out.println("CourseUnit - searchTeacher(): Id not exist inside teachersST");
        return null;
    }

    /**
     * Imprimir todos os Teacher
     */
    public static void printAllTeacher(SeparateChainingHashST<String, Teacher> teachersST)
    {
        for(String tKey: teachersST.keys())
        {
            Teacher t = teachersST.get(tKey);
            System.out.println(t);
        }
    }

    /**
     * Validar a Teacher
     * @param email
     * @return true se existir, false se nao existir
     */
    public static boolean validTeacher(SeparateChainingHashST<String, Teacher> teachersST, String email)
    {
        for(String mail: teachersST.keys())
        {
            Teacher t = teachersST.get(mail);

            if(t.getEmail().equals(email))
            {
                return true;
            }
        }
        return false;
    }

}
