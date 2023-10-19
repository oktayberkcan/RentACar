package com.oktay.RentACar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailureException extends ProblemDetails {

    private Map<String, String> ObjectFailureException;
}

