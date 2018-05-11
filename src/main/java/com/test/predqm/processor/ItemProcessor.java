package com.test.predqm.processor;

public interface ItemProcessor<I,O> {
	public O process(I input);
}
