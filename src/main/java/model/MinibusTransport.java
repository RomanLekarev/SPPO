package model;

import model.abstracts.Transport;
import model.abstracts.enums.TypeTransport;

public class MinibusTransport extends Transport {
    public MinibusTransport(String number) {
        super(TypeTransport.MINIBUS, number);
    }
}
