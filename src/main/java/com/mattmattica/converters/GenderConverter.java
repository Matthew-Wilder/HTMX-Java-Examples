package com.mattmattica.converters;

import com.mattmattica.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return gender.getId();
    }

    @Override
    public Gender convertToEntityAttribute(Integer integer) {
        return Gender.ofId(integer);
    }
}
