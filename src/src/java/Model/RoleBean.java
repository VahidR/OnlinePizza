package Model;

import java.io.Serializable;
/**
 * this class is a bean class to create role object that includes userName and
 * roleName.
 *
 * 
 */
public class RoleBean implements Serializable {
   //Private attribute

    private String userName;
    private String roleName;

    /**
     * Zero constructor for RoleBean
     * it will initialize all private variables (i.e put empty string in both properties)
     */
    public RoleBean() {
        userName = "";
        roleName = "";
    }

    /**
     * The constructor to initialize the attributes with defined values
     * @param userName unique user name which is string
     * @param roleName Role name define the role of the user
     */
    public RoleBean(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    /**
     * The setter method for userName which will set the user defined value to
     * the corresponding property
     * @param userName an string that define the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * The getter method for userName which will return the value of the userName
     * @return a string which is the value of current userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The setter method for roleName which will set the user defined value to
     * the corresponding property
     * @param roleName an string that define the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * The getter method for roleName which will return the value of the roleName
     * @return a string which is the value of current roleName
     */
    public String getRoleName() {
        return roleName;
    }

}
