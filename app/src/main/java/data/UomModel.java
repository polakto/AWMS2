package data;

import java.io.Serializable;

/**
 * Created by DN on 23/11/2015.
 */
public class UomModel implements Serializable {

    public static final String TAG = "UoM";
    private static final long serialVersionUID = -7406082437623008161L;

    private int UoMId;
    private String UoMName;
    ;

    public UomModel() {}


    public UomModel(String name) {
        this.UoMName = name;
    }


    public long getId() {
        return UoMId;
    }
    public void setId(int uId) {
        this.UoMId = uId;
    }

    public String getUoMName() {
        return UoMName;
    }
    public void setUomName(String uName) {
        this.UoMName = uName;
    }
}
