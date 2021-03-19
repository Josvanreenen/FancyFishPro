package nl.hu.bep.example.fancyfishpro.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    @Getter @Setter private String username;
    @Getter @Setter private String password;
}
