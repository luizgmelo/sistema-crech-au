package com.api.crechau.models;

import com.api.crechau.dtos.PetRecordDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Table(name = "TB_PET")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class PetModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String breed;
    @Column(nullable = false, length = 3)
    private Double weight;
    @Column(nullable = false, length = 3)
    private Integer age;
    @Column(nullable = false)
    private Boolean isSociable;
    @ManyToOne
    @JoinColumn(
            name = "caretaker_id"
    )
    private CaretakerModel caretaker;

    public PetModel(PetRecordDto dto, CaretakerModel caretaker){
        this.name = dto.name();
        this.breed = dto.breed();
        this.weight = dto.weight();
        this.age = dto.age();
        this.isSociable = dto.isSociable();
        this.caretaker = caretaker;

    }

}
