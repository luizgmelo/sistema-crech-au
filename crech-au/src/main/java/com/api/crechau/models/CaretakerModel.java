package com.api.crechau.models;

import com.api.crechau.dtos.CaretakerRecordDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_CARETAKER")
@Getter
@Setter
@NoArgsConstructor
public class CaretakerModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 9)
    private String gender;
    @Column(nullable = false, length = 11)
    private String phoneNumber;
    @Column(length = 100)
    private String photoPath;

    public CaretakerModel(CaretakerRecordDto dto){
        this.name = dto.name();
        this.gender = dto.gender();
        this.phoneNumber = dto.phoneNumber();
        this.photoPath = dto.photoPath();
    }

}
