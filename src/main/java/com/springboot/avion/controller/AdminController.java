package com.springboot.avion.controller;

import com.springboot.avion.exception.ErrorMessage;
import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.model.Admin;
import com.springboot.avion.model.AdminToken;
import com.springboot.avion.service.AdminService;
import com.springboot.avion.service.AdminTokenService;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    private final AdminTokenService adminTokenService;

    public AdminController(AdminService adminService, AdminTokenService adminTokenService) {
        this.adminService = adminService;
        this.adminTokenService = adminTokenService;
    }


    @PostMapping("/login")
    public ModelJSON login(@RequestBody Admin admin/*@RequestParam(value = "email") String email,@RequestParam(value = "mdp") String mdp*/){
        ModelJSON modelJSON=new ModelJSON();
//        System.out.println(admin.getEmail());
        Admin admin1 = adminService.login(admin.getEmail(), admin.getMdpadmin());

        if (admin1 != null) {
            adminTokenService.unvalidOldToken(admin1.getId());
            AdminToken adminToken =new AdminToken();
            adminToken.setAdmin(admin1);
            adminToken.setValue(adminToken.generateToken());
            LocalDateTime dateExp=LocalDateTime.now().plusMinutes(60);
            Instant instant=dateExp.toInstant(ZoneOffset.UTC);
            adminToken.setDateExp(Date.from(instant));
            adminTokenService.saveToken(adminToken);
            modelJSON.setData(adminToken);

        }
        else{
            ErrorMessage message=new ErrorMessage("404","Admin not found");
            modelJSON.setError(message);
        }

        return modelJSON;
    }

    @GetMapping("/token/check")
    private ModelJSON checkToken(@RequestHeader("tokens") String value){
        ModelJSON modelJSON= new ModelJSON();
        AdminToken adminToken=adminTokenService.checkToken(value);
        System.out.println(adminToken);
        if(adminToken==null){
            System.out.println(value);
            ErrorMessage errorMessage=new ErrorMessage("401","Token expired");
            modelJSON.setError(errorMessage);
        }
        return modelJSON;
    }

    @GetMapping("/token/logout")
    private ModelJSON logout(@RequestHeader("token") String token){
//        Admin admin=adminService.getById(id);
        ModelJSON modelJSON= new ModelJSON();
        AdminToken adminToken=adminTokenService.getValidTokenByToken(token);
//        List<AdminToken> adminToken=adminTokenService.getValidToken(admin.getId());
        if(adminToken==null){
            ErrorMessage errorMessage=new ErrorMessage("401","Token expired");
            modelJSON.setError(errorMessage);
        }
        else{
            AdminToken adminTokenRes= adminTokenService.logout(adminToken);
            modelJSON.setData(adminTokenRes);
        }
        return modelJSON;

    }
}
