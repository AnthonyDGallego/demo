package com.mutant.demo.controller;

import com.mutant.demo.constants.Routes;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.dto.dna.DnaStatsDto;
import com.mutant.demo.service.DnaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.API_ROUTE+Routes.DNA_ROUTE)
@AllArgsConstructor
public class DnaController {
    private DnaService dnaService;
    @PostMapping(Routes.MUTANT_ROUTE)
    public Void validateMutant(@RequestBody DnaRegisterDto dnaRegisterDto){
        return ResponseEntity.status(HttpStatus.OK).body(dnaService.Mutant(dnaRegisterDto)).getBody();
    }
    @GetMapping(Routes.STATS_ROUTE)
    public DnaStatsDto stats(){
        return dnaService.Stats();
    }
}
