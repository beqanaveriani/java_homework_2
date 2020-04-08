package ge.btu.beka.naveriani.currency.service;

import ge.btu.beka.naveriani.currency.models.request.ExchangeConvertRequest;
import ge.btu.beka.naveriani.currency.models.response.Rate;

import java.math.BigDecimal;
import java.util.List;

public interface ExchangeService {

    List<Rate> getRates();

    BigDecimal sellGel(ExchangeConvertRequest request);

    BigDecimal buyGel(ExchangeConvertRequest request);
}
