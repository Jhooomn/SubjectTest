package com.app.api.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRest<I, O> {

	public I domRest(O o);

	public O restDom(I i);

	public default List<I> listDomRest(List<O> list) {
		return list.stream().map(this::domRest).collect(Collectors.toList());
	}

	public default List<O> listRestDom(List<I> list) {
		return list.stream().map(this::restDom).collect(Collectors.toList());
	}
}
