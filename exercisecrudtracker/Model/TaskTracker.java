package com.example.exercisecrudtracker.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTracker {
  private String ID;
  private String title;
  private String description;
  private  String status;
}
