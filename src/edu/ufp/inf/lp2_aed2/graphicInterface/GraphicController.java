package edu.ufp.inf.lp2_aed2.graphicInterface;

import edu.ufp.inf.lp2_aed2.*;
import edu.ufp.inf.lp2_aed2.Class;
import edu.ufp.inf.lp2_aed2.points.Point;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphicController implements Initializable {

    private University university;
    private static final String FILE_DELIMITER = ";";

    /**
     * Room
     */
    public TableView<Room> roomTable;
    public TableColumn<Room, Integer> idRoomCol;
    public TableColumn<Room, Integer> floorCol;
    public TableColumn<Room, String> numberRoomCol;
    public TableColumn<Room, Boolean> socketCol;
    public TableColumn<Room, String> capacityCol;
    public TableColumn<Room, Point> pointCol;
    public TextField idRoomField;
    public TextField floorField;
    public TextField numberRoomField;
    public TextField socketField;
    public TextField capacityField;
    public TextField pointField;

    private static final String PATH_BINROOMS_READ = "./data/bin/RoomBin.bin";
    private static final String PATH_BINROOMS_SAVE = "./data/bin/SaveRoomBin.bin";

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

    private static final String PATH_BINTEACHERS_READ = "./data/bin/TeacherBin.bin";
    private static final String PATH_BINTEACHERS_SAVE = "./data/bin/SaveTeacherBin.bin";

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

    private static final String PATH_BINSCHEDULEACCOMPANIMENT_READ = "./data/bin/ScheduleAccompanimentBin.bin";
    private static final String PATH_BINSCHEDULEACCOMPANIMENT_SAVE = "./data/bin/SaveScheduleAccompanimentBin.bin";

    /**
     * Student
     */
    public TableView<Student> studentTable;
    public TableColumn<Student, Integer> idStudentCol;
    public TableColumn<Student, String> nameStudentCol;
    public TableColumn<Student, String> emailStudentCol;
    public TableColumn<Student, Point> pointStudentCol;
    public TableColumn<Student, Integer> numberStudentCol;
    public TableColumn<Student, String> typeStudentCol;

    public TextField idStudentField;
    public TextField nameStudentField;
    public TextField emailStudentField;
    public TextField pointStudentField;
    public TextField numberStudentField;
    public TextField typeStudentField;

    private static final String PATH_BINSTUDENTS_READ = "./data/bin/StudentBin.bin";
    private static final String PATH_BINSTUDENTS_SAVE = "./data/bin/SaveStudentBin.bin";

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

    private static final String PATH_BINCOURSEUNITS_READ = "./data/bin/CourseUnitBin.bin";
    private static final String PATH_BINCOURSEUNITS_SAVE = "./data/bin/SaveCourseUnitBin.bin";


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
    public ComboBox<String> courseFieldCombo;

    private static final String PATH_BINCLASSES_READ = "./data/bin/ClassBin.bin";
    private static final String PATH_BINCLASSES_SAVE = "./data/bin/SaveClassBin.bin";

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
    public ComboBox<String> teacherSCCombo;

    private static final String PATH_BINSCHEDULECLASSES_READ = "./data/bin/ScheduleClassBin.bin";
    private static final String PATH_BINSCHEDULECLASSES_SAVE = "./data/bin/SaveScheduleClassBin.bin";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.university = new University("UFP");
        /**
         * Room
         */
        idRoomCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        floorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
        numberRoomCol.setCellValueFactory(new PropertyValueFactory<>("numberRoom"));
        socketCol.setCellValueFactory(new PropertyValueFactory<>("socket"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        pointCol.setCellValueFactory(new PropertyValueFactory<>("myPoint"));

        /**
         * Teacher
         */
        idTeacherCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTeacherCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailTeacherCol.setCellValueFactory(new PropertyValueFactory<>("email"));

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
        pointStudentCol.setCellValueFactory(new PropertyValueFactory<>("mypoint"));
        numberStudentCol.setCellValueFactory(new PropertyValueFactory<>("numberStudent"));
        typeStudentCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        /**
         * CourseUnit
         */
        idCourseUnitCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCourseUnitCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ectsCol.setCellValueFactory(new PropertyValueFactory<>("ects"));

        /**
         * Student
         */
        idClassCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameClassCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeClassCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        teacherClassCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        courseUnitClassCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        /**
         * ScheduleClass
         */
        startDateSCCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        finalDateSCCol.setCellValueFactory(new PropertyValueFactory<>("finalDate"));
        roomSCCol.setCellValueFactory(new PropertyValueFactory<>("room"));
        ClassSCCol.setCellValueFactory(new PropertyValueFactory<>("classe"));
    }

    public void handleReadTextFileAction(ActionEvent actionEvent) {
        roomTable.getItems().clear();
        university.loadRoom("./data/Room");
        university.loadRoomPonts("./data/RoomPoint");
        for(String r: university.getRoomST().keys())
        {
            Room room = university.getRoomST().get(r);
            roomTable.getItems().add(room);
        }

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

        studentTable.getItems().clear();
        university.loadStudent("./data/Student");
        Student student = null;
        for(Integer s: university.getStudentsST().keys())
        {
            student = university.getStudentsST().get(s);
            studentTable.getItems().add(student);
        }

        CourseUnitTable.getItems().clear();
        university.loadCourseUnit("./data/CourseUnit");
        CourseUnit courseUnit = null;
        for(Integer cu: university.getCourseUnitsST().keys())
        {
            courseUnit = university.getCourseUnitsST().get(cu);
            CourseUnitTable.getItems().add(courseUnit);
        }

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
        Student.loadStudentCourse(university, "./data/StudentCourse");
    }

    public void handleReadBinFileAction(ActionEvent actionEvent) {
    }

    public void handleSaveTextFileAction(ActionEvent actionEvent) {
    }

    public void handleSaveBinFileAction(ActionEvent actionEvent) {
    }

    public void handleAddRoomAction(ActionEvent actionEvent) {
    }

    public void handleRemoveRoomAction(ActionEvent actionEvent) {
    }

    public void handleAddTeacherAction(ActionEvent actionEvent) {
    }

    public void handleRemoveTeacherAction(ActionEvent actionEvent) {
    }

    public void handleAddSAAction(ActionEvent actionEvent) {
    }

    public void handleRemoveSAAction(ActionEvent actionEvent) {
    }

    public void handleAddStudentAction(ActionEvent actionEvent) {
    }

    public void handleRemoveStudentAction(ActionEvent actionEvent) {
    }

    public void handleAddClassAction(ActionEvent actionEvent) {
    }

    public void handleRemoveClassAction(ActionEvent actionEvent) {
    }

    public void handleAddSCAction(ActionEvent actionEvent) {
    }

    public void handleRemoveSCAction(ActionEvent actionEvent) {
    }
}
