package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;
import pl.edu.agh.dronka.shop.model.items.BooksItem;
import pl.edu.agh.dronka.shop.model.items.ElectronicsItem;
import pl.edu.agh.dronka.shop.model.items.MusicItem;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter;

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();
		Category currentCategory = shopController.getCurrentCategory();
		filter = new ItemFilter(currentCategory);
		add(createPropertyCheckbox("Tanie bo polskie", event -> {
				filter.getItemSpec().setPolish(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		));

		add(createPropertyCheckbox("Używany", event -> {
				filter.getItemSpec().setSecondhand(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		));

		switch (currentCategory) {
			case BOOKS:
				add(createPropertyCheckbox("Twarda oprawa", event -> {
					((BooksItem) filter.getItemSpec()).setHardcover(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}
				));
				break;
			case ELECTRONICS:
				add(createPropertyCheckbox("Gwarancja", event -> {
							((ElectronicsItem) filter.getItemSpec()).setGuarantee(
									((JCheckBox) event.getSource()).isSelected());
							shopController.filterItems(filter);
						}
				));
				add(createPropertyCheckbox("Mobilny", event -> {
						((ElectronicsItem) filter.getItemSpec()).setMobile(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				));
				break;
			case MUSIC:
				add(createPropertyCheckbox("Teledysk", event -> {
							((MusicItem) filter.getItemSpec()).setVideo(
									((JCheckBox) event.getSource()).isSelected());
							shopController.filterItems(filter);
						}
				));
				break;
		}

	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
