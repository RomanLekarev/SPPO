package model;

import model.abstracts.Transport;
import model.abstracts.enums.TypeTransport;

public class ElectroBusTransport extends Transport {
    public ElectroBusTransport(String number) {
        super(TypeTransport.ELECTROBUS, number);
    }
}
