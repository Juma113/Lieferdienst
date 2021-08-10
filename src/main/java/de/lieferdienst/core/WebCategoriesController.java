package de.lieferdienst.core;

import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.repository.storage.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebCategoriesController {

    final
    ProductRepository productRepository;

    private static final List<Product> products = new ArrayList<>();
    private static final List<Product> products2 = new ArrayList<>();

    public WebCategoriesController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/shawarmaCategory")
    public String shawarmaCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shawarmakategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "Shawarma & Döner");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(1);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(8);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/shawarmaCategory";
    }

    @GetMapping("/pizzaCategory")
    public String pizzaCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-pizzakategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "Pizza & Manakish");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(2);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(9);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/pizzaCategory";
    }
    @GetMapping("/grillCategory")
    public String grillCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-grillkategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "Grill & Steaks");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(3);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(10);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/grillCategory";
    }
    @GetMapping("/noodleCategory")
    public String noodleCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-nudelkategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "Nudel & pasta");
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(11);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/noodleCategory";
    }

    @GetMapping("/saladCategory")
    public String saladCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-salatkategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "fresher Salat");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(4);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(12);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/saladCategory";
    }
    @GetMapping("/vegetarianCategory")
    public String vegetarianCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-vegetarischkategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "Vegetarisch");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(5);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(13);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/vegetarianCategory";
    }

    @GetMapping("/drinksCategory")
    public String drinksCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-getränkekategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "Getränke");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(6);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(14);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/drinksCategory";
    }
    @GetMapping("/internationalCategory")
    public String InternationalCategory(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Internationalkategorie");
        model.addAttribute("breadcrumbTitle","Alle kategorien");
        model.addAttribute("pageTitle", "International");
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(7);
        for (Product product : productIterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        products2.clear();
        Iterable<Product> productIterable2 = productRepository.findProductByCategoryId(15);
        for (Product product2 : productIterable2) {
            products2.add(product2);
        }
        model.addAttribute("products2", products2);

        return "categories/internationalCategory";
    }
}
