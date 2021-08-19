package de.lieferdienst.model.orderManagment;
import de.lieferdienst.model.errors.ShoppingCartEmptyException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.helper.BaseEntity;

import de.lieferdienst.model.userManagment.User;


import javax.persistence.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Class which represents Orders
 *
 * @author Lieferdienst Team
 */

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
    /**
     * Creates an Order Object without PaymentMethod.
     *
     * @param address      Address for shipping and billing.
     * @param shoppingcart List of watches, which shall be ordered
     * @author Lieferdienst
     */
    public Orders(Address address, ShoppingCart shoppingcart) throws ShoppingCartEmptyException {
        checkShoppingCartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.REGISTRIERT;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.calcTotal();
        this.payment = new Payment();
        logger.info("New Orders was created.");
    }

    /**
     * Creates an Order Object with PaymentMethod.
     *
     * @param address       Address for shipping and billing.
     * @param shoppingcart  List of watches, which shall be ordered
     * @param paymentMethod How the Order shall be paid.
     * @author Lieferdienst Team
     */
    public Orders(Address address, ShoppingCart shoppingcart, PaymentMethod paymentMethod) throws ShoppingCartEmptyException {
        checkShoppingCartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.REGISTRIERT;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.calcTotal();
        this.payment = new Payment(paymentMethod);
        logger.info("New Orders was created.");
    }

    /**
     * Creates an Order Object with User.
     *
     * @param address      Address for shipping and billing.
     * @param shoppingcart List of watches, which shall be ordered
     * @param user         Owner.
     * @author Liferdienst Team
     */
    public Orders(Address address, ShoppingCart shoppingcart, User user) throws ShoppingCartEmptyException {
        checkShoppingCartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.REGISTRIERT;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.calcTotal();
        this.payment = new Payment();
        this.user = user;
        logger.info("New Orders was created.");
    }
    /**
     * Constructor without Parameters for JPA.
     *
     * @author Lieferdienst Team
     */
    public Orders() {

    }
    /**
     * Checks if the Shoppingcart contains any Items: If not - throws ShoppingcartEmptyException
     *
     * @param shoppingcart Shoppingcart which will be checked
     * @author Lieferdienst Team
     */
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

    /**
     * Sets the ShippingStatus of an Order and if newShippingStatus is SENT, sets shipping date to current time
     *
     * @param newShippingStatus Desired new ShippingStatus
     * @author Lieferdienst Team
     */

    public void setShippingStatus(ShippingStatus newShippingStatus) {
        this.shippingStatus = newShippingStatus;
        logger.info("ShippingStatus was set to " + newShippingStatus + ".");
        if (newShippingStatus == ShippingStatus.GESENDET) {
            setShipped(new Date());
        }
    }
    /**
     * Calculates new total for Order including SHIPPINGFEE.
     *
     * @author Lieferdienst Team
     */
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

    /**
     * Checks whether or not this Order has a set datePaid in its Payment.
     *
     * @return true if datePaid in this Payment is set, else false
     * @author Lieferdienst Team
     */
    public boolean wasAlreadyPaid() {
        return this.payment.getDatePaid() != null;
    }

    public boolean pay() {
        boolean success = false;
        if (!wasAlreadyPaid()) {
            this.getPayment().setDatePaid(new Date());
            this.setShippingStatus(ShippingStatus.GESENDET);
            this.setOrderStatus(OrderStatus.BEENDET);
            success = true;
            logger.info("Orders was paid.");
        } else {
            logger.info("Orders is already paid...");
        }
        return success;
    }



}
/////////////////////////////////////End of class Orders/////////////////////////////////

