package com.mutant.demo.dao;

import com.mutant.demo.dto.dna.DnaCountDTO;
import com.mutant.demo.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DnaDao extends JpaRepository<Dna,Integer> {
    @Query(value= "Select count(id) as total, (select count(id) as mutants from dna where is_mutant =true) as mutants " +
            "from dna",nativeQuery = true)
    public DnaCountDTO countMutants();
}
