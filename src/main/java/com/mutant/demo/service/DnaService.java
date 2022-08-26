package com.mutant.demo.service;

import com.mutant.demo.dto.dna.DnaDto;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.model.Dna;

import java.util.Map;

public interface DnaService {
    Dna save(DnaDto dna);
    Map<String, Object> Mutant (DnaRegisterDto dnaRegisterDto);
}
