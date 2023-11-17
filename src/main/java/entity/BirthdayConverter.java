package entity;


import javax.persistence.AttributeConverter;


import java.util.Optional;
import  java.sql.Date;

public class BirthdayConverter implements AttributeConverter<Birthday, Date > {

    @Override
    public Date convertToDatabaseColumn(Birthday birthday) {
        return Optional.ofNullable(birthday)
                .map(Birthday::getBirthday)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public Birthday convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
                .map(Date::toLocalDate)
                .map (Birthday::new)
                .orElse(null);
    }
}
