package com.codecool.model.dto;

import com.codecool.model.entity.Status;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStoryDTO {
    private Long id;

    @Size(min = 5, message = "Title length must be minimum 5 characters")
    @NotBlank(message = "You have to fill this field")
    private String title;

    @NotBlank(message = "You have to fill this field")
    private String story;

    @NotBlank(message = "You have to fill this field")
    private String acceptanceCriteria;

    @Range(min = 100, max = 1500)
    @NotNull(message = "Data must be between 100 and 1500")
    private Integer businessValue;

    @DecimalMin("0.5")
    @DecimalMax("40.0")
    @NotNull(message = "Data must be between 0.5 and 40.0")
    private Double estimation;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.IN_PROGRESS;

}
