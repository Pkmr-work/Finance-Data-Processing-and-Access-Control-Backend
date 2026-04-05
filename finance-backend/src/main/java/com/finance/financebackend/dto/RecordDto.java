package com.finance.financebackend.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class RecordDto {

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotBlank(message = "Type is required")
    private String type;

    private String category;

    private LocalDate date;

    private String note;

}