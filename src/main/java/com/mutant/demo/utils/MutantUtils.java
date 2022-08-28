package com.mutant.demo.utils;

import com.mutant.demo.constants.ConstantUtils;
import com.mutant.demo.dto.dna.DnaRegisterDto;
import com.mutant.demo.exceptions.custom.AccessDeniedException;
import com.mutant.demo.exceptions.custom.BadDataException;
import com.mutant.demo.model.Dna;
import org.springframework.stereotype.Component;

@Component
public class MutantUtils {

    public static void noMutant(Dna dna) {
        if (dna.getIsMutant() == false) {
            throw new AccessDeniedException(ConstantUtils.ADN_NOT_MUTANT);
        }
    }

    public static Boolean isMutant(char[][] matrix, Integer size) {
        int located = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (located > 1) {
                    return true;
                }
                if (i >= 3) {
                    if (matrix[i][j] == matrix[i - 1][j] && matrix[i][j] == matrix[i - 2][j] && matrix[i][j] ==
                            matrix[i - 3][j]) {
                        located++;
                    }
                }
                if (j >= 3) {
                    if (matrix[i][j] == matrix[i][j - 1] && matrix[i][j] == matrix[i][j - 2] && matrix[i][j] ==
                            matrix[i][j - 3]) {
                        located++;
                    }
                }
                if (i >= 3 && j >= 3) {
                    if (matrix[i][j] == matrix[i - 1][j - 1] && matrix[i][j] == matrix[i - 2][j - 2] && matrix[i][j] ==
                            matrix[i - 3][j - 3]) {
                        located++;
                    }
                }
                if (i >= 3 && j < size - 3) {
                    if (matrix[i][j] == matrix[i - 1][j + 1] && matrix[i][j] == matrix[i - 2][j + 2] && matrix[i][j] ==
                            matrix[i - 3][j + 3]) {
                        located++;
                    }
                }
            }
        }
        if (located > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static char[][] arrayStringToCharMatrix(String[] dna) {
        char matrix[][] = new char[dna.length][dna.length];
        int initial = 0;
        for (String i : dna) {
            matrix[initial] = i.toCharArray();
            initial++;
        }
        return matrix;
    }

    public static String dnaValidations(DnaRegisterDto dnaRegisterDto) {
        String dna[] = dnaRegisterDto.getDna();
        String dnaClear = new String();
        Integer count = dna[0].length();
        for (String i : dna) {
            validateMaxSize(i);
            validateSquare(i, count);
            validateCharacters(i);
            dnaClear = dnaClear.concat(i.concat(","));
        }
        dnaClear = dnaClear.substring(0, dnaClear.length() - 1);
        return dnaClear;
    }

    public static Void validateCharacters(String dna) {
        for (int j = 0; j < dna.length(); j++) {
            char letter = dna.charAt(j);
            if (!(letter == 'A' || letter == 'T' || letter == 'C' || letter == 'G')) {
                throw new BadDataException(ConstantUtils.ADN_NOT_CORRECT);
            }
        }
        return null;
    }

    public static Void validateSquare(String dna, Integer count) {
        if (count != dna.length()) {
            throw new BadDataException(ConstantUtils.ADN_WRONG_SIZE);
        }
        return null;
    }

    public static Void validateMaxSize(String dna) {
        if (ConstantUtils.MAX_SQUARE_SIZE < dna.length()) {
            throw new BadDataException(ConstantUtils.ADN_MAX_SIZE_EXCEEDED);
        }
        return null;
    }
}
