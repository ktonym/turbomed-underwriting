package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by akipkoech on 12/9/14.
 */
@Entity
public class CorpInvoice extends AbstractEntity{

    private String invoiceNo;
    @Convert(converter=LocalDatePersistenceConverter.class)
    private LocalDate invoiceDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anniv_id")
    private CorpAnniv anniv;

    // TODO consider the various types of invoices: new, addition, etc


    public CorpInvoice() {
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public CorpAnniv getAnniv() {
        return anniv;
    }

    public void setAnniv(CorpAnniv anniv) {
        this.anniv = anniv;
    }
}
