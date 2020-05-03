package com.saikat.e_pharm.Model;

public class Orders {
    ShippingUser shippingUser;
    String _id;
    String status;
    String date;
    String products;
    String totalPrice;
    String receipt;
    String slug;

    public Orders() {
    }

    public Orders(ShippingUser shippingUser, String _id, String status, String date, String products, String totalPrice, String receipt, String slug) {
        this.shippingUser = shippingUser;
        this._id = _id;
        this.status = status;
        this.date = date;
        this.products = products;
        this.totalPrice = totalPrice;
        this.receipt = receipt;
        this.slug = slug;
    }

    public ShippingUser getShippingUser() {
        return shippingUser;
    }

    public void setShippingUser(ShippingUser shippingUser) {
        this.shippingUser = shippingUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
