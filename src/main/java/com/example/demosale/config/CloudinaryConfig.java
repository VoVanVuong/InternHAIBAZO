package com.example.demosale.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary("cloudinary://886477998432165:mQas0TFlx3I9fi25mRdp6P99Iww@dkfetvkpu");
//        CLOUDINARY_URL=cloudinary://577988717918425:WHj1K3bLm9oXpaLNTdyErj7wTNo@dbnqwh7hy
//        mQas0TFlx3I9fi25mRdp6P99Iww
//        CLOUDINARY_URL=cloudinary://886477998432165:mQas0TFlx3I9fi25mRdp6P99Iww@dkfetvkpu
    }

}
