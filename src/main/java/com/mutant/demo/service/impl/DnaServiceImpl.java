package com.mutant.demo.service.impl;

import com.mutant.demo.constants.ConstantUtils;
import com.mutant.demo.dao.DnaDao;
import com.mutant.demo.dto.dna.DnaDto;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.exceptions.custom.AccessDeniedException;
import com.mutant.demo.exceptions.custom.BadDataException;
import com.mutant.demo.model.Dna;
import com.mutant.demo.service.DnaService;
import com.mutant.demo.utils.MutantUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DnaServiceImpl implements DnaService {
    private DnaDao dnaDao;
    private ModelMapper modelMapper;
    private MutantUtils mutantUtils;

    @Transactional
    public Dna save(DnaDto dnaDto) {
        Dna dna = modelMapper.map(dnaDto, Dna.class);
        return dnaDao.save(dna);
    }

    @Override
    public Void Mutant(DnaRegisterDto dnaRegisterDto) {
        DnaDto dnaDto = new DnaDto();
        dnaDto.setDna(mutantUtils.dnaValidations(dnaRegisterDto));
        char matrix[][] = mutantUtils.ArrayStringToCharMatrix(dnaRegisterDto.getDna());
        dnaDto.setIsMutant(mutantUtils.isMutant(matrix));
        Dna dna = this.save(dnaDto);
        mutantUtils.NoMutant(dna);
        return null;
    }











}