package core;

import java.util.Objects;
import java.util.UUID;

public abstract class Product {

    private final UUID id;
    private final String name;
    private final Money basePrice;
    private final Props props;

    protected Product(UUID id, String name, Money basePrice, Props props){
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.basePrice=Objects.requireNonNull(basePrice);
        this.props = (props== null)? new Props():props; //boolsche abfrage mit dem ? wenns erfüllt is dann das vorm : wenn ned dann das danach

    }
    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Money basePrice() {
        return basePrice;
    }

    public Props props() {
        return props;
    }

}
