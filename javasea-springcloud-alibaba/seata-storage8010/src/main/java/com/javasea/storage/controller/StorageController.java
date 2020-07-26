package com.javasea.storage.controller;

import com.javasea.storage.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping(path = "/deduct/{commodityCode}/{count}")
    public Boolean deduct(@PathVariable("commodityCode") String commodityCode,
                          @PathVariable("count") Integer count) {
        storageService.deduct(commodityCode, count);
        return true;
    }
}
