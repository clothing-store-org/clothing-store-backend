package com.project.clothing_store_backend.api;
import com.project.clothing_store_backend.dto.request_dto.auth.RequestOrderDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedOrderDto;
import com.project.clothing_store_backend.service.auth.OrderService;
import com.project.clothing_store_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestOrderDto dto){
        orderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order Create!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Order data!",orderService.getById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestOrderDto dto){
        orderService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order was Updated!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        PaginatedOrderDto all = orderService.getAll(searchText, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200,"Order list!..",all),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        orderService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order delete!..", null ),
                HttpStatus.CREATED
        );
    }
}
