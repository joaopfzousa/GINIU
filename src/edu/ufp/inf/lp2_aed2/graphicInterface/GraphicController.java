package edu.ufp.inf.lp2_aed2.graphicInterface;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.ufp.inf.lp2_aed2.*;
import edu.ufp.inf.lp2_aed2.Class;
import edu.ufp.inf.lp2_aed2.points.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GraphicController implements Initializable {

    private University university;
    private GraphMap graphMap;
    private static final String PATH_UNIVERSITY_READSAVE = "./data/bin/UniversityBin.bin";
    private static final String PATH_SEARCHSTUDENTCLASS_SAVE = "./data/search/StudentClass";
    private static final String PATH_SEARCHFREEROOMS_SAVE = "./data/search/FreeRooms";
    private static final String PATH_SEARCHTEACHERBYCU_SAVE = "./data/search/TeacherbyCourse";
    private static final String PATH_SEARCHCLASSTEACHER_SAVE = "./data/search/ClassbyTeacher";
    private static final String PATH_SEARCHSA_SAVE = "./data/search/SA";
    private static final String PATH_SEARCHFREEBD_SAVE = "./data/search/freeBD";
    private static final String PATH_SEARCHNOW_SAVE = "./data/search/Now";
    private double radius = 10;

    /**
     * Room
     */
    public TableView<Room> roomTable;
    public TableColumn<Room, Integer> idRoomCol;
    public TableColumn<Room, Integer> floorCol;
    public TableColumn<Room, String> numberRoomCol;
    public TableColumn<Room, Boolean> socketCol;
    public TableColumn<Room, Integer> capacityCol;
    public TableColumn<Room, Point> pointCol;

    public TextField idRoomField;
    public TextField floorField;
    public TextField numberRoomField;
    public TextField socketField;
    public TextField capacityField;
    public TextField pointField;

    /**
     * Teacher
     */
    public TableView<Teacher> teacherTable;
    public TableColumn<Teacher, Integer> idTeacherCol;
    public TableColumn<Teacher, String> nameTeacherCol;
    public TableColumn<Teacher, String> emailTeacherCol;

    public TextField idTeacherField;
    public TextField nameTeacherField;
    public TextField emailTeacherField;

    /**
     * ScheduleAccompaniment
     */
    public TableView<ScheduleAccompaniment> SATable;
    public TableColumn<ScheduleAccompaniment, Date> startDateSACol;
    public TableColumn<ScheduleAccompaniment, Date> finalDateSACol;
    public TableColumn<ScheduleAccompaniment, Room> roomSACol;
    public TableColumn<ScheduleAccompaniment, Teacher> teacherSACol;

    public TextField startDateSAField;
    public TextField finalDateSAField;
    public ComboBox<String> roomSaCombo;
    public ComboBox<String> teacherSACombo;

    /**
     * Student
     */
    public TableView<Student> studentTable;
    public TableColumn<Student, Integer> idStudentCol;
    public TableColumn<Student, String> nameStudentCol;
    public TableColumn<Student, String> emailStudentCol;
    public TableColumn<Student, Integer> numberStudentCol;
    public TableColumn<Student, String> typeStudentCol;

    public TextField idStudentField;
    public TextField nameStudentField;
    public TextField emailStudentField;
    public TextField numberStudentField;
    public TextField typeStudentField;

    /**
     * CourseUnit
     */
    public TableView<CourseUnit> CourseUnitTable;
    public TableColumn<CourseUnit, Integer> idCourseUnitCol;
    public TableColumn<CourseUnit, String> nameCourseUnitCol;
    public TableColumn<CourseUnit, Integer> ectsCol;
    public TextField idCourseUnitField;
    public TextField nameCourseUnitField;
    public TextField ectsField;

    /**
     * Class
     */
    public TableView<Class> ClassTable;
    public TableColumn<Class, Integer> idClassCol;
    public TableColumn<Class, String> nameClassCol;
    public TableColumn<Class, String> typeClassCol;
    public TableColumn<Class, Teacher> teacherClassCol;
    public TableColumn<Class, CourseUnit> courseUnitClassCol;
    public TextField idClassField;
    public TextField nameClassField;
    public TextField typeClassField;
    public ComboBox<String> teacherFieldCombo;
    public ComboBox<Integer> courseFieldCombo;

    /**
     * ScheduleClass
     */
    public TableView<ScheduleClass> SCTable;
    public TableColumn<ScheduleClass, Date> startDateSCCol;
    public TableColumn<ScheduleClass, Date> finalDateSCCol;
    public TableColumn<ScheduleClass, Room> roomSCCol;
    public TableColumn<ScheduleClass, Class> ClassSCCol;
    public TextField startDateSCField;
    public TextField finalDateSCField;
    public ComboBox<String> roomSCCombo;
    public ComboBox<String> classSCCombo;

    /**
     * Point3D
     */
    public TableView<Point3D> Point3DTable;
    public TableColumn<Point3D, Double> XCol;
    public TableColumn<Point3D, Double> YCol;
    public TableColumn<Point3D, Integer> ZCol;
    public TableColumn<Point3D, Boolean> IndoorCol;
    public TableColumn<Point3D, String> DescriprionPointCol;
    public TableColumn<Point3D, Integer> idPointCol;
    public TextField XPointField;
    public TextField YPointField;
    public TextField ZPointField;
    public TextField indoorPointField;
    public TextField descriptionPointField;

    /**
     * Edges
     */
    public TableView<Edge_Project> EdgesTable;
    public TableColumn<Edge_Project, Integer> vEdgeCol;
    public TableColumn<Edge_Project, Integer> WEdgeCol;
    public TableColumn<Edge_Project, Double> weightEdgeCol;
    public TableColumn<Edge_Project, Double> tempEdgeCol;
    public TableColumn<Edge_Project, Boolean> senseEdgeCol;

    public TextField VEdgeField;
    public TextField WEdgesField;
    public TextField senseEdgeField;

    /**
     * Graphs
     */
    public Group graphUniGroup;
    public ComboBox<String> floorsComboBox;

    /**
     * Search's
     */
    //Student Class
    public ComboBox<String> studentsSeacrhComboBox;
    public TextArea studentClassSearchTextArea;

    //free rooms
    public TextField dateFieldSearch;
    public TextArea freeRoomSearchTextArea;

    //Teacher by Course Unit
    public ComboBox<Integer> CUSearchComboBox;
    public TextArea searchTeacherbyCUSearchTextArea;

    //Class by Teacher
    public ComboBox<String> teacherSearchComboBox;
    public TextArea searchClassByTeacherSearchTextArea;

    //Horário de Atendimento
    public ComboBox<Integer> studentSASearchComboBox;
    public ComboBox<String> teacherSASearchComboBox;
    public TextArea searchSASearchTextArea;

    //free rooms between dates
    public TextField dateinitFieldSearch;
    public TextField datefinalFieldSearch;
    public ComboBox<String> salasBDComboBox;
    public TextArea freeRoomBDSearchTextArea;

    //now
    public TextArea nowSearchTextArea;

    //Graphs - Point - to - Point
    public ComboBox<String> floorsSearchComboBox;
    public ComboBox<String> point1ComboBox;
    public ComboBox<String> point2ComboBox;
    public RadioButton tempRadioButton;
    public RadioButton distanceRadioButton;
    public TextArea PointToPointTextArea;

    //Graphs - Emergency
    public ComboBox<String> pointEmergencyComboBox;
    public RadioButton tempEmergencyRadioButton;
    public RadioButton distanceEmergencyRadioButton;
    public TextArea emergencyTextArea;

    //Graphs - Avoid Points
    public ComboBox<String> pointavoidComboBox;
    public ComboBox<String> pointavoidInitComboBox;
    public ComboBox<String> point2avoidInitComboBox;
    public TextArea avoidPointsTextArea;
    public TableView<Point3D> avoidTable;
    public TableColumn<Point3D, Integer> idAvoidCol;
    public TableColumn<Point3D, Double> xAvoidCol;
    public TableColumn<Point3D, Double> yAvoidCol;
    public TableColumn<Point3D, Integer> zAvoidCol;
    public TableColumn<Point3D, Boolean> indoorAvoidCol;
    public TableColumn<Point3D, String> descriptionAvoidCol;

    //Graphs - Emergency Person
    public TextField personPointField;
    public RadioButton tempEmergencyPersonRadioButton;
    public RadioButton distanceEmergencyPersonRadioButton;
    public TextArea emergencyPersonTextArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.university = new University("UFP");
        this.graphMap = new GraphMap(this.university);
        
        /**
         * Room
         */
        idRoomCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        floorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
        numberRoomCol.setCellValueFactory(new PropertyValueFactory<>("numberRoom"));
        socketCol.setCellValueFactory(new PropertyValueFactory<>("socket"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        pointCol.setCellValueFactory(new PropertyValueFactory<>("point"));

        idRoomCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        floorCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        numberRoomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        socketCol.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        capacityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));


        /**
         * Teacher
         */
        idTeacherCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTeacherCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailTeacherCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        idTeacherCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nameTeacherCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailTeacherCol.setCellFactory(TextFieldTableCell.forTableColumn());

        /**
         * ScheduleAccompaniment
         */
        startDateSACol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        finalDateSACol.setCellValueFactory(new PropertyValueFactory<>("finalDate"));
        roomSACol.setCellValueFactory(new PropertyValueFactory<>("room"));
        teacherSACol.setCellValueFactory(new PropertyValueFactory<>("teacher"));


        /**
         * Student
         */
        idStudentCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameStudentCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailStudentCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        numberStudentCol.setCellValueFactory(new PropertyValueFactory<>("numberStudent"));
        typeStudentCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        idStudentCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nameStudentCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailStudentCol.setCellFactory(TextFieldTableCell.forTableColumn());
        numberStudentCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        typeStudentCol.setCellFactory(TextFieldTableCell.forTableColumn());
        

        /**
         * CourseUnit
         */
        idCourseUnitCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCourseUnitCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ectsCol.setCellValueFactory(new PropertyValueFactory<>("ects"));

        idCourseUnitCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nameCourseUnitCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ectsCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        /**
         * Class
         */
        idClassCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameClassCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeClassCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        teacherClassCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        courseUnitClassCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        idClassCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nameClassCol.setCellFactory(TextFieldTableCell.forTableColumn());
        typeClassCol.setCellFactory(TextFieldTableCell.forTableColumn());

        /**
         * ScheduleClass
         */
        startDateSCCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        finalDateSCCol.setCellValueFactory(new PropertyValueFactory<>("finalDate"));
        roomSCCol.setCellValueFactory(new PropertyValueFactory<>("room"));
        ClassSCCol.setCellValueFactory(new PropertyValueFactory<>("classe"));

        /**
         * Point3D
         */
        XCol.setCellValueFactory(new PropertyValueFactory<>("x"));
        YCol.setCellValueFactory(new PropertyValueFactory<>("y"));
        ZCol.setCellValueFactory(new PropertyValueFactory<>("z"));
        IndoorCol.setCellValueFactory(new PropertyValueFactory<>("indoor"));
        idPointCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        DescriprionPointCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        /**
         * Edges
         */
        vEdgeCol.setCellValueFactory(new PropertyValueFactory<>("v"));
        WEdgeCol.setCellValueFactory(new PropertyValueFactory<>("w"));
        weightEdgeCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tempEdgeCol.setCellValueFactory(new PropertyValueFactory<>("temp"));
        senseEdgeCol.setCellValueFactory(new PropertyValueFactory<>("direction"));

        /**
         * Avoid Points
         */
        xAvoidCol.setCellValueFactory(new PropertyValueFactory<>("x"));
        yAvoidCol.setCellValueFactory(new PropertyValueFactory<>("y"));
        zAvoidCol.setCellValueFactory(new PropertyValueFactory<>("z"));
        indoorAvoidCol.setCellValueFactory(new PropertyValueFactory<>("indoor"));
        idAvoidCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        descriptionAvoidCol.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    public void handleReadTextFileAction(ActionEvent actionEvent) {
        roomTable.getItems().clear();

        university.loadRoom("./data/Room");
        graphMap.loadPoints3DRoom();
        for(String r: university.getRoomST().keys())
        {
            Room room = university.getRoomST().get(r);
            roomTable.getItems().add(room);
        }
        addRoomsToComboBoxs(university.getRoomST());

        teacherTable.getItems().clear();
        SATable.getItems().clear();
        university.loadTeacher("./data/Teacher");
        Teacher.loadScheduleAccompaniment(university, "./data/TeacherScheduleAccompaniment");

        Teacher teacher = null;
        for(String t: university.getTeachersST().keys())
        {
            teacher = university.getTeachersST().get(t);
            teacherTable.getItems().add(teacher);

            for(Date d: teacher.getScheduleAccompanimentsST().keys())
            {
                ScheduleAccompaniment sa = teacher.getScheduleAccompanimentsST().get(d);
                SATable.getItems().add(sa);
            }
        }
        addTeacherToComboBoxs(university.getTeachersST());

        studentTable.getItems().clear();
        university.loadStudent("./data/Student");
        Student student = null;
        for(Integer s: university.getStudentsST().keys())
        {
            student = university.getStudentsST().get(s);
            studentTable.getItems().add(student);
        }

        addStudentsToComboBoxs(university.getStudentsST());

        CourseUnitTable.getItems().clear();
        university.loadCourseUnit("./data/CourseUnit");
        CourseUnit courseUnit = null;
        for(Integer cu: university.getCourseUnitsST().keys())
        {
            courseUnit = university.getCourseUnitsST().get(cu);
            CourseUnitTable.getItems().add(courseUnit);
        }
        addCourseToComboBoxs(university.getCourseUnitsST());

        ClassTable.getItems().clear();
        SCTable.getItems().clear();
        university.loadClass("./data/Class");
        Class.loadScheduleClass(university, "./data/ScheduleClass");
        Class classe = null;
        for(String cl: university.getClassesST().keys())
        {
            classe = university.getClassesST().get(cl);
            ClassTable.getItems().add(classe);

            for(Date d: classe.getScheduleClassesST().keys())
            {
                ScheduleClass sc = classe.getScheduleClassesST().get(d);
                SCTable.getItems().add(sc);
            }

        }

        addClassToComboBoxs(university.getClassesST());

        Student.loadStudentCourse(university, "./data/StudentCourse");

        Point3DTable.getItems().clear();
        EdgesTable.getItems().clear();
        graphMap.loadPoints3D();
        Point3DTable.getItems().addAll(graphMap.getPoints3D());

        graphMap.loadDirectedEdge();
        graphMap.loadDirectedEdgeRoom();
        EdgesTable.getItems().addAll(graphMap.getArrayLisDirectedEdge());

        floorsComboBox.getItems().clear();
        updateFloorComboBox();
    }

    public void handleReadBinFileAction(ActionEvent actionEvent) {
        readFromBinFileUniversitary();
        roomTable.getItems().clear();

        for(String r: university.getRoomST().keys())
        {
            Room room = university.getRoomST().get(r);
            roomTable.getItems().add(room);
        }
        addRoomsToComboBoxs(university.getRoomST());

        teacherTable.getItems().clear();
        SATable.getItems().clear();


        Teacher teacher = null;
        for(String t: university.getTeachersST().keys())
        {
            teacher = university.getTeachersST().get(t);
            teacherTable.getItems().add(teacher);

            for(Date d: teacher.getScheduleAccompanimentsST().keys())
            {
                ScheduleAccompaniment sa = teacher.getScheduleAccompanimentsST().get(d);
                SATable.getItems().add(sa);
            }
        }
        addTeacherToComboBoxs(university.getTeachersST());

        studentTable.getItems().clear();

        Student student = null;
        for(Integer s: university.getStudentsST().keys())
        {
            student = university.getStudentsST().get(s);
            studentTable.getItems().add(student);
        }

        addStudentsToComboBoxs(university.getStudentsST());

        CourseUnitTable.getItems().clear();

        CourseUnit courseUnit = null;
        for(Integer cu: university.getCourseUnitsST().keys())
        {
            courseUnit = university.getCourseUnitsST().get(cu);
            CourseUnitTable.getItems().add(courseUnit);
        }
        addCourseToComboBoxs(university.getCourseUnitsST());

        ClassTable.getItems().clear();
        SCTable.getItems().clear();

        Class classe = null;
        for(String cl: university.getClassesST().keys())
        {
            classe = university.getClassesST().get(cl);
            ClassTable.getItems().add(classe);

            for(Date d: classe.getScheduleClassesST().keys())
            {
                ScheduleClass sc = classe.getScheduleClassesST().get(d);
                SCTable.getItems().add(sc);
            }

        }

        addClassToComboBoxs(university.getClassesST());

        Point3DTable.getItems().clear();
        EdgesTable.getItems().clear();
        Point3DTable.getItems().addAll(graphMap.getPoints3D());
        EdgesTable.getItems().addAll(graphMap.getArrayLisDirectedEdge());

        floorsComboBox.getItems().clear();
        updateFloorComboBox();
    }

    public void handleSaveTextFileAction(ActionEvent actionEvent) {
        university.saveTeacher("./data/SaveTeacher");
        university.saveStudent("./data/SaveStudent");
        university.saveRoom("./data/SaveRoom");
        university.saveCourseUnit("./data/SaveCourseUnit");
        university.saveClass("./data/SaveClass");
        Class.saveScheduleClass(university,"./data/SaveScheduleClass");
        Student.saveStudentCourse(university, "./data/SaveStudentCourse");
        Teacher.saveScheduleAccompaniment(university, "./data/SaveTeacherScheduleAccompaniment");
    }

    public void handleSaveBinFileAction(ActionEvent actionEvent) {
        saveRoomUniversitary();
    }


    private void saveRoomUniversitary(){
        File f = new File(PATH_UNIVERSITY_READSAVE);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(university);
            oos.writeObject(this.graphMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFileUniversitary(){
        File f = new File(PATH_UNIVERSITY_READSAVE);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            university = (University) ois.readObject();
            this.graphMap = (GraphMap) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void handleAddRoomAction(ActionEvent actionEvent) {
        Room r = new Room(Integer.parseInt(idRoomField.getText()), Integer.parseInt(floorField.getText()), numberRoomField.getText(), Boolean.parseBoolean(socketField.getText()), Integer.parseInt(capacityField.getText()));
        roomTable.getItems().add(r);
        idRoomField.setText("");
        floorField.setText("");
        numberRoomField.setText("");
        socketField.setText("");
        capacityField.setText("");
        //falta implementar
        pointField.setText("");

        university.getRoomST().put(r.getNumberRoom(), r);
    }

    public void handleRemoveRoomAction(ActionEvent actionEvent) {
        Room room = roomTable.getSelectionModel().getSelectedItem();
        roomTable.getItems().remove(room);
        university.removeRoom(room.getNumberRoom());
    }

    public void handleAddTeacherAction(ActionEvent actionEvent) {
        Teacher t = new Teacher(Integer.parseInt(idTeacherField.getText()), nameTeacherField.getText(), emailTeacherField.getText());
        teacherTable.getItems().add(t);
        idTeacherField.setText("");
        nameTeacherField.setText("");
        emailTeacherField.setText("");

        university.getTeachersST().put(t.getEmail(), t);
    }

    public void handleRemoveTeacherAction(ActionEvent actionEvent) {
        Teacher teacher = teacherTable.getSelectionModel().getSelectedItem();
        teacherTable.getItems().remove(teacher);
        university.removeTeacher(teacher.getEmail());
    }

    public void handleAddSAAction(ActionEvent actionEvent) {
        String startDate = startDateSAField.getText();

        String[] split =  startDate.split("/");
        int stdayOfWeek = Integer.parseInt(split[0]);
        int sthour = Integer.parseInt(split[1]);
        int stmin = Integer.parseInt(split[2]);
        Date stD = new Date(sthour, stmin, stdayOfWeek);

        String finalDate = finalDateSAField.getText();

        String[] split2 =  finalDate.split("/");
        int fldayOfWeek = Integer.parseInt(split2[0]);
        int flhour = Integer.parseInt(split2[1]);
        int flmin = Integer.parseInt(split2[2]);
        Date flD = new Date(flhour, flmin, fldayOfWeek);

        Room r = university.getRoomST().get(roomSaCombo.getValue());
        Teacher t = university.getTeachersST().get(teacherSACombo.getValue());

        ScheduleAccompaniment sa = new ScheduleAccompaniment(stD, flD, r, t);
        SATable.getItems().add(sa);
        startDateSAField.setText("");
        finalDateSAField.setText("");
    }

    public void handleRemoveSAAction(ActionEvent actionEvent) {
        ScheduleAccompaniment sa = SATable.getSelectionModel().getSelectedItem();
        SATable.getItems().remove(sa);
        sa.getTeacher().removeScheduleAccompaniment(sa.getStartDate());
    }

    public void handleAddStudentAction(ActionEvent actionEvent) {
        Student s = new Student(Integer.parseInt(idStudentField.getText()), nameStudentField.getText(), emailStudentField.getText(), Integer.parseInt(numberStudentField.getText()), typeStudentField.getText());
        studentTable.getItems().add(s);
        idStudentField.setText("");
        nameStudentField.setText("");
        emailStudentField.setText("");
        numberStudentField.setText("");
        typeStudentField.setText("");

        //falta para os pontos
        //pointStudentField
    }

    public void handleRemoveStudentAction(ActionEvent actionEvent) {
        Student s = studentTable.getSelectionModel().getSelectedItem();
        studentTable.getItems().remove(s);
        university.removeStudent(s.getNumberStudent());
    }

    public void handleAddClassAction(ActionEvent actionEvent) {
        Teacher t = university.getTeachersST().get(teacherFieldCombo.getValue());
        CourseUnit cu = university.getCourseUnitsST().get(courseFieldCombo.getValue());

        Class c = new Class(Integer.parseInt(idClassField.getText()), nameClassField.getText(), typeClassField.getText(), t, cu);
        ClassTable.getItems().add(c);
        idClassField.setText("");
        nameClassField.setText("");
        typeClassField.setText("");
    }

    public void handleRemoveClassAction(ActionEvent actionEvent) {
        Class c = ClassTable.getSelectionModel().getSelectedItem();
        ClassTable.getItems().remove(c);
        university.removeClass(c.getName());
    }

    public void handleAddSCAction(ActionEvent actionEvent) {
        String startDate = startDateSCField.getText();

        String[] split =  startDate.split("/");
        int stdayOfWeek = Integer.parseInt(split[0]);
        int sthour = Integer.parseInt(split[1]);
        int stmin = Integer.parseInt(split[2]);
        Date stD = new Date(sthour, stmin, stdayOfWeek);

        String finalDate = finalDateSCField.getText();

        String[] split2 =  finalDate.split("/");
        int fldayOfWeek = Integer.parseInt(split2[0]);
        int flhour = Integer.parseInt(split2[1]);
        int flmin = Integer.parseInt(split2[2]);
        Date flD = new Date(flhour, flmin, fldayOfWeek);


        Room r = university.getRoomST().get(roomSCCombo.getValue());
        Class c = university.getClassesST().get(classSCCombo.getValue());

        ScheduleClass sc = new ScheduleClass(stD, flD, r, c);
        SCTable.getItems().add(sc);
        startDateSCField.setText("");
        finalDateSCField.setText("");
    }

    public void handleRemoveSCAction(ActionEvent actionEvent) {
        ScheduleClass sc = SCTable.getSelectionModel().getSelectedItem();
        SCTable.getItems().remove(sc);
        sc.getClasse().removeScheduleClass(sc.getStartDate());
    }

    private void addRoomsToComboBoxs(RedBlackBST<String, Room> roomST){
        roomSaCombo.getItems().clear();
        roomSCCombo.getItems().clear();
        salasBDComboBox.getItems().clear();

        for(String numberRoom: roomST.keys())
        {
            roomSaCombo.getItems().add(numberRoom);
            roomSCCombo.getItems().add(numberRoom);
            salasBDComboBox.getItems().add(numberRoom);
        }
    }

    public void handleAddCourseAction(ActionEvent actionEvent) {
        CourseUnit cu = new CourseUnit(Integer.parseInt(idCourseUnitField.getText()), nameCourseUnitField.getText(), Integer.parseInt(ectsField.getText()));
        CourseUnitTable.getItems().add(cu);
        idCourseUnitField.setText("");
        nameCourseUnitField.setText("");
        ectsField.setText("");
    }

    public void handleRemoveCourseAction(ActionEvent actionEvent) {
        CourseUnit c = CourseUnitTable.getSelectionModel().getSelectedItem();
        CourseUnitTable.getItems().remove(c);
        university.removeCourseUnit(c.getId());
    }

    private void addTeacherToComboBoxs(SeparateChainingHashST<String, Teacher> teachersST){
        teacherSACombo.getItems().clear();
        teacherFieldCombo.getItems().clear();
        teacherSASearchComboBox.getItems().clear();
        teacherSearchComboBox.getItems().clear();

        for(String email: teachersST.keys())
        {
            teacherSACombo.getItems().add(email);
            teacherFieldCombo.getItems().add(email);
            teacherSASearchComboBox.getItems().add(email);
            teacherSearchComboBox.getItems().add(email);
        }
    }

    private void addStudentsToComboBoxs(SeparateChainingHashST<Integer, Student> studentsST){
        studentsSeacrhComboBox.getItems().clear();
        studentSASearchComboBox.getItems().clear();

        for(Integer numberStudent: studentsST.keys())
        {
            studentsSeacrhComboBox.getItems().add(String.valueOf(numberStudent));
            studentSASearchComboBox.getItems().add(Integer.valueOf(String.valueOf(numberStudent)));
        }
    }

    private void addCourseToComboBoxs(SeparateChainingHashST<Integer, CourseUnit> courseUnitsST){
        courseFieldCombo.getItems().clear();
        CUSearchComboBox.getItems().clear();

        for(Integer id: courseUnitsST.keys())
        {
            courseFieldCombo.getItems().add(id);
            CUSearchComboBox.getItems().add(id);
        }
    }

    private void addClassToComboBoxs(SeparateChainingHashST<String, Class> classesST){
        classSCCombo.getItems().clear();

        for(String name: classesST.keys())
        {
            classSCCombo.getItems().add(name);
        }
    }

    public void handleEditIntegersRoomAction(TableColumn.CellEditEvent<Room, Integer> roomIntegerCellEditEvent) {
        int col = roomIntegerCellEditEvent.getTablePosition().getColumn();
        Room room = roomIntegerCellEditEvent.getRowValue();
        System.out.println(room);
        switch (col){
            case 0:
                room.setId(roomIntegerCellEditEvent.getNewValue());
                break;
            case 1:
                room.setFloor(roomIntegerCellEditEvent.getNewValue());
                break;
            case 4:
                room.setCapacity(roomIntegerCellEditEvent.getNewValue());
                break;
        }
        System.out.println(room);
    }

    public void handleEditStringsRoomAction(TableColumn.CellEditEvent<Room, String> roomStringCellEditEvent) {
        int col = roomStringCellEditEvent.getTablePosition().getColumn();
        Room room = roomStringCellEditEvent.getRowValue();
        System.out.println(room);
        switch (col){
            case 2:
                room.setNumberRoom(roomStringCellEditEvent.getNewValue());
                break;
        }
        System.out.println(room);
    }

    public void handleEditBooleanRoomAction(TableColumn.CellEditEvent<Room, Boolean> roomBooleanCellEditEvent) {
        int col = roomBooleanCellEditEvent.getTablePosition().getColumn();
        Room room = roomBooleanCellEditEvent.getRowValue();
        System.out.println(room);
        switch (col){
            case 3:
                room.setSocket(roomBooleanCellEditEvent.getNewValue());
                break;
        }
        System.out.println(room);
    }

    public void handleEditIntegerTeacherAction(TableColumn.CellEditEvent<Teacher, Integer> teacherIntegerCellEditEvent) {
        int col = teacherIntegerCellEditEvent.getTablePosition().getColumn();
        Teacher teacher = teacherIntegerCellEditEvent.getRowValue();
        System.out.println(teacher);
        switch (col){
            case 0:
                teacher.setId(teacherIntegerCellEditEvent.getNewValue());
                break;

        }
        System.out.println(teacher);
    }

    public void handleEditStringsTeacherAction(TableColumn.CellEditEvent<Teacher, String> teacherStringCellEditEvent) {
        int col = teacherStringCellEditEvent.getTablePosition().getColumn();
        Teacher teacher = teacherStringCellEditEvent.getRowValue();
        System.out.println(teacher);
        switch (col){
            case 1:
                teacher.setName(teacherStringCellEditEvent.getNewValue());
                break;
            case 2:
                teacher.setEmail(teacherStringCellEditEvent.getNewValue());
                break;
        }
        System.out.println(teacher);
    }

    public void handleEditIntegerStudentAction(TableColumn.CellEditEvent<Student, Integer> studentIntegerCellEditEvent) {
        int col = studentIntegerCellEditEvent.getTablePosition().getColumn();
        Student student = studentIntegerCellEditEvent.getRowValue();
        System.out.println(student);
        switch (col){
            case 0:
                student.setId(studentIntegerCellEditEvent.getNewValue());
                break;
            case 2:
                student.setNumberStudent(studentIntegerCellEditEvent.getNewValue());
                break;
        }
        System.out.println(student);
    }

    public void handleEditStringsStudentAction(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        int col = studentStringCellEditEvent.getTablePosition().getColumn();
        Student student = studentStringCellEditEvent.getRowValue();
        System.out.println(student);
        switch (col){
            case 1:
                student.setName(studentStringCellEditEvent.getNewValue());
                break;
            case 3:
                student.setType(studentStringCellEditEvent.getNewValue());
                break;
            case 4:
                student.setEmail(studentStringCellEditEvent.getNewValue());
                break;
        }
        System.out.println(student);
    }

    public void handleEditIntegerCourseAction(TableColumn.CellEditEvent<CourseUnit, Integer> courseUnitIntegerCellEditEvent) {
        int col = courseUnitIntegerCellEditEvent.getTablePosition().getColumn();
        CourseUnit courseUnit = courseUnitIntegerCellEditEvent.getRowValue();
        System.out.println(courseUnit);
        switch (col){
            case 0:
                courseUnit.setId(courseUnitIntegerCellEditEvent.getNewValue());
                break;
            case 2:
                courseUnit.setEcts(courseUnitIntegerCellEditEvent.getNewValue());
                break;
        }
        System.out.println(courseUnit);
    }

    public void handleEditStringCourseAction(TableColumn.CellEditEvent<CourseUnit, String> courseUnitStringCellEditEvent) {
        int col = courseUnitStringCellEditEvent.getTablePosition().getColumn();
        CourseUnit courseUnit = courseUnitStringCellEditEvent.getRowValue();
        System.out.println(courseUnit);
        switch (col){
            case 1:
                courseUnit.setName(courseUnitStringCellEditEvent.getNewValue());
                break;
        }
        System.out.println(courseUnit);
    }

    public void handleEditIntegerClassAction(TableColumn.CellEditEvent<Class, Integer> classIntegerCellEditEvent) {
        int col = classIntegerCellEditEvent.getTablePosition().getColumn();
        Class clase = classIntegerCellEditEvent.getRowValue();
        System.out.println(clase);
        switch (col){
            case 0:
                clase.setId(classIntegerCellEditEvent.getNewValue());
                break;
        }
        System.out.println(clase);
    }

    public void handleEditStringClassAction(TableColumn.CellEditEvent<Class, String> classStringCellEditEvent) {
        int col = classStringCellEditEvent.getTablePosition().getColumn();
        Class clase = classStringCellEditEvent.getRowValue();
        System.out.println(clase);
        switch (col){
            case 1:
                clase.setName(classStringCellEditEvent.getNewValue());
                break;
            case 2:
                clase.setType(classStringCellEditEvent.getNewValue());
                break;
        }
        System.out.println(clase);
    }

    public void handleSelectStudentClassAction(ActionEvent actionEvent) {
        studentClassSearchTextArea.clear();
        Student student = university.getStudentsST().get(Integer.parseInt(studentsSeacrhComboBox.getValue()));

        for(String  nome : student.getClassesST().keys())
        {
            Class c = student.getClassesST().get(nome);
            studentClassSearchTextArea.appendText(c.toString() + "\n");
        }
    }

    public void handleSelectStudentSaveClassAction(ActionEvent actionEvent) {
        saveStudentClassSearchToFile(PATH_SEARCHSTUDENTCLASS_SAVE);
    }

    public void handleSelectFreeRoomsClassAction(ActionEvent actionEvent) {
        freeRoomSearchTextArea.clear();
        String stDate = dateFieldSearch.getText();

        String[] split1 =  stDate.split("/");
        int stdayOfWeek = Integer.parseInt(split1[0]);
        int sthour = Integer.parseInt(split1[1]);
        int stmin = Integer.parseInt(split1[2]);
        Date startDate = new Date(sthour, stmin, stdayOfWeek);

        RedBlackBST<String, Room> rooms = new RedBlackBST<>();
        rooms = university.searchRoomByDate(startDate);

        for (String numberRoom : rooms.keys()) {
            Room r = rooms.get(numberRoom);
            freeRoomSearchTextArea.appendText(r.toString() + "\n");
        }
    }

    public void handleSelectFreeRoomsSaveAction(ActionEvent actionEvent) {
        saveFreeRoomSearchToFile(PATH_SEARCHFREEROOMS_SAVE);
    }

    public void handleTecherbyCourseUnitAction(ActionEvent actionEvent) {
        searchTeacherbyCUSearchTextArea.clear();
        CourseUnit cu = university.getCourseUnitsST().get(CUSearchComboBox.getValue());
        SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();
        teachersST = cu.searchTeacherbyCourseUnit();

        for (String email : teachersST.keys()) {
            Teacher t = teachersST.get(email);
            searchTeacherbyCUSearchTextArea.appendText(t.toString() + "\n");
        }
    }

    public void handleTecherbyCourseUnitSaveAction(ActionEvent actionEvent) {
        saveTeacherByCUSearchToFile(PATH_SEARCHTEACHERBYCU_SAVE);
    }

    private void saveTeacherByCUSearchToFile(String path)
    {
        PrintWriter pw = openPrintWriter(path);
        if(pw != null)
        {
            CourseUnit cu = university.getCourseUnitsST().get(CUSearchComboBox.getValue());
            SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();
            teachersST = cu.searchTeacherbyCourseUnit();

            for (String email : teachersST.keys()) {
                Teacher t = teachersST.get(email);
                pw.write(t.toStringFileTeacher() +"\n");
            }
            pw.close();
        }
    }

    private void saveFreeRoomSearchToFile(String path)
    {
        PrintWriter pw = openPrintWriter(path);
        if(pw != null)
        {
            String stDate = dateFieldSearch.getText();

            String[] split1 =  stDate.split("/");
            int stdayOfWeek = Integer.parseInt(split1[0]);
            int sthour = Integer.parseInt(split1[1]);
            int stmin = Integer.parseInt(split1[2]);
            Date startDate = new Date(sthour, stmin, stdayOfWeek);

            RedBlackBST<String, Room> rooms = new RedBlackBST<>();
            rooms = university.searchRoomByDate(startDate);

            for (String numberRoom : rooms.keys()) {
                Room r = rooms.get(numberRoom);
                pw.write(r.toStringFileRoom() +"\n");
            }
            pw.close();
        }
    }

    private void saveStudentClassSearchToFile(String path)
    {
        PrintWriter pw = openPrintWriter(path);
        if(pw != null)
        {
            Student student = university.getStudentsST().get(Integer.parseInt(studentsSeacrhComboBox.getValue()));

            for(String  nome : student.getClassesST().keys())
            {
                Class c = student.getClassesST().get(nome);
                pw.write(c.toStringFileClass() +"\n");
            }
            pw.close();
        }
    }

    private PrintWriter openPrintWriter(String path)
    {
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            return pw;
        } catch (IOException e) {
            System.out.println("I/O Exception" + e);
        }
        return null;
    }

    public void handleClassByTeacherSearchAction(ActionEvent actionEvent) {
        searchClassByTeacherSearchTextArea.clear();

        Teacher t = university.getTeachersST().get(teacherSearchComboBox.getValue());
        SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();
        classesST = t.searchClassByTeacher();

        for (String nome : classesST.keys()) {
            Class clas = classesST.get(nome);
            searchClassByTeacherSearchTextArea.appendText(clas.toString() + "\n");
        }
    }

    public void handleClassbyTecherSaveAction(ActionEvent actionEvent) {
        saveClassTeacherSearchToFile(PATH_SEARCHCLASSTEACHER_SAVE);
    }

    private void saveClassTeacherSearchToFile(String path)
    {
        PrintWriter pw = openPrintWriter(path);
        if(pw != null)
        {
            Teacher t = university.getTeachersST().get(teacherSearchComboBox.getValue());
            SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();
            classesST = t.searchClassByTeacher();

            for (String nome : classesST.keys()) {
                Class clas = classesST.get(nome);
                pw.write(clas.toStringFileClass() +"\n");
            }
            pw.close();
        }
    }

    public void handleExitAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void handleSASearchAction(ActionEvent actionEvent) {
        searchSASearchTextArea.clear();

        Student stu = university.getStudentsST().get(studentSASearchComboBox.getValue());
        Teacher teac = university.getTeachersST().get(teacherSASearchComboBox.getValue());

        System.out.println(stu);
        System.out.println(teac);

        RedBlackBST<Date, ScheduleAccompaniment> saST = new RedBlackBST<>();

        saST = stu.searchSaByTeacher(teac);

        for (Date date : saST.keys()) {
            ScheduleAccompaniment sa = saST.get(date);
            System.out.println(sa);
            searchSASearchTextArea.appendText(sa.toString() + "\n");
        }
    }

    public void handleSASaveAction(ActionEvent actionEvent) {
        savSASearchToFile(PATH_SEARCHSA_SAVE);
    }

    private void savSASearchToFile(String path)
    {
        PrintWriter pw = openPrintWriter(path);
        if(pw != null)
        {
            Student stu = university.getStudentsST().get(studentSASearchComboBox.getValue());
            Teacher teac = university.getTeachersST().get(teacherSASearchComboBox.getValue());

            RedBlackBST<Date, ScheduleAccompaniment> saST = new RedBlackBST<>();

            saST = stu.searchSaByTeacher(teac);

            for (Date date : saST.keys()) {
                ScheduleAccompaniment sa = saST.get(date);
                pw.write(sa.toStringFileScheduleAccompaniment() +"\n");
            }

            pw.close();
        }
    }

    public void handleAddPointAction(ActionEvent actionEvent) {

        Point3D point = graphMap.novoPonto(Double.parseDouble(XPointField.getText()), Double.parseDouble(YPointField.getText()), Integer.parseInt(ZPointField.getText()), descriptionPointField.getText(),  Boolean.parseBoolean(indoorPointField.getText()));
        graphMap.addPoint3D(point);
        Point3DTable.getItems().add(point);

        XPointField.setText("");
        YPointField.setText("");
        ZPointField.setText("");
        descriptionPointField.setText("");
        indoorPointField.setText("");
    }

    public void handleRemovePointAction(ActionEvent actionEvent) {
        Point3D point = Point3DTable.getSelectionModel().getSelectedItem();
        Point3DTable.getItems().remove(point);
        graphMap.removePoints(point);
    }

    public void handleAddEdgeAction(ActionEvent actionEvent)
    {
        Point3D point1 = graphMap.returnNode(Integer.parseInt(VEdgeField.getText()));
        Point3D point2 = graphMap.returnNode(Integer.parseInt(WEdgesField.getText()));

        System.out.println(point1);
        System.out.println(point2);

        Edge_Project edge = graphMap.addArestaUnidirecional(point1, point2, Boolean.parseBoolean(senseEdgeField.getText()));

        EdgesTable.getItems().add(edge);
        vEdgeCol.setText("");
        WEdgesField.setText("");
        senseEdgeField.setText("");
    }

    public void handleRemoveEdgeAction(ActionEvent actionEvent) {
        Edge_Project edge = EdgesTable.getSelectionModel().getSelectedItem();
        EdgesTable.getItems().remove(edge);
        graphMap.removeDirectEdges(edge);
    }

    public void updateFloorComboBox() {
        floorsComboBox.getItems().clear();
        floorsSearchComboBox.getItems().clear();

        floorsComboBox.getItems().add("All");
        floorsSearchComboBox.getItems().add("All");

        for (Integer floor : graphMap.getDistinctExistingFloors()) {
            floorsComboBox.getItems().add("" + floor);
            floorsSearchComboBox.getItems().add("" + floor);
        }
    }

    public void handleShowFloorAction(ActionEvent actionEvent) {
        graphUniGroup.getChildren().clear();
        if(floorsComboBox.getValue().compareTo("All") == 0)
        {
            desingGraph(this.graphMap.getGraphGeral(), "grafo");
        }else{
            desingGraph(this.graphMap.getSubgrafoByFloor(Integer.parseInt(floorsComboBox.getValue())), "subgrafo");
        }
    }

    public void desingGraph(EdgeWeightedDigraph_Project grafo, String description)
    {
        int multiplic = 2;

        Text t = new Text(this.graphMap.grafoConexo(grafo));
        t.setX(500);
        t.setY(30);

        graphUniGroup.getChildren().addAll(t);
        for (int i=0; i < grafo.V(); i++)
        {
            Point3D p = null;
            if(description.compareTo("subgrafo") == 0)
                p =  this.graphMap.returnNodeOld(i);
            else
                p = graphMap.returnNode(i);

            Circle c = new Circle(p.getX() * multiplic, p.getY() * multiplic, radius);
            c.setFill(Color.WHITE);
            Text text = new Text(String.valueOf(i));
            text.setX((p.getX() * multiplic) - radius/2);
            text.setY((p.getY() * multiplic) + radius/2);

            if (p.getIndoor())
                c.setFill(Color.GREEN);

            graphUniGroup.getChildren().addAll(c, text);

            for (Edge_Project ep : grafo.adj(i))
            {
                Point3D v = null;
                Point3D w = null;
                if(description.compareTo("subgrafo") == 0)
                {
                    v = graphMap.returnNodeOld(ep.getV());
                    w = graphMap.returnNodeOld(ep.getW());
                }else{
                    v = graphMap.returnNode(ep.getV());
                    w = graphMap.returnNode(ep.getW());
                }

                Line line = new Line(v.getX() * multiplic, v.getY() * multiplic , w.getX() * multiplic, w.getY() * multiplic);
                line.setStroke(Color.BLACK);

                if (v.getZ() != w.getZ())
                    line.setStroke(Color.BLUE);

                line.setStrokeWidth(1);

                graphUniGroup.getChildren().addAll(line);
            }
        }
    }

    public void handleSelectFreeRoomsBDClassAction(ActionEvent actionEvent) {
        freeRoomBDSearchTextArea.clear();
        String stDateS = dateinitFieldSearch.getText();

        String[] split3 =  stDateS.split("/");
        int stdayOfWeekS = Integer.parseInt(split3[0]);
        int sthourS = Integer.parseInt(split3[1]);
        int stminS = Integer.parseInt(split3[2]);
        Date startDateS = new Date(sthourS, stminS, stdayOfWeekS);

        String flDate = datefinalFieldSearch.getText();

        String[] split2 =  flDate.split("/");
        int fldayOfWeek = Integer.parseInt(split2[0]);
        int flhour = Integer.parseInt(split2[1]);
        int flmin = Integer.parseInt(split2[2]);
        Date finalDate = new Date(flhour, flmin, fldayOfWeek);

        String sala = salasBDComboBox.getValue();

        Room r = university.getRoomST().get(sala);

        RedBlackBST<Date, Schedule> sST = new RedBlackBST<>();
        sST = r.searchLeaveRoomBetweenDates(startDateS, finalDate);

        for (Date date1 : sST.keys()) {
            Schedule s = sST.get(date1);
            freeRoomBDSearchTextArea.appendText(s.toString() + "\n");
        }
    }

    public void handleSelectFreeRoomsBDSaveAction(ActionEvent actionEvent) {

        PrintWriter pw = openPrintWriter(PATH_SEARCHFREEBD_SAVE);
        if(pw != null)
        {
            String stDateS = dateinitFieldSearch.getText();

            String[] split3 =  stDateS.split("/");
            int stdayOfWeekS = Integer.parseInt(split3[0]);
            int sthourS = Integer.parseInt(split3[1]);
            int stminS = Integer.parseInt(split3[2]);
            Date startDateS = new Date(sthourS, stminS, stdayOfWeekS);

            String flDate = datefinalFieldSearch.getText();

            String[] split2 =  flDate.split("/");
            int fldayOfWeek = Integer.parseInt(split2[0]);
            int flhour = Integer.parseInt(split2[1]);
            int flmin = Integer.parseInt(split2[2]);
            Date finalDate = new Date(flhour, flmin, fldayOfWeek);

            String sala = salasBDComboBox.getValue();

            Room r = university.getRoomST().get(sala);

            RedBlackBST<Date, Schedule> sST = new RedBlackBST<>();
            sST = r.searchLeaveRoomBetweenDates(startDateS, finalDate);

            for (Date date1 : sST.keys()) {
                Schedule s = sST.get(date1);
                pw.write(s.toString() +"\n");
            }
            pw.close();
        }
    }

    public void handleNowSearchAction(ActionEvent actionEvent) {
        nowSearchTextArea.clear();
        SeparateChainingHashST<String, Teacher> teachersSTUsed = new SeparateChainingHashST<>();

        SeparateChainingHashST<String, Teacher> teachersSTUnused = new SeparateChainingHashST<>();

        SeparateChainingHashST<String, Class> classesSTUsed = new SeparateChainingHashST<>();

        SeparateChainingHashST<String, Class> classesSTUnused = new SeparateChainingHashST<>();

        RedBlackBST<String, Room> roomSTUsed = new RedBlackBST<>();

        RedBlackBST<String, Room> roomSTUnused = new RedBlackBST<>();

        SeparateChainingHashST<Integer, CourseUnit> courseUnitsSTUsed = new SeparateChainingHashST<>();

        SeparateChainingHashST<Integer, CourseUnit> courseUnitsSTUnused = new SeparateChainingHashST<>();

        Date now = new Date();

        for(String name : this.university.getTeachersST().keys())
        {
            Teacher t = this.university.getTeachersST().get(name);

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

        for(String name : this.university.getClassesST().keys())
        {
            Class c = this.university.getClassesST().get(name);

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

        nowSearchTextArea.appendText("Professores ocupados: \n");
        for(String email: teachersSTUsed.keys())
        {
            Teacher tUsed = teachersSTUsed.get(email);
            nowSearchTextArea.appendText(tUsed.toString() + "\n");
        }

        nowSearchTextArea.appendText("Professores que não estão ocupados: \n");
        for(String email: teachersSTUnused.keys())
        {
            Teacher tUsed = teachersSTUnused.get(email);
            nowSearchTextArea.appendText(tUsed.toString() + "\n");
        }

        nowSearchTextArea.appendText("Unidades curriculares a ter aulas: \n");
        for(Integer id: courseUnitsSTUsed.keys())
        {
            CourseUnit cuUsed = courseUnitsSTUsed.get(id);
            nowSearchTextArea.appendText(cuUsed.toString() + "\n");
        }

        nowSearchTextArea.appendText("Turmas a ter aulas: \n");
        for(String email: classesSTUsed.keys())
        {
            Class cUsed = classesSTUsed.get(email);
            nowSearchTextArea.appendText(cUsed.toString() + "\n");
        }

        nowSearchTextArea.appendText("Salas ocupadas: \n");
        for(String numberRoom: roomSTUsed.keys())
        {
            Room rUsed = roomSTUsed.get(numberRoom);
            nowSearchTextArea.appendText(rUsed.toString() + "\n");
        }

        nowSearchTextArea.appendText("Salas que não estão ocupadas: \n");
        for(String numberRoom: roomSTUnused.keys())
        {
            Room rUnused = roomSTUnused.get(numberRoom);
            nowSearchTextArea.appendText(rUnused.toString() + "\n");
        }
    }

    public void handleNowSaveAction(ActionEvent actionEvent) {

        PrintWriter pw = openPrintWriter(PATH_SEARCHNOW_SAVE);
        if(pw != null)
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

            for(String name : this.university.getTeachersST().keys())
            {
                Teacher t = this.university.getTeachersST().get(name);

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

            for(String name : this.university.getClassesST().keys())
            {
                Class c = this.university.getClassesST().get(name);

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

            pw.write("Professores ocupados: \n");
            for(String email: teachersSTUsed.keys())
            {
                Teacher tUsed = teachersSTUsed.get(email);
                pw.write(tUsed.toString() + "\n");
            }

            pw.write("Professores que não estão ocupados: \n");
            for(String email: teachersSTUnused.keys())
            {
                Teacher tUsed = teachersSTUnused.get(email);
                pw.write(tUsed.toString() + "\n");
            }

            pw.write("Unidades curriculares a ter aulas: \n");
            for(Integer id: courseUnitsSTUsed.keys())
            {
                CourseUnit cuUsed = courseUnitsSTUsed.get(id);
                pw.write(cuUsed.toString() + "\n");
            }

            pw.write("Turmas a ter aulas: \n");
            for(String email: classesSTUsed.keys())
            {
                Class cUsed = classesSTUsed.get(email);
                pw.write(cUsed.toString() + "\n");
            }

            pw.write("Salas ocupadas: \n");
            for(String numberRoom: roomSTUsed.keys())
            {
                Room rUsed = roomSTUsed.get(numberRoom);
                pw.write(rUsed.toString() + "\n");
            }

            pw.write("Salas que não estão ocupadas: \n");
            for(String numberRoom: roomSTUnused.keys())
            {
                Room rUnused = roomSTUnused.get(numberRoom);
                pw.write(rUnused.toString() + "\n");
            }
            pw.close();
        }
    }

    public void handlePointToPointAction(ActionEvent actionEvent) {
        PointToPointTextArea.clear();
        EdgeWeightedDigraph_Project graph = null;


        if(floorsSearchComboBox.getValue().compareTo("All") == 0)
        {
            graph = this.graphMap.getGraphGeral();
        }else{
            graph = this.graphMap.getSubgrafoByFloor(Integer.parseInt(floorsSearchComboBox.getValue()));
        }

        String[] aux1 = point1ComboBox.getValue().split(" - ");
        String[] aux2 = point2ComboBox.getValue().split(" - ");
        Point3D p1 = graphMap.returnNode(Integer.parseInt(aux1[0]));
        Point3D p2 = graphMap.returnNode(Integer.parseInt(aux2[0]));

        if(tempRadioButton.selectedProperty().getValue())
        {
            ArrayList<String> temp = this.graphMap.shortestPathbetweenTwoPointsByTemp(p1, p2, graph);

            for(String s : temp)
            {
                PointToPointTextArea.appendText(s + "\n");
            }
        }

        if(distanceRadioButton.selectedProperty().getValue())
        {
            ArrayList<String> distance = this.graphMap.shortestPathBetweenTwoPointsByDistance(p1, p2, graph);
            for(String s : distance)
            {
                PointToPointTextArea.appendText(s + "\n");
            }
        }
    }

    public void handleSelectFloorAction(ActionEvent actionEvent) {

        EdgeWeightedDigraph_Project graph;
        String description;

        point1ComboBox.getItems().clear();
        point2ComboBox.getItems().clear();
        pointEmergencyComboBox.getItems().clear();
        pointavoidComboBox.getItems().clear();
        pointavoidInitComboBox.getItems().clear();
        point2avoidInitComboBox.getItems().clear();

        if(floorsSearchComboBox.getValue().compareTo("All") == 0)
        {
            graph = this.graphMap.getGraphGeral();
            description = "grafo";
        }else{
            graph = this.graphMap.getSubgrafoByFloor(Integer.parseInt(floorsSearchComboBox.getValue()));
            description = "subgrafo";
        }

        for (int i=0; i < graph.V(); i++)
        {
            Point3D p = null;
            if(description.compareTo("subgrafo") == 0)
                p =  this.graphMap.returnNodeOld(i);
            else
                p = graphMap.returnNode(i);


            point1ComboBox.getItems().add(i + " - " + p.getDescription());
            point2ComboBox.getItems().add(i + " - " + p.getDescription());
            pointEmergencyComboBox.getItems().add(i + " - " + p.getDescription());
            pointavoidComboBox.getItems().add(i + " - " + p.getDescription());
            pointavoidInitComboBox.getItems().add(i + " - " + p.getDescription());
            point2avoidInitComboBox.getItems().add(i + " - " + p.getDescription());
        }
    }

    public void handleEmergencyAction(ActionEvent actionEvent) {
        emergencyTextArea.clear();
        EdgeWeightedDigraph_Project graph = null;

        if(floorsSearchComboBox.getValue().compareTo("All") == 0)
        {
            graph = this.graphMap.getGraphGeral();
        }else{
            graph = this.graphMap.getSubgrafoByFloor(Integer.parseInt(floorsSearchComboBox.getValue()));
        }

        String[] aux1 = pointEmergencyComboBox.getValue().split(" - ");

        if(tempEmergencyRadioButton.selectedProperty().getValue())
        {
            ArrayList<String> temp = this.graphMap.emergencyPathTempo(aux1[0], graph, floorsSearchComboBox.getValue());

            for(String s : temp)
            {
                emergencyTextArea.appendText(s + "\n");
            }
        }

        if(distanceEmergencyRadioButton.selectedProperty().getValue())
        {
            ArrayList<String> distance = this.graphMap.emergencyPathByDistance(aux1[0], graph, floorsSearchComboBox.getValue());
            for(String s : distance)
            {
                emergencyTextArea.appendText(s + "\n");
            }
        }
    }

    public void handleAvoidPointAction(ActionEvent actionEvent) {
        String point = pointavoidComboBox.getValue();
        String[] aux = point.split(" - ");

        Point3D p = this.graphMap.returnNodeOld(Integer.parseInt(aux[0]));

        avoidTable.getItems().add(p);

        pointavoidComboBox.getItems().remove(point);
        pointavoidInitComboBox.getItems().remove(point);
        point2avoidInitComboBox.getItems().remove(point);

    }

    public void handleGenerateGraphAvoidAction(ActionEvent actionEvent) {
        int size = avoidTable.getItems().size();
        ArrayList<Point3D> avoidPoint = new ArrayList<>();


        for(int i = 0; i < size; i++)
        {
            Point3D p = (Point3D) avoidTable.getItems().get(i);
            avoidPoint.add(p);
        }

        avoidPointsTextArea.clear();
        EdgeWeightedDigraph_Project graph = null;

        if(floorsSearchComboBox.getValue().compareTo("All") == 0)
        {
            graph = this.graphMap.getGraphGeral();
        }else{
            graph = this.graphMap.getSubgrafoByFloor(Integer.parseInt(floorsSearchComboBox.getValue()));
        }

        String point = pointavoidInitComboBox.getValue();
        String[] aux = point.split(" - ");

        String point2 = point2avoidInitComboBox.getValue();
        String[] aux2 = point2.split(" - ");

        ArrayList<String> distance = this.graphMap.avoidPointsPathWeight(graph, Integer.parseInt(aux[0]), avoidPoint, Integer.parseInt(aux2[0]));

        for(String s : distance)
        {
            avoidPointsTextArea.appendText(s + "\n");
        }
    }

    public void handleRemovePointsAvoidAction(ActionEvent actionEvent) {
        Point3D point = (Point3D) avoidTable.getSelectionModel().getSelectedItem();
        avoidTable.getItems().remove(point);
    }

    /*
    public TextField personPointField;
    public RadioButton tempEmergencyPersonRadioButton;
    public RadioButton distanceEmergencyPersonRadioButton;
    public TextArea emergencyPersonTextArea;
    */

    public void handleEmergencyPersonAction(ActionEvent actionEvent) {
        emergencyPersonTextArea.clear();
        EdgeWeightedDigraph_Project graph = null;

        if(floorsSearchComboBox.getValue().compareTo("All") == 0)
        {
            graph = this.graphMap.getGraphGeral();
        }else{
            graph = this.graphMap.getSubgrafoByFloor(Integer.parseInt(floorsSearchComboBox.getValue()));
        }

        String[] aux1 = personPointField.getText().split("/");

        Point3D passed = new Point3D(Double.parseDouble(aux1[0]), Double.parseDouble(aux1[1]), Integer.parseInt(aux1[2]), "person", false);

        Point3D perto = this.graphMap.returnClosestPoint(passed);
        System.out.println(perto);
        Integer idCerto = this.graphMap.getMap_grafoGeral().get(perto.getId());

        if(tempEmergencyPersonRadioButton.selectedProperty().getValue())
        {
            ArrayList<String> temp = this.graphMap.emergencyPathTempo(String.valueOf(idCerto), graph, floorsSearchComboBox.getValue());

            emergencyPersonTextArea.appendText("\n Distance by Temp: \n");
            for(String s : temp)
            {
                emergencyPersonTextArea.appendText(s + "\n");
            }
        }

        if(distanceEmergencyPersonRadioButton.selectedProperty().getValue())
        {
            ArrayList<String> distance = this.graphMap.emergencyPathByDistance(String.valueOf(idCerto), graph, floorsSearchComboBox.getValue());
            emergencyPersonTextArea.appendText("\n Distance by weight: \n");
            for(String s : distance)
            {
                emergencyPersonTextArea.appendText(s + "\n");
            }
        }
    }
}