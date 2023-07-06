package service.Impl;

import model.Laptop;
import model.Phone;
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

public class LaptopService implements IDeviceService<Laptop> {
    private static View<Laptop> view = new View<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void displayList() {
        view.printList(IOTest.laptopsRepository, "máy tính");

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
        String manufacturerLaptop = View.manufacturerPhone();
        String nameLaptop = Validate.checkIntInPut("","","");
        String phoneNumber = Validate.checkIntInPut("","","");
        String password = Validate.checkIntInPut("","","");
        String status =  Validate.checkIntInPut("","","");
        IOTest.laptopsRepository.add(new Laptop(id,name,cccd,price,phoneNumber,pawnDate,note,manufacturerLaptop,nameLaptop,password,status));
        IOTest.writeLaptop();
    }

    @Override
    public void edit(int idEdit) {
        Laptop laptop = findById(idEdit);
        if (laptop != null){
            laptop.setName(Validate.checkIntInPut("","",""));
            laptop.setCccd(Validate.checkIntInPut("","",""));
            laptop.setPrice(Integer.parseInt(Validate.checkIntInPut("","","")));
            SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
            Date pawnDate;
            try {
                pawnDate = dateFormat.parse(Validate.checkIntInPut("","",""));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            laptop.setPawnDate(pawnDate);
            laptop.setNote(Validate.checkIntInPut("","",""));
            laptop.setManufacturerLaptop(View.manufacturerPhone());
            laptop.setNameLaptop(Validate.checkIntInPut("","",""));
            laptop.setPhoneNumber(Validate.checkIntInPut("","",""));
            laptop.setPassword(Validate.checkIntInPut("","",""));
            laptop.setStatus(Validate.checkIntInPut("","",""));
            IOTest.writeLaptop();
        }else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int idDelete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.laptopsRepository.size(); i++) {
            if (IOTest.laptopsRepository.get(i).getId() == idDelete){
                notification = "- Xoá thành công.";
                IOTest.laptopsRepository.remove(i);
                IOTest.writeLaptop();
                break;
            }
        }
        System.out.println(notification);
    }

    @Override
    public void extend(int idExtend) {
        Laptop laptop = findById(idExtend);
        int days = 0;
        if (laptop != null){
            days = Integer.parseInt(Validate.checkIntInPut("","",""));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, laptop.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(laptop.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                laptop.setPawnDate(newDate);
                IOTest.writeLaptop();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Laptop laptop = findById(idToTake);
        if (laptop != null){
            long daysBetween = ChronoUnit.DAYS.between(laptop.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,laptop.getPrice()));
            if (View.confirm("Bạn có muốn lấy điện thoại cầm này không")){
                delete(idToTake);
                IOTest.writePhone();
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
            for (Laptop laptop: IOTest.laptopsRepository) {
                if (laptop.getId() == id){
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
    public Laptop findById(int idToFind) {
        for (int i = 0; i < IOTest.laptopsRepository.size(); i++) {
            if (IOTest.laptopsRepository.get(i).getId() == idToFind){
                return IOTest.laptopsRepository.get(i);
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
