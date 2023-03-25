package com.rdutta.meanstack.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdutta.meanstack.Repository.CompanyRepository;
import com.rdutta.meanstack.Repository.ProviderRepository;
import com.rdutta.meanstack.exception.UserNotFoundException;
import com.rdutta.meanstack.model.Company;
import com.rdutta.meanstack.model.Provider;
import com.rdutta.meanstack.service.ProviderService;

@Service
public class ProviderImpl implements ProviderService{

	@Autowired
	private ProviderRepository providerRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	//Read All Providers
	@Override
	public List<Provider> readAll(){
		List<Provider> providers = providerRepository.findAll();
		return providers;
	}

	


	//Create a new provider
	@Override
	public Provider createProvider(Provider provider){
		return providerRepository.save(provider);
	}




	//Find Provider By Id
	@Override
	public Provider findOneProvider(Long id) {
		return providerRepository.findProviderById(id).orElseThrow(() -> new UserNotFoundException("user by id"+ id + " was not found."));
	}



	//Find One and Update
	@Override
	public Provider findOneAndUpdate(Long id, Provider provider) {
		Provider existProvider = providerRepository.findProviderById(id).orElseThrow(() -> new UserNotFoundException("user by id"+ id + " was not found."));

		existProvider.setFirstname(provider.getFirstname());
        existProvider.setLastname(provider.getLastname());
        existProvider.setPosition(provider.getPosition());
        existProvider.setCompany(provider.getCompany());

		Provider updatedProvider = providerRepository.save(existProvider);
		
		return providerRepository.save(updatedProvider);
	}



	//Delete All
	@Override
	public void deleteAll() {
		providerRepository.deleteAll();
		companyRepository.deleteAll();
	}




	@Override
	@Transactional
	public void deleteOneProvider(Long id) {
		Provider existProvider = providerRepository.findProviderById(id).orElseThrow(() -> new UserNotFoundException("user by id"+ id + " was not found."));
		providerRepository.deleteProviderById(existProvider.getId());
	
		if(existProvider.getId() == id){
			Company company = new Company();
			companyRepository.deleteCompanyByid(company.getId());
		}
	}
	
}
