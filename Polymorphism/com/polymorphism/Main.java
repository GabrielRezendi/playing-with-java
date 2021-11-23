package com.polymorphism;

import java.time.LocalDate;

import javax.sql.rowset.JoinRowSet;

public class Main {
    public static void main(String args[]) {
        Human josevaldo = new Man(LocalDate.of(2000, 05, 14));

        SolidFood maca = new SolidFood();
        LiquidFood aguaDeCoco = new LiquidFood();


        josevaldo.Eat(maca);
        josevaldo.Eat(aguaDeCoco);
    }
}
