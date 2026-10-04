package com.example.xyz.inventoryservice.service;

import com.example.xyz.inventoryservice.entity.Event;
import com.example.xyz.inventoryservice.entity.Venue;
import com.example.xyz.inventoryservice.repository.EventRepository;
import com.example.xyz.inventoryservice.repository.VenueRepository;
import com.example.xyz.inventoryservice.response.EventInventoryResponse;
import com.example.xyz.inventoryservice.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public InventoryService(EventRepository eventRepository, VenueRepository venueRepository){
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }

    public List<EventInventoryResponse> getAllEvents(){
        final List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> EventInventoryResponse.builder()
                .event(event.getName())
                .capacity(event.getLeftCapacity())
                .venue(event.getVenue())
                .build()).collect(Collectors.toList());
    }
    public VenueInventoryResponse getVenueById(Long venueId){
        Venue venue = venueRepository.findById(venueId).orElse(null);
        return VenueInventoryResponse.builder()
                .venueId(venue.getId())
                .venueName(venue.getName())
                .totalCapacity(venue.getTotalCapacity())
                .build();
    }
    public EventInventoryResponse getEventById(Long id){
        final Event event = eventRepository.findById(id).orElse(null);
        return EventInventoryResponse.builder()
                .eventId(event.getId())
                .event(event.getName())
                .capacity(event.getLeftCapacity())
                .venue(event.getVenue())
                .ticketPrice(event.getTicketingPrice())
                .build();
    }
}
