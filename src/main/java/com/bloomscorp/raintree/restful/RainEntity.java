package com.bloomscorp.raintree.restful;

import com.bloomscorp.raintree.RainTreeResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RainEntity<E> extends RainTreeResponse {
	public E entity;
}
