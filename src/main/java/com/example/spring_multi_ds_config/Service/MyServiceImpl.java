package com.example.spring_multi_ds_config.Service;

import com.example.spring_multi_ds_config.entity.RequestDto;
import com.example.spring_multi_ds_config.entity.primary.PrimaryUser;
import com.example.spring_multi_ds_config.entity.secondary.SecondaryOrder;
import com.example.spring_multi_ds_config.repository.primary.PrimaryUserDataAccess;
import com.example.spring_multi_ds_config.repository.primary.PrimaryUserRepository;
import com.example.spring_multi_ds_config.repository.secondary.SecondaryOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{

    private final PrimaryUserRepository primaryUserRepository;
    private final SecondaryOrderRepository secondaryOrderRepository;
    private final PrimaryUserDataAccess primaryUserDataAccess;

    @Autowired
    public MyServiceImpl(PrimaryUserRepository primaryUserRepository, SecondaryOrderRepository secondaryOrderRepository, PrimaryUserDataAccess primaryUserDataAccess) {
        this.primaryUserRepository = primaryUserRepository;
        this.secondaryOrderRepository = secondaryOrderRepository;
        this.primaryUserDataAccess = primaryUserDataAccess;
    }

    @Override
    public PrimaryUser savePrimaryUser(PrimaryUser user) {
        return primaryUserRepository.save(user);
    }

    @Override
    public SecondaryOrder saveSecondaryOrder(SecondaryOrder order) {
        return secondaryOrderRepository.save(order);
    }

    @Override
    @Transactional
    public int updatePrimaryUserName(RequestDto requestDto) {
        return primaryUserDataAccess.updateNameByUserID(requestDto.getId(),requestDto.getName());
    }
}
