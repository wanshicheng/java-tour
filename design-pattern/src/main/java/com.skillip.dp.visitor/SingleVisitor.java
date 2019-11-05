package com.skillip.dp.visitor;

public class SingleVisitor implements Visitor {

    @Override
    public void visit(Shanghai shanghai) {
        System.out.println("Hello Shanghai!");
    }

    @Override
    public void visit(Beijing beijing) {
        System.out.println("Hello Beijing!");
    }
}
