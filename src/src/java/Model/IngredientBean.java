package Model;

import java.io.Serializable;

/**
 * This class will create the bean for ingredients
 * 
 */

public class IngredientBean implements Serializable {

    private int ingID;
    private String ingName;
    private float ingPrice;
    private int ingQuantity;

    /**
     * zero constructor to initiate instances
     * @param ingID a unique auto incremental number as the ID of the ingredient
     * @param ingName represents the name of the ingredient
     * @param ingPrice represents the price of the ingredient
     */
    public IngredientBean() {
        ingID = 0;
        ingName = "";
        ingPrice = 0;
        ingQuantity = 0;
    }

    /**
     * The constructor to initialize the attributes with defined values
     * @param ID a unique auto incremental number as the ID of the ingredient
     * @param Name represents the name of the ingredient
     * @param Price represents the price of the ingredient
     */
    public IngredientBean(int ID, String Name, float Price, int Quantity) {
        ingID = ID;
        ingName = Name;
        ingPrice = Price;
        ingQuantity = Quantity;
    }

    /**
     * set method to set the value of the ingredient ID to the value defiened by the
     * user
     * @param ID the value which will be set as ingredient ID
     */
    public void setIngID(int ID) {
        ingID = ID;
    }

    /**
     * set method to set the value of the ingredient Name to the value defiened by the
     * user
     * @param Name the value which will be set as ingredient Name
     */
    public void setIngName(String Name) {
        ingName = Name;
    }

    /**
     * set method to set the value of the ingredient Price to the value defiened by the
     * user
     * @param Price the value which will be set as ingredient Price
     */
    public void setIngPrice(float Price) {
        ingPrice = Price;
    }

    /**
     * get method to return the ingeredient ID for the object
     * @return ingID a unique value representing the ingeredient ID
     */
    public int getIngID() {
        return ingID;
    }

    /**
     * get method to return the ingeredient Name for the object
     * @return ingName a value representing the ingeredient Name
     */
    public String getIngName() {
        return ingName;
    }

    /**
     * get method to return the ingeredient Price for the object
     * @return ingPrice a value representing the ingeredient Price
     */
    public float getIngPrice() {
        return ingPrice;
    }

    public int getIngQuantity(){
        return ingQuantity;
    }

    public void setIngQuantity(int Quantity){
        ingQuantity = Quantity;
    }
}
