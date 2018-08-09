package com.sergiossj.msmail.services;

import com.sergiossj.msmail.dtos.UserDto;
import com.sergiossj.msmail.entities.User;

public interface EmailService {
    public void sendSimpleMessage(User input);
}
