package common;

import java.util.Scanner;

public class PageLoop {
    final AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }

    int getChildrenSize() {
        return this.view.children.size();
    }

    int getOptionalsSize() {   // функция добавляет в меню ввода еще один пункт при наличии следующей страницы
        int optionalsSize = 0;
        if(this.view.hasNextPage) {
            optionalsSize++;
        }
        return optionalsSize;
    }


    public void run() {
        while (true) {
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalsSize() + 1; //полное кол-во выбираемых пользователем
                                                                     // вариантов в меню ввода (включая "назад")
            Scanner in = new Scanner(System.in);
            int value = in.nextInt(); //номер страницы
            if (value < 0 || value > fullSize) {
                System.out.println("Неверное значение страницы");
            } else if (value == fullSize) {
                break;
            } else if(value < getChildrenSize()) {
                AppView selectedView = this.view.children.get(value - 1);
                new PageLoop(selectedView).run();
            } else {
                this.view.nowPage++;
                run();
            }
        }
    }

    void displayChildren() {
        System.out.println(this.view.title);
        System.out.println("Выберите вариант (от 1 до " + (getChildrenSize()+ 1) + ")");
        for (int i = 0; i < getChildrenSize(); i++) {
            AppView viewChild = this.view.children.get(i);
            System.out.println((i + 1) + " - " + viewChild.title);
        }
        if(this.view.hasNextPage) {
            System.out.println(getChildrenSize() + 1 + " - " + "next page");
        }
        System.out.println((getChildrenSize() + getOptionalsSize() + 1) + " - назад");
    }
}
