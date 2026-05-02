package com.mycompany.property.management.service.impl;


import com.mycompany.property.management.controller.PropertyController;
import com.mycompany.property.management.converter.PropertyConverter;
import com.mycompany.property.management.dto.PropertyDTO;
import com.mycompany.property.management.entity.PropertyEntity;
import com.mycompany.property.management.repository.PropertyRepository;
import com.mycompany.property.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class   PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy}")
    private String dummy;

    @Value("${spring.datasource.url}")
    private String dburl;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;


    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

       PropertyEntity pe =  propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);

        propertyDTO = propertyConverter.convertEntityToDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        System.out.println("Inside service " + dummy);
        System.out.println("Inside service " + dburl);

       List<PropertyEntity> listofProps = (List<PropertyEntity>)propertyRepository.findAll();

        List<PropertyDTO> propList = new ArrayList<>();
       for(PropertyEntity pe:listofProps){
          PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
           propList.add(dto);
        }
       return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> opten = propertyRepository.findById(propertyId);

        PropertyDTO dto = null;
        if(opten.isPresent()){

            PropertyEntity pe = opten.get();//data from database
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
             dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opten = propertyRepository.findById(propertyId);

        PropertyDTO dto = null;
        if(opten.isPresent()){
            PropertyEntity pe = opten.get();//data from database
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opten = propertyRepository.findById(propertyId);

        PropertyDTO dto = null;
        if(opten.isPresent()){
            PropertyEntity pe = opten.get();//data from database
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void  deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

    }


}
