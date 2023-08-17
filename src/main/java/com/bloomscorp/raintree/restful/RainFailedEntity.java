package com.bloomscorp.raintree.restful;

import lombok.AllArgsConstructor;

public class RainFailedEntity<E> extends RainEntity<E> {

	public boolean success = false;
	public E entity = null;
	public String message;

	public RainFailedEntity(String message) {
		this.message = message;
	}
}
