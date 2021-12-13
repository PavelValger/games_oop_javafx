package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell cell = figure.position();
        assertThat(cell, is(Cell.C1));
    }

    @Test
    public void way() {
        Figure step1 = new BishopBlack(Cell.C1);
        Cell[] step2 = step1.way(Cell.G5);
        assertThat(step2, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
        Figure step3 = new BishopBlack(Cell.G5);
        Cell[] step4 = step3.way(Cell.E3);
        assertThat(step4, is(new Cell[]{Cell.F4, Cell.E3}));
        Figure step5 = new BishopBlack(Cell.E3);
        Cell[] step6 = step5.way(Cell.G1);
        assertThat(step6, is(new Cell[]{Cell.F2, Cell.G1}));
        Figure step7 = new BishopBlack(Cell.G1);
        Cell[] step8 = step7.way(Cell.A7);
        assertThat(step8, is(new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7}));
    }

    @Test
    public void copy() {
        Figure first = new BishopBlack(Cell.C1);
        Figure second = first.copy(Cell.E3);
        Cell cell = second.position();
        assertThat(cell, is(Cell.E3));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void itsNotDiagonal() {
        Figure step1 = new BishopBlack(Cell.C1);
        Cell[] step2 = step1.way(Cell.G3);
        Figure step3 = new BishopBlack(Cell.D4);
        Cell[] step4 = step3.way(Cell.D5);
        Figure step5 = new BishopBlack(Cell.C5);
        Cell[] step6 = step5.way(Cell.G3);
    }
}