package Model;

import java.io.Serializable;

/**
 *
 *
 * This class is Bean for Food Table in the Database.
 * It's responsible to deal with Food problems and issuing relevant
 * transactions within DB.
 *
 */

public class FoodBean implements Serializable {

    private int foodID;
    private String foodName;
    private float foodPrice;
    private String foodDescription;

    /**
     * It's a Zero constructor for FoodBean .
     * @param foodID Integer which represents the ID of food
     * @param foodName  String that is the name of food
     * @param foodPrice Double which is the price of food 
     */
    public FoodBean () {

        foodID = 0;
        foodName = "";
        foodPrice = 0; // "0.0" because it's double
        foodDescription = "";

    }

    /**
     * Now we can define a Constructor for our class
     *
     * @param foodDescription is String and it represents the description of the food.
     */
    public FoodBean (int ID, String Name, float Price, String foodDescription){

        foodID = ID;
        foodName = Name;
        foodPrice = Price;
        this.foodDescription = foodDescription;
    }

    /**
     * Setter for foodID
     * @param ID which sets the ID of food as an argument
     */
    public void setFoodID(int id)
    {
        foodID = id;
    }

    /**
     * Getter for foodID
     * @return foodID which returns the ID of food as an attribute
     */
    public int getFoodID()
    {
      return foodID;
    }

    /**
     * Setter for foodName
     * @param fName which sets the name of food as an argument
     */
    public void setFoodName(String fName)
    {
        foodName = fName;
    }

    /**
     * Getter for foodName
     * @return foodName which returns the name of food as an attribute
     */
    public String getFoodName()
    {
      return foodName;
    }
    
    /**
     * Setter for price
     * @param price which sets the price of food as an argument
     */
    public void setFoodPrice(float price)
    {
        foodPrice = price;
    }

    /**
     * Getter for price
     * @return foodPrice which returns the price of food as an attribute
     */
    public float getFoodPrice()
    {
      return foodPrice;
    }

    /**
     * This is getter for foodDescrption attribute according to the definition of JavaBeans. The aim of using this method is
     * that since this attribute is private though the value of this attribute is not reachable from outside of this class so
     * by invoking this method the value of foodDescription attribute is accessible.
     *
     * @return foodDescription as String and it contains the value of foodDescription attribute.
     */
    public String getFoodDescription() {
        return foodDescription;
    }

    /**
     * This is setter for foodDescription attribute according to the definition of JavaBeans. The aim of using this method is
     * that since this attribute is private though it is not possible to change/edit the value of this attribute from outside of
     * this class but by invoking of this method it is possible to edit/change the value of foodDescription attribute from
     * outside of this class.
     *
     * @param foodDescription is String. This String will be assign as value for foodDescription attribute.
     */
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

}
