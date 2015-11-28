package data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DN on 23/11/2015.
 */
public class TransactionModel implements Serializable {
    public static final String TAG = "Transaction";
    private static final long serialVersionUID = -7406082437623008161L;

    private int transId;
    private String transStatus;//to Do Boolean
    private Date transDate; //to Do Date
    private String transQuantity;
    private String transValue;
    private SubjectModel transSubject;


    public TransactionModel(){}
    // constructor
    public TransactionModel(String tStatus,Date tDate,String tQuantity,String tValue) {
        this.transStatus=tStatus;
        this.transDate=tDate;
        this.transQuantity=tQuantity;
        this.transValue=tValue;
    }

    public int getId() {
        return transId;
    }
    public void setId(int tId) {
        this.transId = tId;
    }

    public String getTransStatus() {return transStatus;}
    public void setTransStatus(String tStatus) { this.transStatus = tStatus;}

    public Date getTransDate() {return transDate;}
    public void setTransDate(Date tDate) { this.transDate = tDate;}

    public String getTransactionQuantity() {return  transQuantity;}
    public void setTransactionQuantity(String tQuantity){this.transQuantity=tQuantity;}

    public String getTransactionValue() {return  transValue;}
    public void setTransactionValue(String tValue){this.transQuantity=tValue;}

    public SubjectModel getTransSubject() {
        return transSubject;
    }
    public void setTransSubject(SubjectModel tSubject) {
        this.transSubject = tSubject;
    }
}
