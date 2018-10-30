package lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@SuppressWarnings("deprecation")
public class DateTimeValue extends Value {
    private LocalDate date;
    private SimpleDateFormat simpleDateFormat;

    public DateTimeValue(LocalDate date) {
        this.date = date;
    }

    public DateTimeValue(String string) throws ParseException {
        date = LocalDate.parse(string);
    }

    @Override
    public String toString() {
        return date.toString();
    }

    @Override
    public Value add(Value value) {
        if (value instanceof DateTimeValue) {
            LocalDate valueDate = (LocalDate) value.getValue();
            return new DateTimeValue(date.plusYears(valueDate.getYear()).plusDays(valueDate.getDayOfMonth()).plusMonths(valueDate.getMonthValue()));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Value sub(Value value) {
        if (value instanceof DateTimeValue) {
            LocalDate valueDate = (LocalDate) value.getValue();
            return new DateTimeValue(date.minusYears(valueDate.getYear()).minusDays(valueDate.getDayOfMonth()).minusMonths(valueDate.getMonthValue()));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Value mul(Value value) {
        return new DateTimeValue(this.date);
    }

    @Override
    public Value div(Value value) {
        return new DateTimeValue(this.date);
    }

    @Override
    public Value pow(Value value) {
        return new DateTimeValue(this.date);
    }

    @Override
    public boolean eq(Value value) {
        if (value instanceof DateTimeValue) {
            return this.date.compareTo((LocalDate) value.getValue()) == 0;
        }
        return false;
    }

    @Override
    public boolean lte(Value value) {
        if (value instanceof DateTimeValue) {
            return this.date.compareTo((LocalDate) value.getValue()) < 0;
        }
        return false;
    }

    @Override
    public boolean gte(Value value) {
        if (value instanceof DateTimeValue) {
            return this.date.compareTo((LocalDate) value.getValue()) > 0;
        }
        return false;
    }

    @Override
    public boolean neq(Value value) {
        if (value instanceof DateTimeValue) {
            return this.date.compareTo((LocalDate) value.getValue()) != 0;
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof DateTimeValue) {
            DateTimeValue dateTimeValue = (DateTimeValue) other;
            return dateTimeValue.date.equals(date);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }

    @Override
    public Value clone() {
        return new DateTimeValue(date);
    }

    @Override
    public Value create(String s) {
        try {
            return new DateTimeValue(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public LocalDate getValue() {
        return this.date;
    }
}
