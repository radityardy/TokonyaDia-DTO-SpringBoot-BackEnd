package com.enigmacamp.tokonyadia.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor // Menghasilkan constructor yang menerima argumen
@NoArgsConstructor // constructor yang tidak menerima argumen
@Entity // entitas JPA yang tidak akan dipetaan ke database
@Builder
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
}

/*
* siapa yang beli
* produk apa yang di beli
* kapan dia beli
* jika produk lebih dari 1, produk mana saja yang di beli
 */
