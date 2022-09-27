package udea.edu.co.sistemagestion.gestion.Entidades;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Employees")
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column(name = "name",length = 100)
        private String name;
        @Column(name = "email",length = 100)
        private String email;
        @OneToOne
        @JoinColumn
        private Profile profile;

        @Column(name = "role",length = 30)
        @Enumerated(value = EnumType.STRING)
        private Enum_RoleName role;
        @ManyToOne
        @JoinColumn
        private Enterprise enterprise;
        //   @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
        //   private List<Transaction> transactions;

        @Column(name = "createdAt")
        private Date createdAt;
        @Column(name = "updatedAt")
        private Date updatedAt;

        public Employee(){}
        public Employee(long id, String name, String email, Profile profile, Enum_RoleName role, Enterprise enterprise, List<Transaction> transactions, Date createdAt, Date updatedAt) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.profile = profile;
                this.role = role;
                this.enterprise = enterprise;
                //   this.transactions = transactions;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Profile getProfile() {
                return profile;
        }

        public void setProfile(Profile profile) {
                this.profile = profile;
        }

        public Enum_RoleName getRole() {
                return role;
        }

        public void setRole(Enum_RoleName role) {
                this.role = role;
        }

        public Enterprise getEnterprise() {
                return enterprise;
        }

        public void setEnterprise(Enterprise enterprise) {
                this.enterprise = enterprise;
        }

        /*  public List<Transaction> getTransactions() {
                  return transactions;
          }

          public void setTransactions(List<Transaction> transactions) {
                  this.transactions = transactions;
          }
  */
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