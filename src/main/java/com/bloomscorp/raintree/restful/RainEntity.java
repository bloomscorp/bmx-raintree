package com.bloomscorp.raintree.restful;

import com.bloomscorp.raintree.RainTreeResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RainEntity<E> extends RainTreeResponse {

	public E entity;

	public RainEntity(E entity) {
		this.entity = entity;
		this.success = entity != null;
	}
}
