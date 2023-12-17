package common;

import java.util.Scanner;

public class PageLoop {
    final AppView view;
    int fullSizeMenu;  // полное кол-во выбираемых пользователем вариантов в меню ввода (включая "назад")

    public PageLoop(AppView view) {
        this.view = view;
    }

    int getChildrenSize() {               // сколько основных пунктов в меню
        return this.view.children.size();
    }

    int getOptionalsSize() {         // сколько дополнительных пунктов в меню (для опций сортировки и др.)
        int optionalsSize = 0;
        if (view instanceof AppViewCatalogs) {
            optionalsSize = ((AppViewCatalogs) this.view).getOptionalsSize();
        }
        return optionalsSize;
    }

    public void run() {
        while (true) {
            view.action();     //отображение содержимого (если это каталог, корзина или ордер, либо другое действие)
            this.fullSizeMenu = getChildrenSize() + getOptionalsSize() + 1;
            displayMenu();        //отображение меню
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();         //выбор пользователем номера пункта меню ввода
            if (value < 1 || value > fullSizeMenu) {
                System.out.println("Неверное значение выбор пункта меню");
            } else if (value == fullSizeMenu) { // выбран пункт меню "назад"
                break;
            } else if (value <= getChildrenSize()) {  //выбран один из основных пунктов меню
                AppView selectedView = this.view.children.get(value - 1);
                new PageLoop(selectedView).run();
            } else {                           //выбраны дополнительные пункты меню
                runAppViewCatalogs(value);
            }
        }
    }

    private void runAppViewCatalogs(int value) {
        AppViewCatalogs viewCurrent = (AppViewCatalogs) this.view;
        if (value - 1 == getChildrenSize() && viewCurrent.hasNextPage) { //выбран пункт "next page"
            viewCurrent.nowPage++;
            new PageLoop(viewCurrent).run();
        } else {  //выбраны пункты с фильтрами
            viewCurrent.nowPage = 0;
            int comparatorIndex = value - getChildrenSize() - 1 - (viewCurrent.hasNextPage ? 1 : 0);
            viewCurrent.selectedComparator = viewCurrent.availableComparators.get(comparatorIndex);
            new PageLoop(viewCurrent).run();
        }
    }

    void displayMenu() { //отображение меню в консоли
        int currentIndex = 1;
        System.out.println(this.view.title);
        System.out.println("Выберите вариант (от 1 до " + fullSizeMenu + ")");
        for (int i = 0; i < getChildrenSize(); i++) {
            AppView viewChild = this.view.children.get(i);
            System.out.println(currentIndex + " - " + viewChild.title);
            currentIndex++;
        }
        if (this.view instanceof AppViewCatalogs) {
            ((AppViewCatalogs) this.view).displayOptionals(currentIndex);
        }
        System.out.println(fullSizeMenu + " - go back");
    }
}
