package com.mutant.demo.service.impl;

import com.mutant.demo.dao.DnaDao;
import com.mutant.demo.dto.dna.DnaDto;
import com.mutant.demo.dto.dna.DnaRegisterDto;
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
        dnaDto.setIsMutant(true);
        dnaDto = dnaRegisterDtoToDnaDto(dnaRegisterDto);
        Dna dna = this.save(dnaDto);
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    DnaDto dnaRegisterDtoToDnaDto(DnaRegisterDto dnaRegisterDto){
        String dna[] = dnaRegisterDto.getDna();
        String dnaClear = new String();
        for (String i:dna) {
            dnaClear = dnaClear.concat(i.concat(","));
        }
        dnaClear= dnaClear.substring(0,dnaClear.length()-1);
        DnaDto dnaDto = new DnaDto();
        dnaDto.setDna(dnaClear);
        return dnaDto;
    }


}
