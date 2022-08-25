package com.mutant.demo.dao;

import com.mutant.demo.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaDao extends JpaRepository<Dna,Integer> {
}
