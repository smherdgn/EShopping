package com.indbilisim.fieldsproperties.enums;

/**
 * @author aakbulak <alper.akbulak@indbilisim.com.tr>
 * @since 0.0.11
 *        20.10.2016
 *        LocationFieldsPropertiesType enum
 *        LocationFieldsProperties'de type olarak kullanılacaktır.
 */
public enum LocationFieldsPropertiesType {

    STRING("Metin"), NUMBER("Sayı"), DATE("Tarih"), SELECT("Çoktan Seçmeli");

    private String displayName;

    private LocationFieldsPropertiesType(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
