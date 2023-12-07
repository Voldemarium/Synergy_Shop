package common;

import java.util.Scanner;

public class PageLoop {
    final AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            view.action();
            displayChildren();
            Scanner in = new Scanner(System.in);
            int value = in.nextInt(); //номер страницы
            if (value < 0 || value > view.children.size() + 1) {
                System.out.println("Неверное значение страницы");
            } else if (value == view.children.size() + 1) {
                 break;
            } else {
                AppView selectedView = this.view.children.get(value - 1);
                new PageLoop(selectedView).run();
            }
        }
    }

    void displayChildren() {
        System.out.println(this.view.title);
        System.out.println("Выберите вариант (от 1 ло " + (view.children.size() + 1) + ")");
        for (int i = 0; i < this.view.children.size(); i++) {
            AppView viewChild = this.view.children.get(i);
            System.out.println((i + 1) + " - " + viewChild.title);
        }
        System.out.println((view.children.size() + 1) + " - назад");
    }


}
