package com.voyager.barasti.activity.PriceDetailPage.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 26-Feb-19.
 */

public class PriceDetails {


    /**
     * dates_array : {"2019-02-18":35,"2019-02-19":35,"2019-02-20":35,"2019-02-21":35,"2019-02-22":35,"2019-02-23":35,"2019-02-24":35,"2019-02-25":35}
     * total_night_price : 280
     * property_price : 35
     * total_nights : 8
     * service_fee : 14
     * host_fee : 0
     * additional_guest : 95
     * security_fee : 0
     * cleaning_fee : 2
     * total : 391
     * subtotal : 391
     * currency : INR
     * checkin : 2019-02-18
     * checkout : 2019-02-25
     */

    private int total_night_price;
    private int property_price;
    private int total_nights;
    private String service_fee;
    private String host_fee;
    private int additional_guest;
    private int security_fee;
    private int cleaning_fee;
    private int total;
    private int subtotal;
    private String currency;
    private String checkin;
    private String checkout;



    public int getTotal_night_price() {
        return total_night_price;
    }

    public void setTotal_night_price(int total_night_price) {
        this.total_night_price = total_night_price;
    }

    public int getProperty_price() {
        return property_price;
    }

    public void setProperty_price(int property_price) {
        this.property_price = property_price;
    }

    public int getTotal_nights() {
        return total_nights;
    }

    public void setTotal_nights(int total_nights) {
        this.total_nights = total_nights;
    }

    public String getService_fee() {
        return service_fee;
    }

    public void setService_fee(String service_fee) {
        this.service_fee = service_fee;
    }

    public String getHost_fee() {
        return host_fee;
    }

    public void setHost_fee(String host_fee) {
        this.host_fee = host_fee;
    }

    public int getAdditional_guest() {
        return additional_guest;
    }

    public void setAdditional_guest(int additional_guest) {
        this.additional_guest = additional_guest;
    }

    public int getSecurity_fee() {
        return security_fee;
    }

    public void setSecurity_fee(int security_fee) {
        this.security_fee = security_fee;
    }

    public int getCleaning_fee() {
        return cleaning_fee;
    }

    public void setCleaning_fee(int cleaning_fee) {
        this.cleaning_fee = cleaning_fee;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public static class DatesArrayBean {
        /**
         * 2019-02-18 : 35
         * 2019-02-19 : 35
         * 2019-02-20 : 35
         * 2019-02-21 : 35
         * 2019-02-22 : 35
         * 2019-02-23 : 35
         * 2019-02-24 : 35
         * 2019-02-25 : 35
         */

        @SerializedName("2019-02-18")
        private int _$20190218;
        @SerializedName("2019-02-19")
        private int _$20190219;
        @SerializedName("2019-02-20")
        private int _$20190220;
        @SerializedName("2019-02-21")
        private int _$20190221;
        @SerializedName("2019-02-22")
        private int _$20190222;
        @SerializedName("2019-02-23")
        private int _$20190223;
        @SerializedName("2019-02-24")
        private int _$20190224;
        @SerializedName("2019-02-25")
        private int _$20190225;

        public int get_$20190218() {
            return _$20190218;
        }

        public void set_$20190218(int _$20190218) {
            this._$20190218 = _$20190218;
        }

        public int get_$20190219() {
            return _$20190219;
        }

        public void set_$20190219(int _$20190219) {
            this._$20190219 = _$20190219;
        }

        public int get_$20190220() {
            return _$20190220;
        }

        public void set_$20190220(int _$20190220) {
            this._$20190220 = _$20190220;
        }

        public int get_$20190221() {
            return _$20190221;
        }

        public void set_$20190221(int _$20190221) {
            this._$20190221 = _$20190221;
        }

        public int get_$20190222() {
            return _$20190222;
        }

        public void set_$20190222(int _$20190222) {
            this._$20190222 = _$20190222;
        }

        public int get_$20190223() {
            return _$20190223;
        }

        public void set_$20190223(int _$20190223) {
            this._$20190223 = _$20190223;
        }

        public int get_$20190224() {
            return _$20190224;
        }

        public void set_$20190224(int _$20190224) {
            this._$20190224 = _$20190224;
        }

        public int get_$20190225() {
            return _$20190225;
        }

        public void set_$20190225(int _$20190225) {
            this._$20190225 = _$20190225;
        }
    }
}
