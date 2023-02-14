package org.top.mvcordersappex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.mvcordersappex.model.dao.item.DbDaoItem;
import org.top.mvcordersappex.model.entity.Client;
import org.top.mvcordersappex.model.entity.Item;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private DbDaoItem daoItem;

    @GetMapping("/")
    public String getAll(Model model){
        List<Item> items = daoItem.listAll();
        model.addAttribute("items",items);
        return  "item/item-list";
    }
    @GetMapping("/add/")
    public String getFormAdd(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "item/item-form";
    }

    @PostMapping("/add/")
    public String addNewItem(Item item, RedirectAttributes ra) {
        Item addItem = daoItem.save(item);
        // 2. отправим сообщение о том что Продукт добавлен
        ra.addFlashAttribute("goodMsg", "Item " + addItem+ " added");

        return "redirect:/item/"; // 3. перенаправить ответ на вывод всех продуктов (redirect)
    }

    // обработчик получения формы редактирования (Update) продукта
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") Integer itemId, Model model) {
        // 1. получить продукт для обновления
        Optional<Item> item = daoItem.getById(itemId);
        // 2. добавить этот продукт в контекст
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        };
        // 3. вернуть форму ОБНОВЛЕНИЯ
        return "item/item-update";
    }

    // обработчик (Update) продукт
    @PostMapping("/update/")
    public String updateClient(Item item) {
        // 1. сохранить продукт
        daoItem.update(item);
        // 2. вернуться на список сущностей
        return "redirect:/item/";
    }


    @GetMapping("/detail/{id}")
    public String itemDetail(@PathVariable("id") Integer itemId, Model model){
        Optional<Item> item = daoItem.getById(itemId);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        }
        return  "item/item-detail";
    }


}
