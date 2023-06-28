package application;

import domain.Data;
import domain.Order;

import java.util.List;

public interface DataInput {

    public int configBufferLength();
    public List<Data> sendOrders();

}
