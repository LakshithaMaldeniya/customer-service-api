package com.devstack.customerserviceapi.repo;

import com.devstack.customerserviceapi.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer WHERE name LIKE %?1% OR address LIKE %?1%", nativeQuery = true)
    Page<Customer> searchAllByAddressOrName(String searchText,Pageable pageable);
    @Query(value = "SELECT COUNT(id) FROM customer WHERE name LIKE %?1% OR address LIKE %?1%", nativeQuery = true)
    long countDataWithSearchText(String searchText);
}
