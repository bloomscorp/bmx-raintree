package com.bloomscorp.raintree.restful;

import com.bloomscorp.hastar.code.ActionCode;
import com.bloomscorp.raintree.RainTree;
import com.bloomscorp.raintree.RainTreeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

@Getter
@AllArgsConstructor
public abstract class RainResponse<E> {

	private final RainTree rainTree;

	@Contract("_ -> new")
	public static @NotNull RainTreeResponse prepareActionResponse(int action) {

		boolean success = switch (action) {
			case 	ActionCode.INSERT_SUCCESS,
					ActionCode.UPDATE_SUCCESS,
					ActionCode.DELETE_SUCCESS -> true;
			default -> false;
		};

		return new RainTreeResponse(
			success,
			ActionCode.message(action)
		);
	}

	protected <T> String prepareList(List<? extends T> list, String responseParameter) {
		HashMap<String, Object> parameters = new HashMap<>();

		parameters.put(
			responseParameter,
			list
		);

		return this.rainTree.renderParameterizedSuccessResponse(parameters);
	}

	protected <T> String prepareEntity(T object, String responseParameter) {

		HashMap<String, Object> parameters = new HashMap<>();

		parameters.put(
			responseParameter,
			object
		);

		return this.rainTree.renderParameterizedSuccessResponse(parameters);
	}

	public abstract String buildEntity(E entity);
	public abstract String buildList(List<E> list);
}
