package org.ssglobal.training.codes;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ProcessIntegerStream {

	// intermediate methods
	public abstract ProcessIntegerStream filter(Predicate<Integer> convert);
	public abstract ProcessIntegerStream sort(Comparator<Integer> compare);
	// terminal methods
	public abstract List<Integer> toList();
	public abstract Integer[] toArray();
}
