package com.example.xyz.inventoryservice.controller;

import com.example.xyz.inventoryservice.response.EventInventoryResponse;
import com.example.xyz.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    InventoryService inventoryService ;

    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
    @GetMapping("/inventory/events")
    public @ResponseBody void inventoryGetAllEvents(){
         inventoryService.getAllEvents();
    }

}
