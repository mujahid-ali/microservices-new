package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // Path variable
    // http://localhost:8082/api/inventory/iphone13,iphone13-red

    // RequestParam
    // http://localhost:8082/api/inventory?skuCode=iphone13&skuCode=iphone13-red
    //2nd option is more readable so we would be using it.

    // Also having list as param can save multiple calls to service and save https calls.
    // so using List<String> in place of String

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
