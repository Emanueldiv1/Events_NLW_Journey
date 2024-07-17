package com.rocketseat.planer.participant;

import java.util.UUID;

public record ParticipantData (UUID ID, String nome, String email, Boolean isConfirmed) {

}
