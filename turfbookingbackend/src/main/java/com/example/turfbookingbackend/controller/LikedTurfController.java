package com.example.turfbookingbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.turfbookingbackend.model.LikedTurf;
import com.example.turfbookingbackend.service.LikedTurfService;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikedTurfController {
    @Autowired
    private LikedTurfService likedTurfService;

    @GetMapping("/{userId}")
    public List<LikedTurf> getLikedTurfs(@PathVariable Long userId) {
        return likedTurfService.getLikedTurfs(userId);
    }

    @PostMapping("/toggle")
    public void toggleLike(@RequestParam Long userId, @RequestParam Long turfId) {
        if (likedTurfService.isTurfLiked(userId, turfId)) {
            likedTurfService.removeLike(userId, turfId);
        } else {
            likedTurfService.addLike(userId, turfId);
        }
    }
}
