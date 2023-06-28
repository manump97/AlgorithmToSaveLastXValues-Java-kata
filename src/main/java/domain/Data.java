package domain;

public class Data {
    private Order order;
    private String Value;

    public Data(Order order, String value) {
        this.order = order;
        Value = value;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
