package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * id
 * adi
 * fiyat
 * kayitTarihi
 * KategoriId
 */
@Getter
@Setter
@Entity
@Table(
        name = "URUN"
)
public class Product {

    @SequenceGenerator(name = "generator", sequenceName = "URUN_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(length = 50, name = "ADI")
    private String name;

    @Column(name = "FIYAT" , precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "KAYIT_TARIHI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI",
            foreignKey = @ForeignKey(name = "FK_URUN_KATEGORI_ID")
    )
    private Category category;
}
