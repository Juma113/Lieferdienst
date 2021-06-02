package de.lieferdienst.model.userManagment;


import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.helper.BaseEntity;
import de.lieferdienst.model.orderManagment.Orders;
import de.lieferdienst.model.orderManagment.PaymentMethod;
import de.lieferdienst.model.orderManagment.ShoppingCart;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Entity
@NoArgsConstructor
//////////////////////////////////Start Class User/////////////////////////
public class User extends BaseEntity {

    private final transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @NotNull
    @Size(min = 2, max = 35, message = "Firstname must be 2-35 characters long.")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 35, message = "Lastname must be 2-35 characters long.")
    private String lastName;

    @Column(unique = true)
    @NotNull
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotNull
    @Size(min = 3, message = "Password must be 3-9 characters long.")
    private String password;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @NotNull
    @NotBlank(message = "Require")
    private String phone;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    ///////////////////////////Constructor//////////////////////////


    public User(String firstName, String lastName, String email, String password, LocalDate dob, String phone, Address address, ShoppingCart shoppingCart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.accountStatus = AccountStatus.USER;
        this.address = address;
        this.paymentMethod = null;
        this.shoppingCart = shoppingCart;
        this.orders = new ArrayList<>();
    }


    public static String get_SHA_256_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }


    public void setPassword(String newPasswordToHash) {
        this.password = newPasswordToHash;
    }

    public void changePassword(String newPasswordToHash) {
        this.password = get_SHA_256_SecurePassword(newPasswordToHash);
    }

    public boolean addOrder(Orders order) {
        orders.add(order);
        logger.info("Orders was added.");
        return true;
    }

    public boolean removeOrder(Orders order) {
        if (orders.contains(order)) {
            orders.remove(order);
            logger.info("Orders was successfully removed");
            return true;
        } else {
            logger.info("Orders was not found or does not exist.");
            return false;
        }
    }

    public String returnRolesForAuthority() {
        return "ROLE_" + accountStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
/////////////////////////////////////End of class User/////////////////////////////////
