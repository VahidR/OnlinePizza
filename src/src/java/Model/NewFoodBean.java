package Model;

import java.io.Serializable;

/**
 * This class will create the bean for ingredients
 * 
 */

public class NewFoodBean implements Serializable {

    private String foodName;
    private String foodDescription;

    private String ingName1;
    private int quantityNeeded1;
    private int price1;

    private String ingName2;
    private int quantityNeeded2;
    private int price2;

    private String ingName3;
    private int quantityNeeded3;
    private int price3;

    private String ingName4;
    private int quantityNeeded4;
    private int price4;

    private String ingName5;
    private int quantityNeeded5;
    private int price5;


    public NewFoodBean() {
        foodName = "";
        foodDescription = "";

        ingName1 = "";
        quantityNeeded1 = 0;
        price1 = 0;

        ingName2 = "";
        quantityNeeded2 = 0;
        price2 = 0;

        ingName3 = "";
        quantityNeeded3 = 0;
        price3 = 0;

        ingName4 = "";
        quantityNeeded4 = 0;
        price4 = 0;

        ingName5 = "";
        quantityNeeded5 = 0;
        price5 = 0;
    }


    public NewFoodBean(String FoodName, String FoodDescription, String IngName1,
            int QuantityNeeded1, int Price1, String IngName2,
            int QuantityNeeded2, int Price2,String IngName3,
            int QuantityNeeded3, int Price3,String IngName4,
            int QuantityNeeded4, int Price4,String IngName5,
            int QuantityNeeded5, int Price5)
    {
        this.foodName = FoodName;
        this.foodDescription = FoodDescription;

        this.ingName1 = IngName1;
        this.quantityNeeded1 = QuantityNeeded1;
        this.price1 = Price1;

        this.ingName2 = IngName2;
        this.quantityNeeded2 = QuantityNeeded2;
        this.price2 = Price2;

        this.ingName3 = IngName3;
        this.quantityNeeded3 = QuantityNeeded3;
        this.price3 = Price3;

        this.ingName4 = IngName4;
        this.quantityNeeded4 = QuantityNeeded4;
        this.price4 = Price4;

        this.ingName5 = IngName5;
        this.quantityNeeded5 = QuantityNeeded5;
        this.price5 = Price5;
    }


    public void setFoodName(String FoodName) {
        this.foodName = FoodName;
    }


    public void setFoodDescription(String FoodDescription) {
        this.foodDescription = FoodDescription;
    }


    public void setIngName1(String IngName1) {
        this.ingName1 = IngName1;
    }

    public void setQuantityNeeded1(int QuantityNeeded1) {
        this.quantityNeeded1 = QuantityNeeded1;
    }

    public void setPrice1(int Price1) {
        this.price1 = Price1;
    }

    ////////////////////////////////////////////////////////

    public void setIngName2(String IngName2) {
        this.ingName2 = IngName2;
    }

    public void setQuantityNeeded2(int QuantityNeeded2) {
        this.quantityNeeded2 = QuantityNeeded2;
    }

    public void setPrice2(int Price2) {
        this.price2 = Price2;
    }

    /////////////////////////////////////////////////////////

    public void setIngName3(String IngName3) {
        this.ingName3 = IngName3;
    }

    public void setQuantityNeeded3(int QuantityNeeded3) {
        this.quantityNeeded3 = QuantityNeeded3;
    }

    public void setPrice3(int Price3) {
        this.price3 = Price3;
    }

    ///////////////////////////////////////////////////////

    public void setIngName4(String IngName4) {
        this.ingName4 = IngName4;
    }

    public void setQuantityNeeded4(int QuantityNeeded4) {
        this.quantityNeeded4 = QuantityNeeded4;
    }

    public void setPrice4(int Price4) {
        this.price4 = Price4;
    }

    /////////////////////////////////////////////////////////

    public void setIngName5(String IngName5) {
        this.ingName5 = IngName5;
    }

    public void setQuantityNeeded5(int QuantityNeeded5) {
        this.quantityNeeded5 = QuantityNeeded5;
    }

    public void setPrice5(int Price5) {
        this.price5 = Price5;
    }



    //////////////////////////////////////////////////////////////
    ///
    ///
    ///                Getter Functions
    ///
    ///
    //////////////////////////////////////////////////////////////


    public String getFoodName() {
        return this.foodName;
    }


    public String getFoodDescription() {
        return this.foodDescription;
    }


    public String getIngName1() {
        return this.ingName1;
    }

    public int getQuantityNeeded1() {
        return this.quantityNeeded1;
    }

    public int getPrice1() {
        return this.price1;
    }

    ////////////////////////////////////////////////////////

    public String getIngName2() {
        return this.ingName2;
    }

    public int getQuantityNeeded2() {
        return this.quantityNeeded2;
    }

    public int getPrice2() {
        return this.price2;
    }

    /////////////////////////////////////////////////////////

    public String getIngName3() {
        return this.ingName3;
    }

    public int getQuantityNeeded3() {
        return this.quantityNeeded3;
    }

    public int getPrice3() {
        return this.price3;
    }

    ///////////////////////////////////////////////////////

    public String getIngName4() {
        return this.ingName4;
    }

    public int getQuantityNeeded4() {
        return this.quantityNeeded4;
    }

    public int getPrice4() {
        return this.price4;
    }

    /////////////////////////////////////////////////////////

    public String getIngName5() {
        return this.ingName5;
    }

    public int getQuantityNeeded5() {
        return this.quantityNeeded5;
    }

    public int getPrice5() {
        return this.price5;
    }

}
   
