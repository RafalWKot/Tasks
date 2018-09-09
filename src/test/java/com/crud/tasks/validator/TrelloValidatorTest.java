package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
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
public class TrelloValidatorTest {

    @Autowired
    TrelloValidator trelloValidator;

    @Test
    public void validateTrelloBoardsWithoutTestName() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "my_board", new ArrayList<>()));

        //When
        List<TrelloBoard> validTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertNotNull(validTrelloBoards);
        assertEquals(1, validTrelloBoards.size());
        validTrelloBoards.forEach(trelloBoard -> {
            assertEquals("1", trelloBoard.getId());
            assertEquals("my_board", trelloBoard.getName());
            assertEquals(new ArrayList<>(), trelloBoard.getLists());
        });
    }

    @Test
    public void validateTrelloBoardsWithTestName() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", new ArrayList<>()));

        //When
        List<TrelloBoard> validTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertNotNull(validTrelloBoards);
        assertEquals(0, validTrelloBoards.size());
    }
}