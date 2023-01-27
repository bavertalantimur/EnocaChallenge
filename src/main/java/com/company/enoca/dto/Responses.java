package com.company.enoca.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Responses {
    private int statusCode;
    private String status;
    private String message;
}
