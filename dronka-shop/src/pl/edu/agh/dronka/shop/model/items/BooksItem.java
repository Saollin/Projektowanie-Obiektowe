package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class BooksItem extends Item{

    private int pages;
    private boolean hardcover;

    public BooksItem(String name, int price, int quantity, int pages, boolean hardcover) {
        super(name, Category.BOOKS, price, quantity);
        this.pages = pages;
        this.hardcover = hardcover;
    }

    public BooksItem() {
        this.setCategory(Category.BOOKS);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isHardcover() {
        return hardcover;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }
}
