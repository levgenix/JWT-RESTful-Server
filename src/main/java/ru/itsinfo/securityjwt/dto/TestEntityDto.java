package ru.itsinfo.securityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class TestEntityDto extends AbstractDto {

    private String email;
    private String name;
}
