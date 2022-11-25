package com.turbo.disease_management.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.turbo.disease_management.Dto.DiscoverDto;
import com.turbo.disease_management.Dto.DiseaseDto;
import com.turbo.disease_management.Dto.RecordDto;
import com.turbo.disease_management.Service.DiscoverService;
import com.turbo.disease_management.Service.DiseaseService;
import com.turbo.disease_management.Service.RecordService;

@Controller
public class DataCreateController {
    
    @Autowired
    private RecordService recordService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private DiscoverService discoverService;

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

    @GetMapping("/records/deleteRecord/{recordId}")
    public String deleteRecord(@PathVariable(value = "recordId", required = false) Integer recordId) {
        recordService.deleteRecordById(recordId);
        return "redirect:/records";
    }

    @GetMapping("/diseases/addDisease")
    public String addDisease(Model model) {
        DiseaseDto disease = new DiseaseDto();
        model.addAttribute("disease", disease);

        return "new_disease";
    }

    @PostMapping("/diseases/saveDisease")
    public String saveDisease(@Valid @ModelAttribute(value="disease") DiseaseDto disease,
                              BindingResult result, Model model) {

        if (result.hasErrors()){
            model.addAttribute("disease", disease);
            return "new_disease";
        }

        diseaseService.saveDisease(disease);
        return "redirect:/diseases";
    }

    @GetMapping("/discoveries/deleteDiscovery/{diseaseCode}")
    public String deleteDiscovery(@PathVariable(value="diseaseCode", required = false) String diseaseCode){
        discoverService.deleteDiscoveryByDiseaseCode(diseaseCode);
        return "redirect:/discoveries";
    }

    @GetMapping("/discoveries/newDiscovery")
    public String newDiscoveryForm(Model model) {
        List<DiseaseDto> diseases = diseaseService.findAllDiseases();
        DiscoverDto discovery = new DiscoverDto();
        model.addAttribute("discovery", discovery);
        model.addAttribute("diseases", diseases);

        return "new_discovery";
    }

    @PostMapping("/discoveries/saveDiscovery")
    public String saveDiscovery(@Valid @ModelAttribute(value = "discovery") DiscoverDto discovery,
                                BindingResult result, Model model) {

        if (result.hasErrors()){
            model.addAttribute("discovery", discovery);
            return "new_discovery";
        }

        discoverService.saveDiscovery(discovery);
        return "redirect:/discoveries";
    }
}
