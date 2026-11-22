package com.tikfind.polymorphism;

import com.tikfind.inheritance.Pengguna;
import org.springframework.stereotype.Service;

/**
 * Demonstrates polymorphism: the method works with the base type {@code Pengguna}
 * but the actual implementation is provided by the concrete subclass
 * (Mahasiswa or Admin). This service could be injected wherever we need a
 * generic handling of users.
 */
@Service
public class PenggunaService {
    /**
     * Returns the role description of the supplied user. The concrete class
     * decides what to return via method overriding.
     */
    public String getRoleDescription(Pengguna pengguna) {
        return pengguna.getRoleDescription();
    }
}
