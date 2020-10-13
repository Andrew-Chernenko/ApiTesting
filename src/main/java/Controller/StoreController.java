package Controller;
import Models.StoreModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class StoreController {

    private RequestSpecification requestSpecification;
    private StoreModel storeModel;
    private Response response;

    public StoreController(StoreModel storeModel) {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "deevee")
                .setBaseUri("https://petstore.swagger.io")
                .setBasePath("/v2/store/order")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
        this.storeModel = storeModel;
    }

    public void order() {
        response = given(requestSpecification)
                .body(storeModel)
                .post();
    }

    public Boolean isCheckStatusCode() {
        switch (response.statusCode()) {
            case 200:
                return true;
            default:
                return false;
        }
    }

    public void findOrder(int id) {
        response = given(requestSpecification)
                .get(String.valueOf(id));
    }

    public boolean isCheckResponse() {
        if (response.path("id").toString() != null) {
            return true;
        } else {
            return false;
        }
    }
}
