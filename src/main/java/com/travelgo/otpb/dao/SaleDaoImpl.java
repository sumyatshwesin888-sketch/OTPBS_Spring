package com.travelgo.otpb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.SaleDao;
import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.dto.SaleDto;

@Repository
@Transactional
public class SaleDaoImpl implements SaleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SaleDto> getSale() {

        List<Sale> list = entityManager
                .createQuery("FROM Sale", Sale.class)
                .getResultList();

        List<SaleDto> dtoList = new ArrayList<>();

        for (Sale sale : list) {
            dtoList.add(new SaleDto(sale));
        }

        return dtoList;
    }

    @Override
    public void addSale(Sale sale) {

        entityManager.persist(sale);

    }

    @Override
    public void updateSale(Sale sale) {

        entityManager.merge(sale);

    }

    @Override
    public void deleteSale(int saleId) {

        Sale sale = entityManager.find(Sale.class, saleId);

        if (sale != null) {

            entityManager.remove(sale);

        }

    }

}