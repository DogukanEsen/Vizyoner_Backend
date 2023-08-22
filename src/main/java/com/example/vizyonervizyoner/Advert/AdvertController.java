package com.example.vizyonervizyoner.Advert;

import com.example.vizyonervizyoner.Company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adverts")
@CrossOrigin(origins = "http://localhost:3000")
public class AdvertController {

    private final AdvertService advertService;

    @Autowired
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    // Create a new advert
    @PostMapping("/create")
    public ResponseEntity<Advert> createAdvert(@RequestBody Advert advert) {
        Advert createdAdvert = advertService.createAdvert(advert);
        return new ResponseEntity<>(createdAdvert, HttpStatus.CREATED);
    }

    // Get all adverts
    @GetMapping("/getAllAdverts")
    public List<Advert> getAllAdverts() {
        List<Advert> adverts = advertService.getAllAdverts();
        return adverts;
    }


    // Get a single advert by ID
    @GetMapping("/getAdvertByID/{id}")
    public ResponseEntity<Advert> getAdvertById(@PathVariable Integer id) {
        Advert advert = advertService.getAdvertById(id);
        if (advert != null) {
            return new ResponseEntity<>(advert, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Advert>> getAdvertsByCompanyId(@PathVariable int companyId) {
        List<Advert> adverts = advertService.findAdvertsByCompanyId(companyId);
        if (adverts != null && !adverts.isEmpty()) {
            return new ResponseEntity<>(adverts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Update an existing advert
    @PutMapping("/update/{id}")
    public ResponseEntity<Advert> updateAdvert(@PathVariable int id, @RequestBody Advert updatedAdvert) {
        Advert advert = advertService.updateAdvert(id, updatedAdvert);
        if (advert != null) {
            return new ResponseEntity<>(advert, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an advert by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdvert(@PathVariable Integer id) {
        boolean deleted = advertService.deleteAdvert(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
