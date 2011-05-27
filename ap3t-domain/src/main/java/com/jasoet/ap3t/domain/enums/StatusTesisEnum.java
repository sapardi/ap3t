package com.jasoet.ap3t.domain.enums;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public enum StatusTesisEnum {
    TIDAK_LULUS, PERBAIKAN, LULUS;


    @Override
    public String toString() {
        switch (this) {
            case TIDAK_LULUS:
                return "Tidak Lulus";
            case PERBAIKAN:
                return "Lulus dengan Perbaikan";
            case LULUS:
                return "Lulus tanpa Perbaikan";
            default:
                throw new IllegalArgumentException("Wrong Enum Constant");
        }
    }


    public String getValue(){
        return this.toString();
    }
}
