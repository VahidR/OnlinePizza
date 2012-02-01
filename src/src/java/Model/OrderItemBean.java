
package Model;

import java.io.Serializable;

/**
 * This class provide a tool to make object of orderItem which is applied to follow
 * the user order items. it will use an orderID to trace the order details and
 * a foodId to have information about the food and quantity to know how how many
 * of that food order by in this order.
 * Due to the definition of java bean you are not allowed to access the private properties
 * of this class. Hence, I have provide some method to apply to access these properties.
 *
 */
public class OrderItemBean implements Serializable {
    private int orderID;
    private int foodID;
    private int quantity;
    private float foodPrice;

    /**
     * zero constructor to initiate instances
     * @param orderID which is the integer number that declare the corresponding order
     * @param foodID an integer number to determine the food
     * @param quantity represents the number of the food in the order
     */
    public OrderItemBean() {
        orderID = 0;
        foodID = 0;
        quantity = 0;
        foodPrice = 0;
    }

    /**
     * The constructor to initialize the attributes with defined values
     * @param orderID which is the integer number that declare the corresponding order
     * @param foodID an integer number to determine the food
     * @param quantity represents the number of the food in the order
     * @param foodPrice represent the food price
     */
    public OrderItemBean(int orderID, int foodID, int quantity, float foodPrice) {
        this.orderID= orderID;
        this.foodID = foodID;
        this.quantity = quantity;
        this.foodPrice = foodPrice;
    }

    /**
     * set method to set the value of the orderID (of this object) with the given
     * orderID as a input parameter.
     *
     * @param orderID the value which will be set as orderID for current
     * instance of this class. It should be integer.
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * set method to set the value of the foodID (of this object) with the given
     * foodID as a input parameter.
     *
     * @param foodID the value which will be set as foodID for current
     * instance of this class. It should be integer.
     */
    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    /**
     * set method to set the value of the foodPrice (of this object) with the given
     * foodPrice as a input parameter.
     *
     * @param foodPrice the value which will be set as foodPrice for current
     * instance of this class. It should be float.
     */
    public void setFoodPrice(float foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * set method to set the value of the quantity (of this object) with the given
     * quantity as a input parameter.
     *
     * @param quantity the value which will be set as quantity for current
     * instance of this class. It should be integer.
     */
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    /**
     * get method to return the orderID of the current instance of this class
     * @return orderID an integer value representing the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * get method to return the foodID of the current instance of this class
     * @return foodID an integer value representing the foodID
     */
    public int getFoodID() {
        return foodID;
    }

     /**
     * get method to return the foodPrice of the current instance of this class
     * @return foodPrice an float value representing the foodPrice
     */
    public float getFoodPrice() {
        return foodPrice;
    }

    /**
     * get method to return the Quantity of the current instance of this class
     * @return quantity an integer value representing the quantity
    */
    public int getQuantity() {
        return quantity;
    }

}
