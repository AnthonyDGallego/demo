package com.mutant.demo.dto.dna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnaRegisterDto {
    private Integer id;
    private String dna[];
}
