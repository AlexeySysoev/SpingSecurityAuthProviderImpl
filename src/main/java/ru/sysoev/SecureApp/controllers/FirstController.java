package ru.sysoev.SecureApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sysoev.SecureApp.services.AdminService;

@Controller
public class FirstController {
    private final AdminService adminService;
    @Autowired

    public FirstController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminThings();
        return "admin";
    }
}
