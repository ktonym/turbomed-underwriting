package ke.co.turbosoft.med.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

/**
 * Created by ktonym on 1/10/15.
 */
@Entity
public class BillVet extends AbstractEntity{

    @OneToOne(optional=false)
    private Bill bill;
    @Column(nullable = false)
    private LocalDate date;
    private String narration;
    @OneToOne(mappedBy = "billVet")
    private Payment payment;
    @Column(nullable = false)
    private VetStatus vetStatus;


    public BillVet() {
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public VetStatus getVetStatus() {
        return vetStatus;
    }

    public void setVetStatus(VetStatus vetStatus) {
        this.vetStatus = vetStatus;
    }
}
