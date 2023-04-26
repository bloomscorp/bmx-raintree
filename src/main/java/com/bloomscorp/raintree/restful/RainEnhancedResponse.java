package com.bloomscorp.raintree.restful;

import com.bloomscorp.raintree.RainTree;
import com.bloomscorp.raintree.RainTreeResponse;

public abstract class RainEnhancedResponse<E, P> extends RainResponse<E> {

	public RainEnhancedResponse(RainTree rainTree) {
		super(rainTree);
	}

	public abstract RainTreeResponse prepareResponse(P parameter);
}
