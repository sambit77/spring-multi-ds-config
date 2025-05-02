package com.example.spring_multi_ds_config.controller;

import com.example.spring_multi_ds_config.Service.MyService;
import com.example.spring_multi_ds_config.entity.RequestDto;
import com.example.spring_multi_ds_config.entity.primary.PrimaryUser;
import com.example.spring_multi_ds_config.entity.secondary.SecondaryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService service;

    @Autowired
    public MyController(MyService service) {
        this.service = service;
    }

    @PostMapping("/primary")
    public PrimaryUser savePrimaryUser(@RequestBody PrimaryUser user) {
        return service.savePrimaryUser(user);
    }

    @PostMapping("/secondary")
    public SecondaryOrder saveSecondaryOrder(@RequestBody SecondaryOrder order) {

        return  service.saveSecondaryOrder(order);
    }

    @PutMapping("/primary/updatename")
    public int updatePrimaryUserName(@RequestBody RequestDto requestDto) {

        return  service.updatePrimaryUserName(requestDto);
    }
}
