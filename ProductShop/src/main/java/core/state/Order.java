package core.state;

import core.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Order {

    private final UUID id = UUID.randomUUID();
    private OrderState state = OrderState.NEW;
    private final List<Product> items = new ArrayList<>();

    public UUID id() { return id; }
    public OrderState state() { return state; }

    public List<Product> items() {
        return new ArrayList<>(items);
    }

    public void addItem(Product p) {
        items.add(Objects.requireNonNull(p));
        // we already know about requireNonNull
    }

    public void transition(OrderState target) {
        // TODO: write your state change code here
        // DISCUSSION: create a state diagram (together)
        // IllegalStateException if state change is not allowed
    }
}
