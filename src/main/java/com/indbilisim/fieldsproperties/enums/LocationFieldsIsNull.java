package com.indbilisim.fieldsproperties.enums;

/**
 * @Author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.3
 */
public enum LocationFieldsIsNull {

    TRUE("Evet"), FALSE("Hayır");

    private String displayName;

    private LocationFieldsIsNull(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
