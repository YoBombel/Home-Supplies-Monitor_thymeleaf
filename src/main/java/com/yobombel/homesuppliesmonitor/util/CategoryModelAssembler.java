package com.yobombel.homesuppliesmonitor.util;

import com.yobombel.homesuppliesmonitor.api.ItemAPI;
import com.yobombel.homesuppliesmonitor.model.Item;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CategoryModelAssembler implements RepresentationModelAssembler<Item, EntityModel<Item>> {

    @Override
    public EntityModel<Item> toModel(Item item) {
        return EntityModel.of(item,
                linkTo(methodOn(ItemAPI.class).getCategory(item.getCategory().getValue())).withRel("category"),
                linkTo(methodOn(ItemAPI.class).all()).withRel("supplies"));
    }
}
