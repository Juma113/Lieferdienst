package de.lieferdienst.model.orderManagment;

import de.lieferdienst.model.helper.BaseEntity;


import javax.persistence.*;
import java.util.Date;
import java.util.logging.Logger;
/**
 * Class which represents a Payment
 * @author Lieferdienst Team
 */
@Entity
public class Payment extends BaseEntity {

   // private final transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Temporal(TemporalType.TIMESTAMP )
    private Date datePaid;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String details;

    /*
    Creates an empty Payment-Object
    */
    public Payment()
    {
        this.datePaid = null;
        this.paymentMethod = null;
        this.details = null;
    }

    /**
     * Creates Payment-Object with given Payment Method. Can be used when default Payment Method of an Account is set.
     * @param paymentMethod Payment Method. For example PayPal or Transfer.
     * @author Lieferdienst Team
     */
    public Payment(PaymentMethod paymentMethod) {
        this.datePaid = null;
        this.paymentMethod = paymentMethod;
        this.details = null;
    }

    /**
     * @param paymentMethod Payment Method. For example PayPal or Transfer.
     * @param details       Details for Payment. Usage or extra information.
     * @author Lieferdienst Team
     */
    public Payment(PaymentMethod paymentMethod, String details) {
        this.datePaid = null;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }


    /**
     * Creates a completed/paid Payment.
     * @param paymentMethod Payment Method. For example PayPal or Transfer.
     * @param details       Details for Payment. Usage or extra information.
     * @param paid          Date at which Payment was executed.
     * @author Lieferdienst Team
     */
    public Payment(Date paid, PaymentMethod paymentMethod, String details) {
        this.datePaid = paid;
        this.paymentMethod = paymentMethod;
        this.details = details;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
