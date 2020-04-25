package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class SportItem extends Item {

    public SportItem(String name, int price, int quantity) {
        super(name, Category.SPORT, price, quantity);
    }

    public SportItem() {
        this.setCategory(Category.SPORT);
    }

}
