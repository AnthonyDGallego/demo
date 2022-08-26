package com.mutant.demo.service.impl;

import com.mutant.demo.constants.ConstantUtils;
import com.mutant.demo.dao.DnaDao;
import com.mutant.demo.dto.dna.DnaDto;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.exceptions.custom.BadDataException;
import com.mutant.demo.model.Dna;
import com.mutant.demo.service.DnaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class DnaServiceImpl implements DnaService {
    private DnaDao dnaDao;
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public Dna save(DnaDto dnaDto){
        Dna dna = modelMapper.map(dnaDto,Dna.class);
        return dnaDao.save(dna);
    }
    @Override
    @Transactional
    public Map<String, Object> Mutant (DnaRegisterDto dnaRegisterDto){
        DnaDto dnaDto = new DnaDto();
        dnaDto.setDna(dnaValidations(dnaRegisterDto));
        dnaDto.setIsMutant(true);
        Dna dna = this.save(dnaDto);
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    String dnaValidations(DnaRegisterDto dnaRegisterDto){
        String dna[] = dnaRegisterDto.getDna();
        String dnaClear = new String();
        Integer count=dna[0].length();
        for (String i:dna) {
            validateMaxSize(i);
            validateSquare(i,count);
            validateCharacters(i);
            dnaClear = dnaClear.concat(i.concat(","));
        }
        dnaClear= dnaClear.substring(0,dnaClear.length()-1);
        return dnaClear;
    }
    Void validateCharacters(String dna){
        for (int j=0;j<dna.length();j++) {
            char letter = dna.charAt(j);
            if(!(letter=='A'||letter=='T'||letter=='C'||letter=='G')){
                throw new BadDataException(ConstantUtils.ADN_NOT_CORRECT);
            }
        }
        return null;
    }
    Void validateSquare(String dna, Integer count){
        if(count!=dna.length()){
            throw new BadDataException(ConstantUtils.ADN_WRONG_SIZE);
        }
        return null;
    }
    Void validateMaxSize(String dna){
        if(ConstantUtils.MAX_SQUARE_SIZE<dna.length()){
            throw new BadDataException(ConstantUtils.ADN_MAX_SIZE_EXCEEDED);
        }
        return null;
    }
}
