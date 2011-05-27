package com.jasoet.ap3t.domain.enums;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public enum NilaiProposalEnum {
    DITOLAK, PERBAIKAN, DITERIMA;


    @Override
    public String toString() {
        switch (this) {
            case DITOLAK:
                return "Ditolak";
            case PERBAIKAN:
                return "Diterima dengan Perbaikan";
            case DITERIMA:
                return "Diterima tanpa Perbaikan";
            default:
                throw new IllegalArgumentException("Wrong Enum Constant");
        }
    }


    public String getValue(){
        return this.toString();
    }
}
