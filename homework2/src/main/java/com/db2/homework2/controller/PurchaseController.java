package com.db2.homework2.controller;

import com.db2.homework2.models.Purchase;
import com.db2.homework2.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository repository;

    @PostMapping
    private String registerPurchase(@RequestBody Purchase purchase) {
        repository.save(purchase);
        return "Purchase has been created successfully!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> searchPurchase(@PathVariable int id) {
        Optional<Purchase> searchedPurchase = repository.findById(id);

        if (searchedPurchase.isPresent()) {
            Purchase purchase = searchedPurchase.get();
            return ResponseEntity.ok(purchase);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
