package com.example.studentCouncil.Controller.Api;

import com.example.studentCouncil.Dto.ImageDto;
import com.example.studentCouncil.Dto.UserReqDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class ImageApi {

    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage() throws IOException {
        // Load the image from the file system or any other source
        // For example, you can serve an image from the resources' folder:
        Path imagePath = Paths.get("Images/userx.png");
        Resource imageResource = new UrlResource(imagePath.toUri());

        // You can also load the image from a database or other storage systems.
        // Make sure to set the appropriate Content-Type according to the image type.

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imageResource.getInputStream()));
    }

}