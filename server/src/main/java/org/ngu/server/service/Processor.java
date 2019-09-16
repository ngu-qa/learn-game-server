package org.ngu.server.service;

@FunctionalInterface
public interface Processor<IN,OUT> {

    OUT process(IN in);

}
