package model;

import model.abstracts.Transport;
import model.abstracts.enums.TypeTransport;

public class BusTransport extends Transport {

    public BusTransport(String number) {
        super(TypeTransport.BUS, number);
    }
}
