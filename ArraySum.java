package com.assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySum {
	static List<Integer> running = new LinkedList<>();
	static Set<Set<Integer>> master = new HashSet<>();
	static int itr = -1;

	public static void main(String[] args) {
		running.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		Set<Set<Integer>> integers = append(null);
		System.out.println(integers);
	}

	public static Set<Set<Integer>> append(Set<Set<Integer>> set) {
		Set<Set<Integer>> s1 = new HashSet<>();
		for (Integer a1 : running) {
			if (set != null && set.size() > 0)
				set.forEach((Set<Integer> a2) -> {
					Set<Integer> a3 = new HashSet<>();
					if (!a2.contains(a1) && a1 == Collections.max(a2)+1) {
						a3.addAll(a2);
						a3.add(a1);
						s1.add(a3);
					}
				});
			else
				s1.add(new HashSet<>(Arrays.asList(a1)));
		}
		if (s1 != null && s1.size() > 0) {
			master.addAll(s1);
			append(s1);
		}
		return master;
	}
}
