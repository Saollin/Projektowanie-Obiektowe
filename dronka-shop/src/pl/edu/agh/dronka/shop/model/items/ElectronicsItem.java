package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class ElectronicsItem extends Item {

    private boolean mobile;
    private boolean guarantee;


    public ElectronicsItem(String name, int price, int quantity, boolean mobile, boolean guarantee) {
        super(name, Category.ELECTRONICS, price, quantity);
        this.mobile = mobile;
        this.guarantee = guarantee;
    }

    public ElectronicsItem(){
        this.setCategory(Category.ELECTRONICS);
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }
}
