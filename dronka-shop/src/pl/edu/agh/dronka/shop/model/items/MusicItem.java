package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.MusicGenre;

public class MusicItem extends Item {

    private MusicGenre musicGenre;
    private boolean video;

    public MusicItem(String name, int price, int quantity, MusicGenre musicGenre, boolean video) {
        super(name, Category.MUSIC, price, quantity);
        this.musicGenre = musicGenre;
        this.video = video;
    }

    public MusicItem() {
        this.setCategory(Category.MUSIC);
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
