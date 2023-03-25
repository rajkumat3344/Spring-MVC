package com.rdutta.meanstack.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rdutta.meanstack.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
    Optional<Provider> findProviderById(Long id);
    void deleteProviderById(Long id);
}
