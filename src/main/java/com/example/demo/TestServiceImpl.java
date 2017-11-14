package com.example.demo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Vasek
 */
public class TestServiceImpl implements TestService {

    @Override
    @TestAnnotation
    public List<String> getTestData() {
        return Arrays.asList("1", "2", "3");
    }
}
