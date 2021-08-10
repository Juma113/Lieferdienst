package de.lieferdienst.core;

import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.repository.storage.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebRestaurantsController {

    final
    ProductRepository productRepository;

    private static final List<Product> products = new ArrayList<>();

    public WebRestaurantsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/shamShawarma")
    public String shamShawarma(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamShawarma");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "Shawarma");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(1);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamShawarma";
    }
    @GetMapping("/ademShawarma")
    public String ademShawarma(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademShawarma");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Shawarma & Döner");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(8);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademShawarma";
    }
    @GetMapping("/shamPizza")
    public String shamPizza(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamPizza");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "Pizza & Manakish");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(2);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamPizza";
    }
    @GetMapping("/ademPizza")
    public String ademPizza(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademPizza");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Pizza & Manakish");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(9);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademPizza";
    }
    @GetMapping("/shamGrill")
    public String shamGrill(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamGrill");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "Grill");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(3);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamGrill";
    }
    @GetMapping("/ademGrill")
    public String ademGrill(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademGrill");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Grill");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(10);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademGrill";
    }
    @GetMapping("/shamSalat")
    public String shamSalat(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamSalat");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "Salat");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(4);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamSalat";
    }
    @GetMapping("/ademNudel")
    public String ademNudel(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademNudel");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Nudel & pasta");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(11);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademNudel";
    }
    @GetMapping("/ademSalat")
    public String ademSalat(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademSalat");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Salat");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(12);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademSalat";
    }
    @GetMapping("/shamVegetarisch")
    public String shamVegetarisch(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamVegetarisch");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "Vegetarisch");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(5);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamVegetarisch";
    }
    @GetMapping("/ademVegetarisch")
    public String ademVegetarisch(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademVegetarisch");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Vegetarisch");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(13);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademVegetarisch";
    }

    @GetMapping("/shamGetränke")
    public String shamGetränke(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamGetränke");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "Getränke");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(6);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamGetränke";
    }
    @GetMapping("/ademGetränke")
    public String ademGetränke(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademGetränke");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "Getränke");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(14);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademGetränke";
    }
    @GetMapping("/shamInternational")
    public String shamInternational(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamInternational");
        model.addAttribute("breadcrumbTitle","Restauranten");
        model.addAttribute("RName", "sham-bistro");
        model.addAttribute("pageTitle", "International");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(7);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/sham/shamInternational";
    }
    @GetMapping("/ademInternational")
    public String ademInternational(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-ademInternational");
        model.addAttribute("breadcrumbTitle","Restaurants");
        model.addAttribute("RName", "Pizzeria Adem");
        model.addAttribute("pageTitle", "International");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(15);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "restaurants/adem/ademInternational";
    }

}
