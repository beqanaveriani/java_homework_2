package ge.btu.beka.naveriani.currency.service.impl;

import ge.btu.beka.naveriani.currency.models.request.ExchangeConvertRequest;
import ge.btu.beka.naveriani.currency.models.response.Rate;
import ge.btu.beka.naveriani.currency.service.ExchangeService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExchangeServiceImpl implements ExchangeService {

    private static ExchangeServiceImpl bean;

    private List<Rate> rates;

    ExchangeServiceImpl(){
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate("USD", new BigDecimal("3.16"), new BigDecimal("3.2")));
        rates.add(new Rate("EUR", new BigDecimal("3.425"), new BigDecimal("3.475")));
        rates.add(new Rate("GBP", new BigDecimal("3.84"), new BigDecimal("3.94")));
        rates.add(new Rate("RUB", new BigDecimal("0.0412"), new BigDecimal("0.043")));
        rates.add(new Rate("TRY", new BigDecimal("0.4"), new BigDecimal("0.47")));
        rates.add(new Rate("AZN", new BigDecimal("1.6"), new BigDecimal("1.84")));

        this.rates = rates;
    }

    @Override
    public List<Rate> getRates() {
        return this.rates;
    }

    @Override
    public BigDecimal sellGel(ExchangeConvertRequest request) {
        Rate toRate = getRate(request);
        if (toRate != null){
            return request.getAmount().divide(toRate.getBuy(), RoundingMode.HALF_UP);
        }
        throw new IllegalArgumentException("unsupported.currency");
    }

    @Override
    public BigDecimal buyGel(ExchangeConvertRequest request) {
        Rate toRate = getRate(request);
        if (toRate != null){
            return request.getAmount().multiply(toRate.getSell()).setScale(2, RoundingMode.HALF_UP);
        }
        throw new IllegalArgumentException("unsupported.currency");
    }

    public static ExchangeServiceImpl getBean(){
        if (bean == null){
            bean = new ExchangeServiceImpl();
        }
        return bean;
    }

    private Rate getRate(ExchangeConvertRequest request) {
        for (Rate rate : rates) {
            if (rate.getTitle().equalsIgnoreCase(request.getTo())){
                return rate;
            }
        }
        return null;
    }
}
