package com.example.demo.controller;


import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")// 리소스
public class TestController {
    @GetMapping("/testGetMapping")
    public String testController(){
        return "Hello World";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello ID : " + id;
     }

     @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello ID : " + id;
     }

     @GetMapping("testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello ID : " + testRequestBodyDTO.getId() + "Message : " + testRequestBodyDTO.getMessage();
     }

     @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponse(){
         List<String> list = new ArrayList<>();
         list.add("Hello ! I'm ResponseDTO");
         ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
         return response;
     }

     @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("Hello ! I'm ResponseEntity. And you got 400!" );
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status 를 400으로 설정.
         return ResponseEntity.badRequest().body(response);
     }
}
