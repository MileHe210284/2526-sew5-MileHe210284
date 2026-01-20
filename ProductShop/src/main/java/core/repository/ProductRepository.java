package core.repository;

import core.Product;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product p);
    Optional<Product> findById(java.util.UUID id);
    java.util.List<Product> findAll();
    java.util.List<Product> search(java.util.function.Predicate<Product> filter);
    boolean delete(java.util.UUID id);
}