package com.test.predqm.translator;

public interface OutputTranslator<T> {
    String translateToLine(T t);
}
