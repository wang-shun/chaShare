package com.holley.charging.model.def;

import com.holley.charging.model.bus.BusPayment;

public class BusPaymentVo extends BusPayment {

    private String pileCode;

    public String getPileCode() {
        return pileCode;
    }

    public void setPileCode(String pileCode) {
        this.pileCode = pileCode;
    }

}
