package com.nazjara;

import com.nazjara.matcher.ModelMatcher;
import com.nazjara.model.Role;
import com.nazjara.model.User;

import java.util.Objects;

import static com.nazjara.model.BaseEntity.START_SEQ;

public class UserTestData {

    public static final User ADMIN = new User(START_SEQ , "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static final User USER = new User(START_SEQ + 1, "User", "user@gmail.com", "password", Role.ROLE_USER);

    public static final ModelMatcher<User> MATCHER = new ModelMatcher<>(
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getPassword(), actual.getPassword())
                            && Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getEmail(), actual.getEmail())
                    )
    );
}