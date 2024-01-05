package com.jlbabon.springbootgraphqlpractice.model;

import java.util.List;

public record MovieModel(String title,
                         String director,
                         String studio,
                         Integer releaseYear,
                         List<String> movieCast) {
}
