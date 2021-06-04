package de.lieferdienst.controllers.orderManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.orderManagment.Payment;
import de.lieferdienst.repository.storage.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/payment")
public class PaymentController {


    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/default")
    ResponseEntity<List<Payment>> getAllPayments()
    {
        return ResponseEntity.ok(this.paymentRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Payment> findPaymentByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.paymentRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No Payment found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<Payment> addNewPayment(@RequestBody Payment payment)
    {
        return ResponseEntity.ok(this.paymentRepository.save(payment));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<Payment> updatePayment(@PathVariable Long id,@RequestBody Payment newPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setDatePaid(newPayment.getDatePaid());
                    payment.setPaymentMethod(newPayment.getPaymentMethod());
                    payment.setDetails(newPayment.getDetails());
                    return ResponseEntity.ok(this.paymentRepository.save(payment));
                })
                .orElseGet(() -> {
                    newPayment.setId(id);
                    return ResponseEntity.ok(this.paymentRepository.save(newPayment));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deletePayment(@PathVariable Long id) {
        this.paymentRepository.deleteById(id);
    }
}
