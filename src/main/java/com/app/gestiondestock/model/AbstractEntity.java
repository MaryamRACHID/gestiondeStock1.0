/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Sciences
 */

package com.app.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@Data // Shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor
@MappedSuperclass // Designates a class whose mapping information is applied to the entities that inherit from it. A mapped superclass has no separate table defined for it.
@EntityListeners(AuditingEntityListener.class) //Specifies the callback listener classes to be used for an entity or mapped superclass. This annotation may be applied to an entity class or mapped superclass.
//AuditingEntityListener : JPA entity listener to capture auditing information on persiting and updating entities.

/*Serialization in Java allows us to convert an Object to stream
that we can send over the network or save it as file or store in DB for later usage.
------------------------------------------------------------------------------------
A class which needs to be persisted to a file or other media has to implement Serializable interface,
so that JVM can allow the class object to be serialized. Why Object class is not serialized then none
of the classes need to implement the interface, after all JVM serializes the class
only when I use ObjectOutputStream which means the control is still in my hands to let the JVM to serialize.

The reason why Object class is not serializable by default in the fact that the class version
is the major issue.Therefore each class that is interested in serialization has to be marked
as Serializable explicitly and provide a version number serialVersionUID.

If serialVersionUID is not provided then we get unexpected results while deserialzing the object,
that is why JVM throws InvalidClassException if serialVersionUID doesn't match.
Therefore every class has to implement Serializable interface and provide serialVersionUID
to make sure the Class presented at the both ends is identical.
------------------------------------------------------------------------------------
*/
public class AbstractEntity implements Serializable {

    @Id //The @Id annotation specifies the primary key of an entity.
    @GeneratedValue //provides for the specification of generation strategies for the values of primary keys.
    private Integer id;

    @CreatedDate //Declares a field as the one representing the date the entity containing the field was created.
    @Column(name = "creationDate", nullable = false) //
    @JsonIgnore //@JsonIgnore is used to ignore the logical property used in serialization and deserialization.
    private Instant creationDate;

    @LastModifiedDate //Declares a field as the one representing the date the entity containing the field was recently modified.
    @Column(name = "lastModifiedDate")
    @JsonIgnore
    private Instant lastModifiedDate;
}
