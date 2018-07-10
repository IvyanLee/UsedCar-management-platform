package Bean;

import java.util.Date;

//商品类
public class AgainCar {


    private String CarName;
    private Date BuyDate;
    private double HasRun;
    private double TotalPrice;
    private double FirstPrice;
    private String ConnectNumber;
    private String Picture;
    private int CarId;

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public Date getBuyDate() {
        return BuyDate;
    }

    public void setBuyDate(Date buyDate) {
        BuyDate = buyDate;
    }

    public double getHasRun() {
        return HasRun;
    }

    public void setHasRun(double hasRun) {
        HasRun = hasRun;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public double getFirstPrice() {
        return FirstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        FirstPrice = firstPrice;
    }

    public String getConnectNumber() {
        return ConnectNumber;
    }

    public void setConnectNumber(String connectNumber) {
        ConnectNumber = connectNumber;
    }
}
