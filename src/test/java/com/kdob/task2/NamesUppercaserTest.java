package com.kdob.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesUppercaserTest {

    private final NamesUppercaser uppercaser = new NamesUppercaser();

    @Test
    void shouldReturnEmptyListWhenInputIsEmpty() {
        List<String> result = uppercaser.uppercase(new String[]{});
        assertTrue(result.isEmpty(), "Result should be empty for empty input array");
    }

    @Test
    void shouldUppercaseAllNames() {
        String[] input = {"Alice", "bob", "CHARLIE", "dAVid"};
        List<String> result = uppercaser.uppercase(input);
        
        assertEquals(List.of("ALICE", "BOB", "CHARLIE", "DAVID"), result);
    }

    @Test
    void shouldHandleStringsWithSpecialCharacters() {
        String[] input = {"Alice-123", "!@#", " "};
        List<String> result = uppercaser.uppercase(input);
        
        assertEquals(List.of("ALICE-123", "!@#", " "), result);
    }
}
