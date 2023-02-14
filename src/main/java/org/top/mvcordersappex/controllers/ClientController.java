package org.top.mvcordersappex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.mvcordersappex.model.dao.client.IDaoClient;
import org.top.mvcordersappex.model.entity.Client;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IDaoClient daoClient;

    @GetMapping("/")
    public String listAll(Model model){
        System.out.println("/ listAll");
        List<Client> clients = daoClient.listAll();
        System.out.println("list " + clients.size());
        model.addAttribute("clients", clients);
        System.out.println("model ");
        return "client/client-list";
    }

    @GetMapping("/add/")
    public String getAddForm(Model model){
        Client  client = new Client();
        model.addAttribute("client", client);
        return "client/client-form";
    }

//    @PostMapping("/add/")
//    public String addNewForm(Client client ){
//        Client  addClient = daoClient.save(client);
//
//        return "redirect:/client/";
//    }

    @PostMapping("/add/")
    public String addNewForm(Client client, RedirectAttributes ra) {
        Client addClient = daoClient.save(client);
        // 2. отправим сообщение о том что клиент добавлен
        ra.addFlashAttribute("goodMsg", "Client " + addClient+ "added");

        return "redirect:/client/"; // 3. перенаправить ответ на вывод всех клиентов (redirect)
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable ("id") Integer clientId){
        daoClient.delete(clientId);
        return "redirect:/client/";
    }

    // обработчик получения формы редактирования (Update) клиента
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") Integer clientId, Model model) {
        // 1. получить клиента для обновления
        Optional<Client> client = daoClient.getById(clientId);
        // 2. добавить этого клиента в контекст
        if (client.isPresent()) {
            model.addAttribute("client", client.get());
        };
        // 3. вернуть форму ОБНОВЛЕНИЯ
        return "client/client-update";
    }

    // обработчик (Update) клиента
    @PostMapping("/update/")
    public String updateClient(Client client) {
        // 1. сохранить клиента
        daoClient.update(client);
        // 2. вернуться на список сущностей
        return "redirect:/client/";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable ("id") Integer clientId, @RequestParam String back, Model model){
        Optional<Client>  client = daoClient.getById(clientId);
        if (client.isPresent()) {
            model.addAttribute("client", client.get());
            model.addAttribute("back", back);
        }
        return "client/client-detail";
    }


}
