package com.zti.controller;

import com.zti.model.Pin;
import com.zti.repository.PinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@PreAuthorize("isFullyAuthenticated()")
@CrossOrigin(origins = "http://localhost:5173")
public class PinController {

    @Autowired
    private PinRepository pinRepository;

    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }


    @GetMapping
    public List<Pin> getAllPins(Principal principal) {
        return pinRepository.findAll();
    }

    @GetMapping("/creator/{creatorUid}/pins")
    public List<Pin> getCreatorPins(Principal principal, @PathVariable String creatorUid) {return pinRepository.findByCreatorUid(creatorUid);}

    @DeleteMapping("/pins/{pinId}/pin")
    public ResponseEntity<String> deletePin(Principal principal,@PathVariable Long pinId){
        String creatorUid = principal.getName();
        Optional<Pin> existingPin = Optional.ofNullable(this.pinRepository.findByCreatorUidAndPinId(creatorUid, pinId));
        if(existingPin.isPresent()){
            this.pinRepository.delete(existingPin.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/pins")
    public ResponseEntity<String> addPin(Principal principal,  @RequestParam double latitude, @RequestParam double longitude, @RequestParam String pinText, @RequestParam String category){
        System.out.println("Adding pin");
        String creatorUid = principal.getName();
        Pin newPin = new Pin(creatorUid, latitude, longitude, pinText, category);
        this.pinRepository.save(newPin);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/pins/{category}/category")
    public List<Pin> getPinsByCategory(Principal principal, @PathVariable String category) {
        return pinRepository.findByCategory(category);
    }
}