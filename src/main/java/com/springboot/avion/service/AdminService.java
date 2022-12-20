package com.springboot.avion.service;

import com.springboot.avion.model.Admin;
import com.springboot.avion.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    public final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

//    @
//    public Admin login(String email, String mdpadmin) {
//        return null;
//    }

    public Admin login(String email, String mdpadmin) {
        return adminRepository.findByEmailAndMdp(email, mdpadmin);
    }

    public Admin getById(Integer id) {
        Optional<Admin> admin=adminRepository.findById(id);
        return admin.orElse(null);
    }
}
