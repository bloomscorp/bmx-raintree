package com.bloomscorp.raintree.restful;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RainFailedEntity<E> extends RainEntity<E> {
	public E entity;
}
