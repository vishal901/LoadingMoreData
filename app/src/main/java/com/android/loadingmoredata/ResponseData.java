package com.android.loadingmoredata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vishal on 05/07/2016.
 */
public class ResponseData {

    /**
     * id : 1
     * vendor_id : 2
     * category_id : 1
     * offer_name : buy 1 soap get 1 free
     * validity_from : 2016-02-20
     * validity_to : 2016-02-22
     * image : http://nearely.com/nearely/assets/uploads/offers/14556898122.jpg
     * terms : this is the test term
     * keywords : soap,sabu
     * status : active
     * created_time : 2016-02-26 18:37:48
     * updated_time : 0000-00-00 00:00:00
     * business_name : Khodiyar cassete
     * owner_name : Bharatbhai patel
     * address : tejendra avenue
     * area_id : 0
     * pincode : 382481
     * latitude : 65.9667
     * longitude : -18.5333
     * city_name : Ahmedabad
     * state_name : Gujarat
     * country_name : India
     * category_name : grocery
     */

    @SerializedName("offers")
    private List<OffersBean> offers;

    public List<OffersBean> getOffers() {
        return offers;
    }

    public void setOffers(List<OffersBean> offers) {
        this.offers = offers;
    }

    public static class OffersBean {
        @SerializedName("id")
        private String id;
        @SerializedName("vendor_id")
        private String vendorId;
        @SerializedName("category_id")
        private String categoryId;
        @SerializedName("offer_name")
        private String offerName;
        @SerializedName("validity_from")
        private String validityFrom;
        @SerializedName("validity_to")
        private String validityTo;
        @SerializedName("image")
        private String image;
        @SerializedName("terms")
        private String terms;
        @SerializedName("keywords")
        private String keywords;
        @SerializedName("status")
        private String status;
        @SerializedName("created_time")
        private String createdTime;
        @SerializedName("updated_time")
        private String updatedTime;
        @SerializedName("business_name")
        private String businessName;
        @SerializedName("owner_name")
        private String ownerName;
        @SerializedName("address")
        private String address;
        @SerializedName("area_id")
        private String areaId;
        @SerializedName("pincode")
        private String pincode;
        @SerializedName("latitude")
        private String latitude;
        @SerializedName("longitude")
        private String longitude;
        @SerializedName("city_name")
        private String cityName;
        @SerializedName("state_name")
        private String stateName;
        @SerializedName("country_name")
        private String countryName;
        @SerializedName("category_name")
        private String categoryName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVendorId() {
            return vendorId;
        }

        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getOfferName() {
            return offerName;
        }

        public void setOfferName(String offerName) {
            this.offerName = offerName;
        }

        public String getValidityFrom() {
            return validityFrom;
        }

        public void setValidityFrom(String validityFrom) {
            this.validityFrom = validityFrom;
        }

        public String getValidityTo() {
            return validityTo;
        }

        public void setValidityTo(String validityTo) {
            this.validityTo = validityTo;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTerms() {
            return terms;
        }

        public void setTerms(String terms) {
            this.terms = terms;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }
}
