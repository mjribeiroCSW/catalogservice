package csw.catalogservice.dto.enums;

public enum GenreDto
{
    UNKNOW(0),
    ACTION(1),
    DRAMA(2),
    COMEDY(3);

    public final int value;

    GenreDto(int id) {
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