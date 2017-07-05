package com.indbilisim.fieldsproperties.enums;

/**
 * @Author Semih Erdoğan <semih.erdogan@indbilisim.com.tr>
 * @since 0.0.3
 */
public enum LocationFieldsTableNames {

    BUILDING("Bina"), SPACE("Bağımsız Bölüm");

    private String displayName;

    private LocationFieldsTableNames(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
