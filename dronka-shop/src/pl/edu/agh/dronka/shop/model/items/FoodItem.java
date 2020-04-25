package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodItem extends Item {

    private Date eatByDate;

    public FoodItem(String name, int price, int quantity, Date eatByDate) {
        super(name, Category.FOOD, price, quantity);
        this.eatByDate = eatByDate;
    }

    public FoodItem() {
        this.setCategory(Category.FOOD);
    }

    public String getEatByDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        return dateFormat.format(eatByDate);
    }

    public void setEatByDate(Date eatByDate) {
        this.eatByDate = eatByDate;
    }
}
