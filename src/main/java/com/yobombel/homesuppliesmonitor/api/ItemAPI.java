package com.yobombel.homesuppliesmonitor.api;

import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.service.SupplyService;
import com.yobombel.homesuppliesmonitor.util.CategoryModelAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemAPI {

    private final SupplyService supplyService;
    private final CategoryModelAssembler assembler;

    @GetMapping("all")
    public CollectionModel<EntityModel<Supply>> all() {

        List<EntityModel<Supply>> supplies = supplyService.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(supplies, assembler.getCategoryLinks());
    }

    @GetMapping("{name}")
    public Optional<Supply> getItemByName(@PathVariable String name) {
        return supplyService.findByName(name);
    }

    @PostMapping("")
    public void addItem(@RequestBody Supply supply) {
        supplyService.saveItem(supply);
    }

    @GetMapping("/category/{category}")
    public CollectionModel<EntityModel<Supply>> getCategory(@PathVariable String category) {

        List<EntityModel<Supply>> supplies = supplyService.findByCategory(category).stream()
                .map(EntityModel::of)
                .toList();
        return CollectionModel.of(supplies, assembler.getCategoryLinks());
    }
}
