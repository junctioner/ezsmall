package com.wemall.foundation.service;

import com.wemall.foundation.domain.Consumer;

public interface IConsumerService {
	public abstract boolean save(Consumer consumer);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(Consumer consumer);
}
