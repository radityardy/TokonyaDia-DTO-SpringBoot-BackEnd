package com.enigmacamp.tokonyadia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor // Menghasilkan constructor yang menerima argumen
@NoArgsConstructor // constructor yang tidak menerima argumen
@Entity // entitas JPA yang tidak akan dipetaan ke database
@Table(name = "m_product") // table "m_product"
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false, columnDefinition = "BIGINT CHECK (price >= 0)")
    private Long price;
    @Column(name = "stock", nullable = false, columnDefinition = "INT CHECK (stock >= 0)")
    private Integer stock;

    @Override
    public String toString() {
        return "Product: " +
                "id= " + id +
                ", name= " + name +
                ", price= " + price +
                ", stock= " + stock;
    }
}
