package com.mycompany.property.management.service.impl;

import com.mycompany.property.management.converter.UserConventer;
import com.mycompany.property.management.dto.UserDTO;
import com.mycompany.property.management.entity.UserEntity;
import com.mycompany.property.management.exception.BusinessException;
import com.mycompany.property.management.exception.ErrorModel;
import com.mycompany.property.management.repository.UserRepository;
import com.mycompany.property.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConventer userConventer;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL ALREADY EXIT");
            errorModel.setMessage("The Email With Which You Are Trying To Already Exist!");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConventer.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConventer.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);

        if(optionalUserEntity.isPresent()){
            userDTO = userConventer.convertEntityToDTO(optionalUserEntity.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email of Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
