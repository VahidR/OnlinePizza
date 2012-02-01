/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;


import java.io.Serializable;

public class FoodIngBean implements Serializable{

    private int ingID;
    private int quantityNeeded;

   /**
     * Now we can define a Constructor for our class
     *
     */
    public FoodIngBean () {

        ingID = 0;
        quantityNeeded = 0;

    }



     /**
     *
     * @param ingID Integer which represents the ID of the ingredient
     * @param QuantityNeeded the number of the needed quantity
     */
    public FoodIngBean (int ID, int qN){

        ingID = ID;
        quantityNeeded = qN;

   }

    /**
     * Setter for ingID
     * @param ingID which sets the ingID
     */
    public void setIngID(int id)
    {
        ingID = id;
    }

    /**
     * Getter for foodID
     * @return ingID which returns the ingID
     */
    public int getIngID()
    {
      return ingID;
    }

    /**
     * Setter for quantityNeeded
     * @param quantityNeeded which sets quantityNeeded
     */
    public void setQuantityNeeded(int qN)
    {
        quantityNeeded = qN;
    }

    /**
     * Getter for fquantityNeeded
     * @return quantityNeeded which returns the quantityNeeded attribute
     */
    public int getQuantityNeeded()
    {
      return quantityNeeded;
    }

}
