package com.referyou.promotionservice.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @NotNull
    @Getter @Setter
    private String codeValue;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private LocalDateTime expirationDate;

    @Getter @Setter
    @ManyToOne
    public User ownedBy;

    @Getter @Setter
    @ManyToOne
    public Website from;
}
