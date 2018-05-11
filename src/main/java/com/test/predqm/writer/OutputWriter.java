package com.test.predqm.writer;

import java.util.List;

public interface OutputWriter<T> {
	public boolean write(List<T> list, String fileName);
}
