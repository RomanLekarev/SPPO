package model.abstracts;

import model.abstracts.enums.TypeTransport;

import java.util.Objects;

public abstract class Transport {

    private TypeTransport typeTransport;
    private String number;


    public Transport(TypeTransport typeTransport, String number) {
        this.typeTransport = typeTransport;
        this.number = number;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return typeTransport == transport.typeTransport && Objects.equals(number, transport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeTransport, number);
    }
}
