/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.mappers.MessageMapper;
import com.goldencompany.airbnb.repositories.MessageRepository;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class MessageManagementController {

    @Inject
    MessageRepository messageRepository;

    @Inject
    MessageMapper messageMapper;

    public List retrieveReceivedMessageByUserID(Integer id) {
        List<Message> messages = messageRepository.findReceivedByUserID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }
    
        public List retrieveSentMessageByUserID(Integer id) {
        List<Message> messages = messageRepository.findSentByUserID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }
        
        //edw
        public List retrieveMessageDetailsByID(Integer id) {
        List<Message> messages = messageRepository.findDetailsByID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }
        
//        public List retrieveAllMessageByUserID(Integer id) {
//        List<Message> messages = messageRepository.retrieveAllMessagesByUserID(id);
//
//        List dtos = messageMapper.toDTO(messages);
//
//        return dtos;
//    }    

//    public List findDetailsByID(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public List retrieveAllMessagesByUserID(Integer id) {
          List<Message> messages = messageRepository.findByUserID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }
    
    
    

}
