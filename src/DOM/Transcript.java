import java.util.ArrayList;
import java.util.Date;


public class Transcript {

    private String name;
    private int studentID;
    private String university;
    private String degree;
    private Date startingYear;
    private Date endingtear;
    private ArrayList<Course> courses;

    public Transcript() {
        this.courses = new ArrayList<Course>();
    }

    public Course getCourse(int num) {
        return courses.get(num);
    }

    public int getCourseSize() {
        return courses.size();
    }


    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(Date startingYear) {
        this.startingYear = startingYear;
    }

    public Date getEndingtear() {
        return endingtear;
    }

    public void setEndingtear(Date endingtear) {
        this.endingtear = endingtear;
    }
}
