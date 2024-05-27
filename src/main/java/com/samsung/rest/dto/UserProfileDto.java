package com.samsung.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserProfileDto {

    private long id;

    private String name;

    private String email;

    private String photoUrl;
}


