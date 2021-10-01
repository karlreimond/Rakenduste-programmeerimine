package ee.karl_reimond.backend.controller;

import ee.karl_reimond.backend.model.Item;
import ee.karl_reimond.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("items")
    public List<Item> getItems() {
        return itemService.getItem();
    }

    //localgist;8080/items

    @PostMapping("items")
    public String postItem(@RequestBody Item item){
        itemService.saveItem(item);
        return "ese edukalt lisatud" + item.getName();
        //annan midagi jason kujul kaasa, 3 asja peavad sama olema
    }
    //delete päringu
    //edit päringu
    //view one item päringu
    //andmebaas
    //kategooria osa kordub

}
