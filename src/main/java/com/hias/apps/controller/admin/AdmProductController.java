package com.hias.apps.controller.admin;

import com.hias.apps.domain.*;
import com.hias.apps.dto.*;
import com.hias.apps.repository.CartRepository;
import com.hias.apps.service.*;
import com.hias.apps.util.ResponseSuccess;
import com.hias.apps.repository.DiscussionRepository;
import com.hias.apps.repository.MediaRepository;
import com.hias.apps.service.AmazonClient;

import java.io.IOException;
import java.net.URI;
import java.util.*;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hias.apps.util.ErrorResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/adm/product/")
@Api(value = "/adm/product/", description = "Authentication", produces = "application/json")
@CrossOrigin
public class AdmProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TestimonialService testimonialService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ProductPilihanService productPilihanService;

    @Autowired
    private AmazonClient AmazonClient;


    @Autowired
    private MediaRepository mediaRepository;


    @Autowired
    private NewsLatterService newsLatterService;

    @Autowired
    private RefundService RefundService;

    @Autowired
    private BannerService bannerService;
    private AmazonClient amazonClient;


    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable (value = "id") Long Id) {


        JSONObject resp = new JSONObject();
        List<JSONObject> listSub = new ArrayList<>();
        List<String> pictures = new ArrayList<>();
        List<String> couriers = new ArrayList<>();
        List<JSONObject> variants = new ArrayList<>();
        JSONObject result = new JSONObject();
        JSONObject picture = new JSONObject();
        JSONObject courier = new JSONObject();

        Optional<Product> listHotProduct = productService.getProductById(Id);
//        Product existingProduct = listHotProduct.get();
        if(listHotProduct != null){
            JSONObject listSubCategory = new JSONObject();
            JSONObject listMiniSubCategory = new JSONObject();
            JSONObject superMiniSubCategory = new JSONObject();
            JSONObject mainCategory = new JSONObject();
            JSONObject category = new JSONObject();
            JSONObject json = new JSONObject();
            JSONObject variant = new JSONObject();
            JSONObject variant1 = new JSONObject();

//
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
//            HashMap<String,Object> map = mapper.readValue( body, typeRef);

            Product existingProduct = listHotProduct.get();
            json.put("productId", existingProduct.getId());
            json.put("productName", existingProduct.getName());
            json.put("discount", existingProduct.getDiscount());
            json.put("productCode", existingProduct.getProductCode());
            json.put("color", existingProduct.getColor());
            json.put("description", existingProduct.getDescription());
//            json.put("courier", existingProduct.getCourier());
            json.put("overview", existingProduct.getOverview());
            json.put("rating", "20");
            json.put("price", existingProduct.getPrice());
            json.put("weight", existingProduct.getWeight());
            json.put("hashTag", existingProduct.getHash_tag());
            json.put("dimensions", existingProduct.getDimensions());
            json.put("thumbnail",existingProduct.getThumNailUrl());


//
//            json.put("picture",pictures);
//            map.put(Sample, Value);
            json.put("picture1",existingProduct.getPicture_1());
            json.put("picture2",existingProduct.getPicture_2());
            json.put("picture3",existingProduct.getPicture_3());
            json.put("picture4",existingProduct.getPicture_4());
            json.put("picture5",existingProduct.getPicture_5());
            json.put("picture6",existingProduct.getPicture_6());
            json.put("courier1",existingProduct.getCourier_1());
            json.put("courier2",existingProduct.getCourier_2());
            json.put("courier3",existingProduct.getCourier_3());
            json.put("courier4",existingProduct.getCourier_4());


//            json.put("variant",variants);
            //;fijifnuf
//            variant.put("productId",existingProduct.getProductVariant1().getId());
//            variant.put("productName", existingProduct.getProductVariant1().getName());
//            variant.put("price", existingProduct.getProductVariant1().getPrice());
//            variant.put("thumbnail",existingProduct.getProductVariant1().getThumNailUrl());

//            variant.put("category",category);
//            category.put("id",existingProduct.getProductVariant2().getMiniSubCategoryProperties().getId());
//            category.put("name",existingProduct.getProductVariant2().getMiniSubCategoryProperties().getCategoryname());
//
//            variant1.put("productId",existingProduct.getProductVariant2().getId());
//            variant1.put("productName", existingProduct.getProductVariant2().getName());
//            variant1.put("price", existingProduct.getProductVariant2().getPrice());
//            variant1.put("thumbnail",existingProduct.getProductVariant2().getThumNailUrl());

//            variant1.put("category",category);
//            category.put("id",existingProduct.getProductVariant2().getMiniSubCategoryProperties().getId());
//            category.put("name",existingProduct.getProductVariant2().getMiniSubCategoryProperties().getCategoryname());

//
//            json.put("mainCategory",mainCategory);
//            mainCategory.put("id",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getId());
//            mainCategory.put("name",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getCategoryname());
//            mainCategory.put("description",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getDescription());
//
//            mainCategory.put("subCategory", listSubCategory);
//            listSubCategory.put("id",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getId());
//            listSubCategory.put("name",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getCategoryname());
//
//            mainCategory.put("secondSubCategory", listMiniSubCategory);
//            listMiniSubCategory.put("id",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getId());
//            listMiniSubCategory.put("name",existingProduct.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getCategoryname());

//            json.put("category",mainCategory);
            json.put("categoryId",existingProduct.getMiniSubCategoryProperties().getId());
            json.put("name",existingProduct.getMiniSubCategoryProperties().getCategoryname());

//            json.put("courier",couriers);

            listSub.add(json);
//            pictures.add(existingProduct.getPicture_1());
//            pictures.add(existingProduct.getPicture_2());
//            pictures.add(existingProduct.getPicture_3());
//            pictures.add(existingProduct.getPicture_4());
//            pictures.add(existingProduct.getPicture_5());
//            pictures.add(existingProduct.getPicture_6());
//            couriers.add(existingProduct.getCourier_1());
//            couriers.add(existingProduct.getCourier_2());
//            couriers.add(existingProduct.getCourier_3());
//            couriers.add(existingProduct.getCourier_4());
//            variants.add(variant);
//            variants.add(variant1);

            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }

    @GetMapping("getProduct")
    public ResponseEntity<?> getallproduct(Pageable pageable) {

        JSONObject resp = new JSONObject();
        List<JSONObject> listSub = new ArrayList<>();
//        float totalPrice;
        JSONObject result = new JSONObject();
        Page<Product> listHotProduct = productService.getListProduct(pageable);
        for(Product objects : listHotProduct) {
            JSONObject json = new JSONObject();
//            TotalAfterDiscount = objects.getPrice()*objects.getDiscount()/100;
//            totalPrice = objects.getPrice()-TotalAfterDiscount;



            JSONObject mainCategory = new JSONObject();

            json.put("id", objects.getId());
            json.put("productName", objects.getName());
            json.put("discount", objects.getDiscount());
            json.put("price", objects.getPrice());
//            json.put("priceAfterDiscount", TotalAfterDiscount);
            json.put("itemStock", objects.getQuantity());
            json.put("thumbnail",objects.getThumNailUrl());

            json.put("category",mainCategory);
            mainCategory.put("id",objects.getMiniSubCategoryProperties().getId());
            mainCategory.put("name",objects.getMiniSubCategoryProperties().getCategoryname());


            listSub.add(json);


        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
            resp.put("offset", pageable.getOffset());
            resp.put("hashNext", pageable.next());;
            resp.put("first", pageable.first());
            resp.put("hasPrevious", pageable.hasPrevious());
            resp.put("isPaged", pageable.isPaged());
            resp.put("unPaged", pageable.isUnpaged());
            resp.put("pageNumber", pageable.getPageNumber());
            resp.put("sort",
                    pageable.getSort());
            resp.put("sortOr",
                    pageable.getSortOr(Sort.unsorted()));
            resp.put("size", pageable.getPageSize());
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }

//    @GetMapping("getAllProduct")
//    public ResponseEntity<?> hotItems() {
//
//        JSONObject resp = new JSONObject();
//        List<JSONObject> listSub = new ArrayList<>();
//        JSONObject result = new JSONObject();
//        List<Product> listHotProduct = productService.getListProduct();
//        for(Product objects : listHotProduct) {
//            JSONObject json = new JSONObject();
//            JSONObject listSubCategory = new JSONObject();
//            JSONObject listMiniSubCategory = new JSONObject();
//            JSONObject superMiniSubCategory = new JSONObject();
//            JSONObject mainCategory = new JSONObject();
////            JSONObject json = new JSONObject();
//            json.put("id", objects.getId());
//            json.put("productName", objects.getName());
//            json.put("discount", objects.getDiscount());
//            json.put("price", objects.getPrice());
//            json.put("thumbnail",objects.getThumNailUrl());
//            json.put("categoryName",objects.getMiniSubCategoryProperties().getCategoryname());
////
//////            json.put("mainCategory",mainCategory);
//////            mainCategory.put("id",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getId());
//////            mainCategory.put("name",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getCategoryname());
//////            mainCategory.put("description",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getDescription());
//////
//////            mainCategory.put("subCategory", listSubCategory);
//////            listSubCategory.put("id",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getId());
//////            listSubCategory.put("name",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getCategoryname());
//////
//////            mainCategory.put("secondSubCategory", listMiniSubCategory);
//////            listMiniSubCategory.put("id",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getId());
//////            listMiniSubCategory.put("name",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getCategoryname());
////
////
////            mainCategory.put("thirdSubCategory", superMiniSubCategory);
////            superMiniSubCategory.put("id",objects.getMiniSubCategoryProperties().getId());
////            superMiniSubCategory.put("name",objects.getMiniSubCategoryProperties().getCategoryname());
//            listSub.add(json);
//
//
//        }
//        if(listSub != null){
//            resp.put("data", listSub);
//            resp.put("success", true);
//            resp.put("error", null);
//        }
//        else {
//            resp.put("data", null);
//            resp.put("success", false);
//            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
//        }
//        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
//    }



//
//    @GetMapping("{id}/getCartByUserId")
//    public  ResponseEntity<?>  getAddToCart(@PathVariable (value = "id") Long id) {
//        List<Cart> cart = cartRepository.findByUserId(id);
//
//        JSONObject listSub = new JSONObject();
//        JSONObject resp = new JSONObject();
//
//        List<JSONObject> listItem = new ArrayList<>();
//
//        int subTotal = 0;
////        Cart cart = user.getCart();
////        Product product = productRepository.findOne(productId);
////        List<CartItem> cartItems = cart.getCartItems();
//
////        List<CartItem> cartItem = (List<CartItem>) new JSONObject();
//        List<CartItem> listHotProduct = cartItemService.getByCartId(id);
//        for(CartItem objects : listHotProduct) {
//            JSONObject json = new JSONObject();
//
////            Total = objects.getCartProduct().getPrice()*objects.getAmount();
////            subTotal += total += Total ;
//            Total = objects.getCartProduct().getPrice()*objects.getAmount();
//            subTotal += Total;
//
//
////            List<JSONObject> total = new ArrayList<>();
//
////           Total = objects.getProductCart(objects.getCartProduct().getPrice()*objects.getAmount());
//
//            listSub.put("listItems",listItem);
//
////            listSub.put("totalPrice",Total);
//            listSub.put("cartId",objects.getCart().getId());
//            listSub.put("subTotal",subTotal);
//
//            json.put("itemsId",objects.getId());
//            json.put("productId",objects.getCartProduct().getId());
//
//            json.put("name",objects.getCartProduct().getName());
//            json.put("thumbnail",objects.getCartProduct().getThumNailUrl());
//            json.put("price",objects.getCartProduct().getPrice());
//            json.put("totalItemPrice",objects.getCartProduct().getPrice()*objects.getAmount());
//            json.put("qty",objects.getAmount());
//
//            listItem.add(json);
//
//        }
//        if(listSub != null){
//            resp.put("data", listSub);
//            resp.put("success", true);
//            resp.put("error", null);
//        }
//        else {
//            resp.put("data", null);
//            resp.put("success", false);
//            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
//        }
//        return new ResponseEntity<>(resp, HttpStatus.OK);
//    }

    @GetMapping("getNewsLatter")
   public ResponseEntity<?> newsLatter(Pageable pageable) {

        JSONObject resp = new JSONObject();
        JSONObject listSub = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();
        JSONObject result = new JSONObject();
        Page<NewsLatter> listHotProduct = newsLatterService.getAllNewsLatter(pageable);
        for(NewsLatter objects : listHotProduct) {
            JSONObject json = new JSONObject();
            JSONObject listSubCategory = new JSONObject();
            JSONObject listMiniSubCategory = new JSONObject();
            JSONObject superMiniSubCategory = new JSONObject();
            JSONObject mainCategory = new JSONObject();
//            JSONObject json = new JSONObject();
            listSub.put("listItems",listItem);
            json.put("id", objects.getId());
            json.put("email", objects.getEmail());

//            json.put("users", pageable.getSortOr());
            listItem.add(json);


        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);

            resp.put("offset", pageable.getOffset());
            resp.put("hashNext", pageable.next());;
            resp.put("first", pageable.first());
            resp.put("hasPrevious", pageable.hasPrevious());
            resp.put("isPaged", pageable.isPaged());
            resp.put("unPaged", pageable.isUnpaged());
            resp.put("pageNumber", pageable.getPageNumber());
            resp.put("sort",
                    pageable.getSort());
            resp.put("sortOr",
                    pageable.getSortOr(Sort.unsorted()));
            resp.put("size", pageable.getPageSize());
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }

    @GetMapping("getUser")
    public ResponseEntity<?> getUser(Pageable pageable) {

        JSONObject resp = new JSONObject();
        JSONObject listSub = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();
        JSONObject result = new JSONObject();
        Page<User> listHotProduct = usersService.getAllUser(pageable);
        for(User objects : listHotProduct) {
            JSONObject json = new JSONObject();
            JSONObject listSubCategory = new JSONObject();
            JSONObject listMiniSubCategory = new JSONObject();
            JSONObject superMiniSubCategory = new JSONObject();
            JSONObject mainCategory = new JSONObject();
//            JSONObject json = new JSONObject();
            listSub.put("listUser",listItem);
            json.put("id", objects.getId());
            json.put("email", objects.getEmail());
            json.put("fullName", objects.getFullname());
            json.put("noTelp", objects.getUserRegister().getTelp());


//            json.put("users", pageable.getSortOr());
            listItem.add(json);


        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);

            resp.put("offset", pageable.getOffset());
            resp.put("hashNext", pageable.next());;
            resp.put("first", pageable.first());
            resp.put("hasPrevious", pageable.hasPrevious());
            resp.put("isPaged", pageable.isPaged());
            resp.put("unPaged", pageable.isUnpaged());
            resp.put("pageNumber", pageable.getPageNumber());
            resp.put("sort",
                    pageable.getSort());
            resp.put("sortOr",
                    pageable.getSortOr(Sort.unsorted()));
            resp.put("size", pageable.getPageSize());
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }

    @GetMapping("getAllTestimoni")
    public ResponseEntity<?> getTestimoni(Pageable pageable) {

        JSONObject resp = new JSONObject();
        JSONObject listSub = new JSONObject();

        List<JSONObject> listItem = new ArrayList<>();
        JSONObject result = new JSONObject();
        Page<Testimonial> listHotProduct = testimonialService.getAllTestimoni(pageable);
        for(Testimonial objects : listHotProduct) {
            JSONObject json = new JSONObject();
            JSONObject listSubCategory = new JSONObject();
            JSONObject listMiniSubCategory = new JSONObject();
            JSONObject superMiniSubCategory = new JSONObject();
            JSONObject mainCategory = new JSONObject();
//            JSONObject json = new JSONObject();
            listSub.put("listTestimoni",listItem);
            json.put("id", objects.getId());
            json.put("fullName", objects.getUser().getFullname());
            json.put("rating", objects.getRating());
            json.put("comment", objects.getComment());
            json.put("date", objects.getCreatedAt());


//            json.put("users", pageable.getSortOr());
            listItem.add(json);


        }
        if(listSub != null){
            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);

            resp.put("offset", pageable.getOffset());
            resp.put("hashNext", pageable.next());;
            resp.put("first", pageable.first());
            resp.put("hasPrevious", pageable.hasPrevious());
            resp.put("isPaged", pageable.isPaged());
            resp.put("unPaged", pageable.isUnpaged());
            resp.put("pageNumber", pageable.getPageNumber());
            resp.put("sort",
                    pageable.getSort());
            resp.put("sortOr",
                    pageable.getSortOr(Sort.unsorted()));
            resp.put("size", pageable.getPageSize());
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }

    @GetMapping("{id}/getTestimoniById")
    public ResponseEntity<?> getTestimoniById(@PathVariable (value = "id") Long id) {

        JSONObject resp = new JSONObject();
        List<JSONObject> listSub = new ArrayList<>();
        List<String> pictures = new ArrayList<>();
        List<String> couriers = new ArrayList<>();
        List<JSONObject> variants = new ArrayList<>();
        JSONObject result = new JSONObject();
        JSONObject picture = new JSONObject();
        JSONObject courier = new JSONObject();

        Optional<Testimonial> listHotProduct = testimonialService.getAllTestimonialById(id);
//        Product existingProduct = listHotProduct.get();
        if(listHotProduct != null){
            JSONObject listSubCategory = new JSONObject();
            JSONObject listMiniSubCategory = new JSONObject();
            JSONObject superMiniSubCategory = new JSONObject();
            JSONObject mainCategory = new JSONObject();
            JSONObject category = new JSONObject();
            JSONObject json = new JSONObject();
            JSONObject variant = new JSONObject();
            JSONObject variant1 = new JSONObject();

//
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
//            HashMap<String,Object> map = mapper.readValue( body, typeRef);

            Testimonial existingProduct = listHotProduct.get();
            json.put("id", existingProduct.getId());
            json.put("rating", existingProduct.getRating());
            json.put("comment", existingProduct.getComment());
            json.put("date", existingProduct.getCreatedAt());
            json.put("userId", existingProduct.getUser().getId());
            json.put("email", existingProduct.getUser().getFullname());
            json.put("fullName", existingProduct.getUser().getEmail());
            json.put("noHp", existingProduct.getUser().getUserRegister().getTelp());

            listSub.add(json);

            resp.put("data", listSub);
            resp.put("success", true);
            resp.put("error", null);
        }
        else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }

//    @RequestMapping(value = "listPageable", method = RequestMethod.GET)
//    Page<NewsLatter> employeesPageable(Pageable pageable) {
//        return newsLatterService.getAllNewsLatter(pageable);
//
//    }


    @GetMapping("getRefund")
    public ResponseEntity<?> refund() {

        JSONObject resp = new JSONObject();
        List<JSONObject> listSub = new ArrayList<>();
        JSONObject result = new JSONObject();
        List<Refund> listHotProduct = RefundService.getAllRefund();
        for(Refund objects : listHotProduct) {
            JSONObject json = new JSONObject();
            JSONObject listSubCategory = new JSONObject();
            JSONObject listMiniSubCategory = new JSONObject();
            JSONObject superMiniSubCategory = new JSONObject();
            JSONObject mainCategory = new JSONObject();
//            JSONObject json = new JSONObject();
            json.put("id", objects.getId());
            json.put("phone", objects.getPhone());
            json.put("reason", objects.getReason());
            json.put("fullName", objects.getFullName());
            json.put("email", objects.getEmail());
            json.put("place", objects.getPlace());
            json.put("noOrder", objects.getNoOrder());
            listSub.add(json);


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
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
    }
//    @PostMapping("addProduct")
//    public ResponseEntity<?> addProduct() {
//
//        JSONObject resp = new JSONObject();
//        List<JSONObject> listSub = new ArrayList<>();
//        JSONObject result = new JSONObject();
//        List<Product> listHotProduct = productService.getListProduct();
//        for(Product objects : listHotProduct) {
//            JSONObject json = new JSONObject();
//            JSONObject listSubCategory = new JSONObject();
//            JSONObject listMiniSubCategory = new JSONObject();
//            JSONObject superMiniSubCategory = new JSONObject();
//            JSONObject mainCategory = new JSONObject();
////            JSONObject json = new JSONObject();
//            json.put("id", objects.getId());
//            json.put("productName", objects.getName());
//            json.put("price", objects.getPrice());
//            json.put("thumbnail",objects.getThumNailUrl());
//            json.put("categoryName",objects.getMiniSubCategoryProperties().getCategoryname());
//
////            json.put("mainCategory",mainCategory);
////            mainCategory.put("id",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getId());
////            mainCategory.put("name",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getCategoryname());
////            mainCategory.put("description",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getMainCategoryProperties().getDescription());
////
////            mainCategory.put("subCategory", listSubCategory);
////            listSubCategory.put("id",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getId());
////            listSubCategory.put("name",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getSubCategoryProperties().getCategoryname());
////
////            mainCategory.put("secondSubCategory", listMiniSubCategory);
////            listMiniSubCategory.put("id",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getId());
////            listMiniSubCategory.put("name",objects.getMiniSubCategoryProperties().getMiniSubCategoryProperties().getCategoryname());
//
//
//            mainCategory.put("thirdSubCategory", superMiniSubCategory);
//            superMiniSubCategory.put("id",objects.getMiniSubCategoryProperties().getId());
//            superMiniSubCategory.put("name",objects.getMiniSubCategoryProperties().getCategoryname());
//            listSub.add(json);
//
//
//        }
//        if(listSub != null){
//            resp.put("data", listSub);
//            resp.put("success", true);
//            resp.put("error", null);
//        }
//        else {
//            resp.put("data", null);
//            resp.put("success", false);
//            resp.put("error",  new ErrorResponse("Product Doesnt Exist", 500));
//        }
//        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);
//    }

    @PostMapping("addBanner")
    public  ResponseEntity<?> insertAddToCartIten(@RequestBody BannerDescDto bannerDescDto, String imageUrl, String link){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();



        bannerService.insertBanner(bannerDescDto.getImageUrl(imageUrl),bannerDescDto.getLink(link));
        if(bannerService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Cart Doesnt Exist", 204));
        }
      return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @PostMapping("addProductVariant")
    public  ResponseEntity<?> insertVariant(@RequestBody VariantDto variantDto, Long productId, Long productVariantId){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();



        productService.insertVariantProduct(variantDto.getProductId(productId),variantDto.getProductVariantId(productVariantId));
        if(productService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Cart Doesnt Exist", 204));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @PostMapping("addProductRelated")
    public  ResponseEntity<?> insertRelated(@RequestBody ColorDto colorDto, Long productId, Long productRelatedId){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();



        productService.insertRelatedProduct(colorDto.getProductId(productId),colorDto.getProductRelatedId(productRelatedId));
        if(productService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Cart Doesnt Exist", 204));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @PostMapping("addProductColor")
    public  ResponseEntity<?> insertColor(@RequestBody ColorDto colorDto, Long productId, Long productRelatedId){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();



        productService.insertColorProduct(colorDto.getProductId(productId),colorDto.getProductRelatedId(productRelatedId));
        if(productService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Cart Doesnt Exist", 204));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @PostMapping("addProductPilihan")
    public  ResponseEntity<?> insertProductPilihan(@RequestBody ProductPilihanDto productPilihanDto, Long productId){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();



        productPilihanService.insertProductPilihan(productPilihanDto.getProductId(productId));
        if(productPilihanService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Cart Doesnt Exist", 204));
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @DeleteMapping("{id}/deleteProductPilihan")
    public  ResponseEntity<?> deleteProductPilihan(@PathVariable(value = "id") Long id){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();


        productPilihanService.deleteProductPilihan(id);
        if(productPilihanService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Banner Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }
    @PostMapping("{id}/updateProductPilihan")
    public  ResponseEntity<?> updateProductPilihan(@RequestBody ProductPilihanDto productPilihanDto, @PathVariable(value = "id") Long id, Long productId){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();


        productPilihanService.updateProductPilihan(productPilihanDto.getProductId(productId),id);
        if(productPilihanService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Banner Item Qty Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }

    @DeleteMapping("{id}/deleteBanner")
    public  ResponseEntity<?> deleteBanner(@PathVariable(value = "id") Long id){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();


        bannerService.deleteBanner(id);
        if(bannerService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Banner Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }

    @PostMapping("{id}/updateBanner")
    public  ResponseEntity<?> updateBanner(@RequestBody BannerDescDto bannerDescDto, @PathVariable(value = "id") Long id, String imageUrl, String link){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();


        bannerService.updateBanner(bannerDescDto.getImageUrl(imageUrl),bannerDescDto.getLink(link),id);
        if(bannerService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Banner Item Qty Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }

    @PostMapping("{id}/updateProduct")
    public  ResponseEntity<?> changeIsLive(@RequestBody ProductDto productDto, String productName, Long categoryId,Long discount, String overview, String description,String thumbnail,String hashTag, String color, String dimen,Long price, String productCode, Long quantity, String weight, String picture1,String picture2,String picture3,String picture4,String picture5,String picture6,String courier1, String courier2, String courier3, String courier4 ,@PathVariable(value = "id") Long id){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();

        productService.changeProduct(productDto.getProductName(productName),productDto.getCategoryId(categoryId),productDto.getDiscount(discount),productDto.getOverview(overview),productDto.getDescription(description),productDto.getThumbnail(thumbnail),productDto.getHashTag(hashTag),productDto.getColor(color),productDto.getDimen(dimen),productDto.getPrice(price),productDto.getProductCode(productCode),productDto.getQuantity(quantity),productDto.getWeight(weight),productDto.getPicture1(picture1),productDto.getPicture2(picture2),productDto.getPicture3(picture3),productDto.getPicture4(picture4),productDto.getPicture5(picture5),productDto.getPicture6(picture6),productDto.getCourier1(courier1),productDto.getCourier2(courier2),productDto.getCourier3(courier3),productDto.getCourier4(courier4),id);
        if(productService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Live Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }

    @PostMapping("addProduct")
    public  ResponseEntity<?> addProduct(@RequestBody ProductDto productDto,String productName, Long categoryId,Long discount, String overview, String description,String thumbnail,String hashTag, String color, String dimen,Long price, String productCode, Long quantity, String weight, String picture1,String picture2,String picture3,String picture4,String picture5,String picture6,String courier1, String courier2, String courier3, String courier4){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();


        productService.insertProduct(productDto.getProductName(productName),productDto.getCategoryId(categoryId),productDto.getDiscount(discount),productDto.getOverview(overview),productDto.getDescription(description),productDto.getThumbnail(thumbnail),productDto.getHashTag(hashTag),productDto.getColor(color),productDto.getDimen(dimen),productDto.getPrice(price),productDto.getProductCode(productCode),productDto.getQuantity(quantity),productDto.getWeight(weight),productDto.getPicture1(picture1),productDto.getPicture2(picture2),productDto.getPicture3(picture3),productDto.getPicture4(picture4),productDto.getPicture5(picture5),productDto.getPicture6(picture6),productDto.getCourier1(courier1),productDto.getCourier2(courier2),productDto.getCourier3(courier3),productDto.getCourier4(courier4));
        if(productService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Banner Item Qty Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }

    @DeleteMapping("{id}/deleteProduct")
    public  ResponseEntity<?> deleteCartItem(@PathVariable(value = "id") Long id){
        JSONObject resp = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject listArtis = new JSONObject();


        productService.deleteProduct(id);
        if(productService != null) {
            resp.put("success", true);
            resp.put("error", null);
        } else {
            resp.put("data", null);
            resp.put("success", false);
            resp.put("error",  new ErrorResponse("Wishlist Doesnt Exist", 204));
        }
        return new ResponseEntity<JSONObject>(resp, HttpStatus.OK);

    }

    @PostMapping("uploadImage")
    public ResponseEntity<?> uploadFile( @RequestPart(value = "file") MultipartFile file) {
//        Optional<User> user = userRepository.findById(userId);
//
//        if (!user.isPresent()) {
//            String msg = String.format("Upload not found with with id %s!", userId);
//            return new ResponseEntity(new ResponseError("ERR_NOT_FOUND", msg),
//                    HttpStatus.NOT_FOUND);
//        }

        String path = this.amazonClient.uploadFile(file);

        Media media = new Media(file.getOriginalFilename(),"lorem", path, file.getSize(),file.getContentType());

//        media.setUser(user.get());
        Media savedMedia = mediaRepository.save(media);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMedia.getId()).toUri();

        return ResponseEntity.created(location).body(new ResponseSuccess(location,"Clients successfully created!"));
    }
}
