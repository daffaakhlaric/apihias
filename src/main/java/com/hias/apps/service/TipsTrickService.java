package com.hias.apps.service;

import com.amazonaws.services.apigateway.model.Op;
import com.hias.apps.domain.*;
import com.hias.apps.dto.ProductDiscussionDto;
import com.hias.apps.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class TipsTrickService {
    @Autowired
    private TipsTrickRepository tipsTrickRepository;

    @Autowired
    private TipsRepository tipsRepository;



    public List<TipsProduct> getByTipsId(Long id){

        return tipsTrickRepository.findByTipsId(id);
    }

    public List<TipsTrick> getALlTips(){

        return tipsRepository.findAll();
    }


    public void insertTipsTrick(String description, String title,String image){
        tipsRepository.insertTips(title,description,image);

    }

    public void insertInspirationRelated(Long inspirationId, Long productId){
        tipsTrickRepository.insertDiscussion(inspirationId,productId);

    }

    public void deleteTips(Long id){
        tipsRepository.deleteTips(id);

    }

    public void updateInspiration(String title,String description,String image, Long id){
        tipsRepository.updateTips(title,description,image,id);

    }
}
