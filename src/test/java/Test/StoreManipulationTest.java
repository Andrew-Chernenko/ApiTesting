package Test;
import Controller.StoreController;
import Models.StoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreManipulationTest {

    @Test
    public void orderingTest() {
        StoreModel storeModel = new StoreModel();
        storeModel.setOrderId(1);
        storeModel.setPetId(1);
        storeModel.setQuantity(3);
        storeModel.setShipDate("2020");
        StoreController storeController = new StoreController(storeModel);
        storeController.order();
        Assert.assertTrue(storeController.isCheckStatusCode());
    }

    @Test
    public void findOrder() {
        StoreModel storeModel = new StoreModel();
        storeModel.setOrderId(1);
        storeModel.setPetId(1);
        storeModel.setQuantity(3);
        storeModel.setShipDate("2020");
        StoreController storeController = new StoreController(storeModel);
        storeController.order();
        Assert.assertTrue(storeController.isCheckStatusCode());
        storeController.findOrder(1);
        Assert.assertTrue(storeController.isCheckStatusCode());
        Assert.assertTrue(storeController.isCheckResponse());
    }
}
