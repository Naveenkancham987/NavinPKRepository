package com.pk.publisher.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author navi
 *
 */
@Configuration
public class ModelMapConfiguration {
   
     /**
      * 
      * @return ModelMapper
      */
    @Bean public ModelMapper getModelMapper() 
    { 
      return new ModelMapper();
    
    }
   
}
