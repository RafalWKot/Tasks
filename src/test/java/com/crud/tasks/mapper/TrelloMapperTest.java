package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoards() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("test_list_id","test_list",true));
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("test_id", "test_board", trelloListDtos));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals("test_id", trelloBoards.get(0).getId());
        assertEquals("test_board", trelloBoards.get(0).getName());
        assertEquals(1, trelloBoards.get(0).getLists().size());
    }

    @Test
    public void mapToBoardsDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("test_list_id","test_list",true));
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("test_id", "test_board", trelloLists));

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        assertEquals("test_id", trelloBoardDtos.get(0).getId());
        assertEquals("test_board", trelloBoardDtos.get(0).getName());
        assertEquals(1, trelloBoardDtos.get(0).getLists().size());
    }

    @Test
    public void mapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("test_list_id","test_list",true));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals("test_list_id", trelloLists.get(0).getId());
        assertEquals("test_list", trelloLists.get(0).getName());
        assertEquals(true, trelloLists.get(0).isClosed());
    }

    @Test
    public void mapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("test_list_id","test_list",true));

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals("test_list_id", trelloListDtos.get(0).getId());
        assertEquals("test_list", trelloListDtos.get(0).getName());
        assertEquals(true, trelloListDtos.get(0).isClosed());
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test_name", "test_description", "test_pos", "test_id");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("test_name", trelloCardDto.getName());
        assertEquals("test_description", trelloCardDto.getDescription());
        assertEquals("test_pos", trelloCardDto.getPos());
        assertEquals("test_id", trelloCardDto.getListId());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test_name", "test_description", "test_pos", "test_id");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("test_name", trelloCard.getName());
        assertEquals("test_description", trelloCard.getDescription());
        assertEquals("test_pos", trelloCard.getPos());
        assertEquals("test_id", trelloCard.getListId());
    }
}