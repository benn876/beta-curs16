package org.beta.curs16.code.model;

import lombok.Builder;

@Builder
public record Person(
        String name,
        Integer age,
        String job
) {
}
