package com.example.demo.service;

import com.example.demo.model.Function;
import com.example.demo.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService {
   @Autowired
    private FunctionRepository functionRepository;
    public String saveFunction(Function function) {
        Function f=new Function(
                function.getName(),
                function.getCode(),
                function.getUrl()
        );

        functionRepository.save(f);
        return function.getName();
    }

    public List<Function> getFunctionDetails(Long FunctionId) {
        if (null != FunctionId) {
            return functionRepository.findAllById(FunctionId);
        } else {
            return functionRepository.findAll();
        }
    }

    public void deleteFunction(Long FunctionId) {
        functionRepository.deleteById(FunctionId);
    }


}
