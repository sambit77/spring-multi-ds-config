package com.example.spring_multi_ds_config.Service;

import com.example.spring_multi_ds_config.entity.primary.PrimaryUser;
import com.example.spring_multi_ds_config.entity.secondary.SecondaryOrder;
import com.example.spring_multi_ds_config.repository.primary.PrimaryUserRepository;
import com.example.spring_multi_ds_config.repository.secondary.SecondaryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{

    private final PrimaryUserRepository primaryUserRepository;
    private final SecondaryOrderRepository secondaryOrderRepository;

    @Autowired
    public MyServiceImpl(PrimaryUserRepository primaryUserRepository, SecondaryOrderRepository secondaryOrderRepository) {
        this.primaryUserRepository = primaryUserRepository;
        this.secondaryOrderRepository = secondaryOrderRepository;
    }

    @Override
    public PrimaryUser savePrimaryUser(PrimaryUser user) {
        return primaryUserRepository.save(user);
    }

    @Override
    public SecondaryOrder saveSecondaryOrder(SecondaryOrder order) {
        return secondaryOrderRepository.save(order);
    }
}
