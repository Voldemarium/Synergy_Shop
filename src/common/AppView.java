package common;

import java.util.ArrayList;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;          //номер текущей страницы
    public final int pageLimit = 5;   //количество элементов на странице
    public boolean hasNextPage = false;  //наличие следующей страницы

    protected AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    public void action() {};
}
