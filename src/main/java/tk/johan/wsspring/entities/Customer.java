package tk.johan.wsspring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Casa on 17/05/2015.
 */
@Entity
public class Customer {
    private int customerId;
    private String customerPid;
    private String customerName;
    private Collection<Account> acounts;

    public Customer() {
    }

    public Customer(int customerId, String customerPid, String customerName) {
        this.customerId = customerId;
        this.customerPid = customerPid;
        this.customerName = customerName;
        this.acounts = new ArrayList<>();
    }

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_pid")
    public String getCustomerPid() {
        return customerPid;
    }

    public void setCustomerPid(String customerPid) {
        this.customerPid = customerPid;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (customerPid != null ? !customerPid.equals(customer.customerPid) : customer.customerPid != null)
            return false;
        if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (customerPid != null ? customerPid.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    public Collection<Account> getAcounts() {
        return acounts;
    }

    public void setAcounts(Collection<Account> acounts) {
        this.acounts = acounts;
    }
/*
    @Override
    public String toString(){
        return "[id="+customerId+"name"+customerName+"pid="+customerPid+"]";
    }*/
}
