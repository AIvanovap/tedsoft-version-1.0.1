package net.apispark.webapi.representation;

import javax.persistence.*;

@Entity
@Table(name = "keywords")
@NamedQuery(name = "findId", query = "select c from Keywords c where c.keyword = :keyword ")
public class Keywords {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="keyword_id")
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="keyword")
    private java.lang.String keyword;

    public java.lang.String getKeyword() {
        return keyword;
    }

    public void setKeyword(java.lang.String keyword) {
        this.keyword = keyword;
    }

    @Column(name="binded_class")
    private int binded_class;
    
    public int getBinded_class() {
        return binded_class;
    }

    public void setBinded_class(int binded_class) {
        this.binded_class = binded_class;
    }

    public String toString(){
        return "id " + id + "keyword" + keyword + "binded_class" + binded_class;
    }
}
