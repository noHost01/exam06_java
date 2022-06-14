package com.exam.exam1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void _1더하기_1 () { assertEquals(2, new Calc().run("1 + 1")); }
    @Test
    public void _2더하기_1 () { assertEquals(3, new Calc().run("1 + 2")); }
    @Test
    public void _2빼기_1 () { assertEquals(0, new Calc().run("1 - 1")); }
    @Test
    public void _1빼기_2 () { assertEquals(-1, new Calc().run("1 - 2")); }
    @Test
    public void _1곱하기_1 () { assertEquals(1, new Calc().run("1 * 1")); }
    @Test
    public void _1곱하기_2 () { assertEquals(2, new Calc().run("1 * 2")); }
    @Test
    public void _2나누기_1 () { assertEquals(2, new Calc().run("2 / 1")); }
    @Test
    public void _2나누기_2 () { assertEquals(1, new Calc().run("2 / 2")); }
    @Test
    public void 괄호_1_더하기_1 () { assertEquals(2, new Calc().run("(1 + 1)")); }
    @Test
    public void 괄호두겹_1_더하기_2 () { assertEquals(3, new Calc().run("((1 + 2))")); }
    @Test
    public void 복합연산_17 () { assertEquals(17, new Calc().run("5 * 3 + 2")); }
    @Test
    public void 복합연산_16 () { assertEquals(16, new Calc().run("5 * 3 + 1")); }
    @Test
    public void 복합연산_11 () { assertEquals(11, new Calc().run("5 + 3 * 2")); }
    @Test
    public void 복합연산_14 () { assertEquals(14, new Calc().run("5 + 3 * 3")); }
    @Test
    public void 괄호복합연산_10 () { assertEquals(10, new Calc().run("(1 + 4) * 2")); }
    @Test
    public void 마이너스연산_2 () { assertEquals(-2, new Calc().run("-1 + -1")); }
}
