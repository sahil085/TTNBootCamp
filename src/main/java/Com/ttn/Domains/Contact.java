package Com.ttn.Domains;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;


@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = ("CONTACT_ID"))
    long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String emailId;
    @Column(nullable = false)
    long phoneNo;
    @Column(nullable = false)
    String company;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST,
            })
    @JoinTable(name = ("cont_cat"),joinColumns = {@JoinColumn(name = ("CONTACT_ID"))},inverseJoinColumns = {@JoinColumn(name = ("CATEGORY_ID"))} )
   public List<Category> categories=new ArrayList<Category>();
    @ManyToOne
    public User createdBy;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
