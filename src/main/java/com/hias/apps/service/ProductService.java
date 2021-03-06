package com.hias.apps.service;

//import com.amazonaws.services.apigateway.model.O;
import com.hias.apps.domain.ColorProduct;
import com.hias.apps.domain.Product;
import com.hias.apps.domain.UserRegister;
import com.hias.apps.repository.ColorProductRepository;
import com.hias.apps.repository.ProductRelatedRepository;
import com.hias.apps.repository.ProductRepository;
import java.util.List;

import com.hias.apps.repository.VarianProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColorProductRepository colorProductRepository;

    @Autowired
    private VarianProductRepository varianProductRepository;

    @Autowired
    private ProductRelatedRepository productRelatedRepository;

    // View All Product
    public List<Product> getListAllProduct(){
        List<Product> result = productRepository.findAll();
        return result;
    }
    public void insertProduct(Product product) {
        productRepository.save(product);
    }
    // View All Product 10 Terlaris
    public List<Product> getListTopProduct(){
        List<Product> result = productRepository.findTop10ByOrderByQuantityDesc();
        return result;
    }

    public Page<Product> getListProduct(Pageable pageable){
        Page<Product> result = productRepository.findAllByOrderByIdDesc(pageable);
        return result;
    }

    public List<Product> getListProductBanner(){
        List<Product> result = productRepository.findAllProductBanner();
        return result;
    }

    public List<Product> getListNewestProduct(Long Id){
        List<Product> result = productRepository.findAllByOrderByIdAsc(Id);
        return result;
    }

    public List<Product> getRelatedList(Long Id){
        List<Product> result = productRepository.findAllByRelatedOrderByIdAsc(Id);
        return result;
    }
    public List<Product> getColorRed(Long Id){
        List<Product> result = productRepository.findAllColorRed(Id);
        return result;
    }

    public List<Product> getColorGreen(Long Id){
        List<Product> result = productRepository.findAllColorGreen(Id);
        return result;
    }

    public List<Product> getColorBlue(Long Id){
        List<Product> result = productRepository.findAllColorBlue(Id);
        return result;
    }

    public List<Product> getDiskon(Long Id){
        List<Product> result = productRepository.findAllDiskon(Id);
        return result;
    }

    public List<Product> getAllColot(Long Id,String color){
        List<Product> result = productRepository.findAllColor(Id,color);
        return result;
    }

    public Page<Product> getAllDiscount(Pageable pageable){
        Page<Product> result = productRepository.findDscoount(pageable);
        return result;
    }

    public List<Product> getColorBlack(Long Id){
        List<Product> result = productRepository.findAllColorBlack(Id);
        return result;
    }

    public List<Product> getColorWhite(Long Id){
        List<Product> result = productRepository.findAllColorWhite(Id);
        return result;
    }

    public List<Product> getListLatestProduct(Long Id){
        List<Product> result = productRepository.findAllByOrderByIdDesc(Id);
        return result;
    }

    public List<Product> getListLastPriceProduct(Long Id){
        List<Product> result = productRepository.findAllByOrderByPriceAsc(Id);
        return result;
    }

    public List<Product> getListNewestPriceProduct(Long Id){
        List<Product> result = productRepository.findAllByOrderByPriceDesc(Id);
        return result;
    }

    public Optional<Product> getProductById(Long Id){
        Optional<Product> result = productRepository.findById(Id);
        return result;
    }

    public Page<Product> getProductBySubCategoryId(Long id, Pageable pageable){
        Page<Product> result = productRepository.findByCategoryId(id,pageable);
        return result;
    }

    public Page<Product> getListSearchProduct(String name,Pageable pageable){
        Page<Product> result = productRepository.findByName(name,pageable);
        return result;
    }

    public List<Product> getListEndProduct(){
        List<Product> result = productRepository.findTop10ByOrderByQuantityAsc();
        return result;
    }

    public List<Product> getListBestSeller(){
        List<Product> result = productRepository.findFirst8ByOrderBySellCountAsc();
        return result;
    }

    public List<Product> getListHoItemsProduct(){
        List<Product> result = productRepository.findFirst8ByOrderByIdDesc();
        return result;
    }

    public List<Product> getLisAtoZProduct(Long Id){
        List<Product> result = productRepository.findAllByOrderByNameAsc(Id);
        return result;
    }

    public List<Product> getLisZtoAProduct(Long Id){
        List<Product> result = productRepository.findAllByOrderByNameDesc(Id);
        return result;
    }

    public List<ColorProduct> getColorProduct(Long id){

        return colorProductRepository.findByProductId(id);
    }

    public void insertRelatedProduct(Long productId, Long productRelatedId){
        productRelatedRepository.insertRelated(productId,productRelatedId);

    }

    public void insertVariantProduct(Long productId, Long productVariantId){
        varianProductRepository.insertVariant(productId,productVariantId);

    }

    public void insertColorProduct(Long productId, Long productRelatedId){
        colorProductRepository.insertRelated(productId,productRelatedId);

    }

    public void deleteProduct(Long id){
        productRepository.deleteProduct(id);

    }

    public void insertProduct(String productName, Long categoryId,Long discount, String overview, String description, String thumbnail,String hashTag,String color, String dimen,Long price, String productCode, Long quantity, String weight, String picture1,String picture2,String picture3,String picture4,String picture5,String picture6,String courier1,String courier2,String courier3, String courier4){
        productRepository.insertProduct(productName,categoryId,discount,overview,description,thumbnail,hashTag,color,dimen,price,productCode,quantity,weight,picture1,picture2,picture3,picture4,picture5,picture6,courier1,courier2,courier3,courier4);

    }

    public void changeProduct(String productName, Long categoryId, Long discount,String overview, String description, String thumbnail,String hashTag,String color, String dimen,Long price, String productCode, Long quantity, String weight, String picture1,String picture2,String picture3,String picture4,String picture5,String picture6,String courier1,String courier2,String courier3, String courier4,Long id){
        productRepository.updateProduct(productName,categoryId,discount,overview,description,thumbnail,hashTag,color,dimen,price,productCode,quantity,weight,picture1,picture2,picture3,picture4,picture5,picture6,courier1,courier2,courier3,courier4,id);
    }
}
