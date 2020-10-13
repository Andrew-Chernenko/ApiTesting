package Models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreModel {

    @JsonProperty("id")
    private int orderId;
    @JsonProperty("petId")
    private int petId;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("shipDate")
    private String shipDate;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }
}
