package uoit.ca.movieapp;

import android.graphics.Bitmap;

public class ListData {

    private int imageId;
    private String title;
    private String subtitle;
    private Bitmap imageBitmap;
    private String debugPath;
    private String setImage;

    /* Getters */

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public String getDebugPath() {
        return debugPath;
    }

    public String getSetImage() {
        return setImage;
    }

    /* Setters*/

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public  void setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
    }

    public void setDebugPath(String debugPath) {
        this.debugPath = debugPath;
    }

    public void setSetImage(String setImage) {
        this.setImage = setImage;
    }
}
