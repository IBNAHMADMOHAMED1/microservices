package io.company.fraud.repository;

import io.company.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepo extends JpaRepository<FraudCheckHistory, Long> {

}
