import Utils.*;
import service.Auth;
import service.MainMenu;
import Utils.PlaceUtils;
import Utils.CarUtils;
public class CarBooking {

    public static void main(String[] args) {
        PlaceUtils placeUtils = new PlaceUtils();
        UserUtils userUtils = new UserUtils();
        Auth auth = new Auth(userUtils);
        auth.printAuthMenu();

        MainMenu mainMenu = new MainMenu(placeUtils , auth ,userUtils);
        mainMenu.printMenu();

    }
}

