package com.mutant.demo.dto.dna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnaStatsDto {
    private Integer count_mutant_dna;
    private Integer count_human_dna;
    private Float ratio;
}
