package data;

import com.support.android.designlibdemo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import interfaces.UiToData2;

/**
 * Created by Dell on 24.11.2015.
 */
public class SecondDataLayer implements UiToData2 {
    @Override
    public int[] getAllSubjectsIds() {
        return new int[0];
    }

    @Override
    public Double getStatusBySubject(int id) {
        return null;
    }

    @Override
    public String[] getAllTransactionsIds() {
        return new String[0];
    }

    @Override
    public String[] getTransactionById(int id) {
        return new String[0];
    }

    @Override
    public Date getDateOfTransaction(int id) {
        return null;
    }

    @Override
    public String getTypeOfTransaction(int id) {
        return null;
    }

    @Override
    public String getSubjectNameOfTransaction(int id) {
        return null;
    }

    @Override
    public Double getQ1OfTransaction(int id) {
        return null;
    }

    @Override
    public String getQ1UomOfTransaction(int id) {
        return null;
    }

    @Override
    public Double getUnitPriceOfTransaction(int id) {
        return null;
    }

    @Override
    public Double getValueOfTransaction(int id) {
        return null;
    }

    /**
     * ARTIFICIAL DATA FOR DEMO
     */

    /**
     * These method is just for our example.
     * @return
     */
    public static List getArtificialDashboardData(){
        List<String> sArtificialDataDashboard = new ArrayList();
        sArtificialDataDashboard.add("WOOD  15 675.90 tons");
        sArtificialDataDashboard.add("OIL   11 890.43 litres");
        sArtificialDataDashboard.add("SAND   3 234.09 tons");
        sArtificialDataDashboard.add("MILK 113 234.09 tons");
        return sArtificialDataDashboard;
    };

    public static ArrayList getAllCommodities(){
        ArrayList<HashMap> myList = new ArrayList();

        HashMap commodity = new HashMap();
        commodity.put("id", 0);
        commodity.put("name", "wood");
        commodity.put("quantity", 29.87);
        commodity.put("picture", "commodity_11");
        myList.add(0, commodity);

        HashMap commodity2 = new HashMap();
        commodity2.put("id", 1);
        commodity2.put("name", "coffee");
        commodity2.put("quantity", 129.87);
        commodity2.put("picture", "commodity_3");
        myList.add(1, commodity2);

        HashMap commodity3 = new HashMap();
        commodity3.put("id", 2);
        commodity3.put("name", "rock");
        commodity3.put("quantity", 11129.87);
        commodity3.put("picture", "commodity_12");
        myList.add(2, commodity3);

        HashMap commodity4 = new HashMap();
        commodity4.put("id", 3);
        commodity4.put("name", "sand");
        commodity4.put("quantity", 129.87);
        commodity4.put("picture", "commodity_8");
        myList.add(3, commodity4);




        return myList;
    }

    /**
     * These method is just for our example.
     * @return
     */
    public static List getArtificialTransactionsData(){
        List<String> sArtificialDataTransactions = new ArrayList();
        sArtificialDataTransactions.add("IN  WOOD  12.89 tons");
        sArtificialDataTransactions.add("OUT OIL   90.43 litres");
        sArtificialDataTransactions.add("IN MILK   34.09 litres");
        sArtificialDataTransactions.add("OUT SAND  11.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  10.89 tons");
        sArtificialDataTransactions.add("OUT OIL   95.43 litres");
        sArtificialDataTransactions.add("IN MILK   39.09 litres");
        sArtificialDataTransactions.add("OUT SAND  19.00 tons");
        sArtificialDataTransactions.add("IN  WOOD  112.89 tons");
        sArtificialDataTransactions.add("OUT OIL   190.43 litres");
        sArtificialDataTransactions.add("IN MILK   134.09 litres");
        sArtificialDataTransactions.add("OUT SAND  111.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  110.89 tons");
        sArtificialDataTransactions.add("OUT OIL   195.43 litres");
        sArtificialDataTransactions.add("IN MILK   139.09 litres");
        sArtificialDataTransactions.add("OUT SAND  119.00 tons");
        sArtificialDataTransactions.add("IN  WOOD  112.89 tons");
        sArtificialDataTransactions.add("OUT OIL   290.43 litres");
        sArtificialDataTransactions.add("IN MILK   334.09 litres");
        sArtificialDataTransactions.add("OUT SAND  211.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  3310.89 tons");
        sArtificialDataTransactions.add("OUT OIL   2295.43 litres");
        sArtificialDataTransactions.add("IN MILK   6639.09 litres");
        sArtificialDataTransactions.add("OUT SAND  99019.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  12.89 tons");
        sArtificialDataTransactions.add("IN OIL   90.43 litres");
        sArtificialDataTransactions.add("OUT MILK   34.09 litres");
        sArtificialDataTransactions.add("IN SAND  11.00 tons");
        sArtificialDataTransactions.add("IN  WOOD  10.89 tons");
        sArtificialDataTransactions.add("IN OIL   95.43 litres");
        sArtificialDataTransactions.add("OUT MILK   39.09 litres");
        sArtificialDataTransactions.add("IN SAND  19.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  112.89 tons");
        sArtificialDataTransactions.add("IN OIL   190.43 litres");
        sArtificialDataTransactions.add("OUT MILK   134.09 litres");
        sArtificialDataTransactions.add("IN SAND  111.00 tons");
        sArtificialDataTransactions.add("IN  WOOD  110.89 tons");
        sArtificialDataTransactions.add("IN OIL   195.43 litres");
        sArtificialDataTransactions.add("OUT MILK   139.09 litres");
        sArtificialDataTransactions.add("IN SAND  119.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  112.89 tons");
        sArtificialDataTransactions.add("IN OIL   290.43 litres");
        sArtificialDataTransactions.add("OUT MILK   334.09 litres");
        sArtificialDataTransactions.add("IN SAND  211.00 tons");
        sArtificialDataTransactions.add("OUT  WOOD  3310.89 tons");
        sArtificialDataTransactions.add("IN OIL   2295.43 litres");
        sArtificialDataTransactions.add("OUT MILK   6639.09 litres");
        sArtificialDataTransactions.add("IN SAND  99019.00 tons");
        return sArtificialDataTransactions;

    };


}
