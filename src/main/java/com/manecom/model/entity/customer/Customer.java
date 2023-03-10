package com.manecom.model.entity.customer;

import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.adress.Adress;
import com.manecom.model.entity.base.AbstractEntity;
import com.manecom.model.entity.superUser.SuperUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = EntityConstantsUtil.PREFIX_TB + "customer")
public class Customer extends AbstractEntity {

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_surname")
    private String customerSurname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

    @OneToOne(mappedBy = "customer")
    private SuperUser superUser;
}
