package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

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

            r.setCapacity(300);
            r.setSocket(false);
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

            t.setName("Beatriz Gomes");

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

            s.setName("João Sousa");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
