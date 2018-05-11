package com.test.predqm.translator;

public interface InputTranslator<T> {
	T translateFromLine(String line);
}
