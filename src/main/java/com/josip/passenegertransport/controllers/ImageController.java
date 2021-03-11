package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Driver;
import com.josip.passenegertransport.services.DriverService;
import com.josip.passenegertransport.services.ImageService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@AllArgsConstructor
public class ImageController {

 @Autowired private final ImageService imageService;
 @Autowired private final DriverService driverService;


    @GetMapping("driver/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model) {
        model.addAttribute("driver", driverService.findById(Long.valueOf(id)));

        return "driver/imageuploadform";
    }

    @PostMapping("driver/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {

        imageService.saveImageFile(Long.valueOf(id), file);

        return "redirect:/driver/" + id + "/show";
    }

    @GetMapping("driver/{id}/driverimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Driver driver = driverService.findById(Long.valueOf(id));

        byte[] byteArray = new byte[driver.getImage().length];
        int i = 0;

        for (Byte wrappedByte : driver.getImage()) {
            byteArray[i++] = wrappedByte; // ovo je auto unboxing
        }
        response.setContentType("image/jpeg");
        InputStream inputStream = new ByteArrayInputStream(byteArray);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
}
