package com.epam.logic.comparator;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import com.epam.notebook.Note;

public final class NoteComparator implements Comparator<Note> {

	@Override
	public int compare(Note note1, Note note2) {
		SimpleDateFormat formatDays = new SimpleDateFormat("dd");
		SimpleDateFormat formatMonths = new SimpleDateFormat("MM");
		SimpleDateFormat formatYears = new SimpleDateFormat("yyyy");
		if (Integer.parseInt(formatYears.format(note1.getDate())) < Integer
				.parseInt(formatYears.format(note2.getDate()))) {
			return -1;
		} else if (Integer.parseInt(formatYears.format(note1.getDate())) == Integer
				.parseInt(formatYears.format(note2.getDate()))) {

			if (Integer.parseInt(formatMonths.format(note1.getDate())) == Integer
					.parseInt(formatMonths.format(note2.getDate()))) {

				if (Integer.parseInt(formatDays.format(note1.getDate())) < Integer
						.parseInt(formatDays.format(note2.getDate()))) {
					return -1;
				} else if (Integer.parseInt(formatDays.format(note1.getDate())) == Integer
						.parseInt(formatDays.format(note2.getDate()))) {
					return 0;
				} else
					return 1;
			} else if (Integer.parseInt(formatMonths.format(note1.getDate())) < Integer
					.parseInt(formatMonths.format(note2.getDate()))) {
				return -1;
			} else {
				return 1;
			}
		} else
			return 1;
	}
}

