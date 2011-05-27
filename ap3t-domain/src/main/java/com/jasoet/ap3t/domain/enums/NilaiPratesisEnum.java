package com.jasoet.ap3t.domain.enums;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public enum NilaiPratesisEnum {
    PERBAIKAN, TANPA_PERBAIKAN;


    @Override
    public String toString() {
        switch (this) {
            case PERBAIKAN:
                return "Diterima dengan Perbaikan";
            case TANPA_PERBAIKAN:
                return "Diterima tanpa Perbaikan";
            default:
                throw new IllegalArgumentException("Wrong Enum Constant");
        }
    }


    public String getValue(){
        return this.toString();
    }
}
