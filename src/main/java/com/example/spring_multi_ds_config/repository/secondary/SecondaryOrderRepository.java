package com.example.spring_multi_ds_config.repository.secondary;

import com.example.spring_multi_ds_config.entity.secondary.SecondaryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryOrderRepository extends JpaRepository<SecondaryOrder, Long> {
}

