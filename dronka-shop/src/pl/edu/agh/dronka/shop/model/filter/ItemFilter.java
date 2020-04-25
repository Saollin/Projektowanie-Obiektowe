package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.items.*;

public class ItemFilter {

	public ItemFilter(Category category) {
		switch(category) {
			case BOOKS:
				itemSpec = new BooksItem();
				break;
			case ELECTRONICS:
				itemSpec = new ElectronicsItem();
				break;
			case FOOD:
				itemSpec = new FoodItem();
				break;
			case MUSIC:
				itemSpec = new MusicItem();
				break;
			case SPORT:
				itemSpec = new SportItem();
				break;
		}
	}

	private Item itemSpec;

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		if(item instanceof BooksItem) {
			if(((BooksItem) itemSpec).isHardcover() && !(((BooksItem) item).isHardcover())) {
				return false;
			}
		}

		if(item instanceof ElectronicsItem) {
			if(((ElectronicsItem) itemSpec).isGuarantee() && !(((ElectronicsItem) item).isGuarantee())){
				return false;
			}
			if(((ElectronicsItem) itemSpec).isMobile() && !(((ElectronicsItem) item).isMobile())){
				return false;
			}

		}
		if(item instanceof MusicItem)
			if (((MusicItem) itemSpec).isVideo() && !(((MusicItem) item).isVideo())) {
			return false;
		}

		return true;
	}

}