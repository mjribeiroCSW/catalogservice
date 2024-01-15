package csw.catalogservice.dto.enums;

public enum BookAvailabilityDto {
    TO_BE_LAUNCHED(0),
    ON_PRE_ORDER(1),
    ON_ORDER(2),
    AVAILABLE(3);

    public final int value;

    BookAvailabilityDto(int id) {
        if (id < 0 || id > 3)
        {
            value = 0;
        }
        else
        {
            value = id;
        }
    }

    public int getValue() { return value; }
}