package com.example.emailsnippet.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailMessage {
    private final String from;
    private final String[] to;
    private final String[] cc;
    private final String subject;
    private final String body;
}
