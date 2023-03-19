package com.manecom.model.entity.publisher;

import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.author.Author;
import com.manecom.model.entity.base.AbstractEntity;
import com.manecom.model.entity.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = EntityConstantsUtil.PREFIX_TB + "publisher")
public class Publisher extends AbstractEntity {
    @Column(name = "publisher_name")
    private String publisherName;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publisher")
    private List<Book> books;

    @ManyToMany(mappedBy = "publishers")
    private Set<Author> authors = new HashSet<>();
}
