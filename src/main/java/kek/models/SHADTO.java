package kek.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class SHADTO {

    private String message;

    public SHADTO(String message) {
        this.message = message;
    }
}
