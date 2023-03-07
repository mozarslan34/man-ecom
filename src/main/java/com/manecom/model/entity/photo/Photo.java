package com.manecom.model.entity.photo;

import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.base.AbstractEntity;
import com.manecom.model.entity.book.Book;
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
@Table(name = EntityConstantsUtil.PREFIX_TB + "photo")
public class Photo extends AbstractEntity {
    @Column(name = "url")
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

}
