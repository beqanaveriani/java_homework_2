package ge.btu.beka.naveriani.currency.models.request;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ExchangeConvertRequest {

    @NotNull
    private String to;

    @NotNull
    private BigDecimal amount;

    public ExchangeConvertRequest(String  to, BigDecimal amount){
        this.to = to;
        this.amount = amount;
    }

    public ExchangeConvertRequest(){

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTo() {
        return to;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
