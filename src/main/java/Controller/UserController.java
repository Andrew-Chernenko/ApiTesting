package Controller;
import Models.UserModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;

public class UserController {
    private RequestSpecification requestSpecification;
    private UserModel userModel;
    private Response response;

    public UserController(UserModel userModel) {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "deevee")
                .setBaseUri("https://petstore.swagger.io")
                .setBasePath("/v2/user")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
        this.userModel = userModel;
    }

    public void addUser(){
        response = given(requestSpecification)
                .body(userModel)
                .post();
    }

    public void updateUser(String userName){
        response = given(requestSpecification)
                .body(userModel)
                .put(userName);
    }

    public Boolean isCheckStatusCode(){
        System.out.println(response.statusCode());
        switch (response.statusCode()){
            case 200:
                return true;
            default: return false;
        }
    }

    public void findUserByUserName(String userName){
        response = given(requestSpecification)
                .get(userName);
    }


    public void deleteUserByUserName(String userName){
        response = given(requestSpecification)
                .delete(userName);
    }
}
