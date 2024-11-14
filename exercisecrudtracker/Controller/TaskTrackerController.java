package com.example.exercisecrudtracker.Controller;

import com.example.exercisecrudtracker.ApiResponse.ApiResponse;
import com.example.exercisecrudtracker.Model.TaskTracker;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task-tracker")
public class TaskTrackerController {
    ArrayList<TaskTracker>tasks =new ArrayList<>();

    @PostMapping("/create")
    public ApiResponse CreateTask(@RequestBody TaskTracker task){
       tasks.add(task);
        return new ApiResponse("Created task successfully");
    }


    @GetMapping("/get-tasks")
    public ArrayList<TaskTracker> getTasks(){
        return tasks;
    }

@PutMapping("/update/{index}")
    public ApiResponse UpdateTask(@RequestBody TaskTracker task,@PathVariable int index){
        tasks.set(index,task);
        return new ApiResponse("Updated task successfully");
    }

@DeleteMapping("/delete/{index}")
    public ApiResponse DeleteTask(@PathVariable int index){
        if (index>tasks.size()) return new ApiResponse("task not found");
        tasks.remove(index);
        return new ApiResponse("Deleted task successfully");
    }
    @PutMapping("/change-status/{index}")
    public ApiResponse ChangeStatus(@PathVariable int index){
       if(tasks.get(index).getStatus().equalsIgnoreCase("done")){
          return new ApiResponse("task already done");
       } else if (tasks.get(index).getStatus().equalsIgnoreCase("not done")) {
           tasks.get(index).setStatus("done");
       }
return  new ApiResponse("Changed status successfully");
    }


    @GetMapping("/search/{title}")
    public TaskTracker SearchByTitle(@PathVariable String title){
        for (TaskTracker task : tasks) {
            if(task.getTitle().equals(title)){
                return task;
            }
        }return null;
    }

}
