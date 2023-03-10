package com.manecom.model.entity.adress;
import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.base.AbstractEntity;
import com.manecom.model.entity.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
@Table(name = EntityConstantsUtil.PREFIX_TB + "adress")
public class Adress extends AbstractEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "adress_line")
    private String adressLine;

    @Column(name = "post_code")
    private Long postCode;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "adress")
    private Customer customer;


}
