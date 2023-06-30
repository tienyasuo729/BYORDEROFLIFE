    package com.tienthanh.controllerORM;

    import com.tienthanh.modelORM.Android_PhoneORM;
    import com.tienthanh.serviceORM.IAndroid_PhoneServiceORM;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;


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


    }
