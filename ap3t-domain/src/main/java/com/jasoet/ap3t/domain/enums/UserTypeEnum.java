package com.jasoet.ap3t.domain.enums;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public enum UserTypeEnum {
    MAHASISWA,DOSEN,ADMINISTRATOR,STAFF,OTHER;


    @Override
    public String toString() {
        switch (this) {
            case MAHASISWA:
                return "Mahasiswa";
            case DOSEN:
                return "Dosen";
            case ADMINISTRATOR:
                return "Administrator";
            case STAFF:
                return "Staff";
            case OTHER:
                return "Other";
            default:
                throw new IllegalArgumentException("Wrong Enum Constant");
        }
    }


    public String getValue(){
        return this.toString();
    }
}
