package edu.ufp.inf.lp2_aed2.graphicInterface;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

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
    public TableColumn<Room, Integer> capacityCol;
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
    public ComboBox<Integer> courseFieldCombo;

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
    public ComboBox<String> classSCCombo;

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
        pointStudentCol.setCellValueFactory(new PropertyValueFactory<>("mypoint"));
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
    }

    public void handleReadBinFileAction(ActionEvent actionEvent) {
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

        for(String numberRoom: roomST.keys())
        {
            roomSaCombo.getItems().add(numberRoom);
            roomSCCombo.getItems().add(numberRoom);
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

        for(String email: teachersST.keys())
        {
            teacherSACombo.getItems().add(email);
            teacherFieldCombo.getItems().add(email);
        }
    }

    private void addCourseToComboBoxs(SeparateChainingHashST<Integer, CourseUnit> courseUnitsST){
        courseFieldCombo.getItems().clear();

        for(Integer id: courseUnitsST.keys())
        {
            courseFieldCombo.getItems().add(id);
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
}
