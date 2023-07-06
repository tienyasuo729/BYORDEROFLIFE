package service.Impl;

import model.Laptop;
import model.Phone;
import model.Vehicle;
import repository.IOTest;
import service.IDeviceService;
import validate.Validate;
import views.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class VehicleService implements IDeviceService<Vehicle> {
    private static View<Vehicle> view = new View<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void displayList() {
        view.printList(IOTest.vehiclesRepository, "xe");

    }

    @Override
    public void add() {
        int id = checkIdIsExist();
        String name = Validate.checkIntInPut("","","");
        String cccd = Validate.checkIntInPut("","","");
        int price = Integer.parseInt(Validate.checkIntInPut("","",""));
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date pawnDate;
        try {
            pawnDate = dateFormat.parse(Validate.checkIntInPut("","",""));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String note = Validate.checkIntInPut("","","");
        String manufacturerVehicle = View.manufacturerPhone();
        String nameVehicle = Validate.checkIntInPut("","","");
        String phoneNumber = Validate.checkIntInPut("","","");
        String password = Validate.checkIntInPut("","","");
        String status =  Validate.checkIntInPut("","","");
        IOTest.vehiclesRepository.add(new Vehicle(id,name,cccd,price,phoneNumber,pawnDate,note,manufacturerVehicle,nameVehicle,password,status));
        IOTest.writeVehicle();
    }

    @Override
    public void edit(int idEdit) {
        Vehicle vehicle = findById(idEdit);
        if (vehicle != null){
            vehicle.setName(Validate.checkIntInPut("","",""));
            vehicle.setCccd(Validate.checkIntInPut("","",""));
            vehicle.setPrice(Integer.parseInt(Validate.checkIntInPut("","","")));
            SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
            Date pawnDate;
            try {
                pawnDate = dateFormat.parse(Validate.checkIntInPut("","",""));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            vehicle.setPawnDate(pawnDate);
            vehicle.setNote(Validate.checkIntInPut("","",""));
            vehicle.setManufacturerVehicle(View.manufacturerPhone());
            vehicle.setNameVehicle(Validate.checkIntInPut("","",""));
            vehicle.setPhoneNumber(Validate.checkIntInPut("","",""));
            vehicle.setLicensePlate(Validate.checkIntInPut("","",""));
            vehicle.setStatusVehicle(Validate.checkIntInPut("","",""));
            IOTest.writeVehicle();
        }else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int idDelete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.vehiclesRepository.size(); i++) {
            if (IOTest.vehiclesRepository.get(i).getId() == idDelete){
                notification = "- Xoá thành công.";
                IOTest.vehiclesRepository.remove(i);
                IOTest.writeVehicle();
                break;
            }
        }
        System.out.println(notification);
    }

    @Override
    public void extend(int idExtend) {
        Vehicle vehicle = findById(idExtend);
        int days = 0;
        if (vehicle != null){
            days = Integer.parseInt(Validate.checkIntInPut("","",""));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, vehicle.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(vehicle.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                vehicle.setPawnDate(newDate);
                IOTest.writeVehicle();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Vehicle vehicle = findById(idToTake);
        if (vehicle != null){
            long daysBetween = ChronoUnit.DAYS.between(vehicle.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,vehicle.getPrice()));
            if (View.confirm("Bạn có muốn lấy điện thoại cầm này không")){
                delete(idToTake);
                IOTest.writeVehicle();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể lấy máy");
        }
    }

    @Override
    public int checkIdIsExist() {
        Boolean check = true;
        int id = 0;
        while (check){
            id = Integer.parseInt(Validate.checkIntInPut("","",""));
            for (Vehicle vehicle: IOTest.vehiclesRepository) {
                if (vehicle.getId() == id){
                    check = true;
                    System.out.println("- " + id + " đã tồn tại, xin hãy nhập id khác");
                    break;
                }else {
                    check = false;
                }
            }
        }
        return id;
    }

    @Override
    public Vehicle findById(int idToFind) {
        for (int i = 0; i < IOTest.vehiclesRepository.size(); i++) {
            if (IOTest.vehiclesRepository.get(i).getId() == idToFind){
                return IOTest.vehiclesRepository.get(i);
            }
        }
        return null;    }
    private int money_all_days(int days, int price){
        int payment = 0;
        payment = ((price / 1000000) * 3000 + less_than_500(price)) * days;
        return payment;
    }
    private int less_than_500 (int price){
        int support = price % 1000000;
        if ( support == 0){
            return 0;
        }else if (support < 500000){
            return 2000;
        }else {
            return 3000;
        }
    }
}
