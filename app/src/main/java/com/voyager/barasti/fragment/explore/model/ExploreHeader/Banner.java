package com.voyager.barasti.fragment.explore.model.ExploreHeader;

/**
 * Created by User on 07-Jan-19.
 */

public class Banner {


    /**
     * id : 1
     * title : Slider1
     * url : www.slider1.com
     * image : slider_1546680186.jpg
     * status : Active
     * image_url : http://betaholder.com/barastiapp/public/images/sliders/slider_1546680186.jpg
     */

    private int id;
    private String title;
    private String url;
    private String image;
    private String status;
    private String image_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
