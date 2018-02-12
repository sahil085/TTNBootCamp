package Com.ttn.Domains;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("CATEGORY_ID"))
    private long id;
    @Column(nullable = false)
    private String categoryName;
    @ManyToOne
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
