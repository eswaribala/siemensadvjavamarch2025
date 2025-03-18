package com.siemens.dtos;

import com.siemens.models.Gender;

import java.time.LocalDate;

public record Transaction(long amount, LocalDate timeStamp, String Sender, String Receiver) {
}
