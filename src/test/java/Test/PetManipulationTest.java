package Test;
import Controller.PetController;
import Models.PetModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetManipulationTest {
    private String petName = "Bobik";
    private String categoryName = "dog";

    @Test
    public void addNewPetTest() {
        PetModel petModel = new PetModel();
        petModel.setId(1);
        petModel.setCategoryName(categoryName);
        petModel.setCategoryId(1);
        petModel.setName(petName);
        petModel.setPhotoUrls(null);
        petModel.setTags(null);
        petModel.setStatus("available");
        PetController petController = new PetController(petModel);
        petController.addNewPet();
        Assert.assertTrue(petController.isCheckStatusCode());
    }

    @Test
    public void updatePetDataTest() {
        PetModel petModel = new PetModel();
        petModel.setId(1);
        petModel.setCategoryName(categoryName);
        petModel.setCategoryId(1);
        petModel.setName(petName);
        petModel.setPhotoUrls(null);
        petModel.setTags(null);
        petModel.setStatus("available");
        PetController petController = new PetController(petModel);
        petController.addNewPet();
        Assert.assertTrue(petController.isCheckStatusCode());
        petController.setPathName("name");
        petModel.setName("Xan");
        petController.updatePet();
        Assert.assertTrue(petController.isCheckStatusCode());
        Assert.assertTrue(petController.isCheckChange());
    }

    @Test
    public void findPetByIdTest() {
        PetModel petModel = new PetModel();
        petModel.setId(1);
        petModel.setCategoryName(categoryName);
        petModel.setCategoryId(1);
        petModel.setName(petName);
        petModel.setPhotoUrls(null);
        petModel.setTags(null);
        petModel.setStatus("available");
        PetController petController = new PetController(petModel);
        petController.addNewPet();
        Assert.assertTrue(petController.isCheckStatusCode());
        petController.findPetById(1);
        Assert.assertTrue(petController.isCheckStatusCode());
    }

    @Test
    public void deletePetTest() {
        PetModel petModel = new PetModel();
        petModel.setId(1);
        petModel.setCategoryName(categoryName);
        petModel.setCategoryId(1);
        petModel.setName(petName);
        petModel.setPhotoUrls(null);
        petModel.setTags(null);
        petModel.setStatus("available");
        PetController petController = new PetController(petModel);
        petController.addNewPet();
        Assert.assertTrue(petController.isCheckStatusCode());
        petController.deletePetById(1);
        Assert.assertTrue(petController.isCheckStatusCode());
    }
}
