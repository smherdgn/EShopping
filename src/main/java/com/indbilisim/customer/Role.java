package com.indbilisim.customer;



/**
 * Created by alikumru on 13.07.2017.
 */

public enum Role{
USER("Kullanici");

    private String displayName;
    Role(String displayName){
        this.displayName=displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}
