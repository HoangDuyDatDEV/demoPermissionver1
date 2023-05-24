package com.example.demo.controller;


import com.example.demo.model.Function;
import com.example.demo.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@CrossOrigin
@RequestMapping("api/v1/function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;
    @PostMapping("/save")
    public ResponseEntity createFunction(@RequestBody Function function) {
        functionService.saveFunction(function);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getFunctions", "/{functionId}"})
    public List<Function> getFunctions(@PathVariable(required = false) Long functionId) {
        return functionService.getFunctionDetails(functionId);
    }

    @DeleteMapping("/delete/{functionId}")
    public ResponseEntity removeFunction(@PathVariable Long functionId) {
        functionService.deleteFunction(functionId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
