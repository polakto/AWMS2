package data;

/**
 * Created by Dell on 27.11.2015.
 */
public class Transaction {
    private long id;
    private String type;
    private String commodity;
    private Double quantity;
    private Double value;

    public Transaction(long id, String type, String commodity, Double quantity, Double value){
        this.id = id;
        this.type = type;
        this.commodity = commodity;
        this.quantity = quantity;
        this.value = value;
    }

    public String getType(){
        return this.type;
    }


    public String getCommodity(){
        return this.commodity;
    }

    public Double getQuantity(){
        return this.quantity;
    }

    public Double getValue(){
        return this.value;
    }
}
