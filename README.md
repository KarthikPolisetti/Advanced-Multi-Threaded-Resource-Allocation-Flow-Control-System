Concurrency Roller Coaster Simulation
A multithreaded Java application that simulates a theme park's roller coaster operation using advanced concurrency and synchronization utilities. This project demonstrates how to safely manage shared states, safely queue passengers, and coordinate thread behaviors to model real-world scenarios.

🚀 Features & Concurrency Concepts Demonstrated
This project utilizes several features from the java.util.concurrent package to achieve thread safety and synchronization:

ArrayBlockingQueue (Thread-Safe Queueing): Simulates the actual ride line. It safely handles producers (guests arriving at the park) and consumers (coaster trains boarding passengers) without explicit synchronization blocks.

CountDownLatch (Barrier Synchronization): Used to ensure that a roller coaster train does not dispatch until all 4 passengers have securely buckled their safety harnesses.

ReentrantReadWriteLock (Optimized Locking): Manages ParkMetrics. Multiple threads can read the ride's wait times simultaneously, but updating the wait time requires an exclusive write lock.

AtomicInteger (Lock-Free Mutation): Safely increments and tracks the total number of physical visitor walk-ins without the overhead of heavy locks.

ExecutorService (Thread Pool Management): Manages a fleet of roller coaster trains executing concurrently via a fixed thread pool.

🏗️ Architecture Breakdown
The system is split into distinct, decoupled components:

ParkMetrics: Keeps track of global stats like live visitor count and estimated ride wait-times using highly optimized concurrent primitives.

RideQueue: The gateway to the coaster. Built on top of a blocking queue capped at 50 guests.

CoasterTrain: A Runnable task representing a train asset. Each train boards exactly 4 guests sequentially, checks safety compliance via a latch, and prepares for departure.

Main: The simulation orchestrator that seeds the queue with 60 eager guests, provisions the train fleet, and updates the park dashboard.

🛠️ Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher.

Running the Project
Clone the repository:

Bash
git clone https://github.com/YOUR_USERNAME/RollerCoaster-Concurrency.git
cd RollerCoaster-Concurrency
Compile the files:

Bash
javac RollerCoaster/Main.java
Run the application:

Bash
java RollerCoaster.Main
📊 Sample Console Output
When you run the simulation, you will observe threads interleaving safely as guests line up, board trains dynamically, and successfully secure their harnesses:

Plaintext
Welcome to the Roller Coaster!
Guest On boarded on train 0
Guest On boarded on train 1
Guest_1 added to the ride queue.
Guest_1 boarded the ride.
Guest_1 has buckled into Seat 1 of Train [0].
Passenger 1 clicked harness for Train [0]
...
Train [0] has arrived at the platform. Beginning boarding...
Current No Of Visitors is :1
Updating  ride wait time 
Reading ride wait time
Current Wait Time: 30 minutes
📜 License
This project is open-source and available under the MIT License.
