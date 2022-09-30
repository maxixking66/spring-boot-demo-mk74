package com.maktabsharif.springbootdemo.service.dto.extra;

import com.maktabsharif.springbootdemo.base.service.dto.BaseDTO;
import com.maktabsharif.springbootdemo.service.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDTO extends BaseDTO<Long> {

    private Set<AddressDTO> addressSet;

}
