package com.mutant.demo.exceptions;

import com.mutant.demo.constants.ConstantUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String date;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, Date date, String message, String description) {
        this.statusCode = statusCode;
        this.date = new SimpleDateFormat(ConstantUtils.DATE_PATTERN).format(date);
        this.message = message;
        this.description = description;
    }

}
