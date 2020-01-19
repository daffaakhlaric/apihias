package com.hias.apps.service;

import com.hias.apps.domain.ProductPilihan;
import com.hias.apps.domain.ProductRating;

import com.hias.apps.repository.ProductPilihanRepository;
import com.hias.apps.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductPilihanService {

    @Autowired
    private ProductPilihanRepository productPilihanRepository;


    public Page<ProductPilihan> getProductPilihanAll(Pageable pageable){
        Page<ProductPilihan> result = productPilihanRepository.findAllByOrderByIdDesc(pageable);

        return result;
    }

    public List<ProductPilihan> getPopupCartProduct(){
        List<ProductPilihan> result = productPilihanRepository.findFirst3ByOrderByIdDesc();

        return result;
    }

    public List<ProductPilihan> getProductPilihanHome(){
        List<ProductPilihan> result = productPilihanRepository.findFirst8ByOrderByIdDesc();

        return result;
    }

    public void insertProductPilihan(Long productId){
        productPilihanRepository.insertProductPilihan(productId);

    }

    public void deleteProductPilihan(Long Id){
        productPilihanRepository.deleteProductPilihan(Id);

    }

    public void updateProductPilihan(Long productId, Long id){
        productPilihanRepository.updateProductPilihan(productId,id);
    }
}
