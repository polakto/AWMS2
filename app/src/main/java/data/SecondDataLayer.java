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
        commodity.put("quantity", 295.87);
        commodity.put("uom", "t");
        commodity.put("picture", "commodity_11");
        myList.add(0, commodity);

        HashMap commodity2 = new HashMap();
        commodity2.put("id", 1);
        commodity2.put("name", "coffee");
        commodity2.put("quantity", 967.87);
        commodity2.put("uom", "t");
        commodity2.put("picture", "commodity_3");
        myList.add(1, commodity2);

        HashMap commodity3 = new HashMap();
        commodity3.put("id", 2);
        commodity3.put("name", "rock");
        commodity3.put("quantity", 5129.87);
        commodity3.put("uom", "t");
        commodity3.put("picture", "commodity_12");
        myList.add(2, commodity3);

        HashMap commodity4 = new HashMap();
        commodity4.put("id", 3);
        commodity4.put("name", "paint");
        commodity4.put("quantity", 101.87);
        commodity4.put("uom", "l");
        commodity4.put("picture", "commodity_10");
        myList.add(3, commodity4);

        HashMap commodity5 = new HashMap();
        commodity5.put("id", 4);
        commodity5.put("name", "coal");
        commodity5.put("quantity", 667.87);
        commodity5.put("uom", "l");
        commodity5.put("picture", "commodity_5");
        myList.add(4, commodity5);




        return myList;
    }

    /**
     * These method is just for our example.
     * @return
     */
    public static ArrayList getAllTransactions(){
        ArrayList<HashMap> transactions = new ArrayList();

        HashMap transaction0 = new HashMap();
        transaction0.put("id", 0);
        transaction0.put("commodity", "coffee");
        transaction0.put("date", "20.10.2015");
        transaction0.put("quantity", 15.90);
        transaction0.put("uom", "t");
        transaction0.put("type", "IN");
        transaction0.put("picture", "commodity_3");
        transactions.add(0, transaction0);

        HashMap transaction1 = new HashMap();
        transaction1.put("id", 1);
        transaction1.put("commodity", "sand");
        transaction1.put("date", "3.6.2009");
        transaction1.put("quantity", 22.13);
        transaction1.put("uom", "t");
        transaction1.put("type", "IN");
        transaction1.put("picture", "commodity_8");
        transactions.add(1, transaction1);

        HashMap transaction2 = new HashMap();
        transaction2.put("id", 2);
        transaction2.put("commodity", "coal");
        transaction2.put("date", "2.1.1996");
        transaction2.put("quantity", 19.34);
        transaction2.put("uom", "t");
        transaction2.put("type", "OUT");
        transaction2.put("picture", "commodity_1");
        transactions.add(2, transaction2);

        HashMap transaction3 = new HashMap();
        transaction3.put("id", 3);
        transaction3.put("commodity", "coffee");
        transaction3.put("date", "20.10.2015");
        transaction3.put("quantity", 15.90);
        transaction3.put("uom", "t");
        transaction3.put("type", "IN");
        transaction3.put("picture", "commodity_3");
        transactions.add(3, transaction3);

        HashMap transaction4 = new HashMap();
        transaction4.put("id", 4);
        transaction4.put("commodity", "sand");
        transaction4.put("date", "3.6.2009");
        transaction4.put("quantity", 22.13);
        transaction4.put("uom", "t");
        transaction4.put("type", "IN");
        transaction4.put("picture", "commodity_8");
        transactions.add(4, transaction4);

        HashMap transaction5 = new HashMap();
        transaction5.put("id", 5);
        transaction5.put("commodity", "coal");
        transaction5.put("date", "2.1.1996");
        transaction5.put("quantity", 19.34);
        transaction5.put("uom", "t");
        transaction5.put("type", "OUT");
        transaction5.put("picture", "commodity_1");
        transactions.add(5, transaction5);




        return transactions;
    };


}
