package csw.catalogservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto
{
    public int id;

    public String name;

    public AuthorDto(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}