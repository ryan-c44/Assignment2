package assignment2;

import java.util.Comparator;

public class SortByEmail implements Comparator<Billing> {

	@Override
	public int compare(Billing a, Billing b) {
		return a.getEmail().compareTo(b.getEmail());
	}
}
