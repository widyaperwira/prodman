package com.ism.erp.prodman.dao;

import com.ism.erp.prodman.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ItemDao extends PagingAndSortingRepository<Item, Serializable> {
}
