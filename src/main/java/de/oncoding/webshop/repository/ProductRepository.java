package de.oncoding.webshop.repository;

import de.oncoding.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    List<ProductResponse> products = Arrays.asList(
            new ProductResponse(
                    "1",
                    "RTX 4060",
                    "asasdaftfufsf",
                    555550,
                    Arrays.asList("NVidia".toLowerCase(), "GPU".toLowerCase())
            ),
            new ProductResponse(
                    "2",
                    "RIntel Core I5 13600",
                    "asasdaftfufsf",
                    39080,
                    Arrays.asList("Intel".toLowerCase(), "CPU".toLowerCase())
            ),
            new ProductResponse(
                    "3",
                    "AMD Ryzen 6",
                    "asasdaftfufsf",
                    34590,
                    Arrays.asList("AMD".toLowerCase(), "CPU".toLowerCase())
            )
    );
    public List<ProductResponse>findAll(String tag){

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

}

