package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    @JsonProperty("id")
    private int id;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("userStatus")
    private int userStatus;

    public void setId(int id){
        this.id = id;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setUserStatus(int userStatus){
        this.userStatus = userStatus;
    }
}
