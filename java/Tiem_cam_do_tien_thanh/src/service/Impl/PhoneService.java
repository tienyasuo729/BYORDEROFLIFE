package service.Impl;

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


public class PhoneService implements IDeviceService<Phone> {
    private static View<Phone> view = new View<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList() {
        view.printList(IOTest.phonesRepository, "điện thoại");
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
        String manufacturerPhone = View.manufacturerPhone();
        String namePhone = Validate.checkIntInPut("","","");
        String phoneNumber = Validate.checkIntInPut("","","");
        String password = Validate.checkIntInPut("","","");
        String status =  Validate.checkIntInPut("","","");
        IOTest.phonesRepository.add(new Phone(id,name,cccd,price,phoneNumber,pawnDate,note,manufacturerPhone,namePhone,password,status));
        IOTest.writePhone();
    }

    @Override
    public void edit(int idEdit) {
        Phone phone = findById(idEdit);
        if (phone != null){
            phone.setName(Validate.checkIntInPut("","",""));
            phone.setCccd(Validate.checkIntInPut("","",""));
            phone.setPrice(Integer.parseInt(Validate.checkIntInPut("","","")));
            SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
            Date pawnDate;
            try {
                pawnDate = dateFormat.parse(Validate.checkIntInPut("","",""));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            phone.setPawnDate(pawnDate);
            phone.setNote(Validate.checkIntInPut("","",""));
            phone.setManufacturerPhone(View.manufacturerPhone());
            phone.setNamePhone(Validate.checkIntInPut("","",""));
            phone.setPhoneNumber(Validate.checkIntInPut("","",""));
            phone.setPassword(Validate.checkIntInPut("","",""));
            phone.setStatus(Validate.checkIntInPut("","",""));
            IOTest.writePhone();
        }else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int delete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.phonesRepository.size(); i++) {
            if (IOTest.phonesRepository.get(i).getId() == delete){
                notification = "- Xoá thành công.";
                IOTest.phonesRepository.remove(i);
                IOTest.writePhone();
                break;
            }
        }
        System.out.println(notification);
    }

    @Override
    public void extend(int extend) {
        Phone phone = findById(extend);
        int days = 0;
        if (phone != null){
            days = Integer.parseInt(Validate.checkIntInPut("","",""));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, phone.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(phone.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                phone.setPawnDate(newDate);
                IOTest.writePhone();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Phone phone = findById(idToTake);
        if (phone != null){
            long daysBetween = ChronoUnit.DAYS.between(phone.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,phone.getPrice()));
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
            for (Phone phone: IOTest.phonesRepository) {
                if (phone.getId() == id){
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
    public Phone findById(int idToFind) {
        for (int i = 0; i < IOTest.phonesRepository.size(); i++) {
            if (IOTest.phonesRepository.get(i).getId() == idToFind){
                return IOTest.phonesRepository.get(i);
            }
        }
        return null;
    }
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
