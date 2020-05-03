package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        University u = new University("UFP");
        History h = new History();
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Gestão de Informação e Navegação Indoor numa Universidade <-----\n");
            System.out.println(" [1] -> Salas");
            System.out.println(" [2] -> Professores");
            System.out.println(" [3] -> Estudantes");
            System.out.println(" [4] -> Unidades Curriculares");
            System.out.println(" [5] -> Pesquisas");
            System.out.println(" [6] -> Gestão de Fichieros");
            System.out.println(" [S] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    menuSalas(u, h);
                    break;
                case "2":
                    menuProfessores(u, h);
                    break;
                case "3":
                    menuEstudantes(u, h);
                    break;
                case "4":
                    menuCourseUnit(u, h);
                    break;
                case "5":
                    menuPesquisas(u);
                    break;
                case "6":
                    menuGestaoFiles(u);
                    break;
                case "s":
                case "S":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"s".equals(op) && !"S".equals(op));
    }

    public static void menuGestaoFiles(University u)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Gestão de Ficheiros <-----\n");
            System.out.println(" [1] -> Carregar Ficheiros");
            System.out.println(" [2] -> Guardar em Ficheiros ");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    u.loadTeacher("./data/Teacher");
                    u.loadStudent("./data/Student");
                    u.loadRoom("./data/Room");
                    u.loadCourseUnit("./data/CourseUnit");
                    u.loadClass("./data/Class");
                    Class.loadScheduleClass(u, "./data/ScheduleClass");
                    Student.loadStudentCourse(u, "./data/StudentCourse");
                    Teacher.loadScheduleAccompaniment(u, "./data/TeacherScheduleAccompaniment");
                    System.out.println("Os ficheiros foram todos carregados!");
                    break;
                case "2":
                    u.saveTeacher("./data/SaveTeacher");
                    u.saveStudent("./data/SaveStudent");
                    u.saveRoom("./data/SaveRoom");
                    u.saveCourseUnit("./data/SaveCourseUnit");
                    u.saveClass("./data/SaveClass");
                    Class.saveScheduleClass(u,"./data/SaveScheduleClass");
                    Student.saveStudentCourse(u, "./data/SaveStudentCourse");
                    Teacher.saveScheduleAccompaniment(u, "./data/SaveTeacherScheduleAccompaniment");
                    System.out.println("Todos os dados foram guardados nos seus respetivos ficheiros!");
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuSalas(University u, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Salas <-----\n");
            System.out.println(" [1] -> Listar Salas");
            System.out.println(" [2] -> Criar Sala");
            System.out.println(" [3] -> Eliminar Sala");
            System.out.println(" [4] -> Editar Sala");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    u.printAllRoom();
                    break;
                case "2":
                    Scanner roomSc = new Scanner(System.in);
                    int idAux = 0;

                    for(String numberRoom: u.getRoomST().keys())
                    {
                        Room r = u.getRoomST().get(numberRoom);
                        if(r.getId() > idAux)
                        {
                            idAux = r.getId();
                        }
                    }
                    idAux += 1;
                    System.out.println("id = " + idAux);
                    System.out.println("\t\t -----> Inserir Sala <-----\n");
                    System.out.println("Andar: ");
                    Integer floor = Integer.parseInt(roomSc.nextLine());
                    System.out.println("Nº Sala: ");
                    String numberRoom = roomSc.nextLine();
                    System.out.println("Tomadas(true/false): ");
                    Boolean socket = Boolean.parseBoolean(roomSc.nextLine());
                    System.out.println("Capacidade: ");
                    Integer capacity = Integer.parseInt(roomSc.nextLine());

                    Room r = new Room(idAux,floor,numberRoom,socket,capacity);
                    u.addRoom(r);
                    break;
                case "3":
                    u.printAllRoom();
                    Scanner roomScApagar = new Scanner(System.in);
                    System.out.println("Selecione um numberRoom para APAGAR da ST");
                    String nRoom = roomScApagar.nextLine();
                    Room rApagar = u.removeRoom(nRoom);

                    h.archiveRoom(u, rApagar);

                    if(rApagar != null)
                    {
                        System.out.println("A sala " + rApagar.getNumberRoom() + " foi Apagada e Arquivada!");
                    }
                    break;
                case "4":
                    u.printAllRoom();
                    Scanner roomScEdit = new Scanner(System.in);
                    System.out.println("Selecione um numberRoom para EDITAR");
                    String numRoom = roomScEdit.nextLine();
                    u.editRoom(numRoom);
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuProfessores(University u, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Professores <-----\n");
            System.out.println(" [1] -> Listar Professores");
            System.out.println(" [2] -> Criar Professor");
            System.out.println(" [3] -> Eliminar Professor");
            System.out.println(" [4] -> Editar Professor");
            System.out.println(" [5] -> Horários de atendimento");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    u.printAllTeacher();
                    break;
                case "2":
                    Scanner roomSc = new Scanner(System.in);
                    int idAux = 0;

                    for(String email: u.getTeachersST().keys())
                    {
                        Teacher t = u.getTeachersST().get(email);
                        if(t.getId() > idAux)
                        {
                            idAux = t.getId();
                        }
                    }
                    idAux += 1;
                    System.out.println("id = " + idAux);
                    System.out.println("\t\t -----> Inserir Professor <-----\n");

                    System.out.println("Nome: ");
                    String name = roomSc.nextLine();
                    System.out.println("Email: ");
                    String email = roomSc.nextLine();

                    Teacher t = new Teacher(idAux, name, email);
                    u.addTeacher(t);
                    break;
                case "3":
                    u.printAllTeacher();
                    Scanner teacherScApagar = new Scanner(System.in);
                    System.out.println("Selecione um email para APAGAR da ST");
                    String emailT = teacherScApagar.nextLine();
                    Teacher tApagar = u.removeTeacher(emailT);

                    h.archiveTeacher(u, tApagar);

                    for(Date stdate: tApagar.getScheduleAccompanimentsST().keys())
                    {
                        ScheduleAccompaniment saApagar = tApagar.getScheduleAccompanimentsST().get(stdate);

                        ScheduleAccompaniment sAapagar = tApagar.removeScheduleAccompaniment(saApagar.getStartDate());

                        h.archiveScheduleAccompaniment(tApagar, sAapagar);

                        if(sAapagar != null)
                        {
                            System.out.println("O ScheduleAccompaniment com a Data inicial = " + sAapagar.getStartDate() + " foi Apagado e Arquivado!");
                        }
                    }

                    if(tApagar != null)
                    {
                        System.out.println("O Professor com o email " + tApagar.getEmail() + " foi Apagado e Arquivado!");
                    }
                    break;
                case "4":
                    u.printAllTeacher();
                    Scanner teacherScEdit = new Scanner(System.in);
                    System.out.println("Selecione um email para EDITAR da ST");
                    String emailTe = teacherScEdit.nextLine();
                    u.editTeacher(emailTe);
                    break;
                case "5":
                    u.printAllTeacher();
                    Scanner teacherScAtend = new Scanner(System.in);
                    System.out.println("Selecione um Professor para ver o Menu de Horários de Atendimento");
                    String emailTeacher = teacherScAtend.nextLine();
                    Teacher tea = u.getTeachersST().get(emailTeacher);
                    menuHorarioAtendimento(u, tea, h);
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuHorarioAtendimento(University u, Teacher t, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Horário de Atendimento <-----\n");
            System.out.println(" [1] -> Listar Horários de Atendimento");
            System.out.println(" [2] -> Criar  Horário de Atendimento ");
            System.out.println(" [3] -> Eliminar Horário de Atendimento ");
            System.out.println(" [4] -> Editar  Horário de Atendimento");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    t.printAllScheduleAccompaniment();
                    break;
                case "2":
                    Scanner teacherSc = new Scanner(System.in);
                    System.out.println("\t\t -----> Inserir Horários de Atendimento <-----\n");
                    System.out.println("Inserir Data Inicial (Dia da semana/hora/minutos)");
                    String stDate = teacherSc.nextLine();

                    String[] split1 =  stDate.split("/");
                    int stdayOfWeek = Integer.parseInt(split1[0]);
                    int sthour = Integer.parseInt(split1[1]);
                    int stmin = Integer.parseInt(split1[2]);
                    Date startDate = new Date(sthour, stmin, stdayOfWeek);


                    System.out.println("Inserir Data Final (Dia da semana/hora/minutos)");
                    String flDate = teacherSc.nextLine();

                    String[] split2 =  stDate.split("/");
                    int fldayOfWeek = Integer.parseInt(split2[0]);
                    int flhour = Integer.parseInt(split2[1]);
                    int flmin = Integer.parseInt(split2[2]);
                    Date finalDate = new Date(flhour, flmin, fldayOfWeek);

                    u.printAllRoom();
                    System.out.println("Selecionar uma Sala pelo numberRoom");
                    String numberRoom = teacherSc.nextLine();

                    Room r = u.getRoomST().get(numberRoom);

                    ScheduleAccompaniment sa = new ScheduleAccompaniment(startDate, finalDate, r, t);

                    t.addScheduleAccompaniment(sa);
                    break;
                case "3":
                    t.printAllScheduleAccompaniment();
                    Scanner saScApagar = new Scanner(System.in);
                    System.out.println("Selecione uma Data Inicial (Dia da semana/hora/minutos) para APAGAR da ST");
                    String stDateElim = saScApagar.nextLine();

                    String[] split3 =  stDateElim.split("/");
                    int stdayOfWeekElim = Integer.parseInt(split3[0]);
                    int sthourElim = Integer.parseInt(split3[1]);
                    int stminElim = Integer.parseInt(split3[2]);
                    Date startDateElim = new Date(sthourElim, stminElim, stdayOfWeekElim);

                    ScheduleAccompaniment saApagar = t.removeScheduleAccompaniment(startDateElim);

                    h.archiveScheduleAccompaniment(t, saApagar);

                    if(saApagar != null)
                    {
                        System.out.println("A ScheduleAccompaniment com a Data inicioal " + saApagar.getStartDate() + " foi Apagada e Arquivado!");
                    }
                    break;
                case "4":
                    t.printAllScheduleAccompaniment();
                    Scanner saScEdit = new Scanner(System.in);
                    System.out.println("Selecione uma Data Inicial (Dia da semana/hora/minutos) para APAGAR da ST");
                    String stDateEdit = saScEdit.nextLine();

                    String[] split4 =  stDateEdit.split("/");
                    int stdayOfWeekEdit = Integer.parseInt(split4[0]);
                    int sthourEdit = Integer.parseInt(split4[1]);
                    int stminEdit = Integer.parseInt(split4[2]);
                    Date startDateEdit = new Date(sthourEdit, stminEdit, stdayOfWeekEdit);

                    t.editScheduleAccompaniment(u, startDateEdit);
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuEstudantes(University u, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Estudantes <-----\n");
            System.out.println(" [1] -> Listar Estudantes");
            System.out.println(" [2] -> Criar Estudante");
            System.out.println(" [3] -> Eliminar Estudante");
            System.out.println(" [4] -> Editar Estudante");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    u.printAllStudent();
                    break;
                case "2":
                    Scanner studentSc = new Scanner(System.in);
                    int idAux = 0;

                    for(Integer id: u.getStudentsST().keys())
                    {
                        Student s = u.getStudentsST().get(id);

                        if(s.getId() > idAux)
                        {
                            idAux = s.getId();
                        }
                    }
                    idAux += 1;
                    System.out.println("id = " + idAux);

                    System.out.println("\t\t -----> Inserir Estudante <-----\n");
                    System.out.println("Nome: ");
                    String name = studentSc.nextLine();
                    System.out.println("Email: ");
                    String email = studentSc.nextLine();
                    System.out.println("Nº Estudante: ");
                    Integer numberStudent = Integer.parseInt(studentSc.nextLine());
                    System.out.println("Tipo(Noturno/Diurno)");
                    String type = studentSc.nextLine();

                    Student s = new Student(idAux, name, email, numberStudent, type);
                    u.addStudent(s);
                    break;
                case "3":
                    u.printAllStudent();
                    Scanner studentScApagar = new Scanner(System.in);
                    System.out.println("Selecione um numberStudent para APAGAR da ST");
                    Integer nStudent = Integer.parseInt(studentScApagar.nextLine());
                    Student sApagar = u.removeStudent(nStudent);

                    h.archiveStudent(u, sApagar);

                    if(sApagar != null)
                    {
                        System.out.println("O Estudante com o Nº " + sApagar.getNumberStudent() + " foi Apagado e Arquivado!");
                    }
                    break;
                case "4":
                    u.printAllStudent();
                    Scanner studentScEdit = new Scanner(System.in);
                    System.out.println("Selecione um numberStudent para EDITAR");
                    Integer numStudent = Integer.parseInt(studentScEdit.nextLine());
                    u.editStudent(numStudent);
                    System.out.println("Editado com Sucesso");
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuCourseUnit(University u, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Unidade Curriculares <-----\n");
            System.out.println(" [1] -> Listar Unidade Curriculares");
            System.out.println(" [2] -> Criar Unidade Curricular");
            System.out.println(" [3] -> Eliminar Unidade Curricular");
            System.out.println(" [4] -> Editar Unidade Curricular");
            System.out.println(" [5] -> Turmas");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    u.printAllCourseUnit();
                    break;
                case "2":
                    Scanner cuSc = new Scanner(System.in);
                    int idAux = 0;

                    for(Integer id: u.getCourseUnitsST().keys())
                    {
                        CourseUnit cu = u.getCourseUnitsST().get(id);

                        if(cu.getId() > idAux)
                        {
                            idAux = cu.getId();
                        }
                    }
                    idAux += 1;
                    System.out.println("id = " + idAux);

                    System.out.println("\t\t -----> Inserir Course Unit <-----\n");
                    System.out.println("Nome: ");
                    String name = cuSc.nextLine();
                    System.out.println("Ects: ");
                    Integer ects = Integer.parseInt(cuSc.nextLine());

                    CourseUnit cu = new CourseUnit(idAux, name, ects);

                    u.addCourseUnit(cu);
                    break;
                case "3":
                    u.printAllCourseUnit();
                    Scanner cuScApagar = new Scanner(System.in);
                    System.out.println("Selecione um id para APAGAR da ST");
                    Integer id = Integer.parseInt(cuScApagar.nextLine());
                    CourseUnit cuApagar = u.removeCourseUnit(id);

                    for(String nome : cuApagar.getClassesST().keys())
                    {
                        Class cApagar = cuApagar.getClassesST().get(nome);

                        Class Capagar = cuApagar.removeClass(cApagar.getName());

                        h.archiveClass(cuApagar, Capagar);

                        if(Capagar != null)
                        {
                            System.out.println("O Class com o nome " + Capagar.getName() + " foi Apagado e Arquivado!");
                        }

                        for(Date date: Capagar.getScheduleClassesST().keys())
                        {
                            ScheduleClass scApagar = Capagar.getScheduleClassesST().get(date);

                            ScheduleClass sCapagar = Capagar.removeScheduleClass(scApagar.getStartDate());

                            h.archiveScheduleClass(Capagar, sCapagar);

                            if(sCapagar != null)
                            {
                                System.out.println("O ScheduleClass com a Data Inicial =  " + sCapagar.getStartDate() + " foi Apagado e Arquivado!");
                            }
                        }
                    }

                    h.archiveCourse(u, cuApagar);

                    if(cuApagar != null)
                    {
                        System.out.println("O CourseUnit com o id " + cuApagar.getId() + " foi Apagado e Arquivado!");
                    }
                    break;
                case "4":
                    u.printAllCourseUnit();
                    Scanner cuScEdit = new Scanner(System.in);
                    System.out.println("Selecione um id para Editar da ST");
                    Integer idCu = Integer.parseInt(cuScEdit.nextLine());
                    u.editCourseUnit(idCu);
                    System.out.println("Editado com Sucesso");
                    break;
                case "5":
                    if(u.getCourseUnitsST().size() <= 0)
                    {
                        System.out.println("Tem de adiocinar primeiro uma Turma");
                        break;
                    }
                    u.printAllCourseUnit();
                    Scanner cuMenuClass = new Scanner(System.in);
                    System.out.println("Selecione um id para o menu Turmas");
                    Integer idCuMenu = Integer.parseInt(cuMenuClass.nextLine());
                    CourseUnit cuMenu = u.getCourseUnitsST().get(idCuMenu);
                    menuTurmas(u, cuMenu, h);
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuTurmas(University u, CourseUnit cu, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Turmas <-----\n");
            System.out.println(" [1] -> Listar Turmas");
            System.out.println(" [2] -> Criar Turma");
            System.out.println(" [3] -> Eliminar Turma");
            System.out.println(" [4] -> Editar Turma");
            System.out.println(" [5] -> Horarios das Turmas");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    cu.printAllClass();
                    break;
                case "2":
                    Scanner cSc = new Scanner(System.in);
                    int idAux = 0;

                    for(String name: cu.getClassesST().keys())
                    {
                        Class c = cu.getClassesST().get(name);

                        if(c.getId() > idAux)
                        {
                            idAux = c.getId();
                        }
                    }
                    idAux += 1;
                    System.out.println("id = " + idAux);

                    System.out.println("\t\t -----> Inserir Turma <-----\n");
                    System.out.println("Nome: ");
                    String name = cSc.nextLine();
                    System.out.println("Tipo (Noturno/Diurno): ");
                    String type = cSc.nextLine();

                    u.printAllTeacher();
                    System.out.println("Escolha o email do professor: ");
                    String email = cSc.nextLine();

                    while(u.validTeacher(email))
                    {
                        System.out.println("o email não existe");
                        System.out.println("Escolha o email do professor: ");
                        email = cSc.nextLine();
                    }

                    Teacher t = u.getTeachersST().get(email);

                    u.printAllCourseUnit();
                    System.out.println("Escolha o id do CourseUnit: ");
                    Integer idCu = Integer.parseInt(cSc.nextLine());

                    while(u.validCourseUnit(idCu))
                    {
                        System.out.println("o id não existe");
                        System.out.println("Escolha o id do CourseUnit: ");
                        idCu = Integer.parseInt(cSc.nextLine());
                    }

                    CourseUnit cuC = u.getCourseUnitsST().get(idCu);

                    Class c = new Class(idAux, name, type, t, cuC);

                    cu.addClass(c);
                    break;
                case "3":
                    cu.printAllClass();
                    Scanner cScApagar = new Scanner(System.in);
                    System.out.println("Selecione um nome para APAGAR da ST");
                    String nameC = cScApagar.nextLine();
                    Class cApagar = cu.removeClass(nameC);

                    h.archiveClass(cu, cApagar);

                    for(Date date: cApagar.getScheduleClassesST().keys())
                    {
                        ScheduleClass scApagar = cApagar.getScheduleClassesST().get(date);

                        ScheduleClass sCapagar = cApagar.removeScheduleClass(scApagar.getStartDate());

                        h.archiveScheduleClass(cApagar, sCapagar);

                        if(sCapagar != null)
                        {
                            System.out.println("O ScheduleClass com a Data Inicial =  " + sCapagar.getStartDate() + " foi Apagado e Arquivado!");
                        }
                    }

                    if(cApagar != null)
                    {
                        System.out.println("A Class com o nome " + cApagar.getName() + " foi Apagada e Arquivado!");
                    }
                    break;
                case "4":
                    cu.printAllClass();
                    Scanner cScEdit = new Scanner(System.in);
                    System.out.println("Selecione um nome para Editar da ST");
                    String nameE = cScEdit.nextLine();
                    cu.editClass(u, nameE);
                    System.out.println("Editado com Sucesso");
                    break;
                case "5":
                    if(u.getClassesST().size() <= 0)
                    {
                        System.out.println("Tem de adiocinar primeiro uma Turma");
                        break;
                    }
                    cu.printAllClass();
                    Scanner cMenuClass = new Scanner(System.in);
                    System.out.println("Selecione um nome para o Menu Horário Turmas");
                    String nameCr = cMenuClass.nextLine();
                    Class cM = cu.getClassesST().get(nameCr);
                    menuHorarioTurmas(u, cu, cM, h);
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuHorarioTurmas(University u, CourseUnit cu, Class c, History h)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Horário(s) Turma <-----\n");
            System.out.println(" [1] -> Listar Horário(s) Turma");
            System.out.println(" [2] -> Criar Horário Turma");
            System.out.println(" [3] -> Eliminar Horário Turma");
            System.out.println(" [4] -> Editar Horário Turma");
            System.out.println(" [V] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    c.printAllScheduleClass();
                    break;
                case "2":
                    Scanner chSc = new Scanner(System.in);
                    System.out.println("\t\t -----> Inserir Horario Turma <-----\n");

                    System.out.println("Inserir Data Inicial (Dia da semana/hora/minutos)");
                    String stDate = chSc.nextLine();

                    String[] split1 =  stDate.split("/");
                    int stdayOfWeek = Integer.parseInt(split1[0]);
                    int sthour = Integer.parseInt(split1[1]);
                    int stmin = Integer.parseInt(split1[2]);
                    Date startDate = new Date(sthour, stmin, stdayOfWeek);


                    System.out.println("Inserir Data Final (Dia da semana/hora/minutos)");
                    String flDate = chSc.nextLine();

                    String[] split2 =  flDate.split("/");
                    int fldayOfWeek = Integer.parseInt(split2[0]);
                    int flhour = Integer.parseInt(split2[1]);
                    int flmin = Integer.parseInt(split2[2]);
                    Date finalDate = new Date(flhour, flmin, fldayOfWeek);

                    cu.printAllClass();
                    System.out.println("Selecione um turma pelo nome");
                    String nome = chSc.nextLine();

                    while(cu.validClass(nome))
                    {
                        System.out.println("O nome da turma não existe!");
                        System.out.println("Selecione um turma pelo nome");
                        nome = chSc.nextLine();
                    }

                    Class cA = cu.getClassesST().get(nome);

                    u.printAllRoom();
                    System.out.println("Selecione um sala pelo numberRoom");
                    String nRoom = chSc.nextLine();

                    while(u.validRoom(nRoom))
                    {
                        System.out.println("O numberRoom da Sala não existe!");
                        System.out.println("Selecione um sala pelo numberRoom");
                        nRoom = chSc.nextLine();
                    }

                    Room rA = u.getRoomST().get(nRoom);

                    ScheduleClass sc = new ScheduleClass(startDate, finalDate, rA, cA);

                    c.addScheduleClass(sc);
                    break;
                case "3":
                    c.printAllScheduleClass();
                    Scanner saScApagar = new Scanner(System.in);
                    System.out.println("Selecione uma Data Inicial (Dia da semana/hora/minutos) para APAGAR da ST");
                    String stDateElim = saScApagar.nextLine();

                    String[] split3 =  stDateElim.split("/");
                    int stdayOfWeekElim = Integer.parseInt(split3[0]);
                    int sthourElim = Integer.parseInt(split3[1]);
                    int stminElim = Integer.parseInt(split3[2]);
                    Date startDateElim = new Date(sthourElim, stminElim, stdayOfWeekElim);

                    ScheduleClass scApagar = c.removeScheduleClass(startDateElim);

                    h.archiveScheduleClass(c, scApagar);

                    if(scApagar != null)
                    {
                        System.out.println("O Horario da class com a Data Inicial " + scApagar.getStartDate() + " foi Apagado e Arquivado!");
                    }

                    break;
                case "4":
                    c.printAllScheduleClass();
                    Scanner saScEdit = new Scanner(System.in);
                    System.out.println("Selecione uma Data Inicial (Dia da semana/hora/minutos) para APAGAR da ST");
                    String stDateEdit = saScEdit.nextLine();

                    String[] split4 =  stDateEdit.split("/");
                    int stdayOfWeekEdit = Integer.parseInt(split4[0]);
                    int sthourEdit = Integer.parseInt(split4[1]);
                    int stminEdit = Integer.parseInt(split4[2]);
                    Date startDateEdit = new Date(sthourEdit, stminEdit, stdayOfWeekEdit);

                    c.editScheduleClass(u, startDateEdit);
                    System.out.println("Editado com sucesso!");
                    break;
                case "v":
                case "V":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public static void menuPesquisas(University u)
    {
        Scanner sca = new Scanner(System.in);
        String op;
        do {
            System.out.println("\t\t -----> Gestão de Informação e Navegação Indoor numa Universidade <-----\n");
            System.out.println(" [1] -> Todas as salas livres num determinado horário");
            System.out.println(" [2] -> Todos os professores de uma unidade curricular");
            System.out.println(" [3] -> Todas as turmas de um professor");
            System.out.println(" [4] -> Todos os horários disponíveis para marcação de atendimento ");
            System.out.println(" [5] -> A ocupação de uma sala entre datas");
            System.out.println(" [6] -> Pesquisas de salas por diferentes critérios (ocupação, número de tomadas, piso)");
            System.out.println(" [7] -> now()");
            System.out.println(" [S] -> SAIR\n");
            System.out.println("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    System.out.println(" [1] -> Todas as salas livres num determinado horário");

                    System.out.println("Inserir Data Inicial (Dia da semana/hora/minutos)");
                    String stDate = sca.nextLine();

                    String[] split1 =  stDate.split("/");
                    int stdayOfWeek = Integer.parseInt(split1[0]);
                    int sthour = Integer.parseInt(split1[1]);
                    int stmin = Integer.parseInt(split1[2]);
                    Date startDate = new Date(sthour, stmin, stdayOfWeek);

                    RedBlackBST<String, Room> rooms = new RedBlackBST<>();
                    rooms = u.searchRoomByDate(startDate);

                    System.out.println("As salas livres neste horário " + startDate + " são:");
                    for (String numberRoom : rooms.keys()) {
                        Room r = rooms.get(numberRoom);
                        System.out.println(r);
                    }

                    break;
                case "2":
                    System.out.println(" [2] -> Todos os professores de uma unidade curricular");

                    u.printAllCourseUnit();

                    System.out.println("Inserir o id do Course Unit");
                    Integer id = Integer.parseInt(sca.nextLine());

                    CourseUnit cu = u.getCourseUnitsST().get(id);
                    SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();
                    teachersST = cu.searchTeacherbyCourseUnit();

                    for (String email : teachersST.keys()) {
                        Teacher t = teachersST.get(email);
                        System.out.println(t);
                    }
                    break;
                case "3":
                    System.out.println(" [3] -> Todas as turmas de um professor");

                    u.printAllTeacher();

                    System.out.println("Inserir o email do Professor");
                    String emailT = sca.nextLine();

                    Teacher t = u.getTeachersST().get(emailT);
                    SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();
                    classesST = t.searchClassByTeacher();

                    for (String nome : classesST.keys()) {
                        Class clas = classesST.get(nome);
                        System.out.println(clas);
                    }
                    break;
                case "4":
                    System.out.println(" [4] -> Todos os horários disponíveis para marcação de atendimento ");

                    u.printAllStudent();
                    System.out.println("Inserir o numberStudent do Estudante");
                    Integer numberStudent = Integer.parseInt(sca.nextLine());

                    Student stu = u.getStudentsST().get(numberStudent);

                    u.printAllTeacher();

                    System.out.println("Inserir o email do Professor");
                    String emailTea = sca.nextLine();

                    Teacher teac = u.getTeachersST().get(emailTea);

                    RedBlackBST<Date, ScheduleAccompaniment> saST = new RedBlackBST<>();

                    saST = stu.searchSaByTeacher(teac);

                    for (Date date : saST.keys()) {
                        ScheduleAccompaniment sa = saST.get(date);
                        System.out.println(sa);
                    }
                    break;
                case "5":
                    System.out.println(" [5] -> A ocupação de uma sala entre datas");

                    System.out.println("Inserir uma Data (Dia da semana/hora/minutos)");
                    String stDateS = sca.nextLine();

                    String[] split3 =  stDateS.split("/");
                    int stdayOfWeekS = Integer.parseInt(split3[0]);
                    int sthourS = Integer.parseInt(split3[1]);
                    int stminS = Integer.parseInt(split3[2]);
                    Date startDateS = new Date(sthourS, stminS, stdayOfWeekS);


                    System.out.println("Inserir outra Data (Dia da semana/hora/minutos)");
                    String flDate = sca.nextLine();

                    String[] split2 =  flDate.split("/");
                    int fldayOfWeek = Integer.parseInt(split2[0]);
                    int flhour = Integer.parseInt(split2[1]);
                    int flmin = Integer.parseInt(split2[2]);
                    Date finalDate = new Date(flhour, flmin, fldayOfWeek);

                    u.printAllRoom();
                    System.out.println("Selecione uma sala pelo numberRoom");
                    String sala = sca.nextLine();

                    Room r = u.getRoomST().get(sala);

                    RedBlackBST<Date, Schedule> sST = new RedBlackBST<>();
                    sST = r.searchLeaveRoomBetweenDates(startDateS, finalDate);

                    for (Date date1 : sST.keys()) {
                        Schedule s = sST.get(date1);
                        System.out.println(s);
                    }

                    break;
                case "6":
                    System.out.println(" [6] -> Pesquisas de salas por diferentes critérios (ocupação, número de tomadas, piso)");

                    System.out.println("Inserir o capacidade da Sala:");
                    Integer capacity = Integer.parseInt(sca.nextLine());

                    System.out.println("Inserir o andar da Sala:");
                    Integer floor = Integer.parseInt(sca.nextLine());

                    System.out.println("Inserir sem tem tomadas ou nao (true ou false) da Sala: ");
                    Boolean socket = Boolean.parseBoolean(sca.nextLine());

                    RedBlackBST<String, Room> roomsAttr = new RedBlackBST<>();
                    roomsAttr = u.searchRoomByAttr(capacity, socket, floor);

                    System.out.println("As salas com os critérios -> capacidade: "+ capacity + " andar: "+ floor + " tomadas: "+ socket);
                    for (String numberRoom : roomsAttr.keys()) {
                        Room r1 = roomsAttr.get(numberRoom);
                        System.out.println(r1);
                    }
                    break;
                case "7":
                    System.out.println(" [7] -> now()");
                    u.now();
                    break;
                case "s":
                case "S":
                    break;
                default:
                    System.out.println("Opcao Errada!!!\n");
            }
        } while (!"s".equals(op) && !"S".equals(op));
    }
}
