package com.mutant.demo.utils;

import com.mutant.demo.dao.DnaDao;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.exceptions.custom.AccessDeniedException;
import com.mutant.demo.exceptions.custom.BadDataException;
import com.mutant.demo.model.Dna;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MutantUtilsTest {
    @Mock
    private DnaDao dnaDao;

    @Test
    void testNoMutantShouldThrowException() {
        Dna dna = new Dna();
        dna.setDna("ATGCGA");
        dna.setIsMutant(false);
        assertThrows(AccessDeniedException.class, () -> {
            MutantUtils.noMutant(dna);
        });
    }

    @Test
    void testIsMutantShouldReturnFalse() {
        char[][] matrix = {{'A', 'T', 'G', 'C', 'G'}, {'T', 'A', 'A', 'C', 'A'}, {'G', 'T', 'G', 'G', 'A'}, {'C', 'A',
                'G', 'C', 'T'}, {'A', 'C', 'G', 'C', 'G'}};
        Boolean isMutant = MutantUtils.isMutant(matrix, 5);
        assert (!isMutant);
    }

    @Test
    void testIsMutantShouldReturnTrueWhenFoundHorizontalAndVertical() {
        char[][] matrix = {{'A', 'A', 'A', 'A'}, {'A', 'C', 'G', 'T'}, {'A', 'C', 'G', 'T'}, {'A', 'C', 'G', 'T'}};
        assert (MutantUtils.isMutant(matrix, 4));
    }

    @Test
    void testIsMutantShouldReturnTrueWhenFoundDiagonals() {
        char[][] matrix = {{'A', 'T', 'G', 'A'}, {'C', 'A', 'A', 'T'}, {'G', 'A', 'A', 'T'}, {'A', 'C', 'G', 'A'}};
        assert (MutantUtils.isMutant(matrix, 4));
    }

    @Test
    void testArrayStringToCharMatrixWhenDataCorrect() {
        String[] data = {"ATCG", "ATCG", "ATCG", "ATCG"};
        char[][] matrixDemo = {{'A', 'T', 'C', 'G'}, {'A', 'A', 'C', 'G'}, {'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}};
        char[][] matrix = MutantUtils.arrayStringToCharMatrix(data);
        assert (matrix.length == matrixDemo.length);
    }

    @Test
    void testDnaValidationsWhenDataCorrect() {
        DnaRegisterDto dnaRegisterDto = new DnaRegisterDto();
        String[] dna = {"ATCG", "ATCG", "ATCG", "ATCG"};
        dnaRegisterDto.setDna(dna);
        String dnaValidated = "ATCG,ATCG,ATCG,ATCG";
        assert (MutantUtils.dnaValidations(dnaRegisterDto).equals(dnaValidated));
    }

    @Test
    void testValidateCharactersThrowExceptionWhenDataIncorrect() {
        String dna = "ATCG,ATCG,ATCG,ATCG";
        assertThrows(BadDataException.class, () -> {
            MutantUtils.validateCharacters(dna);
        });
    }

    @Test
    void testValidateSquareThrowExceptionWhenDataIncorrect() {
        String dna = "ATCG,ATCG,ATCG,ATCGG";
        assertThrows(BadDataException.class, () -> {
            MutantUtils.validateSquare(dna, 4);
        });
    }

    @Test
    void testValidateMaxSizeThrowExceptionWhenDataIncorrect() {
        String dna = "ATCGATCGATCGATCGGGGG";
        assertThrows(BadDataException.class, () -> {
            MutantUtils.validateMaxSize(dna);
        });
    }
}
