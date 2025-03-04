# Lab Exercise: Scheduled Tasks and Thread Safety

## Objective:
- Understand how to schedule tasks using `ScheduledExecutorService`.
- Learn how to handle repeated tasks and manage their execution.
- Practice waiting for tasks to complete and shutting down the executor.
- Ensure thread-safety in concurrent operations.

---

## Part 1: Setting Up the Scheduled Executor
1. **Create a new Java project** and a class called `ScheduledExecutorLab`.
2. **Use a `ScheduledExecutorService`** to schedule a task that runs at fixed intervals. The task will print out the current time to simulate a task that executes periodically (for example, a heart-beat task).
   
   **Task:** Write code that:
   - Uses `scheduleAtFixedRate()` to schedule a task every 1 second.
   - In each run, the task should print the current system time.
   - After running for 5 seconds, shut down the executor.

---

## Part 2: Repeating Tasks with Initial Delay
1. **Modify your code** to add an initial delay of 2 seconds before the first execution. 
   
   **Task:** Write code that:
   - Schedules a task that waits for 2 seconds before executing for the first time.
   - Then, the task should execute every 3 seconds.
   - Each time the task runs, it should print the message `"Probing service at [current time]"`.

---

## Part 3: Waiting for Tasks to Finish
1. **Use `awaitTermination()`** to wait for all scheduled tasks to finish executing.
   
   **Task:** Write code that:
   - Schedules 3 tasks with different delay intervals.
   - After submitting all tasks, use `awaitTermination()` to wait for all tasks to finish.
   - If the tasks don’t finish in 5 seconds, shut down the executor.

---

## Part 4: Using `Callable` for Result Return
1. **Create a `Callable` task** that computes a value (e.g., sum of random numbers) and returns it.
   
   **Task:** Write code that:
   - Creates a `Callable` task that returns the sum of 10 random numbers.
   - Submit the task using `submit()` and capture the result in a `Future` object.
   - Print the result of the task after it completes.

---

## Part 5: Implementing Thread-Safe Code
1. **Thread Safety Challenge:**
   - Modify your code to have multiple tasks updating a shared variable (e.g., a counter).
   - Use a `synchronized` block or `ReentrantLock` to ensure that the counter is updated safely.
   
   **Task:** Write code that:
   - Creates a shared counter variable.
   - Submit 5 tasks that each increment the counter 1000 times.
   - Use synchronization or a `ReentrantLock` to make the counter updates thread-safe.
   - After the tasks finish, print the value of the counter (it should be 5000).

---

## Part 5: Optional – Bonus: Task Scheduling with Dynamic Intervals
1. **Advanced Scheduling Task:**
   - Schedule a task that performs an action after an initial delay, then adjusts the interval dynamically depending on the task’s runtime.
   
   **Task:** Write code that:
   - Schedules a task with an initial delay of 1 second.
   - After each execution, the interval between the next executions should decrease by 500 milliseconds (e.g., first 3 seconds, then 2.5 seconds, then 2 seconds, etc.).
   - Print the time each task runs.

---

## Expected Outcomes:
1. Tasks should execute at scheduled intervals.
2. Tasks should stop after the specified duration (or after they complete).
3. Tasks that return a result should correctly provide that result.
4. The shared counter should be updated safely by all threads, and the correct value should be printed after all tasks finish.
5. Use `awaitTermination()` to wait for all tasks to finish and gracefully shut down the executor.

