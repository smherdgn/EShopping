package com.indbilisim.demo;

import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Bina billgileri tutulur dış kapı no anlamındadır
 *
 * @author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.11
 */
@Table(name = "X_LOCATION_BUILDING")
@Entity
public class Building {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    @Size(max = 255)
    private String description;

    /*
     * Bina Site Adı
     */
    @Column(nullable = true)
    @Size(max = 255)
    private String buildingName;


    /**
     * Kayıt yapan kullanıcı id
     */
    private String recordUserId;

    /**
     * Kayıt tarihi
     */
    @Temporal(TemporalType.DATE)
    private Date recordDate;

    private String localUUID;


    public String getBuildingName() {

        return buildingName;
    }

    public void setBuildingName(String buildingName) {

        this.buildingName = buildingName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }


    public String getRecordUserId() {

        return recordUserId;
    }

    public void setRecordUserId(String recordUserId) {

        this.recordUserId = recordUserId;
    }

    public Date getRecordDate() {

        return recordDate;
    }

    public void setRecordDate(Date recordDate) {

        this.recordDate = recordDate;
    }

    public String getLocalUUID() {

        return localUUID;
    }

    public void setLocalUUID(String localUUID) {

        this.localUUID = localUUID;
    }
}
