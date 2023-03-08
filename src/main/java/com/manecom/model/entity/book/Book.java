package com.manecom.model.entity.book;

import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.base.AbstractEntity;
import com.manecom.model.entity.enums.Availability;
import com.manecom.model.entity.enums.CoverType;
import com.manecom.model.entity.enums.RentStatus;
import com.manecom.model.entity.photo.Photo;
import com.manecom.model.entity.publisher.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = EntityConstantsUtil.PREFIX_TB + "book")
public class Book extends AbstractEntity {
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "sub_name")
    private String subName;
    @Column(name = "ısbn")
    private String ısbn;
    @Column(name = "number_of_pages")
    private Long numberOfPages;
    @Column(name = "dimensions")
    private double dimensions;
    @Column(name = "language")
    private String language;
    @Column(name = "print_count")
    private Long printCount;
    @Column(name = "year_of_printing")
    private LocalDate yearOfPrinting;
    @Enumerated(EnumType.STRING)
    private CoverType coverType;
    @Column(name = "book_description")
    private String bookDescription;
    @Enumerated(EnumType.STRING)
    private RentStatus rentStatus;
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @OneToOne(mappedBy = "book")
    private Photo photo;
}
