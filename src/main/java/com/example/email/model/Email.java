package com.example.email.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {
    private String from;
    private String to;
    private String subject;
    private String content;
}
