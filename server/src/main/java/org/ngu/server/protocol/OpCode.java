package org.ngu.server.protocol;

import lombok.Getter;

public enum OpCode {

    UN_KNOW(0),
    SAY_HELLO(1);

    private int code;

    OpCode(int code) {
        this.code = code;
    }

    public int code(){
        return this.code;
    }

}
