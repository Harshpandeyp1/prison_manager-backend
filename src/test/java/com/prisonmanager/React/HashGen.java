package com.prisonmanager.React;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class HashGen {
    private HashGen() {}

    public static void main(String[] args) {
        String raw = (args != null && args.length > 0) ? args[0] : "1234";
        System.out.println(new BCryptPasswordEncoder().encode(raw));
    }
}

