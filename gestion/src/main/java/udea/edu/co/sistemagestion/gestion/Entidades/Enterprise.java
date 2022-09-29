package udea.edu.co.sistemagestion.gestion.Entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "document")
    private String document;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    //@OneToMany(fetch = FetchType.LAZY)
    //private List<Employee> users;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private List<Transaction> transactions;
    @Column(name = "createdAt")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Enterprise(long id, String name, String document, String phone, String address, List<Transaction> transactions, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        //this.users = users;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Enterprise() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
