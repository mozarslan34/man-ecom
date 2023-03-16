package com.manecom.model.entity.customer;

import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.base.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @Column(name = "email",nullable = false, unique = true,length =80)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password",nullable = false, length =20)
    private String password;
}
