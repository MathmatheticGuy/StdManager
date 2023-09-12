package StudentPackage;


public class StudentObj {
    private int student_ID;
    private int course_ID;
    private float student_score;
    private String description;
    
    public StudentObj(int student_ID, int course_ID, float student_score, String description){
        this.student_ID = student_ID;
        this.course_ID = course_ID;
        this.student_score= student_score;
        this.description = description;
    }
    
    public int getStdID(){
        return student_ID;
    }
    public int getCrsID(){
        return course_ID;
    }
    public float getStdScore(){
        return student_score;
    }
    public String getDescription(){
        return description;
    }
    
}
