package com.crud.tasks.controller;

import com.crud.tasks.com.crud.tasks.exception.TrelloException;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        try {
            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
            trelloBoards.stream()
                    .filter(t -> (!t.getId().isEmpty() && !t.getName().isEmpty()))
                    .filter(t -> t.getName().contains("Kodilla"))
                    .forEach(t -> System.out.println(t.getId() + " " + t.getName()));
        }
        catch (TrelloException e) {
            System.out.println("No boards");
        }
    }
}
