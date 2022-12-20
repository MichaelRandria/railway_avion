package com.springboot.avion.service;

import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.model.AdminToken;
import com.springboot.avion.repository.AdminTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.sql.Date;
import java.util.List;

@Service
public class AdminTokenService {

    @Autowired
    AdminTokenRepository adminTokenRepository;


    public AdminToken saveToken(AdminToken adminToken) {
        return adminTokenRepository.save(adminToken);
    }

    public AdminToken getValidTokenByToken(String token) {
        return adminTokenRepository.getTokenByValue(token);
    }

    public List<AdminToken> getValidToken(Integer idAdmin) {
        List<AdminToken> list=adminTokenRepository.getValidTokenById(idAdmin);
        ModelJSON modelJSON=new ModelJSON();
        return list;
    }

    public AdminToken logout(AdminToken adminToken) {
        adminToken.setDateExp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        adminTokenRepository.save(adminToken);
        return adminToken;
    }

    public AdminToken checkToken(String value) {
        System.out.println(value);
        return adminTokenRepository.getTokenByValue(value);
    }

    public void unvalidOldToken(Integer idAdmin){
        adminTokenRepository.unvalidOldToken(idAdmin);
    }
}
