package bhangun.buku.fx.bab.others;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class BindUnbind {
	public static void main(String[] args) {
		IntegerProperty i = new SimpleIntegerProperty(null, "i", 1024);
		LongProperty l = new SimpleLongProperty(null, "l", 0L);

		System.out.println("i.get() = " + i.get());
		System.out.println("l.get() = " + l.get());

		l.bind(i);

		i.set(2048);

		System.out.println("i.get() = " + i.get());
		System.out.println("l.get() = " + l.get());

		l.unbind();
		System.out.println("Unbound l to i, f to l, d to f.");

		i.bind(l);
		System.out.println("Bound f to d, l to f, i to l.");

		System.out.println("Calling d.set(10000000000L).");
		i.set(100);

		System.out.println("l.get() = " + l.get());
		System.out.println("i.get() = " + i.get());
	}
}
