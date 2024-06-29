package de.oncoding.webshop.repository;

import de.oncoding.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    public List<ProductResponse>findAll(String tag){
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

        if (tag == null)
            return products;
        else {
            tag = tag.toLowerCase();
            List<ProductResponse> filtered = new ArrayList<>();

            for (ProductResponse p:products) {
                List<String> lowercaseTags = new ArrayList<>();
                for (String t:p.getTags()) {
                    lowercaseTags.add(t.toLowerCase());
                }
                if(lowercaseTags.contains(tag))
                    filtered.add(p);
            }
            return filtered;
        }
    }
}

