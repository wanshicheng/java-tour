package com.skillip.dp.visitor;

public class Beijing implements City {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
