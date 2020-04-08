package ge.btu.beka.naveriani.currency.controller;


import ge.btu.beka.naveriani.currency.models.request.ExchangeConvertRequest;
import ge.btu.beka.naveriani.currency.models.response.Rate;
import ge.btu.beka.naveriani.currency.service.ExchangeService;
import ge.btu.beka.naveriani.currency.service.impl.ExchangeServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/exchange")
public class ExchangeController {

    private ExchangeService exchangeService = ExchangeServiceImpl.getBean();

    @GET
    @Path("/rates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rate> getRates(){
        return exchangeService.getRates();
    }

    @POST
    @Path("/sell/gel")
    public BigDecimal sellGel(ExchangeConvertRequest request){
        return exchangeService.sellGel(request);
    }

    @POST
    @Path("/buy/gel")
    public BigDecimal buyGel(ExchangeConvertRequest request){
        return exchangeService.buyGel(request);
    }



}
