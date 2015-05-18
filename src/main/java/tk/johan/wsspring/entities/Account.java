package tk.johan.wsspring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Casa on 17/05/2015.
 */
@Entity
public class Account {
    private double incomes;
    private double outcomes;
    private Date creationDate;
    private byte status;
    private int accountNumber;
    private Customer owner;

    @Basic
    @Column(name = "incomes")
    public double getIncomes() {
        return incomes;
    }

    public void setIncomes(double incomes) {
        this.incomes = incomes;
    }

    @Basic
    @Column(name = "outcomes")
    public double getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(double outcomes) {
        this.outcomes = outcomes;
    }

    @Basic
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Id
    @Column(name = "account_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.incomes, incomes) != 0) return false;
        if (Double.compare(account.outcomes, outcomes) != 0) return false;
        if (status != account.status) return false;
        if (accountNumber != account.accountNumber) return false;
        if (creationDate != null ? !creationDate.equals(account.creationDate) : account.creationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(incomes);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(outcomes);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + accountNumber;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "customer_id", nullable = false)
    @JsonBackReference
    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
