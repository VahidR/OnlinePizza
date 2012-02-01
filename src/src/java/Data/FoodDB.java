/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.sql.*;
import Model.NewFoodBean;

public class FoodDB {
    public static int insert(NewFoodBean newFood){


        int foodID = 0;

        int[] ingID = new int[5];
        int ingCounter = -1;
        CallableStatement PreparedFunc1;

        int[] quantity = new int[5];

        

        ConnectionPool pool = ConnectionPool.getInstance();
        
        Connection connection = pool.getConnection();
        
        if (newFood.getIngName1().length() != 0)
        {
            try
            {
                
                
                ++ingCounter;
                quantity[ingCounter] = newFood.getQuantityNeeded1();
                
                PreparedFunc1 = connection.prepareCall
                                ("{? = call insert_new_ingredient(?, ?) }");
                PreparedFunc1.registerOutParameter(1,Types.INTEGER);
                PreparedFunc1.setString(2, newFood.getIngName1());
                PreparedFunc1.setInt(3, newFood.getPrice1());
                PreparedFunc1.execute();

                ingID[ingCounter] = PreparedFunc1.getInt(1);
               

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        
        finally {

                 
                }
        }

        /////////////////////////////////////////

        if (newFood.getIngName2().length() != 0)
        {
            try
            {
                
                ++ingCounter;
                quantity[ingCounter] = newFood.getQuantityNeeded2();


                CallableStatement PreparedFunc2 = connection.prepareCall
                                ("{ ? = call insert_new_ingredient(?, ?) }");
                PreparedFunc2.registerOutParameter(1,Types.INTEGER);
                PreparedFunc2.setString(2, newFood.getIngName2());
                PreparedFunc2.setInt(3, newFood.getPrice2());


                PreparedFunc2.execute();
                
                ingID[ingCounter] = PreparedFunc2.getInt(1);
                

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        /**
         * make free connection object and put it back to connection pool.
         */
        finally {
                 
                }
        }

        ////////////////////////////////////////////////

        if (newFood.getIngName3().length() != 0)
        {
            try
            {
                
                ++ingCounter;
                quantity[ingCounter] = newFood.getQuantityNeeded3();
                CallableStatement PreparedFunc3 = connection.prepareCall
                                ("{ ? = call insert_new_ingredient(?, ?) }");
                PreparedFunc3.registerOutParameter(1,Types.INTEGER);
                PreparedFunc3.setString(2, newFood.getIngName3());
                PreparedFunc3.setInt(3, newFood.getPrice3());
                PreparedFunc3.execute();
                
                ingID[ingCounter] = PreparedFunc3.getInt(1);
                

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        /**
         * make free connection object and put it back to connection pool.
         */
        finally {
                 
                }
        }

        ////////////////////////////////////////////////


        if (newFood.getIngName4().length() != 0)
        {
            try
            {
                
                ++ingCounter;
                quantity[ingCounter] = newFood.getQuantityNeeded4();
                CallableStatement PreparedFunc4 = connection.prepareCall
                                ("{ ? = call insert_new_ingredient(?, ?) }");
                PreparedFunc4.registerOutParameter(1,Types.INTEGER);
                PreparedFunc4.setString(2, newFood.getIngName4());
                PreparedFunc4.setInt(3, newFood.getPrice4());
                PreparedFunc4.execute();
                
                ingID[ingCounter] = PreparedFunc4.getInt(1);
                

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        /**
         * make free connection object and put it back to connection pool.
         */
        finally {
                 
                }
        }

        ///////////////////////////////////////////////////////

        if (newFood.getIngName5().length() != 0)
        {
            try
            {
                
                ++ingCounter;
                quantity[ingCounter] = newFood.getQuantityNeeded5();
                CallableStatement PreparedFunc5 = connection.prepareCall
                                ("{ ? = call insert_new_ingredient(?, ?) }");
                PreparedFunc5.registerOutParameter(1,Types.INTEGER);
                PreparedFunc5.setString(2, newFood.getIngName5());
                PreparedFunc5.setInt(3, newFood.getPrice5());
                PreparedFunc5.execute();
                
                ingID[ingCounter] = PreparedFunc5.getInt(1);
                

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        /**
         * make free connection object and put it back to connection pool.
         */
        finally {
                 
                }
        }

        ///////////////////////////////////////////////////////////

        if (newFood.getFoodName().length() != 0)
        {
            try
            {
                
                CallableStatement PreparedFunc = connection.prepareCall
                                ("{? = call insert_new_food(?, ?) }");
                PreparedFunc.registerOutParameter(1,Types.INTEGER);
                PreparedFunc.setString(2, newFood.getFoodName());
                PreparedFunc.setString(3, newFood.getFoodDescription());
                PreparedFunc.execute();
                
                foodID = PreparedFunc.getInt(1);
               

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        
        finally {
                 
                }
        }

        /////////////////////////////////////////////////////////////////

       
            try
            {
                
                CallableStatement PreparedFuncIngFood1 = connection.prepareCall
                                ("{ ? = call insert_foodingredient(?, ?, ?) }");
                PreparedFuncIngFood1.registerOutParameter(1,Types.INTEGER);
                PreparedFuncIngFood1.setInt(2, foodID);
                PreparedFuncIngFood1.setInt(3, ingID[0]);
                PreparedFuncIngFood1.setInt(4, quantity[0]);
                PreparedFuncIngFood1.execute();
                
                
                
            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }


        try
            {

                CallableStatement PreparedFuncIngFood2 = connection.prepareCall
                                ("{ ? = call insert_foodingredient(?, ?, ?) }");
                PreparedFuncIngFood2.registerOutParameter(1,Types.INTEGER);
                PreparedFuncIngFood2.setInt(2, foodID);
                PreparedFuncIngFood2.setInt(3, ingID[1]);
                PreparedFuncIngFood2.setInt(4, quantity[1]);
                PreparedFuncIngFood2.execute();

                

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }

        finally {

                }


        
        try
            {

                CallableStatement PreparedFuncIngFood3 = connection.prepareCall
                                ("{ ? = call insert_foodingredient(?, ?, ?) }");
                PreparedFuncIngFood3.registerOutParameter(1,Types.INTEGER);
                PreparedFuncIngFood3.setInt(2, foodID);
                PreparedFuncIngFood3.setInt(3, ingID[2]);
                PreparedFuncIngFood3.setInt(4, quantity[2]);
                PreparedFuncIngFood3.execute();

              

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }

        finally {

                }

        try
            {

                CallableStatement PreparedFuncIngFood4 = connection.prepareCall
                                ("{ ? = call insert_foodingredient(?, ?, ?) }");
                PreparedFuncIngFood4.registerOutParameter(1,Types.INTEGER);
                PreparedFuncIngFood4.setInt(2, foodID);
                PreparedFuncIngFood4.setInt(3, ingID[3]);
                PreparedFuncIngFood4.setInt(4, quantity[3]);
                PreparedFuncIngFood4.execute();

             

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }

        finally {

                }

        try
            {

                CallableStatement PreparedFuncIngFood5 = connection.prepareCall
                                ("{ ? = call insert_foodingredient(?, ?, ?) }");
                PreparedFuncIngFood5.registerOutParameter(1,Types.INTEGER);
                PreparedFuncIngFood5.setInt(2, foodID);
                PreparedFuncIngFood5.setInt(3, ingID[4]);
                PreparedFuncIngFood5.setInt(4, quantity[4]);
                PreparedFuncIngFood5.execute();

               

            }

          catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }

        finally {

                }
        ////////////////////////////////////////
        //Price calculation

        try
        {
        CallableStatement PreparedFuncFoodPrice = connection.prepareCall
                                ("{ call insert_new_food_price(?) }");
                PreparedFuncFoodPrice.setInt(1, foodID);

                PreparedFuncFoodPrice.execute();

        }
        catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }

        finally {

                }


        ///////////////////////////////////////////


        try
        {
            connection.close();
        }
        catch(SQLException e){
                 e.printStackTrace();
                 return 0;
             }
        finally{
            
        }

        


       return 1;
     }

}
