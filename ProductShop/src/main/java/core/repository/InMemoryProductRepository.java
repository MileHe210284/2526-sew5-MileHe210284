package core.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;


public class InMemoryProductRepository implements ProductRepository {

    ConcurrentMap<UUID, Product> products = new ConcurrentHashMap<>();

    @Override
    public Product save(Product p) {
        products.put(p.id(), p);
        return p;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return products.get(id)==null? Optional.empty(): Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> findAll() {

        return products.values().stream().toList();
    }

    @Override
    public List<Product> search(Predicate<Product> filter) {
        List<Product> l = new ArrayList<>();
        for(Product i : products.values()){
            l.add(i);
        }
        return l;
    }

    @Override
    public boolean delete(UUID id) {
        if(products.get(id)!=null){
            products.remove(id);
            return true;
        }
        return false;
    }

}
