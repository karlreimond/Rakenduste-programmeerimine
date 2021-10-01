package ee.karl_reimond.backend.controller;

import ee.karl_reimond.backend.model.Item;
import ee.karl_reimond.backend.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping("items")
    public String postItem(@RequestBody Item item) {
        itemService.saveItem(item);

        return "posted: " + item.getName();
    }

    @GetMapping("items/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        String name = itemService.getItemById(id).getName();
        itemService.deleteItem(itemService.getItemById(id));
        return "deleted: " + name;
    }

}