package domain;

public class StoredValue {
    private String value;
    private boolean blocked;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public StoredValue(String value) {
        this.value = value;
        this.blocked = false;
    }
}
