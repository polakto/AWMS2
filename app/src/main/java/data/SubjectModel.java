package data;

import java.io.Serializable;

/**
 * Created by DN on 23/11/2015.
 */
public class SubjectModel implements Serializable {
    public static final String TAG = "Subject";
    private static final long serialVersionUID = -7406082437623008161L;

    private int subjectId;
    private String subjectName;
    private UomModel subjectUoM;



    public SubjectModel(){}
    // constructor
    public SubjectModel(String sName) {
        this.subjectName = sName;
    }

    public int getId() {
        return subjectId;
    }
    public void setId(int sId) {
        this.subjectId = sId;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String sName) {
        this.subjectName = sName;
    }

    public UomModel getUoM() {
        return subjectUoM;
    }
    public void setUoM(UomModel UomS) {
        this.subjectUoM = UomS;
    }
}
