package Model;

import java.io.Serializable;

/**
 * This class is a bean which will store the orders made by users
 * 
 */
public class OrderBean implements Serializable {
//Private attributes in the bean

    private int orderID;
    private int userID;
    private float price;
    private String orderDate;
    private long orderNo;

    /**
     * Zero constructor for OrderBean
     * @param orderID unique auto incremental number as the ID of the order
     * @param userID the ID of the user making the order
     * @param price the price of the order
     * @param orderDate the date that the order has been made
     */
    public OrderBean() {
        orderID = 0;
        userID = 0;
        price = 0;
        orderDate = "";
        orderNo = 0;
    }

    /**
     * The constructor to initialize the attributes with defined values
     * @param OrderID unique auto incremental number as the ID of the order
     * @param UserID the ID of the user making the order
     * @param Price the price of the order
     * @param OrderDate the date that the order has been made
     */
    public OrderBean(int OrderID, int UserID, float Price, String OrderDate, long OrderNo) {
        orderID = OrderID;
        userID = UserID;
        price = Price;
        orderDate = OrderDate;
        orderNo = OrderNo;
    }

    public void setOrderNo(long OrderNo){
        this.orderNo = OrderNo;
    }

    public long getOrderNo(){
        return this.orderNo;
    }
    /**
     * The setter method for orderID which will set the user defined value to
     * the respective bean value
     * @param OrderID the value defined by user
     */
    public void setOrderID(int OrderID) {
        orderID = OrderID;
    }

    /**
     * The getter method for OrderID which will return the value of the order
     * ID
     * @return The ID for an order will be returned
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * The setter method for userID which will set the user defined value to
     * the respective bean value
     * @param UserID the value for UserID defined by user
     */
    public void setUserID(int UserID) {
        userID = UserID;
    }

    /**
     * The getter method for UserID which will return the value of the User
     * ID
     * @return UserID The ID for an user which has made an order will be returned
     */
    public int getUserID() {
        return userID;
    }

    /**
     * The setter method for OrderPrice which will set the user defined value to
     * the respective bean value
     * @param OrderPrice the value for UserID defined by user
     */
    public void setOrderPrice(float OrderPrice) {
        price = OrderPrice;
    }

    /**
     * The getter method for OrderPrice which will return the value of the Price
     * of an order
     * @return price of The order will be returned
     */
    public float getOrderPrice() {
        return price;
    }

    /**
     * The setter method for OrderDate which will set the user defined value to
     * the respective bean value
     * @param OrderDate the value for date defined by user
     */
    public void setOrderDate(String OrderDate) {
        orderDate = OrderDate;
    }

    /**
     * The getter method for OrderDate which will return the value of the Date
     * of an order
     * @return date of The order will be returned
     */
    public String getOrderDate() {
        return orderDate;
    }
}
