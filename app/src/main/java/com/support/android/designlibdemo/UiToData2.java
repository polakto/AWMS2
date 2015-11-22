package com.support.android.designlibdemo;

import java.util.Date;

/**
 * Created by TP on 13.11.2015.
 */
public interface UiToData2 {

    /**
     * DASHBOARD TAB FUNCTIONALITY
     * these methods is needed for dashboard tab in app
     * only must to do in classiuhii
     */

    /**
     *
     * @return array with int values of subjects ids
     */
    public int[] getAllSubjectsIds();

    /**
     *
     * @param id - id of subject
     * @return Double - SUM of all IN and OUT transactions for exact subject
     */
    public Double getStatusBySubject(int id);



    /**
     * TRANSACTIONS TAB FUNCTIONALITY
     * these methods is needed for transactions tab in app
     */

    /**
     * no parameter
     * @return
     */
    public String[] getAllTransactionsIds();

    /**
     *
     * @param id
     * @return all values of transaction in formatted form
     */
    public String[] getTransactionById(int id);

    /**
     * @param id - id of transaction
     * @return Date of transaction
     */
    public Date getDateOfTransaction(int id);

    /**
     *
     * @param id - id of transaction
     * @return String
     */
    public String getTypeOfTransaction(int id);

    /**
     *
     * @param id - id of transaction
     * @return String - subject name
     */
    public String getSubjectNameOfTransaction(int id);

    /**
     *
     * @param id - id of transaction
     * @return Double - quantity 1 value
     */
    public Double getQ1OfTransaction(int id);

    /**
     *
     * @param id - id of transaction
     * @return String - Unit of Measurement
     */
    public String getQ1UomOfTransaction(int id);

    /**
     *
     * @param id - id of transaction
     * @return Double - unit price from transaction
     */
    public Double getUnitPriceOfTransaction(int id);

    /**
     *
     * @param id - id of transaction
     * @return Double - value of transaction
     */
    public Double getValueOfTransaction(int id);



}
