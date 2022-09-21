package com.mavs.backend.controllers.solution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mavs.backend.helper.ResponseMessage;
import com.mavs.backend.services.solution.SolutionService;

@RestController
@CrossOrigin(origins = "*")
public class SolutionController {

    @Autowired
    public ResponseMessage responseMessage;

    @Autowired
    public SolutionService solutionService;

    
    @PostMapping("/add-solution")
    public ResponseEntity<?> addSolution(@RequestHeader("Authorization") String authorization,@RequestParam("title") String title,@RequestParam("description") String description,@RequestParam("coverimg") String coverimg,@RequestParam("solimg1") String solimg1,@RequestParam("solimg2") String solimg2,@RequestParam("solimg3") String solimg3,@RequestParam("productsused") List<String> productsused){
        try {
            return solutionService.addSolution(title, description, coverimg, solimg1, solimg2, solimg3, productsused, authorization);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);

        }
    }
}