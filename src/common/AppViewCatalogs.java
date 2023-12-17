package common;

import data.comparators.AppComparator;
import data.models.Product;

import java.util.ArrayList;

public abstract class AppViewCatalogs extends AppView {
    public int nowPage = 0;          //номер текущей страницы
    public final int pageLimit = 5;   //количество элементов на странице
    public boolean hasNextPage = false;  //наличие следующей страницы
    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();
    public AppComparator<Product> selectedComparator;  // default Comparator

    protected AppViewCatalogs(String title, ArrayList<AppView> children) {
        super(title, children);
    }

    public int getOptionalsSize() {
        int optionalsSize = 0;
        if (this.hasNextPage) {
            optionalsSize++;          //при наличии следующей страницы
        }
        if (!this.availableComparators.isEmpty()) {
            optionalsSize += this.availableComparators.size();  //при наличии Comparators (фильтров поиска)
        }
        return optionalsSize;
    }

    public void displayOptionals(int currentIndex) {
        if (this.hasNextPage) {
            System.out.println(currentIndex + " - " + "next page"); //при наличии следующей страницы
            currentIndex++;
        }
        if (!this.availableComparators.isEmpty()) {
            for (AppComparator<Product> availableComparator : this.availableComparators) { //при наличии Comparators (фильтров поиска)
                System.out.println(currentIndex + " - " + availableComparator.name);
                currentIndex++;
            }
        }
    }

}
