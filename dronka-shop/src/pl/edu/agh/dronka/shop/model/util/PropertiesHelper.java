package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.items.*;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		if(item instanceof BooksItem) {
			propertiesMap.put("Liczba stron", ((BooksItem) item).getPages());
			propertiesMap.put("Twarda oprawa", ((BooksItem) item).isHardcover());
		}
		else if (item instanceof ElectronicsItem) {
			propertiesMap.put("Gwarancja", ((ElectronicsItem) item).isGuarantee());
			propertiesMap.put("Mobilny", ((ElectronicsItem) item).isMobile());
		}
		else if (item instanceof FoodItem) {
			propertiesMap.put("Data przydatności do spożycia", ((FoodItem) item).getEatByDate());
		}
		else if (item instanceof MusicItem) {
			propertiesMap.put("Gatunek muzyczny", ((MusicItem) item).getMusicGenre());
			propertiesMap.put("Teledysk", ((MusicItem) item).isVideo());
		}
		
		return propertiesMap;
	}
}
