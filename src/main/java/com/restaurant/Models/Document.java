package com.restaurant.Models;

import com.restaurant.Models.BaseModel.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "documents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Document extends BaseModel {

    @Column
    private String name;

    @Column
    private String filePath;
}
