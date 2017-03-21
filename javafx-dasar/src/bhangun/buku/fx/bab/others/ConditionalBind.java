package bhangun.buku.fx.bab.others;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.When;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ConditionalBind {
    public static void main(String[] args) {
        DoubleProperty a = new SimpleDoubleProperty(0);
        DoubleProperty b = new SimpleDoubleProperty(0);

        DoubleBinding s = a.add(b).divide(2.0D);

        final DoubleBinding aBinding = new When(a.add(b).greaterThan(b)
                .and(a.add(a).greaterThan(b)))
                .then(s.multiply(s.subtract(a))
                        .multiply(s.subtract(b)))
                .otherwise(0.0D);

        a.set(3);
        b.set(4);
        System.out.println(a.get());
        System.out.println(b.get());
        System.out.println(aBinding.get());

        a.set(2);
        b.set(2);
        System.out.println(a.get());
        System.out.println(b.get());
        System.out.println(aBinding.get());

    }
}
