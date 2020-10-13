package Controller;
import Models.PetModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class PetController {

    private RequestSpecification requestSpecification;
    private PetModel petModel;
    private Response response;
    private String oldValue;
    private String pathName;

    public PetController(PetModel petModel) {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "deevee")
                .setBaseUri("https://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
        this.petModel = petModel;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
        oldValue = response.path(pathName).toString();
    }

    public void addNewPet() {
        response = given(requestSpecification)
                .body(petModel)
                .post();
    }

    public void updatePet() {
        response = given(requestSpecification)
                .body(petModel)
                .put();
    }

    public void deletePetById(Integer id) {
        response = given(requestSpecification)
                .delete(String.valueOf(id));
    }

    public void findPetById(Integer id) {
        response = given(requestSpecification)
                .get(String.valueOf(id));
    }

    public Boolean isCheckStatusCode() {
        switch (response.statusCode()) {
            case 200:
                return true;
            default:
                return false;
        }
    }

    public Boolean isCheckChange() {
        if (!response.path(pathName).toString().equals(oldValue)) {
            return true;
        } else {
            return false;
        }
    }
}
