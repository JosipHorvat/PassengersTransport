package com.josip.passenegertransport.services.servicesimpl;


import com.josip.passenegertransport.domain.Driver;
import com.josip.passenegertransport.repositories.DriverRepository;
import com.josip.passenegertransport.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl  implements ImageService {

    private final DriverRepository driverRepository;

    public ImageServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long driverId, MultipartFile file) {

        try {
            Driver driver = driverRepository.findById(driverId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }
            driver.setImage(byteObjects);
            driverRepository.save(driver);

        } catch (IOException e) {
            //todo Need to be better handled
            log.error("Error occurred");
            e.printStackTrace();
        }

        log.debug("Received an image file");
    }
}


