package com.mutant.demo.controller;

import com.mutant.demo.constants.Routes;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.service.DnaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(Routes.API_ROUTE+Routes.DNA_ROUTE)
@AllArgsConstructor
public class DnaController {
    private DnaService dnaService;
    @PostMapping(Routes.MUTANT_ROUTE)
    public Map<String, Object> validateMutant(@RequestBody DnaRegisterDto dnaRegisterDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(dnaService.Mutant(dnaRegisterDto)).getBody();
    }
}
