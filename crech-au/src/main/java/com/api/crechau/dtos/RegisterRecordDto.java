package com.api.crechau.dtos;

import com.api.crechau.roles.UserRole;

public record RegisterRecordDto(String name, String login, String password, UserRole role) {
}
