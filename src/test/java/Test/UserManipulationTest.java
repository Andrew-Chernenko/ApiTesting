package Test;
import Controller.UserController;
import Models.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManipulationTest {

    @Test
    public void createUserTest() {
        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setEmail("test@gmail.com");
        userModel.setFirstName("Andrew");
        userModel.setLastName("Chernenko");
        userModel.setPassword("qwerty12345");
        userModel.setPhoneNumber("88005553535");
        userModel.setUserName("deevee");
        userModel.setUserStatus(1);
        UserController userController = new UserController(userModel);
        userController.addUser();
        Assert.assertTrue(userController.isCheckStatusCode());
    }

    @Test
    public void updateUserTest() {
        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setEmail("test@gmail.com");
        userModel.setFirstName("Andrew");
        userModel.setLastName("Chernenko");
        userModel.setPassword("qwerty12345");
        userModel.setPhoneNumber("88005553535");
        userModel.setUserName("deevee");
        userModel.setUserStatus(1);
        UserController userController = new UserController(userModel);
        userController.addUser();
        Assert.assertTrue(userController.isCheckStatusCode());
        userModel.setEmail("qweqweqwe@gmail.com");
        userController.updateUser("deevee");
        Assert.assertTrue(userController.isCheckStatusCode());
    }

    @Test
    public void findUserByUsername() {
        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setEmail("test@gmail.com");
        userModel.setFirstName("Andrew");
        userModel.setLastName("Chernenko");
        userModel.setPassword("qwerty12345");
        userModel.setPhoneNumber("88005553535");
        userModel.setUserName("deevee");
        userModel.setUserStatus(1);
        UserController userController = new UserController(userModel);
        userController.addUser();
        Assert.assertTrue(userController.isCheckStatusCode());
        userController.findUserByUserName("deevee");
        Assert.assertTrue(userController.isCheckStatusCode());
    }

    @Test
    public void deleteUserByUserName() {
        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setEmail("test@gmail.com");
        userModel.setFirstName("Andrew");
        userModel.setLastName("Chernenko");
        userModel.setPassword("qwerty12345");
        userModel.setPhoneNumber("88005553535");
        userModel.setUserName("deevee");
        userModel.setUserStatus(1);
        UserController userController = new UserController(userModel);
        userController.addUser();
        Assert.assertTrue(userController.isCheckStatusCode());
        userController.deleteUserByUserName("deevee");
        Assert.assertTrue(userController.isCheckStatusCode());
    }
}
