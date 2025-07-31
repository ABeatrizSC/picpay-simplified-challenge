package com.github.abeatrizsc.picpay.simplified.challenge.infra.dtos.external.services.notifytransaction;

public record ExternalNotificationResponseDto(
        String status,
        NotificationDataDto data)
{}
