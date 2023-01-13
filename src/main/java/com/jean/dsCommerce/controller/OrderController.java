package com.jean.dsCommerce.controller;

import com.jean.dsCommerce.dtos.OrderDto;
import com.jean.dsCommerce.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        List<OrderDto> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OrderDto> insert(@Valid @RequestBody OrderDto dto) {
        OrderDto newDto = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> update(@PathVariable Long id, @RequestBody OrderDto dto) {
        OrderDto newDto = orderService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
