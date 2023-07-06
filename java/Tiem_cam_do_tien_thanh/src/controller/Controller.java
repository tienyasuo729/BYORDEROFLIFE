package controller;

import model.Laptop;
import model.Phone;
import model.Vehicle;
import repository.IOTest;
import service.Impl.LaptopService;
import service.Impl.PhoneService;
import service.Impl.VehicleService;
import validate.Validate;
import views.View;

public class Controller {
    private static PhoneService phoneService = new PhoneService();
    private static LaptopService laptopService = new LaptopService();
    private static VehicleService vehicleService = new VehicleService();
    public static void main(String[] args) {
//        IOTest.readPhone();
//        IOTest.readLaptop();
//        IOTest.readVehicle();
        int choose = 0;
        Boolean loop;
        while (true){
            View.printMainMenu();
            choose = Integer.parseInt(Validate.checkIntInPut("","",""));
            switch (choose){
                case 1:
                    loop = true;
                    while (loop){
                        View<Phone> view = new View<>();
                        View.printTypeMenu("điện thoại");
                        choose = Integer.parseInt(Validate.checkIntInPut("","",""));
                        switch (choose){
                            case 1:
                                phoneService.displayList();
                                break;
                            case 2:
                                phoneService.add();
                                break;
                            case 3:
                                view.printList(IOTest.phonesRepository,"điện thoại");
                                int idNeedToEdit = Integer.parseInt(Validate.checkIntInPut("","",""));
                                phoneService.edit(idNeedToEdit);
                                break;
                            case 4:
                                view.printList(IOTest.phonesRepository,"điện thoại");
                                int idNeedToDelete = Integer.parseInt(Validate.checkIntInPut("","",""));
                                phoneService.delete(idNeedToDelete);
                                break;
                            case 5:
                                view.printList(IOTest.phonesRepository,"điện thoại");
                                int idNeedToExtend = Integer.parseInt(Validate.checkIntInPut("","",""));
                                phoneService.extend(idNeedToExtend);
                                break;
                            case 6:
                                view.printList(IOTest.phonesRepository,"điện thoại");
                                int idNeedToTake = Integer.parseInt(Validate.checkIntInPut("","",""));
                                phoneService.takeTheProduct(idNeedToTake);
                                break;
                            case 7:
                                loop = false;
                                break;
                            case 8:
                                System.exit(0);
                                break;
                        }
                    }
                    break;
                case 2:
                    loop = true;
                    while (loop){
                        View<Laptop> view = new View<>();
                        View.printTypeMenu("laptop");
                        choose = Integer.parseInt(Validate.checkIntInPut("","",""));
                        switch (choose){
                            case 1:
                                laptopService.displayList();
                                break;
                            case 2:
                                laptopService.add();
                                break;
                            case 3:
                                view.printList(IOTest.laptopsRepository,"laptop");
                                int idNeedToEdit = Integer.parseInt(Validate.checkIntInPut("","",""));
                                laptopService.edit(idNeedToEdit);
                                break;
                            case 4:
                                view.printList(IOTest.laptopsRepository,"laptop");
                                int idNeedToDelete = Integer.parseInt(Validate.checkIntInPut("","",""));
                                laptopService.delete(idNeedToDelete);
                                break;
                            case 5:
                                view.printList(IOTest.laptopsRepository,"laptop");
                                int idNeedToExtend = Integer.parseInt(Validate.checkIntInPut("","",""));
                                laptopService.extend(idNeedToExtend);
                                break;
                            case 6:
                                view.printList(IOTest.laptopsRepository,"laptop");
                                int idNeedToTake = Integer.parseInt(Validate.checkIntInPut("","",""));
                                laptopService.takeTheProduct(idNeedToTake);
                                break;
                            case 7:
                                loop = false;
                                break;
                            case 8:
                                System.exit(0);
                                break;
                        }
                    }
                    break;
                case 3:
                    loop = true;
                    while (loop){
                        View<Vehicle> view = new View<>();
                        View.printTypeMenu("xe");
                        choose = Integer.parseInt(Validate.checkIntInPut("","",""));
                        switch (choose){
                            case 1:
                                vehicleService.displayList();
                                break;
                            case 2:
                                vehicleService.add();
                                break;
                            case 3:
                                view.printList(IOTest.vehiclesRepository,"xe");
                                int idNeedToEdit = Integer.parseInt(Validate.checkIntInPut("","",""));
                                vehicleService.edit(idNeedToEdit);
                                break;
                            case 4:
                                view.printList(IOTest.vehiclesRepository,"xe");
                                int idNeedToDelete = Integer.parseInt(Validate.checkIntInPut("","",""));
                                vehicleService.delete(idNeedToDelete);
                                break;
                            case 5:
                                view.printList(IOTest.vehiclesRepository,"xe");
                                int idNeedToExtend = Integer.parseInt(Validate.checkIntInPut("","",""));
                                vehicleService.extend(idNeedToExtend);
                                break;
                            case 6:
                                view.printList(IOTest.vehiclesRepository,"xe");
                                int idNeedToTake = Integer.parseInt(Validate.checkIntInPut("","",""));
                                vehicleService.takeTheProduct(idNeedToTake);
                                break;
                            case 7:
                                loop = false;
                                break;
                            case 8:
                                System.exit(0);
                                break;
                        }
                    }
                    break;

            }
        }
    }
}
