package com.yobombel.homesuppliesmonitor.api;

import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.service.ItemService;
import com.yobombel.homesuppliesmonitor.util.CategoryModelAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemAPI {

    private final ItemService itemService;
    private final CategoryModelAssembler assembler;

    @GetMapping("")
    public CollectionModel<EntityModel<Item>> all() {

        List<EntityModel<Item>> supplies = itemService.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(supplies, linkTo(methodOn(ItemAPI.class).all()).withSelfRel());
    }

    @GetMapping("{name}")
    public Optional<Item> getItemByName(@PathVariable String name) {
        return itemService.findByName(name);
    }

    @PostMapping("")
    public void addItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @GetMapping("/category/{category}")
    public List<Item> getCategory(@PathVariable String category) {
        return itemService.findByCategory(category);
    }
}
