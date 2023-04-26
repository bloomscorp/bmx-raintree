package com.bloomscorp.raintree.restful;

import com.bloomscorp.raintree.RainTree;

public abstract class RainEnhancedResponse<E, P, R> extends RainResponse<E> {

	public RainEnhancedResponse(RainTree rainTree) {
		super(rainTree);
	}

	public abstract R prepareResponse(P parameter);
}
