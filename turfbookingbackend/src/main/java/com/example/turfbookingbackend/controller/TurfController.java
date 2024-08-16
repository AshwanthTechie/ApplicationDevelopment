package com.example.turfbookingbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turfbookingbackend.model.Turf;
import com.example.turfbookingbackend.service.TurfService;

@RestController
@RequestMapping("/turf")
@CrossOrigin("http://localhost:3000/")
public class TurfController {
    @Autowired
    TurfService turfService;

    @PostMapping("/add")
    public Turf addTurf(@RequestBody Turf turf)
    {
        return turfService.addTurf(turf);
    }

    @GetMapping("/get/{turfId}")
    public Optional<Turf> getTurf(@PathVariable Long turfId)
    {
        return turfService.getTurf(turfId);
    }

    @GetMapping("/get")
    public List<Turf> getTurfs()
    {
        return turfService.getTurfs();
    }

    @PutMapping("/update/{turfId}")
    public Turf updateTurf(@PathVariable Long TurfId,@RequestBody Turf turf)
    {
        return turfService.updateTurf(TurfId, turf);
    }

    @DeleteMapping("/delete/{turfId}")
    public Boolean deleteTurf(@PathVariable Long turfId)
    {
        return turfService.deleteTurf(turfId);
    }
}
