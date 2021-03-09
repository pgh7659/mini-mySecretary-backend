package com.gil.mySecretary.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateRequestDto {
    private Boolean done;

    @Builder
    public TodoUpdateRequestDto(Boolean done) {
        this.done = done;
    }
}
