package com.bitreight.profitprint.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author bitreight
 */
@Data
public class ExecutorServiceItem {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double highPriorityCoefficient;
    private Double lowPriorityCoefficient;
}
