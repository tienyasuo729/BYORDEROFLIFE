    package com.tienthanh.controllerORM;

    import com.tienthanh.modelJDBC.Android_PhoneJDBC;
    import com.tienthanh.modelORM.Android_PhoneORM;
    import com.tienthanh.serviceORM.IAndroid_PhoneServiceORM;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;

    @Controller
    @RequestMapping("tienthanhORM")
    public class Android_PhoneControllerORM {
        @Autowired
        private IAndroid_PhoneServiceORM androidPhoneServiceORM;
        @GetMapping("")
        public String listAndroid_Phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceORM.displayAndroid_Phone());
            model.addAttribute("android_phone", new Android_PhoneORM());
            return "listAndroid_Phone";
        }
        @PostMapping("save_create_android_phone")
        public String save_create_android_phone(@ModelAttribute Android_PhoneORM androidPhoneORM){
            System.out.println(androidPhoneServiceORM.add_new_android_phone(androidPhoneORM));
            return "redirect:/tienthanhORM";
        }

        // có anotation @ResponeBody là ajax
        @PostMapping("check_if_id_exist")
        @ResponseBody
        public String check_if_id_exist(@RequestParam("id_need_to_check") String id){
            return androidPhoneServiceORM.check_if_id_exist(id).toString();
        }
        @PostMapping("delete_android_phone_by_id")
        @ResponseBody
        public String delete_android_phone_by_id(@RequestParam("id_need_to_delete") String idToDelete){
            return androidPhoneServiceORM.delete_Android_Phone(idToDelete).toString();
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


    }
