package com.gigago.util;

public class RemoveOrder {
	
	private Object object;
	private RemoveOrderType type;
	
	public RemoveOrder(Object object, RemoveOrderType type) {
		setObject(object);
		setType(type);
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public RemoveOrderType getType() {
		return type;
	}

	public void setType(RemoveOrderType type) {
		this.type = type;
	}
	
	
	
}
