package com.maktabsharif.springbootdemo.mapper;

import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.service.dto.UserBriefDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserBriefDTO convertUserToBriefDTO(User user);

}
