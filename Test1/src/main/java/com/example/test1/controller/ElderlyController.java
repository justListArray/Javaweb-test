package com.example.test1.controller;

import com.example.test1.POJO.Elderly;
import com.example.test1.POJO.Result;
import com.example.test1.service.ElderlyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ElderlyController {

    @Autowired
    private ElderlyService elderlyService;

    @GetMapping("/getElderly")
    public Result getElderly() {
        List<Elderly> elderlyList = elderlyService.getElderly();
        return Result.success(elderlyList);
    }

    @PostMapping("/addElderly")
    public Result addElderly(@RequestParam Integer ID,
                             @RequestParam String image,
                             @RequestParam String name,
                             @RequestParam Integer age,
                             @RequestParam String room,
                             @RequestParam String disease,
                             @RequestParam String marriageStatus,
                             @RequestParam String phoneNumber) {
        Elderly elderly = new Elderly(ID, image, name, age, room, disease, marriageStatus, phoneNumber);
            elderlyService.addElderly(elderly);
            return Result.success();
    }
    @GetMapping("/deleteElderly")
    public Result deleteElderly(@RequestParam String name) {
        elderlyService.deleteElderly(name);
        return Result.success();
    }
    @GetMapping("/searchElderly")
    public Result searchElderly(@RequestParam String name) {
        List<Elderly> elderlyList = elderlyService.searchElderly(name);
        return Result.success(elderlyList);
    }
}
