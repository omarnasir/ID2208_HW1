package dataObjects;

import java.util.Date;

public class Transcript {

    private String name;
    private int studentID;
    private String university;
    private String degree;
    private Date startingYear;
    private Date endingYear;
    private double TotalGPA;

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

    public void setEndingYear(Date endingYear) {
        this.endingYear = endingYear;
    }

    public Date getEndingYear() {
        return endingYear;
    }

    public double getTotalGPA() {
        return TotalGPA;
    }

    public void setTotalGPA(double TotalGPA) {
        this.TotalGPA = TotalGPA;
    }
}
