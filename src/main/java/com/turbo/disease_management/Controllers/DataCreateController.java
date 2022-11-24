package com.turbo.disease_management.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.turbo.disease_management.Dto.RecordDto;
import com.turbo.disease_management.Service.RecordService;

@Controller
public class DataCreateController {
    
    @Autowired
    private RecordService recordService;

    @GetMapping("/records/newRecord")
    public String newRecord(Model model) {
        RecordDto record = new RecordDto();
        model.addAttribute("record", record);
        return "new_record";
    }

    @PostMapping("/records/saveRecord")
    public String saveRecord(@ModelAttribute(value = "record") RecordDto record) {
        recordService.saveRecord(record);
        return "redirect:/records";
    }
}
