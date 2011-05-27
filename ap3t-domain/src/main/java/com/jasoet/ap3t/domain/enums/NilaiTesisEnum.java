package com.jasoet.ap3t.domain.enums;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public enum NilaiTesisEnum {
    E, D, C, B, A;

    public int nilaiAngka() {
        switch (this) {
            case A:
                return 4;
            case B:
                return 3;
            case C:
                return 2;
            case D:
                return 1;
            case E:
                return 0;
            default:
                throw new IllegalArgumentException("Wrong Enum Constant");
        }
    }


    public String getValue(){
        return this.toString();
    }
}
