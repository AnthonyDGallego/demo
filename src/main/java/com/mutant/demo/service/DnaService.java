package com.mutant.demo.service;

import com.mutant.demo.dto.dna.DnaDto;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.dto.dna.DnaStatsDto;
import com.mutant.demo.model.Dna;

public interface DnaService {
    Dna save(DnaDto dna);

    Void Mutant(DnaRegisterDto dnaRegisterDto);

    DnaStatsDto Stats();
}
