    package com.tienthanh.controllerORM;

    import com.tienthanh.modelORM.Android_PhoneORM;
    import com.tienthanh.serviceORM.IAndroid_PhoneServiceORM;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.text.SimpleDateFormat;
    import java.time.LocalDate;
    import java.time.ZoneId;
    import java.time.temporal.ChronoUnit;
    import java.util.Date;
    import java.util.Locale;


    @Controller
    @RequestMapping("tienthanhORM")
    public class Android_PhoneControllerORM {
        @Autowired
        private IAndroid_PhoneServiceORM androidPhoneServiceORM;
//        @ModelAttribute("default")
//        public String defaultvalue(){
//            return "Không có";
//        }

        @GetMapping("")
        public String listAndroid_Phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.displayAndroid_Phone());
            model.addAttribute("android_phone", new Android_PhoneORM());
            return "listAndroid_Phone";
        }
        @PostMapping("add_or_edit_new_android_phone")
        public String add_or_edit_new_android_phone(@ModelAttribute Android_PhoneORM androidPhoneORM){
            androidPhoneServiceORM.add_or_edit_new_android_phone(androidPhoneORM);
            return "redirect:/tienthanhORM/";
        }

        // có anotation @ResponeBody là ajax
        @PostMapping("check_if_id_exist")
        @ResponseBody
        public String check_if_id_exist(@RequestParam("id_need_to_check") String id){
            return androidPhoneServiceORM.check_if_id_exist(id).toString();
        }
//        @PostMapping("check_if_id_exist")
//
//        public void check_if_id_exist(@RequestParam("id_need_to_check") String id, HttpServletResponse response){
//            try {
//                response.setContentType("text/plain");
//                response.setCharacterEncoding("UTF-8");
//                response.getWriter().write(String.valueOf(androidPhoneServiceORM.check_if_id_exist(id)));
//            } catch (IOException e) {
//                // Xử lý ngoại lệ nếu cần thiết
//            }
//        }
        @PostMapping("delete_android_phone_by_id")
        @ResponseBody
        public String delete_android_phone_by_id(@RequestParam("id_need_to_delete") String idToDelete){
            return androidPhoneServiceORM.delete_Android_Phone(idToDelete).toString();
        }

        @PostMapping("list_Find_Android_Phone_Similar_By_Id")
        public String list_Find_Android_Phone_Similar_By_Id(@RequestParam("find_by_id") String id, Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.list_Find_Android_Phone_Similar_By_Id(id));
            model.addAttribute("android_phone", new Android_PhoneORM());
            return "listAndroid_Phone";

        }

        @PostMapping("list_Find_Android_Phone_Similar_By_Name")
        public String list_Find_Android_Phone_Similar_By_Name(@RequestParam("find_by_name") String name, Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.list_Find_Android_Phone_Similar_By_Name(name));
            model.addAttribute("android_phone", new Android_PhoneORM());
            return "listAndroid_Phone";
        }

        @GetMapping("/late_list_android_phone")
        public String late_list_android_phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.late_list_android_phone());
            model.addAttribute("android_phone", new Android_PhoneORM());
            return "listAndroid_Phone";
        }
        @GetMapping("/near_term_list_android_phone")
        public String near_term_list_android_phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.late_list_android_phone());
            model.addAttribute("android_phone", new Android_PhoneORM());
            return "listAndroid_Phone";
        }

        @PostMapping("interestPayment")
        @ResponseBody
        public String interestPayment(@RequestParam("start_date_interest_payment") String start_date,
                                      @RequestParam("price_interest_payment") int price,
                                      @RequestParam("days_interest_payment") int days){
            String result = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            try {
                Date startDate = dateFormat.parse(start_date);
                long daysBetween = ChronoUnit.DAYS.between(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

                result = "- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + days + " ngày là : " + money_all_days(days,price);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(start_date);
            return result;
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
