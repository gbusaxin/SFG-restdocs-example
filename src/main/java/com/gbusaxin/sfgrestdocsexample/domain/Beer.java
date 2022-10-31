package com.gbusaxin.sfgrestdocsexample.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    private String beerName;
    private String beerStyle;

    @Column(unique = true)
    private Long upc;

    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;

    @Builder
    public Beer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String beerName, String beerStyle, Long upc, BigDecimal price, Integer minOnHand, Integer quantityToBrew) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.minOnHand = minOnHand;
        this.quantityToBrew = quantityToBrew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Objects.equals(id, beer.id) && Objects.equals(version, beer.version) && Objects.equals(createdDate, beer.createdDate) && Objects.equals(lastModifiedDate, beer.lastModifiedDate) && Objects.equals(beerName, beer.beerName) && Objects.equals(beerStyle, beer.beerStyle) && Objects.equals(upc, beer.upc) && Objects.equals(price, beer.price) && Objects.equals(minOnHand, beer.minOnHand) && Objects.equals(quantityToBrew, beer.quantityToBrew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createdDate, lastModifiedDate, beerName, beerStyle, upc, price, minOnHand, quantityToBrew);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", beerName='" + beerName + '\'' +
                ", beerStyle='" + beerStyle + '\'' +
                ", upc=" + upc +
                ", price=" + price +
                ", minOnHand=" + minOnHand +
                ", quantityToBrew=" + quantityToBrew +
                '}';
    }
}
