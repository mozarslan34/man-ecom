package com.manecom.model.entity.author;
import com.manecom.constant.EntityConstantsUtil;
import com.manecom.model.entity.base.AbstractEntity;
import com.manecom.model.entity.book.Book;
import com.manecom.model.entity.publisher.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = EntityConstantsUtil.PREFIX_TB + "author" )
public class Author extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "institute")
    private String institute;

    @Column(name = "author_description")
    private String authorDescription;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "authors_books",
            joinColumns = {
                    @JoinColumn(name = "author_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id")
            }
    )
    Set<Book> projects = new HashSet<>();


    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "authors_publishers",
            joinColumns = {
                    @JoinColumn(name = "author_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "publisher_id")
            }
    )
    Set<Publisher> publishers = new HashSet<>();


}
