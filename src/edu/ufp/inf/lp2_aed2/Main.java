package edu.ufp.inf.lp2_aed2;

public class Main {
    public static void main(String[] args) {
        //testCrudMain();
        testeLoadMAin();
        testSaveMain();
    }

    public static void testCrudMain ()
    {
        University u = new University("UFP");

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


        Room r = new Room(1,1,"101",true,100);
        Room r2 = new Room(2,1,"102", false, 200);
        Room r3 = new Room(3,1,"103", false, 200);
        Room r4 = new Room(4,1,"110",true,5);

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

        u.addTeacher(t);
        u.addTeacher(t2);
        u.addTeacher( t3);

        System.out.println("Primeiro print\n");
        u.printAllTeacher();

        System.out.println("\nRemovido: " +  u.removeTeacher("andre@teste.com"));

        System.out.println("\nSegundo print");
        u.printAllTeacher();

        System.out.println("\nFind: " + u.searchTeacher("rui@teste.com"));

        u.editTeacher("rui@teste.com");

        System.out.println("\nDepois de alterar: " + u.searchTeacher("rui@teste.com"));

        System.out.println("\nTerceiro print");
        u.printAllTeacher();

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

    public static void testeLoadMAin ()
    {
        University u = new University("UFP");

        u.loadTeacher("./data/Teacher");
        u.printAllTeacher();
        System.out.println("\n\n");

        u.loadStudent("./data/Student");
        u.printAllStudent();
        System.out.println("\n\n");

        u.loadRoom("./data/Room");
        u.printAllRoom();
        System.out.println("\n\n");

        u.loadCourseUnit("./data/CourseUnit");
        u.printAllCourseUnit();
        System.out.println("\n\n");

        u.loadClass("./data/Class");
        u.printAllClass();
        System.out.println("\n\n");

        CourseUnit cu = u.getCourseUnitsST().get(9);
        cu.printAllClass();

        Class c = u.getClassesST().get("HBO");
        System.out.println("\n\n");
        System.out.println(c);

        c.loadScheduleClass(u, "./data/ScheduleClass");
        System.out.println("\n\n");

        c.printAllScheduleClass();

        Class cc = u.getClassesST().get("BGE");

        System.out.println();
        System.out.println(cc);
        cc.printAllScheduleClass();

        Student s = u.getStudentsST().get(1);
        System.out.println("\n\n");
        System.out.println(s);

        s.loadStudentCourse(u, "./data/StudentCourse");
        System.out.println("\n\n");

        Student ss = u.getStudentsST().get(2);
        System.out.println("\n\n");
        System.out.println(ss);

        Teacher t = u.getTeachersST().get("afonseca@ufp.edu.pt");
        System.out.println("\n\n");
        System.out.println(t);

        t.loadScheduleAccompaniment(u, "./data/TeacherScheduleAccompaniment");
        System.out.println("\n\n");

        t.printAllScheduleAccompaniment();

        Teacher tt = u.getTeachersST().get("pcosta@ufp.edu.pt");
        System.out.println("\n\n");
        System.out.println(tt);

        tt.printAllScheduleAccompaniment();

    }

    public static void testSaveMain (){

        University u = new University("UFP");

        u.loadTeacher("./data/Teacher");
        u.saveTeacher("./data/SaveTeacher");

        u.loadStudent("./data/Student");
        u.saveStudent("./data/SaveStudent");

        u.loadRoom("./data/Room");
        u.saveRoom("./data/SaveRoom");

        u.loadCourseUnit("./data/CourseUnit");
        u.saveCourseUnit("./data/SaveCourseUnit");

        u.loadClass("./data/Class");
        u.saveRoom("./data/SaveClass");

        Class c = u.getClassesST().get("HBO");
        c.loadScheduleClass(u, "./data/ScheduleClass");
        c.saveScheduleClass(u,"./data/SaveScheduleClass");

    }
}
