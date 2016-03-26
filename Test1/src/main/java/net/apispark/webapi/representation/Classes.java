package net.apispark.webapi.representation;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "select c from Classes c"),
        @NamedQuery(name = "findName", query = "select c from Classes c where c.id = :id")
})

public class Classes {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="class_id" )
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="classname")
    private java.lang.String classname;
    
    public java.lang.String getClassname() {
        return classname;
    }

    public void setClassname(java.lang.String classname) {
        this.classname = classname;
    }

    public String toString(){
        return "Id" + getId() + "  Classname" + getClassname();
    }

}
