package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@Table(name = "errors")
@NamedQuery(name = "Error.getAll", query = "SELECT c from Error c")
public class Error {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="code", length = 6, nullable = false)
    private java.lang.String code;

    
    public java.lang.String getCode() {
        return code;
    }

    public void setCode(java.lang.String code) {
        this.code = code;
    }

    @Column(name="message", length = 6, nullable = false)

    private java.lang.String message;

    
    public java.lang.String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

}
