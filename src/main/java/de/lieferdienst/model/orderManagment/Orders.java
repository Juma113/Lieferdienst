package de.lieferdienst.model.orderManagment;
import de.lieferdienst.model.errors.ShoppingCartEmptyException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.helper.BaseEntity;

import de.lieferdienst.model.userManagment.User;


import javax.persistence.*;
import java.util.Date;
import java.util.logging.Logger;

@Entity
public class Orders extends BaseEntity {

    private final transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Transient
    public static final double SHIPPINGFEE = 3.99;     // Constant Shipping cost.

    @Temporal(TemporalType.TIMESTAMP)
    private Date ordered;

    @Temporal(TemporalType.TIMESTAMP)
    private Date shipped;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address shippingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus;

    private double total;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ShoppingCart shoppingcart;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Payment payment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    ///////////////////////////Constructor//////////////////////////
    /*
       Creates an Orders Object without PaymentMethod.
    */
    public Orders(Address address, ShoppingCart shoppingcart) throws ShoppingCartEmptyException {
        checkShoppingCartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.REGISTERED;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.calcTotal();
        this.payment = new Payment();
        logger.info("New Orders was created.");
    }

    /*
       Creates an Orders Object with PaymentMethod.
    */
    public Orders(Address address, ShoppingCart shoppingcart, PaymentMethod paymentMethod) throws ShoppingCartEmptyException {
        checkShoppingCartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.REGISTERED;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.calcTotal();
        this.payment = new Payment(paymentMethod);
        logger.info("New Orders was created.");
    }

    /*
       Creates an Orders Object with User.
    */
    public Orders(Address address, ShoppingCart shoppingcart, User user) throws ShoppingCartEmptyException {
        checkShoppingCartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.REGISTERED;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.calcTotal();
        this.payment = new Payment();
        this.user = user;
        logger.info("New Orders was created.");
    }

    public Orders() {

    }

    private void checkShoppingCartEmpty(ShoppingCart shoppingcart) throws ShoppingCartEmptyException {
        if (shoppingcart.getItems().isEmpty()) {
            logger.warning("Shoppingcart in Orders cannot be empty");
            throw new ShoppingCartEmptyException("Shoppingcart in Orders cannot be empty");
        }
    }

    //////////////////////////////////Getter And Setter////////////////////////////


    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date date) {
        this.ordered = date;
        logger.info("OrderDate was set to " + date + ".");
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date date) {
        this.shipped = date;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatus newShippingStatus) {
        this.shippingStatus = newShippingStatus;
        logger.info("ShippingStatus was set to " + newShippingStatus + ".");
        if (newShippingStatus == ShippingStatus.SENT) {
            setShipped(new Date());
        }
    }

    public void calcTotal() {
        this.total = this.shoppingcart.getTotalPrice() + SHIPPINGFEE;
    }

    public double getTotal() {
        calcTotal();
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ShoppingCart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(ShoppingCart shoppingcart) {
        this.shoppingcart = shoppingcart;
        this.calcTotal();
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    /*
        Checks whether or not this Orders has a set datePaid in its Payment.
    */
    public boolean wasAlreadyPaid() {
        return this.payment.getDatePaid() != null;
    }

    public boolean pay() {
        boolean success = false;
        if (!wasAlreadyPaid()) {
            this.getPayment().setDatePaid(new Date());
            this.setShippingStatus(ShippingStatus.SENT);
            this.setOrderStatus(OrderStatus.FINISHED);
            success = true;
            logger.info("Orders was paid.");
        } else {
            logger.info("Orders is already paid...");
        }
        return success;
    }



}
/////////////////////////////////////End of class Orders/////////////////////////////////

