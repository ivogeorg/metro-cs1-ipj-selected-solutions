package edu.msud.cs.cs1;

import org.junit.jupiter.api.*;

class QuadraticTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is beforeAll. Note that it is 'static'");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is afterAll. Note that it is 'static'");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("This is beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("This is afterEach");
    }

    @Test
    void test0() {
        System.out.println("This is test0");
    }

    @Test
    void test1() {
        System.out.println("This is test1");
    }
}
