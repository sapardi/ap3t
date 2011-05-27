package com.jasoet.ap3t.domain.enums;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */

public enum MinatEnum {
    ILMU_KOMPUTER, SISTEM_CERDAS, KOMPUTASI;


    @Override
    public String toString() {
        switch (this) {
            case ILMU_KOMPUTER:
                return "Ilmu Komputer";
            case SISTEM_CERDAS:
                return "Sistem Cerdas";
            case KOMPUTASI:
                return "Komputasi";
            default:
                throw new IllegalArgumentException("Wrong Enum Constant");
        }
    }

    public String getValue(){
        return this.toString();
    }

}
