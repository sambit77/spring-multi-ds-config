package com.example.spring_multi_ds_config.Service;

import com.example.spring_multi_ds_config.entity.RequestDto;
import com.example.spring_multi_ds_config.entity.primary.PrimaryUser;
import com.example.spring_multi_ds_config.entity.secondary.SecondaryOrder;

public interface MyService {
    PrimaryUser savePrimaryUser(PrimaryUser user);
    SecondaryOrder saveSecondaryOrder(SecondaryOrder order);

    int updatePrimaryUserName(RequestDto requestDto);
}
