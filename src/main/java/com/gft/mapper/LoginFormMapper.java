package com.gft.mapper;

import com.gft.dto.LoginFormDTO;
import com.gft.model.LoginForm;

public class LoginFormMapper {

    public static LoginForm toLoginForm(LoginFormDTO dto){
        return new LoginForm(dto.getEmail(), dto.getSenha());
    }
}
