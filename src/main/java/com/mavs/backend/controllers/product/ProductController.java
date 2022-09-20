package com.mavs.backend.controllers.product;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mavs.backend.helper.ResponseMessage;
import com.mavs.backend.services.product.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    public ProductService productService;

    @Autowired
    public ResponseMessage responseMessage;
    
    @PostMapping("/add-product")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> addProduct(@RequestParam("modelNumber") String modelNumber,@RequestParam("productName") String productName,@RequestParam("productHighlights") String productHighlights,@RequestParam("productPrice") String productPrice,@RequestParam("offerPrice") String offerPrice,@RequestParam("productImage1") String productImage1,
    @RequestParam("productImage2")String productImage2,@RequestParam("productImage3") String productImage3,@RequestParam("productImage4") String productImage4,@RequestParam("productImage5") String productImage5,@RequestHeader("Authorization") String authorization){
        try{
            return productService.addProductDetail(modelNumber, productName, productHighlights, productPrice, offerPrice, productImage1, productImage2, productImage3, productImage4, productImage5, authorization);
        }
        catch(Exception e){
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }

    @GetMapping("/get-products")
    public ResponseEntity<?> getProducts(){
        try {
            return productService.getProducts();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }

    @PostMapping("/description/{modelNumber}")
    public ResponseEntity<?> addDescription(@RequestHeader("Authorization") String authorization,@PathVariable("modelNumber") String modelNumber,@RequestParam("title") String title, @RequestParam("description") String description,@RequestParam("image") String image){
        try {
            return productService.addDescription(authorization, modelNumber, title, description, image);
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }

}
