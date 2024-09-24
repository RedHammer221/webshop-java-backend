package de.oncoding.webshop.repository;

import de.oncoding.webshop.model.ProductCreateRequest;
import de.oncoding.webshop.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductRepository {


    List<ProductResponse> products = new ArrayList<>();

    public ProductRepository() {
        products.add(
                new ProductResponse(
                        UUID.randomUUID().toString(),
                        "RTX 4060",
                        "asasdaftfufsf",
                        555550,
                        Arrays.asList("NVidia".toLowerCase(), "GPU".toLowerCase())
                ));
        products.add(
                new ProductResponse(
                        UUID.randomUUID().toString(),
                        "RIntel Core I5 13600",
                        "asasdaftfufsf",
                        39080,
                        Arrays.asList("Intel".toLowerCase(), "CPU".toLowerCase())
                ));
        products.add(
                new ProductResponse(
                        UUID.randomUUID().toString(),
                        "AMD Ryzen 6",
                        "asasdaftfufsf",
                        34590,
                        Arrays.asList("AMD".toLowerCase(), "CPU".toLowerCase())
                ));
    }

    public List<ProductResponse> findAll(String tag) {

        if (tag == null)
            return products;
        else {
            String lowerCaseTag = tag.toLowerCase();

            return products.stream()
                    .filter(p -> lowercaseTags(p).contains(lowerCaseTag))
                    .collect(Collectors.toList());
        }
    }

    private List<String> lowercaseTags(ProductResponse p) {

        return p.getTags().stream()
                .map(tag -> tag.toLowerCase()).
                collect(Collectors.toList());
    }

    public Optional<ProductResponse> findById(String id) {
        Optional<ProductResponse> product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return product;
    }

    public void deleteById(String id) {
        this.products = products.stream()
                .filter(p -> !p.getId().equals(id))
                .collect(Collectors.toList());
    }

    public ProductResponse save(ProductResponse response) {
        products.add(response);
        return response;
    }
}

