package com.yazzzeh.cloudinary.controller;

import com.yazzzeh.cloudinary.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class CloudinaryController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload/file")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file")MultipartFile file,
            @RequestParam("folder") String folderName
            ) throws IOException{
        return ResponseEntity.ok(cloudinaryService.uploadFile(file, folderName)); //if the return url shows 401 enable pdf delivery in security settings

    }

    @PostMapping("/upload/image")
    public ResponseEntity<?> uploadImage(
            @RequestParam("file")MultipartFile file,
            @RequestParam("folder") String folderName
    ) throws IOException{
        return ResponseEntity.ok(cloudinaryService.uploadImage(file, folderName));
    }

    @PostMapping("/upload/video")
    public ResponseEntity<?> uploadVideo(
            @RequestParam("file")MultipartFile file,
            @RequestParam("folder") String folderName
    ) throws IOException{
        return ResponseEntity.ok(cloudinaryService.uploadVideo(file, folderName));
    }


    @DeleteMapping("/delete/raw")
    public ResponseEntity<?> deleteRaw(@RequestParam String publicId) throws IOException {
        return ResponseEntity.ok(cloudinaryService.deleteRaw(publicId));
    }
}
