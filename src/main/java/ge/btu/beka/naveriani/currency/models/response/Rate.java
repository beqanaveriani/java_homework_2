package ge.btu.beka.naveriani.currency.models.response;

import java.math.BigDecimal;

public class Rate {

    String title;

    BigDecimal buy;

    BigDecimal sell;

    public Rate(String title, BigDecimal buy, BigDecimal sell){
        this.title = title;
        this.buy = buy;
        this.sell = sell;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public String getTitle() {
        return title;
    }
}
