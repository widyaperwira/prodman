package com.ism.erp.prodman.service.impl;

import com.ism.erp.prodman.dao.ItemDao;
import com.ism.erp.prodman.domain.Item;
import com.ism.erp.prodman.dto.ItemDto;
import com.ism.erp.prodman.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemDao itemDao;


    @Override
    public Page<Item> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return itemDao.findAll(pageable);
    }

    @Override
    public ItemDto findById(Long itemId) throws Throwable {
        Optional optional = itemDao.findById(itemId);
        Item item = (Item) optional.orElseThrow(() -> new RuntimeException("object not found!"));
        ItemDto itemDto = new ItemDto();
        BeanUtils.copyProperties(item, itemDto);

        return itemDto;
    }

    @Override
    public ItemDto saveOrUpdate(ItemDto itemDto) {
        Item item;
        if(itemDto.getId() == null || (itemDto.getId() != null && itemDto.getId() == 0)){
            item = new Item();
        } else {
            item = itemDao.findById(itemDto.getId()).get();
        }
        BeanUtils.copyProperties(itemDto, item, "id");

        Item itemSaved = itemDao.save(item);
        BeanUtils.copyProperties(itemSaved, itemDto);

        return itemDto;
    }

    @Override
    public void delete(ItemDto itemDto) {

    }
}
