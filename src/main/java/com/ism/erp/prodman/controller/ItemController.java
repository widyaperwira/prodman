package com.ism.erp.prodman.controller;

import com.ism.erp.prodman.domain.Item;
import com.ism.erp.prodman.dto.ItemDto;
import com.ism.erp.prodman.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/findAll")
    public Page<Item> findAll(@RequestParam("page")Integer page, @RequestParam("size")Integer size){
        int itemSize = size;
        int itemPage = page;

        return itemService.findAll(page, size);
    }

    @PostMapping("/save")
    public ItemDto saveOrUpdate(@RequestBody ItemDto itemDto){
        return itemService.saveOrUpdate(itemDto);
    }

}
