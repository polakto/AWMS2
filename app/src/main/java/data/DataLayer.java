package data;

import java.util.HashMap;

public class DataLayer {

    public HashMap<Integer, Transaction> mapa = new HashMap<Integer, Transaction>();

    public DataLayer(){

        mapa.put(0, new Transaction( 0, "IN", "wood", 25.7, 567.2));
        mapa.put(1, new Transaction( 1, "IN", "wood", 25.7, 567.2));
        mapa.put(2, new Transaction( 2, "IN", "oil", 125.7, 567.2));
        mapa.put(3, new Transaction( 3, "OUT", "sand", 325.7, 567.2));
        mapa.put(4, new Transaction( 4, "IN", "wood", 27775.7, 567.2));
        mapa.put(5, new Transaction( 5, "OUT", "sand", 28905.7, 567.2));
        mapa.put(6, new Transaction( 6, "IN", "wood", 21115.7, 567.2));
    }

    public HashMap getTransactions(){
        return mapa;
    }

    public String getType(int cislo){
        return this.mapa.get(cislo).getCommodity();
    }
}

