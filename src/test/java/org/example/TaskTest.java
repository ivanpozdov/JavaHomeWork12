package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
public void testSimpleTaskFound(){
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testSimpleTaskNotFound(){
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("бабушке");
        boolean expected = false;
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldFindTrueFalseTask() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertTrue(meeting.matches("приложения"));
        Assertions.assertFalse(meeting.matches("прилжения"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertFalse(meeting.matches("Нетабананка"));
        Assertions.assertFalse(meeting.matches("втроник"));
        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("Выкатывалка"));


    }
    @Test
    public void shouldFindTrueOrFalsSabTask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Epic epicEmpty = new Epic(55, new String[]{});


        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("Кефир"));
        Assertions.assertFalse(epic.matches("Брокколи"));
        Assertions.assertFalse(epic.matches("Молко"));
        Assertions.assertFalse(epic.matches("пирожок"));
    }


}