package io.danilobzerra.crud.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static OrderStatus valueOf(Integer code) {
		for (OrderStatus o : OrderStatus.values()) {
			if (o.getCode() == code) {
				return o;
			}
		}
		throw new IllegalArgumentException();
	}
}
