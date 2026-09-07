# DevOps-F26-TrackFilm

The goal of this project is to develop an **open-source, self-hosted** application that allows users to easily keep track of all the movies and TV series they have watched and the ones they would like to watch, all in one place. 

Today, streaming platforms like Netflix, Prime Video, or Disney+ do not offer an easy way to export or view a unified history of watched content across services. When exports are available, they are usually buried in raw CSV files or complex formats that are not user-friendly. This application aims to solve that problem by providing a central, human-readable hub for your entire media collection.

> **Note on Authentication:** Since the application is built primarily for self-hosting and local usage (`127.0.0.1`), there will be **no login or user authentication system initially**. This keeps the development of the MVP focused on the core functionality.

---

### Key Features

* **History Tracking:** Track what you've watched.
* **Watchlist:** Keep a list of movies and TV series you want to watch.
* **Random Picker:** Unsure of what to watch? Let the random selection feature pick content from your watchlist or select a past favorite to rewatch.

---

### Planned Tech Stack *(Early Stage)*

The project is currently in its early planning phases. The envisioned setup is fully containerized:

* **Application / Interface:** Java (e.g., Spring Boot).
* **Database:** Relational Database (e.g., PostgreSQL or SQLite) running **inside the Docker setup**.
* **Containerization:** Docker & Docker Compose to package both the application and the database together, enabling a single-command local deployment with no external infrastructure needed.
