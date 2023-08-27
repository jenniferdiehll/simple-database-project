package com.db2.homework2.controller;

import com.db2.homework2.models.Consumer;
import com.db2.homework2.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerRepository repository;

    @PostMapping
    private String createConsumer(@RequestBody Consumer consumer) {
        repository.save(consumer);
        return "Consumer has been created successfully!";
    }

    @GetMapping("/{id}")
    public Consumer searchConsumer(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

}
