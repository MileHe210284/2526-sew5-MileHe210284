package core.builder;

import core.Money;
import core.Product;
import core.Props;

import java.util.UUID;

public class SimpleProduct extends Product {

    private SimpleProduct(UUID id, String name, Money basePrice, Props props) {
        super(id, name, basePrice, props);
    }

    public static Builder builder(){
        return new Builder();
    }
    public static final class Builder{
        //builder als innere klasse weil der konstruktor private ist

        private UUID id = UUID.randomUUID();
        private String name;
        private Money price;
        private final Props props = new Props();

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder price(Money price){
            this.price = price;
            return this;
        }

        public Builder prop(String key, String val){
            this.props.put(key,val);
            return this;
        }

        public SimpleProduct build(){
            return new SimpleProduct(id, name, price, props);
        }
    }
}
