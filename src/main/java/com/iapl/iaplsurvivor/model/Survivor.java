package com.iapl.iaplsurvivor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SURVIVOR_TBL")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @NotNull(message = "Please enter id")
    private String name;
    @NotNull(message = "Please enter id")
    private int age;
    @NotNull(message = "Please enter id")
    private String gender;
    @NotNull(message = "Please enter id")
    private String longitude;
    @NotNull(message = "Please enter id")
    private String latitude;
    //@Column(name="Price", columnDefinition="Decimal(10,2) default '100.00'")
    private boolean has_food=true;
    private boolean has_water=true;
    private boolean has_medication=true;
    private boolean has_ammunition=true;
    private boolean infected=false;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
