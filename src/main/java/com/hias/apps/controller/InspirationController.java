package com.hias.apps.controller;

import com.hias.apps.domain.*;
import com.hias.apps.service.InspirationService;
import com.hias.apps.service.BannerService;
import com.hias.apps.service.TipsTrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import java.util.List;

import com.hias.apps.util.ErrorResponse;

@CrossOrigin
@RestController
public class InspirationController {


    @Autowired
    private InspirationService inspirationService;

    @Autowired
    private TipsTrickService tipsTrickService;


    @GetMapping("/inspration/{id}/product")
    public ResponseEntity<?> getBanner(@PathVariable(value = "id") Long Id) {
        JSONObject listSub = new JSONObject();
        JSONObject resp = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();
        List<JSONObject> product = new ArrayList<>();


        List<InspirationProduct> listHotProduct = inspirationService.getByInspirationId(Id);
        JSONObject listUser = new JSONObject();
        for(InspirationProduct objects : listHotProduct) {
            JSONObject json = new JSONObject();

            listSub.put("product",listItem);

            json.put("productId",objects.getProduct().getId());
            json.put("productName",objects.getProduct().getName());
            json.put("price",objects.getProduct().getPrice());
            json.put("thumbnail",objects.getProduct().getThumNailUrl());

            listSub.put("title",objects.getInspiration().getTitle());
            listSub.put("inspiratioId",objects.getInspiration().getId());
            listSub.put("description",objects.getInspiration().getTitle());
            listSub.put("banner",objects.getInspiration().getImagebanner());


//            json.put("id",objects.getId());
//            json.put("imageUrl",objects.getImageBannerUrl());

            listItem.add(json);

        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    @GetMapping("/getAllInspiration")
    public ResponseEntity<?> getAllBannerWeb() {

        JSONObject listSub = new JSONObject();
        JSONObject resp = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();

        List<Inspiration> listHotProduct = inspirationService.getAllInspiration();


        JSONObject listUser = new JSONObject();
        for(Inspiration objects : listHotProduct) {
            JSONObject json = new JSONObject();

            listSub.put("inspiration",listItem);

            json.put("title",objects.getTitle());
            json.put("id",objects.getId());
            json.put("description",objects.getDescription());
            json.put("banner",objects.getImagebanner());


//            json.put("id",objects.getId());
//            json.put("imageUrl",objects.getImageBannerUrl());

            listItem.add(json);

        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/tips/{id}/product")
    public ResponseEntity<?> getTipsTrick(@PathVariable(value = "id") Long Id) {
        JSONObject listSub = new JSONObject();
        JSONObject resp = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();
        List<JSONObject> product = new ArrayList<>();


        List<TipsProduct> listHotProduct = tipsTrickService.getByTipsId(Id);
        JSONObject listUser = new JSONObject();
        for(TipsProduct objects : listHotProduct) {
            JSONObject json = new JSONObject();

            listSub.put("product",listItem);

            json.put("productId",objects.getProduct().getId());
            json.put("productName",objects.getProduct().getName());
            json.put("price",objects.getProduct().getPrice());
            json.put("thumbnail",objects.getProduct().getThumNailUrl());

            listSub.put("title",objects.getTipsTrick().getTitle());
            listSub.put("tipsId",objects.getTipsTrick().getId());
            listSub.put("description",objects.getTipsTrick().getTitle());
            listSub.put("banner",objects.getTipsTrick().getImagebanner());


//            json.put("id",objects.getId());
//            json.put("imageUrl",objects.getImageBannerUrl());

            listItem.add(json);

        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/getAllTips")
    public ResponseEntity<?> getAllTips() {

        JSONObject listSub = new JSONObject();
        JSONObject resp = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();

        List<TipsTrick> listHotProduct = tipsTrickService.getALlTips();


        JSONObject listUser = new JSONObject();
        for(TipsTrick objects : listHotProduct) {
            JSONObject json = new JSONObject();

            listSub.put("tips",listItem);

            json.put("title",objects.getTitle());
            json.put("id",objects.getId());
            json.put("description",objects.getDescription());
            json.put("banner",objects.getImagebanner());


//            json.put("id",objects.getId());
//            json.put("imageUrl",objects.getImageBannerUrl());

            listItem.add(json);

        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}