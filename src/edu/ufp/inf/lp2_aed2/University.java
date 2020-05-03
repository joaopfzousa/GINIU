package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;
import java.util.Scanner;

public class University {

    private String name;

    //Lista de Room da University - chave é o numberRoom do Room
    private RedBlackBST<String, Room> roomST = new RedBlackBST<>();

    // Lista de Teacher da University - chave é o email do Teacher(email Person)
    private SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();

    // Lista de Students do University - chave é o numberStudent do Student
    private SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

    // Lista de CourseUnit do University - chave é o id do CourseUnit
    private SeparateChainingHashST<Integer, CourseUnit> courseUnitsST = new SeparateChainingHashST<>();

    // Lista de Classes do University - chave é o nome da Class
    private SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();
    

    public University(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Adicionar uma Room na ST
     * @param r Room para adicionar na ST
     */
    public void addRoom(Room r)
    {
        if(this.roomST.contains(r.getNumberRoom()))
        {
            System.out.println("University - addRoom(): Room already exists!!!");
            return;
        }
        this.roomST.put(r.getNumberRoom(), r);
    }

    /**
     * Remover uma Room da ST
     * @param numberRoom
     * @return o Room eliminado
     */
    public Room removeRoom(String numberRoom)
    {
        Room r  = this.roomST.get(numberRoom);

        if(r != null)
        {
            this.roomST.delete(numberRoom);
            return r;
        }
        System.out.println("University - removeRoom(): Room not exists!!!");
        return null;
    }

    /**
     * Editar o Room
     * @param numberRoom
     * @return Room
     */
    public Room editRoom(String numberRoom)
    {
        if(this.roomST.contains(numberRoom))
        {
            Room r = this.roomST.get(numberRoom);
            Scanner sca = new Scanner(System.in);
            String op;
            do {
                System.out.println("\t\t -----> Editar Room <-----\n");
                System.out.println(" [1] -> Alterar Tomadas (true/false)");
                System.out.println(" [2] -> Alterar Capacidade");
                System.out.println(" [V] -> SAIR\n");
                System.out.println("OP: ");
                op = sca.nextLine();
                switch (op) {
                    case "1":
                        System.out.println("Tomadas(true/false): ");
                        Boolean socket = Boolean.parseBoolean(sca.nextLine());
                        r.setSocket(socket);
                        break;
                    case "2":
                        System.out.println("Capacidade: ");
                        Integer capacity = Integer.parseInt(sca.nextLine());
                        r.setCapacity(capacity);
                        break;
                    case "v":
                    case "V":
                        break;
                    default:
                        System.out.println("Opcao Errada!!!\n");
                }
            } while (!"v".equals(op) && !"V".equals(op));
            return r;
        }

        System.out.println("University - editRoom(): numberRoom not exist inside roomST");
        return null;
    }

    /**
     * Procurar um determinado Room na ST
     * @param numberRoom
     * @return Room encontrado
     */
    public Room searchRoom(String numberRoom)
    {
        if(this.roomST.contains(numberRoom))
        {
            Room r = this.roomST.get(numberRoom);
            return r;
        }

        System.out.println("University - searchRoom(): numberRoom not exist inside roomST");
        return null;
    }

    /**
     * Imprimir todos os Room
     */
    public  void printAllRoom()
    {
        for(String tKey: this.roomST.keys())
        {
            Room r = this.roomST.get(tKey);
            System.out.println(r);
        }
    }

    /**
     * Validar a Teacher
     * @param numberRoom
     * @return true se existir, false se nao existir
     */
    public boolean validRoom(String numberRoom)
    {
        for(String number: this.roomST.keys())
        {
            Room r = this.roomST.get(number);

            if(r.getNumberRoom().equals(numberRoom))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adicionar um Teacher na ST
     * @param t Teacher para adicionar a ST
     */
    public void addTeacher(Teacher t)
    {
        if(this.teachersST.contains(t.getEmail()))
        {
            System.out.println("University - addTeacher(): Teacher already exists!!!");
            return;
        }
        this.teachersST.put(t.getEmail(), t);
    }

    /**
     * Remover uma Teacher da ST
     * @param email
     * @return o Teacher eliminado
     */
    public Teacher removeTeacher(String email)
    {
        Teacher t = this.teachersST.get(email);

        if(t != null)
        {
            this.teachersST.delete(email);
            return t;
        }
        System.out.println("University - removeTeacher(): Teacher not exists!!!");
        return null;
    }

    /**
     * Editar o Teacher
     * @param email
     * @return Teacher
     */
    public Teacher editTeacher(String email)
    {
        if(this.teachersST.contains(email))
        {
            Teacher t = this.teachersST.get(email);
            Scanner sca = new Scanner(System.in);
            String op;
            do {
                System.out.println("\t\t -----> Editar Teacher <-----\n");
                System.out.println(" [1] -> Alterar Nome");
                System.out.println(" [2] -> Alterar Email");
                System.out.println(" [V] -> SAIR\n");
                System.out.println("OP: ");
                op = sca.nextLine();
                switch (op) {
                    case "1":
                        System.out.println("Alterar Nome: ");
                        String name = sca.nextLine();
                        t.setName(name);
                        break;
                    case "2":
                        System.out.println("Alterar Email: ");
                        String emailT = sca.nextLine();
                        t.setEmail(emailT);
                        break;
                    case "v":
                    case "V":
                        break;
                    default:
                        System.out.println("Opcao Errada!!!\n");
                }
            } while (!"v".equals(op) && !"V".equals(op));
            return t;
        }
        System.out.println("University - editTeacher(): email not exist inside teachersST");
        return null;
    }

    /**
     * Procurar um determinado Teacher na ST
     * @param email
     * @return Teacher encontrado
     */
    public Teacher searchTeacher(String email)
    {
        if(this.teachersST.contains(email))
        {
            Teacher t = this.teachersST.get(email);
            return t;
        }

        System.out.println("University - searchTeacher(): Id not exist inside teachersST");
        return null;
    }

    /**
     * Imprimir todos os Teacher
     */
    public  void printAllTeacher()
    {
        for(String tKey: this.teachersST.keys())
        {
            Teacher t = this.teachersST.get(tKey);
            System.out.println(t);
        }
    }

    /**
     * Validar a Teacher
     * @param email
     * @return true se existir, false se nao existir
     */
    public boolean validTeacher( String email)
    {
        for(String mail: this.teachersST.keys())
        {
            Teacher t = this.teachersST.get(mail);

            if(t.getEmail().equals(email))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adicionar um Student na ST
     * @param s Student para adicionar na ST
     */
    public void addStudent(Student s)
    {
        if(this.studentsST.contains(s.getNumberStudent())){
            System.out.println("CourseUnit - addStudent(): Student already exists!!!");
            return;
        }
        this.studentsST.put(s.getNumberStudent(), s);
    }

    /**
     * Remover um Student da ST
     * @param numberStudent
     * @return o Student eliminado
     */
    public Student removeStudent(Integer numberStudent)
    {
        Student s = this.studentsST.get(numberStudent);

        if(s != null)
        {
            this.studentsST.delete(numberStudent);
            return s;
        }

        System.out.println("Class - removeStudent(): Student not exists!!!");
        return null;
    }

    /**
     * Editar o Student
     * @param numberStudent
     * @return Student editado
     */
    public Student editStudent(Integer numberStudent)
    {
        if(this.studentsST.contains(numberStudent))
        {
            Student s = this.studentsST.get(numberStudent);
            Scanner sca = new Scanner(System.in);
            String op;
            do {
                System.out.println("\t\t -----> Editar Student <-----\n");
                System.out.println(" [1] -> Alterar Nome");
                System.out.println(" [2] -> Alterar Email");
                System.out.println(" [3] -> Alterar Tipo");
                System.out.println(" [V] -> SAIR\n");
                System.out.println("OP: ");
                op = sca.nextLine();
                switch (op) {
                    case "1":
                        System.out.println("Alterar Nome: ");
                        String name = sca.nextLine();
                        s.setName(name);
                        break;
                    case "2":
                        System.out.println("Alterar Email: ");
                        String emailT = sca.nextLine();
                        s.setEmail(emailT);
                        break;
                    case "3":
                        System.out.println("Alterar Tipo (Noturno/Diurno): ");
                        String tipo = sca.nextLine();
                        s.setType(tipo);
                        break;
                    case "v":
                    case "V":
                        break;
                    default:
                        System.out.println("Opcao Errada!!!\n");
                }
            } while (!"v".equals(op) && !"V".equals(op));
            return s;
        }

        System.out.println("Class - editStudent(): numberStudent not exist inside studentsST");
        return null;
    }

    /**
     * Procurar um determinado Student na ST
     * @param numberStudent
     * @return Student encontrado
     */
    public Student searchStudent(Integer numberStudent)
    {
        if(this.studentsST.contains(numberStudent))
        {
            Student s = this.studentsST.get(numberStudent);

            return s;
        }

        System.out.println("Class - searchStudent(): numberStudent not exist inside studentsST");
        return null;
    }

    /**
     * Imprimir todos os Student
     */
    public void printAllStudent()
    {
        for(Integer cKey: this.studentsST.keys())
        {
            Student s = this.studentsST.get(cKey);
            System.out.println(s);
        }
    }

    /**
     * Validar se exist Student na st
     * @param numberStudent
     * @return true se existir, false se não existir
     */
    public boolean validStudent(Integer numberStudent)
    {
        for(Integer number: this.studentsST.keys())
        {
            Student s = this.studentsST.get(number);

            if(s.getNumberStudent().equals(numberStudent))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adicionar um CourseUnit na ST
     * @param c CourseUnit para adicionar a ST
     */
    public void addCourseUnit(CourseUnit c)
    {
        if(this.courseUnitsST.contains(c.getId())){
            System.out.println("Teacher - addCourseUnit(): CourseUnit already exists!!!");
            return;
        }
        this.courseUnitsST.put(c.getId(), c);
    }

    /**
     * Remover uma CourseUnit da ST
     * @param id
     * @return o CourseUnit eliminado
     */
    public CourseUnit removeCourseUnit(Integer id)
    {
        CourseUnit cu = this.courseUnitsST.get(id);

        if(cu != null)
        {
            this.courseUnitsST.delete(id);
            return cu;
        }
        System.out.println("Teacher - removeCourseUnit(): CourseUnit not exists!!!");
        return null;
    }

    /**
     * Editar o CourseUnit
     * @param id
     * @return CourseUnit editado
     */
    public CourseUnit editCourseUnit(Integer id)
    {
        if(this.courseUnitsST.contains(id))
        {
            CourseUnit cu = this.courseUnitsST.get(id);
            Scanner sca = new Scanner(System.in);
            String op;
            do {
                System.out.println("\t\t -----> Editar CourseUnit <-----\n");
                System.out.println(" [1] -> Alterar Nome");
                System.out.println(" [2] -> Alterar Ects");
                System.out.println(" [V] -> SAIR\n");
                System.out.println("OP: ");
                op = sca.nextLine();
                switch (op) {
                    case "1":
                        System.out.println("Nome: ");
                        String name = sca.nextLine();
                        cu.setName(name);
                        break;
                    case "2":
                        System.out.println("Ects: ");
                        Integer ects = Integer.parseInt(sca.nextLine());
                        cu.setEcts(ects);
                        break;
                    case "v":
                    case "V":
                        break;
                    default:
                        System.out.println("Opcao Errada!!!\n");
                }
            } while (!"v".equals(op) && !"V".equals(op));
            cu.setName("LP3");
            cu.setEcts(9);
            return cu;
        }

        System.out.println("Teacher - editCourseUnit(): Id not exist inside CourseUnitsST");
        return null;
    }

    /**
     * Procurar um determinado CourseUnit na ST
     * @param id
     * @return CourseUnit encontrado
     */
    public CourseUnit searchCourseUnit(Integer id)
    {
        if(this.courseUnitsST.contains(id))
        {
            CourseUnit cu = this.courseUnitsST.get(id);
            return cu;
        }

        System.out.println("Teacher - searchCourseUnit(): Id not exist inside CourseUnitsST");
        return null;
    }

    /**
     * Imprimir todos os CourseUnit
     */
    public void printAllCourseUnit()
    {
        for(Integer cKey: this.courseUnitsST.keys())
        {
            CourseUnit cu = this.courseUnitsST.get(cKey);
            System.out.println(cu);
        }
    }

    /**
     * Valida se existe CourseUnit
     * @param id
     * @return true se exitir, false se não existir
     */
    public boolean validCourseUnit(Integer id)
    {
        for(Integer i: this.courseUnitsST.keys())
        {
            CourseUnit cu = this.courseUnitsST.get(i);

            if(cu.getId().equals(id))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adicionar uma Class na ST
     * @param cl Class para adicionar a ST
     */
    public void addClass(Class cl)
    {
        if(this.classesST.contains(cl.getName())){
            System.out.println("University - addClass(): Class already exists!!!");
            return;
        }
        this.classesST.put(cl.getName(), cl);
    }

    /**
     * Remover uma Class da ST
     * @param name
     * @return o Class eliminado
     */
    public Class removeClass(String name)
    {
        Class cl = this.classesST.get(name);

        if(cl != null)
        {
            this.classesST.delete(name);
            return cl;
        }
        System.out.println("Class - removeClass(): Class not exists!!!");
        return null;
    }

    /**
     * Editar a Class
     * @param name
     * @return Class editada
     */
    public Class searchClass(String name)
    {
        if(this.classesST.contains(name))
        {
            Class cl = this.classesST.get(name);
            return cl;
        }

        System.out.println("Class - searchClass(): Name not exist inside Class");
        return null;
    }

    /**
     * Imprimir todas as Classes
     */
    public void printAllClass()
    {
        for(String tKey: this.classesST.keys())
        {
            Class cl = this.classesST.get(tKey);
            System.out.println(cl);
        }
    }

    /**
     * Valida se existe na Class
     * @param name
     * @return true se exitir, false se não existir
     */
    public boolean validClass(String name)
    {
        for(String i: this.classesST.keys())
        {
            Class cl = this.classesST.get(i);

            if(cl.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Carregar o ficheiro txt da classe Teacher
     * @param path
     */
    public void loadTeacher(String path){
        In in = new In(path);
        while(!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer id = Integer.parseInt(split[0]);
            String name = split[1];
            String email = split[2];

            Teacher t = new Teacher(id, name, email);
            this.teachersST.put(email, t);
        }
    }

    /**
     * Carregar o ficheiro txt da classe Student
     * @param path
     */
    public void loadStudent(String path){
        In in = new In(path);
        while(!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer id = Integer.parseInt(split[0]);
            String name = split[1];
            String email = split[2];
            Integer numberStudent = Integer.parseInt(split[3]);
            String type = split[4];

            Student s = new Student(id, name, email, numberStudent, type);
            this.studentsST.put(numberStudent, s);
        }
    }

    /**
     * Carregar o ficheiro txt da classe Room
     * @param path
     */
    public void loadRoom(String path){
        In in = new In(path);
        while(!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer id = Integer.parseInt(split[0]);
            Integer floor = Integer.parseInt(split[1]);
            String numberRoom = split[2];
            Boolean socket = Boolean.parseBoolean(split[3]);
            Integer capacity = Integer.parseInt(split[4]);

            Room r = new Room(id, floor, numberRoom, socket, capacity);
            this.roomST.put(numberRoom, r);
        }
    }

    /**
     * Carregar o ficheiro txt da classe CourseUnit
     * @param path
     */
    public void loadCourseUnit(String path){
        In in = new In(path);
        while(!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer id = Integer.parseInt(split[0]);
            String name = split[1];
            Integer ects = Integer.parseInt(split[2]);

            CourseUnit cu = new CourseUnit(id, name, ects);
            this.courseUnitsST.put(id, cu);
        }
    }

    /**
     * Carregar o ficheiro txt da classe Class
     * @param path
     */
    public void loadClass(String path){
        In in = new In(path);
        while(!in.isEmpty()){
            String[] split = in.readLine().split(";");
            Integer id = Integer.parseInt(split[0]);
            String name = split[1];
            String type = split[2];
            String email = split[3];
            Teacher t = this.teachersST.get(email);
            Integer courseId = Integer.parseInt(split[4]);
            CourseUnit cu = this.courseUnitsST.get(courseId);

            Class c = new Class(id, name, type, t, cu);
            cu.addClass(c);
            t.getClassesST().put(c.getName(), c);
            this.classesST.put(name, c);
        }
    }

    /**
     * Guardar no ficheiro txt da classe Teacher
     * @param path
     * @return
     */
    public String saveTeacher(String path){
        Out o = new Out(path);
        for(String email : this.teachersST.keys()){
            Teacher t = teachersST.get(email);
            o.println(t.toStringFileTeacher());
        }
        return "Saved Teacher on TXT";
    }

    /**
     * Guardar no ficheiro txt da classe Student
     * @param path
     * @return
     */
    public String saveStudent(String path){
        Out o = new Out(path);
        for(Integer numberStudent : this.studentsST.keys()){
            Student s = studentsST.get(numberStudent);
            o.println(s.toStringFileStudent());
        }
        return "Saved Student on TXT";
    }

    /**
     * Guardar no ficheiro txt da classe Room
     * @param path
     * @return
     */
    public String saveRoom(String path){
        Out o = new Out(path);
        for(String numberRoom : this.roomST.keys()){
            Room r = roomST.get(numberRoom);
            o.println(r.toStringFileRoom());
        }
        return "Saved Room on TXT";
    }

    /**
     * Guardar no ficheiro txt da classe CourseUnit
     * @param path
     * @return
     */
    public String saveCourseUnit(String  path){
        Out o = new Out(path);
        for(Integer id : this.courseUnitsST.keys()){
            CourseUnit cu = courseUnitsST.get(id);
            o.println(cu.toStringFileCourseUnit());
        }
        return "Saved CourseUnit on TXT";
    }

    /**
     * Guardar no ficheiro txt da classe Class
     * @param path
     * @return
     */
    public String saveClass(String  path){
        Out o = new Out(path);
        for(String name : this.classesST.keys()){
            Class cl = classesST.get(name);
            o.println(cl.toStringFileClass());
        }
        return "Saved Class on TXT";
    }

    /**
     * Pesquisar todas as salas que não estão ocupadas num horário
     * @param dinicio
     * @return as salas que não estão ocupadas num horario
     */
    public RedBlackBST<String, Room> searchRoomByDate(Date dinicio){
        RedBlackBST<String, Room> res = new RedBlackBST<>();
        ArrayList<Room> used = new ArrayList<>();

        RedBlackBST<Date, ScheduleClass> scheduleClassesST = new RedBlackBST<>();
        RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentST = new RedBlackBST<>();

        for(String aux : this.roomST.keys()){
            Room r = this.roomST.get(aux);
            //System.out.println(r);

            scheduleClassesST = r.getScheduleClassesST();
            scheduleAccompanimentST = r.getScheduleAccompanimentST();

            for(Date dinit: scheduleClassesST.keys())
            {
                ScheduleClass sc = scheduleClassesST.get(dinit);
                //System.out.println(sc);
                System.out.println(r.getNumberRoom() + " sc.getStartDate().compareTo(dinicio) = " + sc.getStartDate().compareTo(dinicio));

                if(sc.getStartDate().compareTo(dinicio) != 0){
                    System.out.println("!res.contains(sc.getRoom()) = " + !res.contains(sc.getRoom().getNumberRoom()));

                    if(!res.contains(sc.getRoom().getNumberRoom()) && !used.contains(sc.getRoom()))
                        res.put(sc.getRoom().getNumberRoom(), sc.getRoom());
                }else{
                    used.add(sc.getRoom());
                }
            }

            for(Date dinicial: scheduleAccompanimentST.keys())
            {
                ScheduleAccompaniment sa = scheduleAccompanimentST.get(dinicial);
                //System.out.println(sa);
                System.out.println(r.getNumberRoom() + " sa.getStartDate().compareTo(dinicio) =" + sa.getStartDate().compareTo(dinicio));
                if(sa.getStartDate().compareTo(dinicio) != 0){
                    System.out.println("!res.contains(sa.getRoom()) = " + !res.contains(sa.getRoom().getNumberRoom()));
                    if(!res.contains(sa.getRoom().getNumberRoom()) && !used.contains(sa.getRoom()) )
                        res.put(sa.getRoom().getNumberRoom(), sa.getRoom());
                }else{
                    used.add(sa.getRoom());
                }
            }
        }
        return res;
    }

    /**
     * Procurar Salas pelos diversos atibutos passados
     * @param capacity
     * @param socket
     * @param floor
     * @return as salas disponiveis com os atributos
     */
    public RedBlackBST<String, Room> searchRoomByAttr(Integer capacity, boolean socket, Integer floor)
    {
        RedBlackBST<String, Room> rooms = new RedBlackBST<>();

        for(String numberRoom: this.getRoomST().keys())
        {
            Room r = this.getRoomST().get(numberRoom);

            if(r.getCapacity() == capacity && !rooms.contains(r.getNumberRoom()))
            {
                if(r.isSocket() == socket && !rooms.contains(r.getNumberRoom()))
                {
                    if(r.getFloor()== floor && !rooms.contains(r.getNumberRoom()))
                    {
                        rooms.put(r.getNumberRoom(), r);
                    }
                }
            }
        }
        return rooms;
    }

    /**
     * Tudo o que está a acontecer na faculdade neste momento
     */
    public void now()
    {
        SeparateChainingHashST<String, Teacher> teachersSTUsed = new SeparateChainingHashST<>();

        SeparateChainingHashST<String, Teacher> teachersSTUnused = new SeparateChainingHashST<>();

        SeparateChainingHashST<String, Class> classesSTUsed = new SeparateChainingHashST<>();

        SeparateChainingHashST<String, Class> classesSTUnused = new SeparateChainingHashST<>();

        RedBlackBST<String, Room> roomSTUsed = new RedBlackBST<>();

        RedBlackBST<String, Room> roomSTUnused = new RedBlackBST<>();

        SeparateChainingHashST<Integer, CourseUnit> courseUnitsSTUsed = new SeparateChainingHashST<>();

        SeparateChainingHashST<Integer, CourseUnit> courseUnitsSTUnused = new SeparateChainingHashST<>();

        Date now = new Date();

        for(String name : this.teachersST.keys())
        {
            Teacher t = this.teachersST.get(name);

            for(Date d : t.getScheduleAccompanimentsST().keys())
            {
                ScheduleAccompaniment sa = t.getScheduleAccompanimentsST().get(d);

                if(sa.getStartDate().getDayOfWeekInt() >= now.getDayOfWeekInt() && sa.getFinalDate().getDayOfWeekInt() <= now.getDayOfWeekInt() &&
                sa.getStartDate().getHour() >= now.getHour() && sa.getFinalDate().getHour() <= now.getHour() &&
                sa.getStartDate().getMinute() >= now.getHour() && sa.getFinalDate().getHour() <= now.getMinute())
                {
                    teachersSTUsed.put(t.getEmail(), t);
                    roomSTUsed.put(sa.getRoom().getNumberRoom(), sa.getRoom());
                }else{
                    teachersSTUnused.put(t.getEmail(), t);
                    roomSTUnused.put(sa.getRoom().getNumberRoom(), sa.getRoom());
                }
            }
        }

        for(String name : this.classesST.keys())
        {
            Class c = this.classesST.get(name);

            for(Date d1: c.getScheduleClassesST().keys())
            {
                ScheduleClass sc = c.getScheduleClassesST().get(d1);

                if(sc.getStartDate().getDayOfWeekInt() >= now.getDayOfWeekInt() && sc.getFinalDate().getDayOfWeekInt() <= now.getDayOfWeekInt() &&
                        sc.getStartDate().getHour() >= now.getHour() && sc.getFinalDate().getHour() <= now.getHour() &&
                        sc.getStartDate().getMinute() >= now.getHour() && sc.getFinalDate().getHour() <= now.getMinute())
                {
                    classesSTUsed.put(c.getName(), c);
                    courseUnitsSTUsed.put(c.getCourse().getId(), c.getCourse());
                    teachersSTUsed.put(c.getTeacher().getEmail(), c.getTeacher());
                    roomSTUsed.put(sc.getRoom().getNumberRoom(), sc.getRoom());

                }else{
                    classesSTUnused.put(c.getName(), c);
                    courseUnitsSTUnused.put(c.getCourse().getId(), c.getCourse());
                    teachersSTUnused.put(c.getTeacher().getEmail(), c.getTeacher());
                    roomSTUnused.put(sc.getRoom().getNumberRoom(), sc.getRoom());
                }
            }
        }

        System.out.println("Professores ocupados:");
        for(String email: teachersSTUsed.keys())
        {
            Teacher tUsed = teachersSTUsed.get(email);
            System.out.println(tUsed);
        }

        System.out.println("Professores que não estão ocupados:");
        for(String email: teachersSTUnused.keys())
        {
            Teacher tUsed = teachersSTUnused.get(email);
            System.out.println(tUsed);
        }

        System.out.println("Unidades curriculares a ter aulas:");
        for(Integer id: courseUnitsSTUsed.keys())
        {
            CourseUnit cuUsed = courseUnitsSTUsed.get(id);
            System.out.println(cuUsed);
        }

        System.out.println("Turmas a ter aulas:");
        for(String email: classesSTUsed.keys())
        {
            Class cUsed = classesSTUsed.get(email);
            System.out.println(cUsed);
        }

        System.out.println("Salas ocupadas:");
        for(String numberRoom: roomSTUsed.keys())
        {
            Room rUsed = roomSTUsed.get(numberRoom);
            System.out.println(rUsed);
        }

        System.out.println("Salas que não estão ocupadas:");
        for(String numberRoom: roomSTUnused.keys())
        {
            Room rUnused = roomSTUnused.get(numberRoom);
            System.out.println(rUnused);
        }
    }

    /**
     * Get's and Set's
     */
    public RedBlackBST<String, Room> getRoomST() {
        return roomST;
    }

    public void setRoomST(RedBlackBST<String, Room> roomST) {
        this.roomST = roomST;
    }

    public SeparateChainingHashST<String, Teacher> getTeachersST() {
        return teachersST;
    }

    public void setTeachersST(SeparateChainingHashST<String, Teacher> teachersST) {
        this.teachersST = teachersST;
    }

    public SeparateChainingHashST<Integer, Student> getStudentsST() {
        return studentsST;
    }

    public void setStudentsST(SeparateChainingHashST<Integer, Student> studentsST) {
        this.studentsST = studentsST;
    }

    public SeparateChainingHashST<Integer, CourseUnit> getCourseUnitsST() {
        return courseUnitsST;
    }

    public void setCourseUnitsST(SeparateChainingHashST<Integer, CourseUnit> courseUnitsST) {
        this.courseUnitsST = courseUnitsST;
    }

    public SeparateChainingHashST<String, Class> getClassesST() {
        return classesST;
    }

    public void setClassesST(SeparateChainingHashST<String, Class> classesST) {
        this.classesST = classesST;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
