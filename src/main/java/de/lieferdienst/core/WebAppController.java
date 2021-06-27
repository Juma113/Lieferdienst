package de.lieferdienst.core;

import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.repository.storage.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class WebAppController {

    @Autowired
    ProductRepository productRepository;

    private String appMode;

    public WebAppController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("mode", appMode);
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Startseite");

        return "index";
    }

    private static List<Product> products = new ArrayList<Product>();

    @GetMapping("/shamShawarma")
    public String shamShawarma(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamShawarma");
        model.addAttribute("pageTitle", "Shawarma");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(1);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamShawarma";
    }
    @GetMapping("/shamPizza")
    public String shamPizza(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamPizza");
        model.addAttribute("pageTitle", "Pizza & Manakish");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(2);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamPizza";
    }
    @GetMapping("/shamGrill")
    public String shamGrill(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamGrill");
        model.addAttribute("pageTitle", "Grill");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(3);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamGrill";
    }
    @GetMapping("/shamSalat")
    public String shamSalat(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamSalat");
        model.addAttribute("pageTitle", "Salat");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(4);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamSalat";
    }
    @GetMapping("/shamVegetarisch")
    public String shamVegetarisch(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamVegetarisch");
        model.addAttribute("pageTitle", "Vegetarisch");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(5);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamVegetarisch";
    }

    @GetMapping("/shamGetränke")
    public String shamGetränke(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamGetränke");
        model.addAttribute("pageTitle", "Getränke");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(6);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamGetränke";
    }
    @GetMapping("/shamInternational")
    public String shamInternational(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-shamInternational");
        model.addAttribute("pageTitle", "International");
        model.addAttribute("products", products);
        products.clear();
        Iterable<Product> productIterable = productRepository.findProductByCategoryId(7);
        for (Product product : productIterable) {
            products.add(product);
        }

        return "shamInternational";
    }
}
