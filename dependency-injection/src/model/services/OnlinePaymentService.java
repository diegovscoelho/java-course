package model.services;

import model.entities.Contract;

public interface OnlinePaymentService {

    public Double paymentFee(Double amount);

    public Double interest(Double amount, Integer months);
}
