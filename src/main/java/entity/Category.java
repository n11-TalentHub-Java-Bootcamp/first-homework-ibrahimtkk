package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * id
 * adi
 * kirilim
 * ustKategoriId
 */
@Getter
@Setter
@Entity
@Table(name = "KATEGORI")
public class Category {

    @SequenceGenerator(name = "generator", sequenceName = "KATEGORI_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ADI", nullable = false, length = 50)
    private String adi;

    @Column(name = "KIRILIM")
    private Long kirilim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UST_KATEGORI_ID")
    private Category ustCategory;

}
