package Model;

import java.io.Serializable;

/**
 *
 * This class is a Bean for Items of orderd food. Within this class we can
 * interact with BASKET items.
 * 
 */

public class ItemsBean implements Serializable {

    private int foodID;
    private int quantity;
    private String foodName;
    private float foodPrice;

    /**
     * It's a Zero constructor for FoodBean .
     * @param foodID Integer which represents the ID of food
     * @param quantity Integer that is the quantity of orderd food
     *
     */
    public ItemsBean () {

        foodID = 0;
        quantity = 0;
        foodName = "";

    }

    /**
     * Defining the Constructor for the class
     */
    public ItemsBean ( int ID, int quant , String name, float fPrice){

        foodID = ID;
        quantity = quant;
        foodName = name;
        foodPrice = fPrice;
        
    }

    /**
     * This method sets the Id of the food for future processing. It's a so
     * called "setter" for foodID.
     * @param ID which sets the ID of food as an argument
     */
    public void setFoodID(int foodid)
    {
        this.foodID = foodid;
    }

    /**
     * This method calls back the ID of the food for future processing.It's a
     * so called "getter" for foodID.
     * @return foodID which returns the ID of food as an attribute
     */
    public int getFoodID()
    {
      return foodID;
    }

    /**
     * This method sets the quantity of the orderd food for future processing.
     * It's a so called "setter" for quantity.
     * @param quantity which sets the quantity of food as an argument
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * This method calls back the quantity of the food for future processing.
     * It's a so called "getter" for quantity.
     * @return quantity which returns the quantity of food as an attribute
     */
    public int getQuantity()
    {
      return quantity;
    }

    /**
     * This method sets the Name of the food for future processing. It's a so
     * called "setter" for foodName.
     * @param foodName which sets the name of food as an argument
     */
    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    /**
     * This method calls back the name of the food for future processing.
     * It's a so called "getter" for foodName.
     * @return foodName which returns the name of food as an attribute
     */
    public String getFoodName()
    {
      return foodName;
    }

    /**
     * This method sets the food price of the orderd food for future processing.
     * It's a so called "setter" for foodPrice.
     * @param fPrice which sets the food Price of food as an argument
     */
    public void setFoodPrice(float fPrice)
    {
        this.foodPrice = fPrice;
    }

    /**
     * This method calls back the foodPrice of the food for future processing.
     * It's a so called "getter" for foodPrice.
     * @return foodPrice which returns the foodPrice of food as an attribute
     */
    public float getFoodPrice()
    {
      return foodPrice;
    }

}
