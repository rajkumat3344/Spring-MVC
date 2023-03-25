package com.rdutta.meanstack.service;

import java.util.List;


import com.rdutta.meanstack.model.Provider;

public interface ProviderService {
	List<Provider> readAll();
	Provider findOneProvider(Long id);
	Provider findOneAndUpdate(Long id, Provider provider);
	Provider createProvider(Provider provider);
	void deleteAll();
	void deleteOneProvider(Long id);
}
