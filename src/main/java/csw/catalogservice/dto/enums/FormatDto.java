package csw.catalogservice.dto.enums;

public enum FormatDto
{
    UNKNOW(0),
    HARDCOVER(1),
    PAPERBACK(2),
    POCKET(3),
    DIGITAL(4);

    public final int value;

    FormatDto(int id) {
        if (id < 0 || id > 4)
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