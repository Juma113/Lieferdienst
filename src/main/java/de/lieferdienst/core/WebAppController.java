package de.lieferdienst.core;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.errors.ShoppingCartEmptyException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.orderManagment.Orders;
import de.lieferdienst.model.orderManagment.Payment;
import de.lieferdienst.model.orderManagment.PaymentMethod;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.model.userManagment.AccountStatus;
import de.lieferdienst.model.userManagment.User;
import de.lieferdienst.repository.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Controller
public class WebAppController {

    final
    ProductRepository productRepository;

    final
    AddressRepository addressRepository;

    final
    UserRepository userRepository;

    final
    ShoppingCartRepository shoppingCartRepository;

    final
    OrdersRepository ordersRepository;

    final
    UserService userService;


    private final PasswordEncoder passwordEncoder;

    public WebAppController(ProductRepository productRepository, AddressRepository addressRepository, UserRepository userRepository, ShoppingCartRepository shoppingCartRepository, OrdersRepository ordersRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.ordersRepository = ordersRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Startseite");
        return "index";
    }

    @GetMapping("/accountSignup")
    public String accountSignup(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken)
        {
            model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Registrieren");
            model.addAttribute("newAddress", new Address());
            model.addAttribute("newUser", new User());
            return "/accountSignup";
        }
        return "redirect:/";
    }

    @PostMapping("/newUser")
    public String newUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult userBindingResult,
                          @Valid @ModelAttribute("newAddress") Address newAddress,BindingResult addressBindingResult)
    {
        if ( userBindingResult.hasErrors() || addressBindingResult.hasErrors()) {
            return "/accountSignup";
        }
        Optional<User> user = userRepository.findByEmail(newUser.getEmail());
        if(user.isPresent())
        {
            userBindingResult.rejectValue("email", "error.newUser","es existiert bereits ein Konto für diese E-Mail.");
            return "/accountSignup";
        }
        addressRepository.save(newAddress);
        newUser.setAddress(newAddress);
        newUser.setAccountStatus(AccountStatus.USER);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        ShoppingCart shoppingCart = new ShoppingCart();
        newUser.setShoppingCart(shoppingCartRepository.save(shoppingCart));
        userRepository.save(newUser);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String ShowLoginPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken)
        {
            model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Anmelden");
            return "/login";
        }
            return "redirect:/";
    }

    @GetMapping(value = "/loginSuccessfull")
    public String currentUserName() {
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String shoppingcart(Authentication authentication, Model model) {
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.isPresent()) {
            model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Einkaufswagen");
            ShoppingCart shoppingcart1 = user.get().getShoppingCart();
            shoppingcart1.calcTotalPrice();
            DecimalFormat format = new DecimalFormat("####0.##");
            String totalPrice = format.format(shoppingcart1.getTotalPrice()+Orders.SHIPPINGFEE);
            String prizeMoney = format.format(shoppingcart1.getTotalPrice());
            model.addAttribute("shoppingcart1", shoppingcart1);
            model.addAttribute("shippingFee", Orders.SHIPPINGFEE);
            model.addAttribute("TotalPrice",totalPrice);
            model.addAttribute("prizeMoney",prizeMoney);
            model.addAttribute("items", shoppingcart1.getItems());
            model.addAttribute("removeProductId", null);
        } else {
            return "redirect:/";
        }
        return "cart";
    }

    @PostMapping(path = "/addProduct/{id}")
    public String addWatchToShoppingCart(@PathVariable long id, Authentication authentication){
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        ShoppingCart shoppingcart = user.get().getShoppingCart();
        shoppingcart.addProduct(productRepository.findById(id).get());
        shoppingCartRepository.save(shoppingcart);

        return "redirect:/cart";
    }
    @PostMapping(path = "/deleteProduct/{id}")
    public String addNewOrder(@PathVariable long id, Authentication authentication){
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        ShoppingCart shoppingcart = user.get().getShoppingCart();
        shoppingcart.deleteProduct(productRepository.findById(id).get());
        shoppingCartRepository.save(shoppingcart);

        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Authentication authentication, Model model) {
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.isPresent()) {
            model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Kasse");
            if (!user.get().getShoppingCart().getItems().isEmpty()) {
                model.addAttribute("userId", user.get().getId());
                Address address = user.get().getAddress();
                model.addAttribute("address", address);
                ShoppingCart shoppingcart = user.get().getShoppingCart();
                shoppingcart.calcTotalPrice();
                DecimalFormat format = new DecimalFormat("####0.##");
                String totalPrice = format.format(shoppingcart.getTotalPrice()+Orders.SHIPPINGFEE);
                String prizeMoney = format.format(shoppingcart.getTotalPrice());
                model.addAttribute("shippingFee", Orders.SHIPPINGFEE);
                model.addAttribute("prizeMoney", prizeMoney);
                model.addAttribute("totalPrice", totalPrice);
                model.addAttribute("paymentMethods", new String[]{
                        PaymentMethod.PAYPAL.toString(), PaymentMethod.CREDITCARD.toString(),
                        PaymentMethod.DEBITCARD.toString()});

                Payment newPayment = new Payment();
                if (user.get().getPaymentMethod() != null) {
                    newPayment.setPaymentMethod(user.get().getPaymentMethod());
                }
                model.addAttribute("newPayment", newPayment);
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
        return "checkout";
    }

    @PostMapping(path = "/newOrder")
    public String addNewOrder(@ModelAttribute("newPayment") Payment newPayment,
                              Authentication authentication) throws ShoppingCartEmptyException {
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        ShoppingCart shoppingcart = user.get().getShoppingCart();
        shoppingcart.calcTotalPrice();    // TODO: Remove when DB is consistent/clear and filled by API's
        Address address = user.get().getAddress();

        Orders saveOrder = new Orders(address, shoppingcart, user.get());
        saveOrder.getPayment().setPaymentMethod(newPayment.getPaymentMethod());
        ordersRepository.save(saveOrder);
        user.get().setShoppingCart(shoppingCartRepository.save(new ShoppingCart()));

        if (user.get().getPaymentMethod() == null){
            user.get().setPaymentMethod(newPayment.getPaymentMethod());
        }
        userRepository.save(user.get());

        return "redirect:/checkoutComplete";
    }

    @GetMapping("/checkoutComplete")
    public String order(Authentication authentication, Model model) {
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Kasse komplett");
        if (user.isEmpty()) {
            return "redirect:/";
        }
        return "checkoutComplete";
    }

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        model.addAttribute("title", "Guten Appetit | Essen Lieferdienst-Ihr Konto");
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.isPresent()) {
            model.addAttribute("pageTitle","Profil info");
            model.addAttribute("id", user.get().getId());
            model.addAttribute("firstName", user.get().getFirstName());
            model.addAttribute("lastName", user.get().getLastName());
            model.addAttribute("email", user.get().getEmail());
            model.addAttribute("dob", user.get().getDob());
            model.addAttribute("phone", user.get().getPhone());
            model.addAttribute("street", user.get().getAddress().getStreet());
            model.addAttribute("houseNumber", user.get().getAddress().getHouseNumber());
            model.addAttribute("zip", user.get().getAddress().getZipCode());
            model.addAttribute("city", user.get().getAddress().getCity());
        } else {
            return "redirect:/";
        }
        return "profile";
    }

    @GetMapping("/updateUser")
    public String updateUser( Model model, RedirectAttributes redirectAttributes,Authentication authentication) {

        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmail(userEmail);
            model.addAttribute("updateUser",user);
            model.addAttribute("updateAddress", user.getAddress());
            model.addAttribute("pageTitle","Profil bearbeiten");
            return "updateUser";
        }catch (NotFounfException e)
        {
            redirectAttributes.addFlashAttribute("messege","");
            return "redirect:/profile";
        }
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("updateUser") User updateUser,@ModelAttribute("updateAddress") Address update,
                           RedirectAttributes redirectAttributes ,
                           Authentication authentication)
    {
        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmail(userEmail);
            if(user.getAddress().getCity().equals(update.getCity())
                    && user.getAddress().getZipCode().equals(update.getZipCode())
                    && user.getAddress().getStreet().equals(update.getStreet())
                    && user.getAddress().getHouseNumber().equals(update.getHouseNumber()))
            {

            }
            else{
                user.setAddress(update);
            }
            user.setDob(updateUser.getDob());
            user.setEmail(updateUser.getEmail());
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setPhone(updateUser.getPhone());
            userRepository.save(user);
            return "redirect:/profile";
        } catch (NotFounfException e)
        {
            redirectAttributes.addFlashAttribute("messege","");
            return "redirect:/";
        }
    }
    @GetMapping("/myOrders")
    public String myOrders(Model model, Authentication authentication) {
        model.addAttribute("title", "My Orders");
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        List<Orders> orders;
        DecimalFormat format = new DecimalFormat("####0.##");
        if (user.isPresent()) {
            orders = user.get().getOrders();
            if(orders != null)
            {
                orders.sort(Comparator.comparing(Orders::getOrdered).reversed());
            }
            model.addAttribute("firstName",user.get().getFirstName());
            model.addAttribute("lastName",user.get().getLastName());
            model.addAttribute("email",user.get().getEmail());
            model.addAttribute("orders", orders);
            model.addAttribute("format",format );
            assert orders != null;
            model.addAttribute("size",orders.size());
        } else {
            return "redirect:/";
        }
        return "accountOrders";
    }
}
