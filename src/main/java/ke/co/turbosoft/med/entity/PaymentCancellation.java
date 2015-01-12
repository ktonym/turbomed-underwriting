package ke.co.turbosoft.med.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

/**
 * Created by ktonym on 1/11/15.
 */
@Entity
public class PaymentCancellation extends AbstractEntity{

    @OneToOne(optional=false)
    private Payment payment;
    @Convert(converter = LocalDatePersistenceConverter.class)
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String reason;

    public PaymentCancellation() {
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
