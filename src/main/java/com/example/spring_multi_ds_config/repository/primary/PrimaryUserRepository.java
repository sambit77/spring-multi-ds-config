package com.example.spring_multi_ds_config.repository.primary;

import com.example.spring_multi_ds_config.entity.primary.PrimaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, Long> {
}
