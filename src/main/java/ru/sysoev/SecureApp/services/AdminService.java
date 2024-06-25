package ru.sysoev.SecureApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdminThings() {
        System.out.println("Admin clean up Database");
    }
}
