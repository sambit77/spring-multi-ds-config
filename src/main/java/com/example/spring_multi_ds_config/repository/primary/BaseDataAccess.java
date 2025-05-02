package com.example.spring_multi_ds_config.repository.primary;

import com.example.spring_multi_ds_config.util.QueryParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDataAccess {

    final EntityManagerFactory entityManagerFactory;

    public BaseDataAccess(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public int executeUpdateQuery(String queryName, List<QueryParam> params) {

        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Query query = entityManager.createNativeQuery(queryName);
            for (int i = 0; i < params.size(); i++) {
                QueryParam queryParam = params.get(i);
                query.setParameter(i + 1, queryParam.value());
            }

            int updatedRows = query.executeUpdate();
            transaction.commit();
            return updatedRows;

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error executing update", e);

        } finally {
            entityManager.close();
        }
    }



    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
