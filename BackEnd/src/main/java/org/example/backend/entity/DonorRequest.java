package org.example.backend.entity;

import jakarta.persistence.*;
import org.example.backend.enums.RequestStatus;

public class DonorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String donorName;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String hospital;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
