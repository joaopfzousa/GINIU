package edu.ufp.inf.lp2_aed2.Graphic;

import edu.ufp.inf.lp2_aed2.*;
import edu.ufp.inf.lp2_aed2.Class;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class UniversityController implements Initializable {
    /**
     * Room
     */
    public TableView<Room> roomTable;
    public TableColumn<Room, Integer> idrCol;
    public TableColumn<Room, Integer> floorCol;
    public TableColumn<Room, String> numberroomrCol;
    public TableColumn<Room, Boolean> socketCol;
    public TableColumn<Room, Integer> capacityCol;
    public TextField idrField;
    public TextField floorField;
    public TextField numberroomrField;
    public TextField socketField;
    public TextField capacityField;

    private static final String PATH_BINROOMS_READ = "./Data/RoomBin.bin";
    private static final String PATH_BINROOMS_SAVE = "./Data/SaveRoomBin.bin";
    private static final String FILE_DELIMITER = ";";

    /**
     * Teacher
     */
    public TableView<Teacher> teacherTable;
    public TableColumn<Teacher, Integer> idtCol;
    public TableColumn<Teacher, String> nametCol;
    public TableColumn<Teacher, String> emailtCol;
    public TextField idtField;
    public TextField nametField;
    public TextField emailtField;

    private static final String PATH_BINTEACHERS_READ = "./Data/TeacherBin.bin";
    private static final String PATH_BINTEACHERS_SAVE = "./Data/SaveTeacherBin.bin";

    /**
     * Student
     */
    public TableView<Student> studentTable;
    public TableColumn<Student, Integer> idsCol;
    public TableColumn<Student, String> namesCol;
    public TableColumn<Student, String> emailsCol;
    public TableColumn<Student, Integer> numberstudentsCol;
    public TableColumn<Student, String> typeCol;
    public TextField idsField;
    public TextField namesField;
    public TextField emailsField;
    public TextField numberstudentsField;
    public TextField typeField;

    private static final String PATH_BINSTUDENTS_READ = "./Data/StudentBin.bin";
    private static final String PATH_BINSTUDENTS_SAVE = "./Data/SaveStudentBin.bin";
    
    /**
     * CourseUnit
     */
    public TableView<CourseUnit> courseunitTable;
    public TableColumn<CourseUnit, Integer> idcuCol;
    public TableColumn<CourseUnit, String> namecuCol;
    public TableColumn<CourseUnit, Integer> ectsCol;
    public TextField idcuField;
    public TextField namecuField;
    public TextField ectsField;

    private static final String PATH_BINCOURSEUNITS_READ = "./Data/CourseUnitBin.bin";
    private static final String PATH_BINCOURSEUNITS_SAVE = "./Data/SaveCourseUnitBin.bin";

    /**
     * Class
     */
    public TableView<edu.ufp.inf.lp2_aed2.Class> classTable;
    public TableColumn<edu.ufp.inf.lp2_aed2.Class, Integer> idcCol;
    public TableColumn<edu.ufp.inf.lp2_aed2.Class, String> namecCol;
    public TableColumn<edu.ufp.inf.lp2_aed2.Class, String> typecCol;
    public TableColumn<edu.ufp.inf.lp2_aed2.Class, Teacher> emailcCol;
    public TableColumn<edu.ufp.inf.lp2_aed2.Class, CourseUnit> coursecCol;
    public TextField idcField;
    public TextField namecField;
    public TextField typecField;
    public TextField emailcField;
    public TextField coursecField;

    private static final String PATH_BINCLASSES_READ = "./Data/ClassBin.bin";
    private static final String PATH_BINCLASSES_SAVE = "./Data/SaveClassBin.bin";


    University u = new University("UFP");
    History h = new History();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        floorCol.setCellValueFactory(new PropertyValueFactory<>("Floor"));
        numberroomrCol.setCellValueFactory(new PropertyValueFactory<>("Number Room"));
        socketCol.setCellValueFactory(new PropertyValueFactory<>("Socket"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("Capacity"));

        nametCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        emailtCol.setCellValueFactory(new PropertyValueFactory<>("Email"));

        namesCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        emailsCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        numberstudentsCol.setCellValueFactory(new PropertyValueFactory<>("Number Student"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));

        namecuCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ectsCol.setCellValueFactory(new PropertyValueFactory<>("ECTS"));

        namecCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        typecCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        emailcCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        coursecCol.setCellValueFactory(new PropertyValueFactory<>("Course"));
    }

    private PrintWriter openPrintWriter(String path) {
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            return pw;
        } catch (IOException e) {
            System.out.println("I/O Exception");
        }
        return null;
    }

    private BufferedReader openBufferedReader(String path)
    {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            return br;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return null;
    }
    
    /**
     * Save Txt
     */
    public void handleSaveTextFileAction(ActionEvent actionEvent) {
        u.saveTeacher("./data/SaveTeacher");
        u.saveStudent("./data/SaveStudent");
        u.saveRoom("./data/SaveRoom");
        u.saveCourseUnit("./data/SaveCourseUnit");
        u.saveClass("./data/SaveClass");
    }

    /**
     * Read Txt
     */
    public void handleReadTextFileAction(ActionEvent actionEvent) {
        u.loadTeacher("./data/Teacher");
        u.loadStudent("./data/Student");
        u.loadRoom("./data/Room");
        u.loadCourseUnit("./data/CourseUnit");
        u.loadClass("./data/Class");
        u.loadRoomPonts("./data/RoomPoint");
        Class.loadScheduleClass(u, "./data/ScheduleClass");
        Student.loadStudentCourse(u, "./data/StudentCourse");
        Teacher.loadScheduleAccompaniment(u, "./data/TeacherScheduleAccompaniment");
    }

    /**
     * Save Bin
     */
    public void handleSaveBinFileAction(ActionEvent actionEvent) {
        saveRoomBin();
        saveTeacherBin();
        saveStudentBin();
        saveCourseUnitBin();
        saveClassBin();
    }

    private void saveRoomBin(){
        File f = new File(PATH_BINROOMS_SAVE);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveTeacherBin(){
        File f = new File(PATH_BINTEACHERS_SAVE);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveStudentBin(){
        File f = new File(PATH_BINSTUDENTS_SAVE);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCourseUnitBin(){
        File f = new File(PATH_BINCOURSEUNITS_SAVE);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveClassBin(){
        File f = new File(PATH_BINCLASSES_SAVE);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Ver o erro
     * Read Bin

    public void handleReadBinFileAction(ActionEvent actionEvent) {
        readFromBinFileRoom();
        roomTable.getItems().clear();
        roomTable.getItems().addAll(());

        readFromBinFileTeacher();
        teacherTable.getItems().clear();
        for (String tc : u.getTeachersST().keys())
        teacherTable.getItems().add(tc.get);

        readFromBinFileStudent();
        studentTable.getItems().clear();
        studentTable.getItems().addAll(u.getStudentsST());

        readFromBinFileCourseUnit();
        courseunitTable.getItems().clear();
        courseunitTable.getItems().addAll(u.getCourseUnitsST());

        readFromBinFileClass();
        classTable.getItems().clear();
        classTable.getItems().addAll(u.getClassesST());
    }
    
    private void readFromBinFileRoom(){
        File f = new File(PATH_BINROOMS_READ);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (University) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFileTeacher(){
        File f = new File(PATH_BINTEACHERS_READ);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (University) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFileStudent(){
        File f = new File(PATH_BINSTUDENTS_READ);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (University) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFileCourseUnit(){
        File f = new File(PATH_BINCOURSEUNITS_READ);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (University) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFromBinFileClass(){
        File f = new File(PATH_BINCLASSES_READ);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (University) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     */

    /**
     * Adicionar
     */
    public void handleAddRoomAction(ActionEvent actionEvent) {
        Room r = new Room(Integer.parseInt(idrField.getText()), Integer.parseInt(floorField.getText()), numberroomrField.getText(), Boolean.parseBoolean(socketField.getText()), Integer.parseInt(capacityField.getText()));
        roomTable.getItems().add(r);
        idrField.setText("");
        floorField.setText("");
        numberroomrField.setText("");
        socketField.setText("");
        capacityField.setText("");
    }

    public void handleAddTeacherAction(ActionEvent actionEvent) {
        Teacher t = new Teacher(Integer.parseInt(idtField.getText()), nametField.getText(), emailtField.getText());
        teacherTable.getItems().add(t);
        idtField.setText("");
        nametField.setText("");
        emailtField.setText("");
    }

    public void handleAddStudentAction(ActionEvent actionEvent) {
        Student s = new Student(Integer.parseInt(idsField.getText()), namesField.getText(), emailtField.getText(), Integer.parseInt(numberstudentsField.getText()), typeField.getText());
        studentTable.getItems().add(s);
        idsField.setText("");
        namesField.setText("");
        emailsField.setText("");
        numberstudentsField.setText("");
        typeField.setText("");
    }

    public void handleAddCourseUnitAction(ActionEvent actionEvent) {
        CourseUnit cu = new CourseUnit(Integer.parseInt(idcuField.getText()), namecuField.getText(), Integer.parseInt(ectsField.getText()));
        courseunitTable.getItems().add(cu);
        idcuField.setText("");
        namecuField.setText("");
        ectsField.setText("");
    }

    /** Ver o erro
    public void handleAddClassAction(ActionEvent actionEvent) {
        edu.ufp.inf.lp2_aed2.Class c = new edu.ufp.inf.lp2_aed2.Class(Integer.parseInt(idcField.getText()), namecField.getText(), typecField.getText(),  emailcField.getText(), Integer.parseInt(coursecField.getText()));
        classTable.getItems().add(c);
        idcField.setText("");
        namecField.setText("");
        typecField.setText("");
        emailcField.setText("");
        coursecField.setText("");
    }
    */

    /**
     * Editar
     */
    public void handleEditRoomAction(TableColumn.CellEditEvent<Room, String> roomStringCellEditEvent) {
        int col = roomStringCellEditEvent.getTablePosition().getColumn();
        switch (col){
            case 0 :
                roomStringCellEditEvent.getRowValue().setFloor(Integer.parseInt(roomStringCellEditEvent.getNewValue()));
                break;
            case 1 :
                roomStringCellEditEvent.getRowValue().setNumberRoom(roomStringCellEditEvent.getNewValue());
                break;
            case 2 :
                roomStringCellEditEvent.getRowValue().setSocket(Boolean.parseBoolean(roomStringCellEditEvent.getNewValue()));
                break;
            case 3 :
                roomStringCellEditEvent.getRowValue().setCapacity(Integer.parseInt(roomStringCellEditEvent.getNewValue()));
                break;
        }
    }

    public void handleEditTeacherAction(TableColumn.CellEditEvent<Teacher, String> teacherStringCellEditEvent) {
        int col = teacherStringCellEditEvent.getTablePosition().getColumn();
        switch (col){
            case 0 :
                teacherStringCellEditEvent.getRowValue().setName(teacherStringCellEditEvent.getNewValue());
                break;
            case 1 :
                teacherStringCellEditEvent.getRowValue().setEmail(teacherStringCellEditEvent.getNewValue());
                break;
        }
    }

    public void handleEditStudentAction(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        int col = studentStringCellEditEvent.getTablePosition().getColumn();
        switch (col){
            case 0 :
                studentStringCellEditEvent.getRowValue().setName(studentStringCellEditEvent.getNewValue());
                break;
            case 1 :
                studentStringCellEditEvent.getRowValue().setEmail(studentStringCellEditEvent.getNewValue());
                break;
            case 2 :
                studentStringCellEditEvent.getRowValue().setNumberStudent(Integer.parseInt(studentStringCellEditEvent.getNewValue()));
                break;
        }
    }

    public void handleEditCourseUnitAction(TableColumn.CellEditEvent<CourseUnit, String> courseUnitStringCellEditEvent) {
        int col = courseUnitStringCellEditEvent.getTablePosition().getColumn();
        switch (col){
            case 0 :
                courseUnitStringCellEditEvent.getRowValue().setName(courseUnitStringCellEditEvent.getNewValue());
                break;
            case 1 :
                courseUnitStringCellEditEvent.getRowValue().setEcts(Integer.parseInt(courseUnitStringCellEditEvent.getNewValue()));
                break;
        }
    }
    // Falta o teacher e o course
    public void handleEditClassAction(TableColumn.CellEditEvent<edu.ufp.inf.lp2_aed2.Class, String> classStringCellEditEvent) {
        /*
        int col = classStringCellEditEvent.getTablePosition().getColumn();
        switch (col){
            case 0 :
                classStringCellEditEvent.getRowValue().setName(classStringCellEditEvent.getNewValue());
                break;
            case 1 :
                classStringCellEditEvent.getRowValue().setType(classStringCellEditEvent.getNewValue());
                break;
            case 2 :
                classStringCellEditEvent.getRowValue().setTeacher(classStringCellEditEvent.getNewValue());
                break;
            case 3 :
                classStringCellEditEvent.getRowValue().setCourse(classStringCellEditEvent.getNewValue());
                break;
        }
         */
    }


    /**
     * Remover
     */
    public void handleRemoveRoomAction(ActionEvent actionEvent) {
        Room room = roomTable.getSelectionModel().getSelectedItem();
        System.out.println(room);
    }

    public void handleRemoveTeacherAction(ActionEvent actionEvent) {
        Teacher teacher = teacherTable.getSelectionModel().getSelectedItem();
        System.out.println(teacher);
    }

    public void handleRemoveStudentAction(ActionEvent actionEvent) {
        Student student = studentTable.getSelectionModel().getSelectedItem();
        System.out.println(student);
    }

    public void handleRemoveCourseUnitAction(ActionEvent actionEvent) {
        CourseUnit courseUnit = courseunitTable.getSelectionModel().getSelectedItem();
        System.out.println(courseUnit);
    }

    public void handleRemoveClassAction(ActionEvent actionEvent) {
        Class classe = classTable.getSelectionModel().getSelectedItem();
        System.out.println(classe);
    }

}
