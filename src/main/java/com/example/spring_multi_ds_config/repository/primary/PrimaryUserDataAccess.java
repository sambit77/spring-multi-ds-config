package com.example.spring_multi_ds_config.repository.primary;

import com.example.spring_multi_ds_config.util.QueryParam;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrimaryUserDataAccess extends BaseDataAccess{

    public static final String QUERY_UPDATE__NAME =
            "UPDATE users SET name = ?1 WHERE id = CAST(?2 AS BIGINT)";

    public PrimaryUserDataAccess(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
    }

    public int updateNameByUserID(int id,String name)
    {
        List<QueryParam> params = List.of(
                new QueryParam(1,String.class,name),
                new QueryParam(2,Integer.class,id)
        );

        return (int) executeUpdateQuery(QUERY_UPDATE__NAME,params);
    }


}
