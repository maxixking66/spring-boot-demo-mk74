package com.maktabsharif.springbootdemo.mapper;

import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.service.dto.UserBriefDTO;
import com.maktabsharif.springbootdemo.service.dto.extra.UserAddressDTO;
import com.maktabsharif.springbootdemo.service.dto.extra.UserCreateDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserBriefDTO convertUserToBriefDTO(User user);

    UserAddressDTO convertUserToAddressDTO(User user);

    User convertUserCreateDTOToUser(UserCreateDTO createDTO);

}
