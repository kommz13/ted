/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.MessageDTO;
import com.goldencompany.airbnb.dto.UserDTO;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class MessageMapper {

    @Inject
    UserMapper userMapper;

    public MessageDTO toDTO(Message entity) {
        MessageDTO dto = new MessageDTO();

        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setDateTime(entity.getDateTime());
        
        User from = entity.getUserIdFrom();
        User to = entity.getUserIdTo();
        
        List<User> entities = new ArrayList<>();
        
        entities.add(from);
        entities.add(to);
        
        List dtos = userMapper.toDTO(entities);
        
        UserDTO fromdto = (UserDTO) dtos.get(0);
        UserDTO todto = (UserDTO) dtos.get(1);
        
        dto.setSender(fromdto);
        dto.setReceiver(todto);

        return dto;
    }

    public List toDTO(List<Message> entities) {
        List list = new ArrayList();

        for (Message entity : entities) {
            MessageDTO messagedto = toDTO(entity);
            list.add(messagedto);
        }

        return list;
    }
}
