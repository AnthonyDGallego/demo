package com.mutant.demo.service.impl;

import com.mutant.demo.dao.DnaDao;
import com.mutant.demo.dto.dna.DnaCountDTO;
import com.mutant.demo.dto.dna.DnaDto;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.dto.dna.DnaStatsDto;
import com.mutant.demo.model.Dna;
import com.mutant.demo.utils.MutantUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DnaServiceImplTest {
    @Mock
    private DnaDao dnaDao;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private MutantUtils mutantUtils;
    private DnaServiceImpl dnaService;

    @BeforeEach
    void setUp() {
        dnaService = new DnaServiceImpl(dnaDao, modelMapper, mutantUtils);
    }

    @Test
    void testMutantWhenDataCorrect() {
        Dna dna = new Dna();
        dna.setDna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG");
        dna.setIsMutant(true);
        DnaRegisterDto dnaRegisterDto = new DnaRegisterDto();
        String dnaArray[] = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        dnaRegisterDto.setDna(dnaArray);
        when(dnaDao.save(any())).thenReturn(dna);
        dnaService.Mutant(dnaRegisterDto);
    }

    @Test
    void testStatsWhenDataCorrect() {
        DnaCountDTO dnaCountDTO = new DnaCountDTO() {
            @Override
            public Integer getMutants() {
                return 1;
            }

            @Override
            public Integer getTotal() {
                return 2;
            }
        };
        when(dnaDao.countMutants()).thenReturn(dnaCountDTO);
        dnaService.Stats();
        verify(dnaDao).countMutants();
    }
}
