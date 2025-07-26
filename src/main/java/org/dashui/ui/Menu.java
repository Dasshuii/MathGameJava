package org.dashui.ui;

import java.util.List;

public abstract class Menu {
    protected List<String> options;

    protected int startIndex = 0;

    public abstract void configure();

    public void show() {
        configure();

        for(int i = 0, size = options.size(); i < size; i++) {
            System.out.printf("[%d] %s\n", startIndex + i, options.get(i));
        }
    };
}
