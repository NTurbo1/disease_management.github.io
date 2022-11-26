package com.turbo.disease_management.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.turbo.disease_management.Dto.DiscoverDto;
import com.turbo.disease_management.Dto.DiseaseDto;
import com.turbo.disease_management.Dto.RecordDto;
import com.turbo.disease_management.Dto.UserDto;
import com.turbo.disease_management.Service.DiscoverService;
import com.turbo.disease_management.Service.DiseaseService;
import com.turbo.disease_management.Service.RecordService;
import com.turbo.disease_management.Service.UserService;

@Controller
public class DataReadController {
    
    @Autowired
    private DiscoverService discoverService; 

    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/discoveries")
    public String discoveriesPage(Model model) {
        List<DiscoverDto> discoveries = discoverService.findAllDiscoveries();
        model.addAttribute("discoveries", discoveries);
        return "discoveries";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/diseases")
    public String diseases(Model model) {
        List<DiseaseDto> diseases = diseaseService.findAllDiseases();
        System.out.println("USERS BEFORE GETTING DISPLAYED");
        for (DiseaseDto d : diseases) {
            System.out.println(d.toString());
        }
        model.addAttribute("diseases", diseases);
        return "diseases";
    }

    @GetMapping("/records")
    public String records(Model model) {
        List<RecordDto> records = recordService.findAllRecords();
        model.addAttribute("records", records);
        return "records";
    }
}
