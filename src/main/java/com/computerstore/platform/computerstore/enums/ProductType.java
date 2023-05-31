package com.computerstore.platform.computerstore.enums;

public enum ProductType {

    DESKTOP,
    LAPTOP,
    HARD_DRIVE,
    MONITOR;

    public static ProductType fromString(String value) {
        for (ProductType type : ProductType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
