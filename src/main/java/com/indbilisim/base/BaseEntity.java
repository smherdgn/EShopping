package com.indbilisim.base;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by semih on 05.07.2017.
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Database identifier of the entity, generated by hibernate on persisting of entity to the database. This
     * property will be null for newly created, not persisted objects. Use equals() for object equality
     * instead of == operator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Generated UUID of the entity. Used in equals() and hashCode().
     */
    @NotAudited
    private String uuid = UUID.randomUUID().toString();

    /**
     * Hibernate optimistic-locking field.
     * <p/>
     * WARNING: Do not mess with this field in application, this is for hibernate use ONLY
     */
    @Version
    private Long version;

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {

        return serialVersionUID;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(Object obj)
     */
    @Override
    public final boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        BaseEntity other = (BaseEntity) obj;
        if (id != null && other.id != null) {
            return id.equals(other.id);
        }

        return uuid.equals(other.uuid);
    }

    /**
     * @return the id
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {

        this.id = id;
    }


    /**
     * @return the uuid
     */
    public String getUuid() {

        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {

        this.uuid = uuid;
    }

    /**
     * @return the version
     */
    public Long getVersion() {

        return version;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode()) + (uuid == null ? 0 : uuid.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return getClass().getSimpleName() + " ( id=" + id + ")";
    }
}