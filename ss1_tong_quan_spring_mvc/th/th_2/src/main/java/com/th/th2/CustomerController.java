package com.th.th2;

@Controller
public class CustomerController {
    @GetMapping("/customers")
    public String showList() {
        return "customers/list.jsp";
    }
}
