package com.yobombel.homesuppliesmonitor.util;

import com.yobombel.homesuppliesmonitor.api.ItemAPI;
import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CategoryModelAssembler implements RepresentationModelAssembler<Supply, EntityModel<Supply>> {

    @Override
    public EntityModel<Supply> toModel(Supply supply) {
        return EntityModel.of(supply);
    }

    public List<Link> getCategoryLinks() {
        List<Link> categoryLinks = new ArrayList<>();

        Stream.of(Category.values()).forEach
                (category -> {
                            String categoryString = category.toString();
                            categoryLinks.add(
                                    linkTo(methodOn(ItemAPI.class).getCategory(categoryString)).withRel(categoryString));
                        }
                );
        categoryLinks.add(linkTo(methodOn(ItemAPI.class).all()).withRel("all"));
        return categoryLinks;
    }


}
