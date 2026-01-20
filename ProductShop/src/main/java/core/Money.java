package core;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal amount, String currency) {

    public Money{ //construktor erweiterung
        //das was oben rein kommt steht da null
        Objects.requireNonNull(amount);
        Objects.requireNonNull(currency);
    }

    public static Money of(String val, String cur){
        //aus datenbanken kommen eher strings oder andere sachen. (wir wissen nicht ob numbers kommen)
        //damit wird money angelegt mit number auch wenn ein string daher kommt
        return new Money(new BigDecimal(val), cur);
    }

}
