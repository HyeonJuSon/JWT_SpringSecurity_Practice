package com.cpdm.tester.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "authority")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id // pk
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}