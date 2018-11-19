package com.ism.erp.prodman.service;

import com.ism.erp.prodman.domain.Item;
import com.ism.erp.prodman.dto.ItemDto;
import org.springframework.data.domain.Page;

public interface ItemService {

    Page<Item> findAll(int page, int size);

    ItemDto findById(Long itemId) throws Throwable;

    ItemDto saveOrUpdate(ItemDto itemDto);

    void delete(ItemDto itemDto);

}
