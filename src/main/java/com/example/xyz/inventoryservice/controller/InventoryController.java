package com.example.xyz.inventoryservice.controller;

import com.example.xyz.inventoryservice.response.EventInventoryResponse;
import com.example.xyz.inventoryservice.response.VenueInventoryResponse;
import com.example.xyz.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents(){
        return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public VenueInventoryResponse inventoryByVenueId(@PathVariable Long venueId){
        return inventoryService.getVenueById(venueId);
    }

    @GetMapping("/inventory/event/{eventId}")
    public @ResponseBody EventInventoryResponse inventoryGetEventById(@PathVariable Long eventId){
        return inventoryService.getEventById(eventId);
    }
}
