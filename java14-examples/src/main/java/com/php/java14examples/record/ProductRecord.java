package com.php.java14examples.record;

import com.fasterxml.jackson.annotation.JsonProperty;

// Record (preview)
public record ProductRecord(
        @JsonProperty Long id,
        @JsonProperty String name,
        @JsonProperty int status,
        @JsonProperty String statusDescription) {
}
