package com.epam.formatter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TextTable {
	
	public TextTable() {
		
	}
	
	public static void printTable(String[][] table, Boolean... justify) {
		/*
		 * leftJustifiedRows - If true, it will add "-" as a flag to format string to
		 * make it left justified. Otherwise right justified.
		 */
		
		boolean leftJustifiedRows = false;
		if(justify.length>0)
			leftJustifiedRows = justify[0];
	
		/*
		 * Table to print in console in 2-dimensional array. Each sub-array is a row.
		 */
//		table = new String[][] { { "id", "First Name", "Last Name", "Age" },
//				{ "1", "John", "Johnson", "45" }, { "2", "Tom", "", "35" }, { "3", "Rose", "Johnson", "22" },
//				{ "4", "Jimmy", "Kimmel", "44" } };
//	
		/*
		 * Calculate appropriate Length of each column by looking at width of data in
		 * each column.
		 * 
		 * Map columnLengths is <column_number, column_length>
		 */
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(table).forEach(a -> Stream.iterate(0, (i -> ++i)).limit(a.length).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
		//System.out.println("columnLengths = " + columnLengths);
	
		/*
		 * Prepare format String
		 */
		final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
		formatString.append("|\n");
		//System.out.println("formatString = " + formatString.toString());
	
		/*
		 * Prepare line for top, bottom & below header row.
		 */
		String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> ++i)).limit(b.getValue()).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
		System.out.println(line);
	
		/*
		 * Print table
		 */
		System.out.print(line);
		Arrays.stream(table).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
		System.out.print(line);
	
		Stream.iterate(1, (i -> ++i)).limit(table.length-1)
				.forEach(a -> System.out.printf(formatString.toString(), table[a]));
		System.out.print(line);
	}
}