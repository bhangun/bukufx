package bhangun.buku.fx.bab.others;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class CustomBind {
    public static void main(String[] args) {
        final DoubleProperty x = new SimpleDoubleProperty(null, "x", 2.0);
        final DoubleProperty y = new SimpleDoubleProperty(null, "y", 3.0);
        DoubleBinding area = new DoubleBinding() {
            private double value;

            {
                super.bind(x, y);
            }

            @Override
            protected double computeValue() {
                System.out.println("computeValue() is called.");
                return x.get() * y.get();
            }
        };
        System.out.println("area.get() = " + area.get());
        x.set(5);
        y.set(7);
        System.out.println("area.get() = " + area.get());
    }
}

