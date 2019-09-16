package org.ngu.server.protocol;

import lombok.Getter;

public enum RetCode {

    SUCCESS(0),
    UN_KNOW(1);

    private int code;

    RetCode(int code) {
        this.code = code;
    }

    public int code(){
        return this.code;
    }

}
