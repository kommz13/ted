/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.RuleDTO;
import com.goldencompany.airbnb.entity.Rule;

/**
 *
 * @author george
 */
class RuleMapper {
    
       public RuleDTO toDTO(Rule entity){
         RuleDTO dto = new RuleDTO();
         
         dto.setId(entity.getId());
         dto.setRule(entity.getRule());
         
         return dto;
     }
    
}
